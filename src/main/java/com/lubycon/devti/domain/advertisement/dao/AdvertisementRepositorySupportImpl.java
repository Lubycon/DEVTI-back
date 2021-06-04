package com.lubycon.devti.domain.advertisement.dao;

import com.lubycon.devti.domain.advertisement.entity.Advertisement;
import com.lubycon.devti.domain.advertisement.entity.QAdvertisement;
import com.lubycon.devti.global.code.AdvertisementType;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class AdvertisementRepositorySupportImpl
    extends QuerydslRepositorySupport implements AdvertisementRepositorySupport {

  private final JPAQueryFactory queryFactory;
  private final QAdvertisement advertisement = QAdvertisement.advertisement;

  public AdvertisementRepositorySupportImpl(final JPAQueryFactory queryFactory) {

    super(Advertisement.class);
    this.queryFactory = queryFactory;
  }

  @Override
  public List<Advertisement> findAllByAdvertisementType(AdvertisementType advertisementType) {
    return queryFactory.selectFrom(advertisement)
        .where(advertisement.advertisementStartDate.before(LocalDate.now())
            .and(advertisement.advertisementEndDate.after(LocalDate.now()))
            .and(validateAdvertisementType(advertisementType)))
        .fetch();
  }

  private BooleanExpression validateAdvertisementType(AdvertisementType advertisementType) {
    if (advertisementType.equals(AdvertisementType.LECTURE)) {
      return advertisement.advertisementType.eq(AdvertisementType.LECTURE);
    }
    if (advertisementType.equals(AdvertisementType.RECRUIT)) {
      return advertisement.advertisementType.eq(AdvertisementType.RECRUIT);
    }
    if (advertisementType.equals(AdvertisementType.ETC)) {
      return advertisement.advertisementType.eq(AdvertisementType.ETC);
    }
    return null;
  }
}
