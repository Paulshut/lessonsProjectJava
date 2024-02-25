package org.sds.delivery.repositories.parcelRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.sds.delivery.entities.Parcel;
import org.sds.delivery.enums.ParcelStatus;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.UUID;

import static org.sds.delivery.entities.QParcel.parcel;

public class ParcelRepositoryCustomImpl extends QuerydslRepositorySupport
        implements ParcelRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public ParcelRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(Parcel.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Integer deleteParcelByParcelNum(Long orderId, Integer parcelNumber) {
        jpaQueryFactory.delete(parcel)
                .where(parcel.parcelNumber.eq(parcelNumber)
                        .and(parcel.order.id.eq(orderId))
                        .and(parcel.parcelStatus.in(ParcelStatus.NOT_REGISTERED)))
                .execute();
        return parcelNumber;
    }

    @Override
    public void updateParcelByNumberAndStatusInNotRegistered(Integer parcelNumber, UUID parcelLabel) {
        jpaQueryFactory.update(parcel)
                .set(parcel.parcelStatus, ParcelStatus.REGISTERED)
                .set(parcel.parcelLabel, parcelLabel)
                .where(parcel.parcelNumber.eq(parcelNumber)
                        .and(parcel.parcelStatus.in(ParcelStatus.NOT_REGISTERED)))
                .execute();
    }
}