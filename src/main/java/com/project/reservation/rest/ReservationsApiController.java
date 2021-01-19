package com.project.reservation.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.reservation.model.ReservationDates;
import com.project.reservation.model.ReservationRequest;
import com.project.reservation.model.UpdateReservationRequest;
import com.project.reservation.service.ReservationService;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-09T19:06:38.954Z[GMT]")
@RestController
@Data
@AllArgsConstructor
public class ReservationsApiController implements ReservationsApi {

    private static final Logger log = LoggerFactory.getLogger(ReservationsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final ReservationService reservationService;

    public ResponseEntity<List<Date>> checkAvailability(ReservationDates reservationDates) {
        return ResponseEntity.ok(reservationService.checkAvailability(reservationDates));
    }

    public ResponseEntity<Void> cancelReservation(Long id) {
        String accept = request.getHeader("Accept");
        reservationService.cancelReservation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public ResponseEntity<Long> makeReservation(ReservationRequest body) {
        return ResponseEntity.ok(reservationService.makeReservation(body));
    }

    public ResponseEntity<Void> modifyReservation(UpdateReservationRequest body) {
        reservationService.modifyReservation(body);
        return ResponseEntity.ok().build();
    }

}
