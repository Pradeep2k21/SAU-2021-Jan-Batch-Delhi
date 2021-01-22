package com.example;

import com.sun.istack.Nullable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)

public class Pradeep {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int sID;
    String favColor;
    String favFood;
    int age;


    public Pradeep(){}

    @Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
    @OneToMany
    List<Alien>AList;
    {
        AList = new ArrayList<Alien>();
    }




    public Pradeep(String favColor, String favFood, int age, List<Alien>alien)
    {
        this.favColor = favColor;
        this.favFood = favFood;
        this.age =  age;
        this.AList = alien;
    }

    public List<Alien> getAlienList() {
        return AList;
    }

    public void setAlienList(List<Alien> alienList) {
        this.AList = alienList;
    }

    @Override
    public String toString() {
        return "sID=" + sID +
                ", favFood='" + favFood + '\'' +
                ", favColor='" + favColor + '\'' +
                ", age=" + age +
                ", alienList=" + AList +
                '}';
    }

    //*********** getter setter methods *************

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getFavColor() {
        return favColor;
    }

    public void setFavColor(String favColor) {
        this.favColor = favColor;
    }

    public String getFavFood() {
        return favFood;
    }

    public void setFavFood(String favFood) {
        this.favFood = favFood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}