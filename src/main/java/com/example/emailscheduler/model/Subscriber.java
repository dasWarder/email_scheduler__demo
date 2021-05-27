package com.example.emailscheduler.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer")
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;
}
