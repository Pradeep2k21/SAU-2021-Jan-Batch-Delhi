package com.example;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.common.reflection.XMethod;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Alien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aid;
    private String aName;
    private String color;

    public Alien() {}

    public Alien(String aName, String color) {
        this.aName = aName;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aName='" + aName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAName() {
        return aName;
    }

    public void setAName(String aName) {
        this.aName = aName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
