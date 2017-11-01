package com.prodigy.ipaddresses.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NotNull
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    public User() {
    }

    public User(String login, String password, boolean enabled) {
        this.login = login;
        this.password = password;
        this.enabled = enabled;
    }

    public User(Integer id, String login, String password, boolean enabled) {
        super(id);
        this.login = login;
        this.password = password;
        this.enabled = enabled;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
