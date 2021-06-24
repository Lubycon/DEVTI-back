package com.lubycon.devti.domain.review.service;

import com.lubycon.devti.domain.review.dao.ReviewRepository;
import com.lubycon.devti.domain.review.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

  private final ReviewRepository reviewRepository;

  public Review findByReviewType(String reviewType) {
    return reviewRepository.findReviewByReviewType(reviewType);
  }

}
