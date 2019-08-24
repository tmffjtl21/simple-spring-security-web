package com.tjlee.springsecurity.form.domain;

import javax.persistence.*;

@Entity
public class Role {

    @Id @GeneratedValue
    private Long roleId;

    private Long accountId;

    private String roleName;

    @ManyToOne(targetEntity = Account.class)
    @JoinColumn(name = "accountId", referencedColumnName = "id",
            insertable = false, updatable = false)
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
