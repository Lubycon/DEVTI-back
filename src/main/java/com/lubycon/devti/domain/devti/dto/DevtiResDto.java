package com.lubycon.devti.domain.devti.dto;

import com.lubycon.devti.domain.advertisement.entity.Advertisement;
import com.lubycon.devti.domain.review.dto.ReviewResDto;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DevtiResDto {

  private Long id;

  @NotNull
  @ApiModelProperty(value = "DEVTI 16타입", example = "VPSW")
  private String devti;

  @NotNull
  @ApiModelProperty(value = "DEVTI 제목", example = "열정적인 꿈을 가진 당신은 야망가!")
  private String devtiTitle;

  @NotNull
  @ApiModelProperty(value = "DEVTI 총평", example = "당신은 블라블라해요 블라블라하면 블라블라해서 블라블라 할수있을거에요 블라블라~~")
  private ReviewResDto generalReview;

  @NotNull
  @ApiModelProperty(value = "Bias 결과 리스트 ")
  private List<BiasReviewResult> biasResults;

  @Nullable
  @ApiModelProperty(value = "학습, 채용공고")
  private List<Advertisement> advertisementList;

  @Builder
  public DevtiResDto(Long id, @NotNull String devti, @NotNull String devtiTitle,
      @NotNull ReviewResDto generalReview,
      @NotNull List<BiasReviewResult> biasResults,
      @Nullable List<Advertisement> advertisementList) {
    this.id = id;
    this.devti = devti;
    this.devtiTitle = devtiTitle;
    this.generalReview = generalReview;
    this.biasResults = biasResults;
    this.advertisementList = advertisementList;
  }
}
