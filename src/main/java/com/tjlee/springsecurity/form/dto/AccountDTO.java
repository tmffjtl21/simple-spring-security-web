package com.tjlee.springsecurity.form.dto;

import java.util.ArrayList;
import java.util.List;

public class AccountDTO {

    public AccountDTO() {
        super();
    }

    public AccountDTO(String username, String password, List<String> roles) {
        super();
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    private Long id;

    private String username;

    private String password;

    private List<String> roles = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
