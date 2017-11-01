package com.prodigy.ipaddresses.service;

import com.prodigy.ipaddresses.LoggedUser;
import com.prodigy.ipaddresses.dao.IpAddressDao;
import com.prodigy.ipaddresses.model.*;
import com.prodigy.ipaddresses.to.IpAddressFilter;
import com.prodigy.ipaddresses.to.IpSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IpAddressServiceImpl implements IpAddressService {

    private IpAddressDao ipAddressDao;

    @Autowired
    public IpAddressServiceImpl(IpAddressDao ipAddressDao) {
        this.ipAddressDao = ipAddressDao;
    }

    @Override
    public IpAddress save(IpAddress ipAddress) {

        if (ipAddress.isNew()) {
            return this.ipAddressDao.save(ipAddress);
        }

        LogChanges logChanges = new LogChanges();
        List<LogChangesDetails> logDetails = new ArrayList<>();

        logChanges.setDatetime(new Date());
        logChanges.setUserName(LoggedUser.getName());
        logChanges.setIpAddress_id(ipAddress.getId());
        logChanges.setIpAddress(ipAddress.getIpAddress());

        IpAddress oldIpAddress = this.ipAddressDao.get(ipAddress.getId());

        if (!oldIpAddress.getIpAddress().equals(ipAddress.getIpAddress())) {
            logDetails.add(new LogChangesDetails("IpAddress", oldIpAddress.getIpAddress(), ipAddress.getIpAddress()));
        }
        if (!oldIpAddress.getMacAddress().equals(ipAddress.getMacAddress())) {
            logDetails.add(new LogChangesDetails("MacAddress", oldIpAddress.getMacAddress(), ipAddress.getMacAddress()));
        }
        if (!oldIpAddress.getCompName().equals(ipAddress.getCompName())) {
            logDetails.add(new LogChangesDetails("CompName", oldIpAddress.getCompName(), ipAddress.getCompName()));
        }
        if (!oldIpAddress.getUserName().equals(ipAddress.getUserName())) {
            logDetails.add(new LogChangesDetails("UserName", oldIpAddress.getUserName(), ipAddress.getUserName()));
        }
        if (!oldIpAddress.getPortName().equals(ipAddress.getPortName())) {
            logDetails.add(new LogChangesDetails("PortName", oldIpAddress.getPortName(), ipAddress.getPortName()));
        }
        if (!oldIpAddress.getComments().equals(ipAddress.getComments())) {
            logDetails.add(new LogChangesDetails("Comments", oldIpAddress.getComments(), ipAddress.getComments()));
        }
        if (!oldIpAddress.getDeviceLogin().equals(ipAddress.getDeviceLogin())) {
            logDetails.add(new LogChangesDetails("DeviceLogin", oldIpAddress.getDeviceLogin(), ipAddress.getDeviceLogin()));
        }
        if (!oldIpAddress.getDevicePassword().equals(ipAddress.getDevicePassword())) {
            logDetails.add(new LogChangesDetails("DevicePassword", oldIpAddress.getDevicePassword(), ipAddress.getDevicePassword()));
        }
        if (!oldIpAddress.getTeamId().equals(ipAddress.getTeamId())) {
            logDetails.add(new LogChangesDetails("TeamviewerID", oldIpAddress.getTeamId(), ipAddress.getTeamId()));
        }
        if (!oldIpAddress.getTeamPass().equals(ipAddress.getTeamPass())) {
            logDetails.add(new LogChangesDetails("TeamviewerPassword", oldIpAddress.getTeamPass(), ipAddress.getTeamPass()));
        }
//        if (oldIpAddress.getSubnet().getId() != ipAddress.getSubnet().getId()) {
//            logDetails.add(new LogChangesDetails("Subnet", oldIpAddress.getSubnet().getName(), ipAddress.getSubnet().getName()));
//        }
//        if (oldIpAddress.getDepartment().getId() != ipAddress.getDepartment().getId()) {
//            logDetails.add(new LogChangesDetails("Department", oldIpAddress.getDepartment().getName(), ipAddress.getDepartment().getName()));
//        }
//        if (oldIpAddress.getDeviceType().getId() != ipAddress.getDeviceType().getId()) {
//            logDetails.add(new LogChangesDetails("DeviceType", oldIpAddress.getDeviceType().getName(), ipAddress.getDeviceType().getName()));
//        }


        if (logDetails.size() > 0) {
            for (LogChangesDetails logChangesDetails : logDetails) {
                logChangesDetails.setChanges(logChanges);
            }
            logChanges.setListDetails(logDetails);
            this.ipAddressDao.saveLogChanges(logChanges);
        }


        return this.ipAddressDao.save(ipAddress);


    }

    @Override
    public boolean delete(int id) {

        LogChanges logChanges = new LogChanges();
        List<LogChangesDetails> logDetails = new ArrayList<>();
        IpAddress ipAddress = ipAddressDao.get(id);

        logChanges.setDatetime(new Date());
        logChanges.setUserName(LoggedUser.getName());
        logChanges.setIpAddress_id(ipAddress.getId());
        logChanges.setIpAddress(ipAddress.getIpAddress());

        LogChangesDetails logChangesDetails = new LogChangesDetails("DeleteIpAddress", ipAddress.getIpAddress(), "");
        logChangesDetails.setDeleted(true);
        logChangesDetails.setChanges(logChanges);
        logDetails.add(logChangesDetails);
        logChanges.setListDetails(logDetails);

        this.ipAddressDao.saveLogChanges(logChanges);

        return this.ipAddressDao.delete(id);
    }

    @Override
    public IpAddress get(int id) {
        return this.ipAddressDao.get(id);
    }

    @Override
    public List<IpAddress> getByFilter(IpAddressFilter ipAddressFilter) {
        List<IpAddress> ipAddressList = this.ipAddressDao.getByFilter(ipAddressFilter);

        Collections.sort(ipAddressList, new Comparator<IpAddress>() {
            @Override
            public int compare(IpAddress o1, IpAddress o2) {
                String[] ips1 = o1.getIpAddress().split("\\.");
                String updatedIp1 = String.format("%3s.%3s.%3s.%3s",
                        ips1[0], ips1[1], ips1[2], ips1[3]);
                String[] ips2 = o2.getIpAddress().split("\\.");
                String updatedIp2 = String.format("%3s.%3s.%3s.%3s",
                        ips2[0], ips2[1], ips2[2], ips2[3]);
                return updatedIp1.compareTo(updatedIp2);
            }
        });

        return ipAddressList;
    }

    @Override
    public IpAddress searchIp(IpSearch ip) {
        return this.ipAddressDao.searchIp(ip);
    }

    @Override
    public List<Department> getAllDepartments() {
        return this.ipAddressDao.getAllDepartments();
    }

    @Override
    public List<DeviceType> getAllDeviceTypes() {
        return this.ipAddressDao.getAllDeviceTypes();
    }

    @Override
    public List<Subnet> getAllSubnets() {
        return this.ipAddressDao.getAllSubnets();
    }

    @Override
    public Subnet getSubnet(Integer id) {
        return this.ipAddressDao.getSubnet(id);
    }

    @Override
    public User addUser(User user) {
        return this.ipAddressDao.addUser(user);
    }

    @Override
    public List<LogChanges> getHistory() {
        return ipAddressDao.getHistory();
    }
}
