package com.ibm.activerecord.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

//Active Record : The entity class becomes repository class
@Entity
public class Customer extends PanacheEntity {
 //columns and fields ; id field we dont need to mention,because it is already there in super class
    @Column(name="name")
    public String name;
    @Column(name="city")
    public String city;
}
