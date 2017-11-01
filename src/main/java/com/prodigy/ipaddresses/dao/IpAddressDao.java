package com.prodigy.ipaddresses.dao;

import com.prodigy.ipaddresses.model.*;
import com.prodigy.ipaddresses.to.IpAddressFilter;
import com.prodigy.ipaddresses.to.IpSearch;

import java.util.List;

public interface IpAddressDao {

    IpAddress save(IpAddress ipAddress);

    boolean delete(int id);

    IpAddress get(int id);

    List<IpAddress> getByFilter(IpAddressFilter ipAddressFilter);

    IpAddress searchIp(IpSearch ip);

    List<Department> getAllDepartments();

    List<DeviceType> getAllDeviceTypes();

    List<Subnet> getAllSubnets();

    Subnet getSubnet(Integer id);

    User addUser(User user);

    User getUserByName(String name);

    LogChanges saveLogChanges(LogChanges log);

    List<LogChanges> getHistory();
}
