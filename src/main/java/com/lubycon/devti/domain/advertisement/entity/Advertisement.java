package com.lubycon.devti.domain.advertisement.entity;

import com.lubycon.devti.global.code.AdvertisementType;
import com.lubycon.devti.global.entity.BaseTimeEntity;
import java.time.LocalDate;
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
public class Advertisement extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "advertisement_id")
  private Long id;

  @Column(name = "advertiser", nullable = false)
  private String advertiser;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "imageUrl", nullable = false)
  private String imageUrl;

  @Column(name = "advertisement_start_date", nullable = false)
  private LocalDate advertisementStartDate;

  @Column(name = "advertisement_ent_date", nullable = false)
  private LocalDate advertisementEndDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "advertisement_type", nullable = false, insertable = false, updatable = false)
  private AdvertisementType advertisementType;

}