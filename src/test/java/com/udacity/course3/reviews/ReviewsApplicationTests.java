package com.udacity.course3.reviews;

import com.udacity.course3.reviews.domain.Comment;
import com.udacity.course3.reviews.domain.Product;
import com.udacity.course3.reviews.domain.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewsApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void injectedComponentsAreNotNull(){
		Assert.assertNotNull(productRepository);
		Assert.assertNotNull(reviewRepository);
		Assert.assertNotNull(commentRepository);
		Assert.assertNotNull(entityManager);
	}


	@Before
	public void setUp(){
		Product product = new Product("Kindle", 300.0);

		Review review = new Review();
		review.setReviewer_name("Mary Anne");
		review.setProduct(product);

		Comment comment = new Comment();
		comment.setComment("Five stars review.");
		comment.setReview(review);

		review.setComment(Arrays.asList(comment));

		product.setReviews(Arrays.asList(review));

		Product new_product = entityManager.persist(product);

	}
//	The project has tests for all the methods in the Spring Data JPA repositories

	@Test
	public void testFindAllProducts() {

		List<Product> products = productRepository.findAll();
		Assert.assertNotNull(products);

	}

@Test
public void testFindReviewsbyProduct() {

	List<Review> reviews = reviewRepository.findReviewsbyProduct(1);
	Assert.assertNotNull(reviews);

}

	@Test
	public void testFindCommentByReview() {

		List<Comment> comments = commentRepository.findCommentByReview(1);
		Assert.assertNotNull(comments);

	}

}