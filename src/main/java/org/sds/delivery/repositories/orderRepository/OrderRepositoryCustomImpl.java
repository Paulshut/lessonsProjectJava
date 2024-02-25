package org.sds.delivery.repositories.orderRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.sds.delivery.entities.Order;
import org.sds.delivery.enums.ParcelStatus;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import static org.sds.delivery.entities.QOrder.order;
import static org.sds.delivery.entities.QParcel.parcel;
import static org.sds.delivery.enums.OrderStatus.*;

public class OrderRepositoryCustomImpl extends QuerydslRepositorySupport

        implements OrderRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;


    public OrderRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(Order.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public void updateOrderStatusByUserIdAndOrderNumberAndStatusInWorkOrCreated(Long userId, Integer orderNumber) {
        jpaQueryFactory.update(order)
                .set(order.orderStatus, CANCELED)
                .where(order.user.id.eq(userId)
                        .and(order.orderNumber.eq(orderNumber))
                        .and(order.orderStatus.in(IN_WORK, CREATED)))
                .execute();
    }

    @Override
    public void updateOrderToInWorkWhenParcelStatusInRegistered() {
        jpaQueryFactory.update(order)
                .set(order.orderStatus, IN_WORK)
                .where(order.id.in(
                        jpaQueryFactory.select(parcel.order.id)
                                .from(parcel)
                                .where(parcel.parcelStatus.eq(ParcelStatus.REGISTERED))
                                .groupBy(parcel.order.id)
                                .having(parcel.order.id.count().eq(
                                        jpaQueryFactory.select(parcel.count())
                                                .from(parcel)
                                                .where(parcel.order.id.eq(order.id))
                                ))
                )).execute();
    }
}