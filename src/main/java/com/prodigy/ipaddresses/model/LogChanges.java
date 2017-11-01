package com.prodigy.ipaddresses.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "log_changes")
public class LogChanges extends BaseEntity{

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datetime")
    private Date datetime;

    @Column(name = "username")
    private String userName;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "ip_address_id")
//    private IpAddress ipAddress;

    @Column(name = "ip_address_id")
    private Integer ipAddress_id;

    @Column(name = "ip_address")
    private String ipAddress;

    @OneToMany(mappedBy = "changes", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<LogChangesDetails> listDetails = new ArrayList<LogChangesDetails>();

    public LogChanges() {
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public IpAddress getIpAddress() {
//        return ipAddress;
//    }
//
//    public void setIpAddress(IpAddress ipAddress) {
//        this.ipAddress = ipAddress;
//    }
//
    public List<LogChangesDetails> getListDetails() {
        return listDetails;
    }

    public void setListDetails(List<LogChangesDetails> listDetails) {
        this.listDetails = listDetails;
    }

    public Integer getIpAddress_id() {
        return ipAddress_id;
    }

    public void setIpAddress_id(Integer ipAddress_id) {
        this.ipAddress_id = ipAddress_id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
