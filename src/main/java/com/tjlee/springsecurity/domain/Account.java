package com.tjlee.springsecurity.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Account {

    public Account() {
    }

    public Account(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String accessToken;

    private String refreshToken;

    // cascade = CascadeType.ALL : Account 맵핑클래스의 행동(삽입,업데이트,삭제)에 Role 맵핑클래스도
    // 동일하게 영향을 받겠다. 즉 Account insert/delete 되면 연결된 Role 자동 insert/delete 된다.
    // orphanRemoval : 고아객체는 삭제됨
    // Account의 상태가 변할때 List<Role>도 상태를 전이하고 싶을 경우, 기본적으로는 변화없음
    @OneToMany(targetEntity =Role.class ,mappedBy = "account"
            , cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Study> studies = new HashSet<>();

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(this.password);
    }

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    // convenient method
    public void addStudy(Study study) {
        study.setAccount(this);
        this.getStudies().add(study);
    }

    public void removeStudy(Study study) {
        this.getStudies().remove(study);
        study.setAccount(null);
    }
}
