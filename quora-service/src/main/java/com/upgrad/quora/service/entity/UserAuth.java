package com.upgrad.quora.service.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

    /*ID BIGSERIAL PRIMARY KEY,
    uuid VARCHAR(200) NOT NULL,
    USER_ID INTEGER NOT NULL,
    ACCESS_TOKEN VARCHAR(500) NOT NULL,
    EXPIRES_AT TIMESTAMP NOT NULL,
    LOGIN_AT TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    LOGOUT_AT TIMESTAMP NULL
    */

@Entity
@Table(name = "USER_AUTH")
@NamedQueries({
        @NamedQuery(name = "userAuthTokenByAccessToken" , query = "select ut from UserAuth ut where ut.accessToken = :accessToken ")
})
public class UserAuth {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "uuid")
    @NotNull
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @NotNull
    private User user;

    @Column(name = "ACCESS_TOKEN")
    @NotNull
    private String accessToken;

    @Column(name = "EXPIRES_AT")
    @NotNull
    private Date expiresAt;

    @Column(name = "LOGIN_AT")
    @NotNull
    private Date loginAt;

    @Column(name = "LOGOUT_AT")
    private Date logoutAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Date getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(Date loginAt) {
        this.loginAt = loginAt;
    }

    public Date getLogoutAt() {
        return logoutAt;
    }

    public void setLogoutAt(Date logoutAt) {
        this.logoutAt = logoutAt;
    }

    @Override
    public String toString() {
        return "UserAuth{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", userId=" + user.toString() +
                ", accessToken='" + accessToken + '\'' +
                ", expiresAt=" + expiresAt +
                ", loginAt=" + loginAt +
                ", logoutAt=" + logoutAt +
                '}';
    }
}
