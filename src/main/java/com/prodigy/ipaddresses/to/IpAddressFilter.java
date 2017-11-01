package com.prodigy.ipaddresses.to;



public class IpAddressFilter {

    private Integer department;

    private Integer subnet;

    private Integer deviceType;

    public IpAddressFilter() {
    }

    public IpAddressFilter(Integer department, Integer subnet, Integer deviceType) {
        this.department = department;
        this.subnet = subnet;
        this.deviceType = deviceType;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getSubnet() {
        return subnet;
    }

    public void setSubnet(Integer subnet) {
        this.subnet = subnet;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }
}
