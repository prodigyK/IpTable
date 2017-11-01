package com.prodigy.ipaddresses.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "subnets")
public class Subnet extends BaseEntity{

    @Column(name = "net")
    private String name;

    @OneToMany
    private List<IpAddress> ipAddresses;

    public Subnet() {
    }

    public Subnet(Integer id) {
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
        return "Subnet{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
