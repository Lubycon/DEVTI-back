package com.lubycon.devti.domain.advertisement.service;

import com.lubycon.devti.domain.advertisement.dao.AdvertisementRepository;
import com.lubycon.devti.domain.advertisement.dto.AdvertisementResDto;
import com.lubycon.devti.domain.advertisement.entity.Advertisement;
import com.lubycon.devti.global.code.AdvertisementType;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertisementService {

  final AdvertisementRepository advertisementRepository;

  public List<AdvertisementResDto> findAllAdvertisementByAdvertisementType(
      AdvertisementType advertisementType) {
    List<Advertisement> advertisements = advertisementRepository
        .findAllByAdvertisementType(advertisementType);

    List<AdvertisementResDto> advertisementResDtos = new ArrayList<>(advertisements.size());
    advertisements.stream().forEach((advertisement) -> {
      advertisementResDtos.add(AdvertisementResDto.convertResponseDto(advertisement));
    });
    return advertisementResDtos;
  }
}
