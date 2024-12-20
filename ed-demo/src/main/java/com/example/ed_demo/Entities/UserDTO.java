package com.example.ed_demo.Entities;

import java.time.LocalDate;

public class UserDTO {

    private int id;

    private String firstname;

    private String lastname;

    private int gender;

    private LocalDate birthdate;

    private WorkAddress workAddress;

    private HomeAddress homeAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public WorkAddress getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(WorkAddress workAddress) {
        this.workAddress = workAddress;
    }

    public HomeAddress getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(HomeAddress homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
                + ", birthdate=" + birthdate + ", workAddress=" + workAddress + ", homeAddress=" + homeAddress + "]";
    }

    
}