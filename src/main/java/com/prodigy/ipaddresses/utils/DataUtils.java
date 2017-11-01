package com.prodigy.ipaddresses.utils;

import com.prodigy.ipaddresses.model.Department;
import com.prodigy.ipaddresses.model.DeviceType;
import com.prodigy.ipaddresses.model.IpAddress;
import com.prodigy.ipaddresses.model.Subnet;
import com.prodigy.ipaddresses.service.IpAddressService;
import com.prodigy.ipaddresses.service.IpAddressServiceImpl;
import com.prodigy.ipaddresses.to.IpAddressView;
import org.springframework.beans.factory.annotation.Autowired;

public class DataUtils {

    public static IpAddress clone(IpAddressView ipAddressView){

        IpAddress ip = new IpAddress();

        ip.setId(ipAddressView.getId());
        ip.setIpAddress(ipAddressView.getIpAddress());
        ip.setMacAddress(ipAddressView.getMacAddress());
        ip.setCompName(ipAddressView.getCompName());
        ip.setUserName(ipAddressView.getUserName());
        ip.setPortName(ipAddressView.getPortName());
        ip.setComments(ipAddressView.getComments());
        ip.setDeviceLogin(ipAddressView.getDeviceLogin());
        ip.setDevicePassword(ipAddressView.getDevicePassword());
        ip.setTeamId(ipAddressView.getTeamId());
        ip.setTeamPass(ipAddressView.getTeamPass());

        Subnet subnet = new Subnet(ipAddressView.getSubnet());
        Department department = new Department(ipAddressView.getDepartment());
        DeviceType deviceType = new DeviceType(ipAddressView.getDeviceType());

        ip.setSubnet(subnet);
        ip.setDepartment(department);
        ip.setDeviceType(deviceType);

        return ip;
    }

    public static IpAddressView clone(IpAddress ip){

        IpAddressView ipAddressView = new IpAddressView();

        ipAddressView.setId(ip.getId());
        ipAddressView.setIpAddress(ip.getIpAddress());
        ipAddressView.setMacAddress(ip.getMacAddress());
        ipAddressView.setCompName(ip.getCompName());
        ipAddressView.setUserName(ip.getUserName());
        ipAddressView.setPortName(ip.getPortName());
        ipAddressView.setComments(ip.getComments());
        ipAddressView.setDeviceLogin(ip.getDeviceLogin());
        ipAddressView.setDevicePassword(ip.getDevicePassword());
        ipAddressView.setTeamId(ip.getTeamId());
        ipAddressView.setTeamPass(ip.getTeamPass());
        ipAddressView.setDepartment(ip.getDepartment().getId());
        ipAddressView.setSubnet(ip.getSubnet().getId());
        ipAddressView.setDeviceType(ip.getDeviceType().getId());

        return ipAddressView;
    }
}
