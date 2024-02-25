package org.sds.delivery.services.parcelService;

import lombok.RequiredArgsConstructor;
import org.sds.delivery.dto.requests.parcelRequest.AddParcelRequest;
import org.sds.delivery.dto.requests.parcelRequest.DeleteParcelRequest;
import org.sds.delivery.dto.responses.parcelResponse.*;
import org.sds.delivery.entities.Order;
import org.sds.delivery.entities.Parcel;
import org.sds.delivery.exceptions.OrderNotFoundException;
import org.sds.delivery.feingClients.LabelApiClient;
import org.sds.delivery.feingClients.ParcelNumberApiClient;
import org.sds.delivery.mappers.parcelMapper.ParcelMapper;
import org.sds.delivery.repositories.orderRepository.OrderRepository;
import org.sds.delivery.repositories.parcelRepository.ParcelRepository;
import org.sds.delivery.utils.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {
    private final ParcelRepository parcelRepository;
    private final ParcelMapper parcelMapper;
    private final OrderRepository orderRepository;
    private final ParcelNumberApiClient parcelNumberApiClient;
    private final LabelApiClient labelApiClient;
    private final MessageService messageService;

    @Override
    @Transactional
    public AddParcelResponse addParcel(Long orderId, AddParcelRequest request) {
        Order order = orderRepository.getOrderById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId.toString()));
        Parcel parcel = parcelMapper.mapParcelRequestToParcel(request);
        parcel.setOrder(order);
        parcel.setParcelNumber(getParcelNumber());
        parcelRepository.save(parcel);
        return parcelMapper.mapParcelToAddParcelResponse(parcel);
    }

    @Override
    @Transactional
    public DeleteParcelResponse deleteParcelByParcelNum(Long orderId, DeleteParcelRequest request) {
        Integer parcelNum = parcelRepository.deleteParcelByParcelNum(orderId, request.getParcelNumber());
        return messageService.getMessageDeleted(parcelNum);
    }

    @Override
    @Transactional
    public RegistrationParcelResponse registrationParcel(Integer parcelNumber) {
        UUID labelNumber = getLabelNumber(parcelNumber);
        parcelRepository.updateParcelByNumberAndStatusInNotRegistered(parcelNumber, labelNumber);
        return messageService.getRegistrationResponse(labelNumber);

    }


    private Integer getParcelNumber() {
        ParcelNumberResponse parcelNumber = parcelNumberApiClient.getParcelNumber();
        return parcelNumber.getParcelNumber();
    }

    private UUID getLabelNumber(Integer parcelNumber) {
        LabelNumberResponse labelNumber = labelApiClient.getLabelNumber(parcelNumber);
        return labelNumber.getLabelNumber();
    }
}