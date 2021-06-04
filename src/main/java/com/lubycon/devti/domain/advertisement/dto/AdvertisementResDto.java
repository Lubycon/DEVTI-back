package com.lubycon.devti.domain.advertisement.dto;


import com.lubycon.devti.domain.advertisement.entity.Advertisement;
import com.lubycon.devti.global.code.AdvertisementType;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AdvertisementResDto {

  private Long id;
  private String advertiser;
  private String title;
  private String imageUrl;
  private LocalDate advertisementStartDate;
  private LocalDate advertisementEndDate;
  private AdvertisementType advertisementType;

  @Builder
  public AdvertisementResDto(Long id, String advertiser, String title, String imageUrl,
      LocalDate advertisementStartDate, LocalDate advertisementEndDate,
      AdvertisementType advertisementType) {
    this.id = id;
    this.advertiser = advertiser;
    this.title = title;
    this.imageUrl = imageUrl;
    this.advertisementStartDate = advertisementStartDate;
    this.advertisementEndDate = advertisementEndDate;
    this.advertisementType = advertisementType;
  }

  public static AdvertisementResDto convertResponseDto(Advertisement advertisement) {
    return AdvertisementResDto.builder()
        .id(advertisement.getId())
        .advertiser(advertisement.getAdvertiser())
        .title(advertisement.getTitle())
        .imageUrl(advertisement.getImageUrl())
        .advertisementStartDate(advertisement.getAdvertisementStartDate())
        .advertisementEndDate(advertisement.getAdvertisementEndDate())
        .advertisementType(advertisement.getAdvertisementType())
        .build();
  }
}