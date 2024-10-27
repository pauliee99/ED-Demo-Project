package com.example.ed_demo.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "home_addresses")
public class HomeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "street_name", nullable = true, length = 100)
    private String street_name;

    @Basic
    @Column(name = "street_num", nullable = true)
    private int street_num;

    @Basic
    @Column(name = "postal_code", nullable = true)
    private int postal_code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public int getStreet_num() {
        return street_num;
    }

    public void setStreet_num(int street_num) {
        this.street_num = street_num;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    @Override
    public String toString() {
        return street_name + " " + street_num + ",  " + postal_code;
    }

    // @Override
    // public String toString() {
    //     return "HomeAddress [id=" + id + ", street_name=" + street_name + ", street_num=" + street_num
    //             + ", postal_code=" + postal_code + "]";
    // }

    
}
