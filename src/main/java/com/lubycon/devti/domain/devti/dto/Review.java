package com.lubycon.devti.domain.devti.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Review {

  @NotNull
  @ApiModelProperty(value = "필러 총평 제목", example = "한치의 비뚤어짐도 용납하지 않는 당신!")
  private String title;

  @NotNull
  @ApiModelProperty(value = "필러 총평 내용", example = "주위에서 평소 미적인 감각이 탁월하다는 칭찬 또는 평가를 받은 경험이 있습니다.")
  private String contents;

  @Builder
  public Review(@NotNull String title, @NotNull String contents) {
    this.title = title;
    this.contents = contents;
  }
}
