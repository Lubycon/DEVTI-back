package com.lubycon.devti.domain.preset.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lubycon.devti.domain.preset.dto.PresetResDto;
import com.lubycon.devti.domain.question.entity.Question;
import com.lubycon.devti.global.entity.BaseTimeEntity;
import com.lubycon.devti.global.util.ModelMapperUtils;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Preset extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "preset_id")
  private Long id;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "question_id")
  private Question question;

  @Column(length = 100)
  private String label;

  public PresetResDto toDto() {
    return ModelMapperUtils.getInstance().map(this, PresetResDto.class);
  }
}