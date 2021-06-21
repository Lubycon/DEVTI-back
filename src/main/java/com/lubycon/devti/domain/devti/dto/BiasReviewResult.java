package com.lubycon.devti.domain.devti.dto;

import com.lubycon.devti.domain.bias.entity.Bias;
import com.lubycon.devti.domain.review.entity.Review;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BiasResult {

  @NotNull
  @ApiModelProperty(value = "Bias 정보")
  private Bias bias;

  @Min(0)
  @Max(100)
  @ApiModelProperty(value = "Bias percent", example = "10")
  private long weight;

  @NotNull
  @ApiModelProperty(value = "Bias 총평", example = "필러 총평")
  private Review review;

  @Builder
  public BiasResult(@NotNull Bias bias, @NotNull long weight,
      @NotNull Review review) {
    this.bias = bias;
    this.weight = weight;
    this.review = review;
  }
}
