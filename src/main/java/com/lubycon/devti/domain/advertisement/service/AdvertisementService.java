package com.lubycon.devti.domain.advertisement.service;

import com.lubycon.devti.domain.advertisement.dao.AdvertisementRepository;
import com.lubycon.devti.domain.advertisement.dto.AdvertisementResDto;
import com.lubycon.devti.domain.advertisement.entity.Advertisement;
import com.lubycon.devti.global.code.AdvertisementType;
import java.util.List;
import java.util.stream.Collectors;
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

    List<AdvertisementResDto> advertisementResDtos = advertisements.stream()
        .map(AdvertisementResDto::convertResponseDto)
        .collect(Collectors.toList());

    return advertisementResDtos;
  }

  public List<Advertisement> findAll() {
    return advertisementRepository.findAll();
  }
}
