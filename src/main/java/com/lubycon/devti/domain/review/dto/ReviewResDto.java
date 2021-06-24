package com.lubycon.devti.domain.review.dto;

import com.lubycon.devti.domain.review.entity.Review;
import javax.persistence.Column;
import javax.persistence.Lob;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class ReviewResDto {

  @Column(length = 500)
  private String title;

  @Lob
  @Column(length = 500)
  private String contents;

  @Builder
  public ReviewResDto(String title, String contents) {
    this.title = title;
    this.contents = contents;
  }

  public ReviewResDto toResDto(Review review) {
    return ReviewResDto.builder()
        .title(review.getTitle())
        .contents(review.getContents())
        .build();
  }
}