package com.example.ed_demo.Entities;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {

    public enum Gender {
        M, F
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "firstname", nullable = false, length = 50)
    private String firstname;

    @Basic
    @Column(name = "lastname", nullable = false, length = 50)
    private String lastname;

    @Basic
    @Pattern(regexp = "M|F", message = "Gender must be either M or F")
    @Column(name = "gender", nullable = false, length = 1)
    private Gender gender;

    @Past
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthdate;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            fetch = FetchType.EAGER )
    @JoinColumn(name = "fk_work_address", nullable = true)
    private WorkAddress workAddress;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            fetch = FetchType.EAGER )
    @JoinColumn(name = "fk_home_address", nullable = true)
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