package com.example.ed_demo.Entities;

import java.time.LocalDate;

// import com.example.ed_demo.Entities.User.Gender;

public class UsersDTO {

    public enum Gender {
        M, F
    }

    private int id;

    private String firstname;

    private String lastname;

    private Gender gender;

    private LocalDate birthdate;

    private String workAddress;

    private String homeAddress;

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
                + ", birthdate=" + birthdate + ", workAddress=" + workAddress + ", homeAddress=" + homeAddress + "]";
    }

    
}