package edu.university.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by gleb on 14.04.16.
 */
@Entity
public class Product {

    @Id
    private long id; // primary key
    private String name; // model name
    private float price; // product price in dollars

    // get set section
    public long getId(){return id;}
    public void setId(long id){ this.id = id; }

    public String getName(){return name;}
    public void setName(String name){ this.name = name; }

    public float getPrice(){return price;}
    public void setPrice(float price){ this.price = price; }
}
