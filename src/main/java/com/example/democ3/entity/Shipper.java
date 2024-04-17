package com.example.democ3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="shippers")
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//si es autoincremental
    @Column(name ="shipperid", nullable = false)//para mapear
    private Integer shipperid;

    @Column(name ="companyname", nullable = false, length = 40)//para mapear
    private String companyname;

    @Column(name ="Phone", length = 24)//para mapear
    private String phone;
}
