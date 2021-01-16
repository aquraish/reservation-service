package com.project.reservation.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateReservationRequest extends ReservationRequest {

    private Long id;
}
