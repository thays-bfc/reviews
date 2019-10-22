package com.udacity.course3.reviews.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table( name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//If a primary column is set as AUTO_INCREMENT in the table, this strategy can be used.
    @Column(name = "prod_id")
    private int prod_id;

    @NotBlank
    @Column(name = "prod_name")
    @Size(min = 1, max = 300)
    private String prod_name;

    @Column(name = "price")
    private double price;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private List<Review> reviews;

   public Product(){
    }
   public Product(String prod_name, double price){
        this.prod_name = prod_name;
        this.price = price;
    }

    public int getProd_id() {
        return prod_id;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
