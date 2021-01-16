package com.project.reservation.mapper;

import com.project.reservation.entity.Reservation;
import com.project.reservation.model.ReservationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {

    @Mapping(target = "arrivalDate", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "departureDate", dateFormat = "yyyy-MM-dd")
    Reservation mapReservation(ReservationRequest reservation);

    @Mapping(target = "arrivalDate", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "departureDate", dateFormat = "yyyy-MM-dd")
    Reservation mapUpdateReservation(Reservation reservation);
}
