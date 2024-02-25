package org.sds.delivery.repositories.parcelRepository;

import java.util.UUID;

public interface ParcelRepositoryCustom {
    Integer deleteParcelByParcelNum(Long orderId, Integer parcelNumber);
    void updateParcelByNumberAndStatusInNotRegistered(Integer parcelNumber, UUID parcelLabel);
}