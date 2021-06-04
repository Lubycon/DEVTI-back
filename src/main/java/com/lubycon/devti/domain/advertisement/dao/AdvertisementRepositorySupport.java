package com.lubycon.devti.domain.advertisement.dao;

import com.lubycon.devti.domain.advertisement.entity.Advertisement;
import com.lubycon.devti.global.code.AdvertisementType;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface AdvertisementRepositorySupport {

  @Transactional(readOnly = true)
  List<Advertisement> findAllByAdvertisementType(AdvertisementType advertisementType);
}
