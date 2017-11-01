package com.prodigy.ipaddresses.model;

import com.prodigy.ipaddresses.to.IpAddressView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ip_addresses")
public class IpAddress extends BaseEntity {

    @NotNull
    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "mac_address")
    private String macAddress;

    @Column(name = "compname")
    private String compName;

    @Column(name = "username")
    private String userName;

    @Column(name = "port_name")
    private String portName;

    @Column(name = "comments")
    private String comments;

    @Column(name = "device_login")
    private String deviceLogin;

    @Column(name = "device_pass")
    private String devicePassword;

    @Column(name = "team_id")
    private String teamId;

    @Column(name = "team_pass")
    private String teamPass;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dep_id")
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private DeviceType deviceType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subnet_id")
    private Subnet subnet;

    public IpAddress() {
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public Subnet getSubnet() {
        return subnet;
    }

    public void setSubnet(Subnet subnet) {
        this.subnet = subnet;
    }

}
