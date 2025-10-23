package com.lab8.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Accounts") // liên kết đến bảng Accounts trong SQL Server
public class Account {

    @Id
    private String username;
    private String password;
    private String fullname;
    private boolean admin;

    // ===== CONSTRUCTORS =====
    public Account() {
    }

    public Account(String username, String password, String fullname, boolean admin) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.admin = admin;
    }

    // ===== GETTERS & SETTERS =====
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    // ===== toString() =====
    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", admin=" + admin +
                '}';
    }
}
