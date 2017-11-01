package com.prodigy.ipaddresses.service;

import com.prodigy.ipaddresses.model.*;
import com.prodigy.ipaddresses.to.IpAddressFilter;
import com.prodigy.ipaddresses.to.IpSearch;

import java.util.List;

public interface IpAddressService {

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

    List<LogChanges> getHistory();
}

