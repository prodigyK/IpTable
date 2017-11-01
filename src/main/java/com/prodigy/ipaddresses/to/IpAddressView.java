package com.prodigy.ipaddresses.to;


public class IpAddressView {

    private Integer id;

    private String ipAddress;

    private String macAddress;

    private String compName;

    private String userName;

    private String portName;

    private String comments;

    private String deviceLogin;

    private String devicePassword;

    private String teamId;

    private String teamPass;

    private Integer department;

    private Integer deviceType;

    private Integer subnet;

    public IpAddressView() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDeviceLogin() {
        return deviceLogin;
    }

    public void setDeviceLogin(String deviceLogin) {
        this.deviceLogin = deviceLogin;
    }

    public String getDevicePassword() {
        return devicePassword;
    }

    public void setDevicePassword(String devicePassword) {
        this.devicePassword = devicePassword;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamPass() {
        return teamPass;
    }

    public void setTeamPass(String teamPass) {
        this.teamPass = teamPass;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getSubnet() {
        return subnet;
    }

    public void setSubnet(Integer subnet) {
        this.subnet = subnet;
    }
}
