package com.lubycon.devti.domain.review.dao;

import com.lubycon.devti.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

  Review findReviewByReviewType(String reviewType);
}
