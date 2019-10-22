package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    //To select all reviews from a single prod_id
    @Query(value = "select r FROM Review r WHERE r.product.prod_id = :productId")
    List<Review> findReviewsbyProduct(Integer productId);
}
