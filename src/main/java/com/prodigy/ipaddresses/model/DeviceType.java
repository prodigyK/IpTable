package com.prodigy.ipaddresses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "device_types")
public class DeviceType extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany
    private List<IpAddress> ipAddresses;

    public DeviceType() {
    }

    public DeviceType(Integer id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IpAddress> getIpAddresses() {
        return ipAddresses;
    }

    public void setIpAddresses(List<IpAddress> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    @Override
    public String toString() {
        return "DeviceType{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
