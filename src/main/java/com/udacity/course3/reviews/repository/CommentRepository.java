package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository  extends JpaRepository<Comment, Integer> {

    @Query( "select c FROM Comment c WHERE c.review.reviews_id = :reviewId")
    List<Comment> findCommentByReview(Integer reviewId);
}


