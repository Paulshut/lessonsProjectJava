package org.sds.delivery.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sds.delivery.enums.OrderStatus;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "ORDER_NUMBER")
    private Integer orderNumber;
    @Column(name = "SENDER_NAME")
    private String senderName;
    @Column(name = "RECEIVER_NAME")
    private String receiverName;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "SENDER_COUNTRY")),
            @AttributeOverride(name = "city", column = @Column(name = "SENDER_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "SENDER_STREET")),
            @AttributeOverride(name = "house", column = @Column(name = "SENDER_HOUSE")),
            @AttributeOverride(name = "flat", column = @Column(name = "SENDER_FLAT")),
            @AttributeOverride(name = "index", column = @Column(name = "SENDER_INDEX"))
    })
    private Address senderAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "RECEIVER_COUNTRY")),
            @AttributeOverride(name = "city", column = @Column(name = "RECEIVER_CITY")),
            @AttributeOverride(name = "street", column = @Column(name = "RECEIVER_STREET")),
            @AttributeOverride(name = "house", column = @Column(name = "RECEIVER_HOUSE")),
            @AttributeOverride(name = "flat", column = @Column(name = "RECEIVER_FLAT")),
            @AttributeOverride(name = "index", column = @Column(name = "RECEIVER_INDEX"))
    })
    private Address receiverAddress;

    @Column(name = "DATA_CREATE")
    private LocalDate dateCreate;

    @Enumerated(STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order")
    private List<Parcel> parcels;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "USER_ID")
    private User user;
}