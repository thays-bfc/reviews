package com.udacity.course3.reviews.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table( name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviews_id")
    private int reviews_id;

    @NotBlank
    @Column(name = "reviewer_name")
    @Size(min = 1, max = 300)
    private String reviewer_name;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    private Product product;

    @JsonIgnore
    @OneToMany(mappedBy = "review", cascade = CascadeType.PERSIST)
    private List<Comment> comment;

    public int getReviews_id() {
        return reviews_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public String getReviewer_name() {
        return reviewer_name;
    }

    public void setReviewer_name(String reviewer_name) {
        this.reviewer_name = reviewer_name;
    }
}
