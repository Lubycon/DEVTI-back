package com.lubycon.devti.domain.bias.entity;

import com.lubycon.devti.global.code.BiasType;
import com.lubycon.devti.global.code.Pillar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bias {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "bias_id")
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "pillar", nullable = false)
  private Pillar pillar;

  @Enumerated(EnumType.STRING)
  @Column(name = "bias", nullable = false)
  private BiasType bias;

  @Column(name = "kr_bias", nullable = false)
  private String krBias;

  @Column(name = "en_bias", nullable = false)
  private String enBias;

}
