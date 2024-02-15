package org.sds.delivery.repositories.parcelRepository;

import java.util.UUID;

public interface ParcelRepositoryCustom {
    Integer deleteParcelByParcelNum(Long orderId, Integer parcelNumber);
    Integer updateParcelByNumberAndStatusIN(Integer parcelNumber, UUID parcelLabel);
}