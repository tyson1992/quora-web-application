package com.upgrad.quora.service.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
* CREATE TABLE IF NOT EXISTS USERS(
*   id SERIAL,
*   uuid VARCHAR(200) NOT NULL ,
*   firstName VARCHAR(30) NOT NULL ,
*   lastName VARCHAR(30) NOT NULL ,
*   userName VARCHAR(30) UNIQUE NOT NULL,
*   email VARCHAR(50) UNIQUE NOT NULL ,
*   password VARCHAR(255) NOT NULL,
*   salt VARCHAR(200) NOT NULL ,
*   country VARCHAR(30) ,
*   aboutMe VARCHAR(50),
*   dob VARCHAR(30),
*   role VARCHAR(30),
*   contactNumber VARCHAR(30),
*   PRIMARY KEY (id));
* */

@Entity
@Table(name = "USERS")
@NamedQueries(
        {
                @NamedQuery(name = "userByUuid", query = "select u from User u where u.uuid = :uuid"),
                @NamedQuery(name = "userByEmail", query = "select u from User u where u.email = :email")
        }
)
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "UUID")
    @NotNull
    private String uuid;

    @Column(name = "FIRSTNAME")
    @NotNull
    private String firstName;

    @Column(name = "LASTNAME")
    @NotNull
    private String lastName;

    @Column(name = "USERNAME")
    @NotNull
    private String userName;

    @Column(name = "EMAIL")
    @NotNull
    private String email;

    @Column(name = "PASSWORD")
    @NotNull
    private String password;

    @Column(name = "SALT")
    @NotNull
    private String salt;

    @Column(name = "COUNTRY")
    @NotNull
    private String country;

    @Column(name = "ABOUTME")
    @NotNull
    private String aboutMe;

    @Column(name = "DOB")
    @NotNull
    private String dob;

    @Column(name = "ROLE")
    @NotNull
    private String role;

    @Column(name = "CONTACTNUMBER")
    @NotNull
    private String contactNumber;


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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", country='" + country + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", dob='" + dob + '\'' +
                ", role='" + role + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
