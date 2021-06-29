package com.lubycon.devti.domain.devti.dto;

import com.lubycon.devti.domain.bias.entity.Bias;
import com.lubycon.devti.domain.review.dto.ReviewResDto;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BiasReviewResult {

  @NotNull
  @ApiModelProperty(value = "Bias 정보")
  private Bias bias;

  @Min(0)
  @Max(100)
  @ApiModelProperty(value = "Bias percent", example = "10")
  private Integer weight;

  @NotNull
  @ApiModelProperty(value = "Bias 총평", example = "필러 총평")
  private ReviewResDto review;

  @Builder
  public BiasReviewResult(@NotNull Bias bias, @NotNull Integer weight,
      @NotNull ReviewResDto review) {
    this.bias = bias;
    this.weight = weight;
    this.review = review;
  }
}
