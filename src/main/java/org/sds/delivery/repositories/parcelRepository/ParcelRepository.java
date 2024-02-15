package org.sds.delivery.repositories.parcelRepository;

import org.sds.delivery.entities.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<Parcel, Long>, ParcelRepositoryCustom{
}
