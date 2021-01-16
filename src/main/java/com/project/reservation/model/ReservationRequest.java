package com.project.reservation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import org.springframework.validation.annotation.Validated;

/**
 * Body1
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-09T19:06:38.954Z[GMT]")

public class ReservationRequest {

    @JsonProperty("arrivalDate")
    private String arrivalDate = null;

    @JsonProperty("departureDate")
    private String departureDate = null;

    @JsonProperty("email")
    private String email = null;

    @JsonProperty("firstName")
    private String firstName = null;

    @JsonProperty("lastName")
    private String lastName = null;

    public ReservationRequest arrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
        return this;
    }

    /**
     * Get arrivalDate
     *
     * @return arrivalDate
     **/
    @Schema(description = "")

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public ReservationRequest departureDate(String departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    /**
     * Get departureDate
     *
     * @return departureDate
     **/
    @Schema(description = "")

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public ReservationRequest email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     **/
    @Schema(description = "")

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ReservationRequest firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Get firstName
     *
     * @return firstName
     **/
    @Schema(description = "")

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public ReservationRequest lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Get lastName
     *
     * @return lastName
     **/
    @Schema(description = "")

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReservationRequest reservationRequest = (ReservationRequest) o;
        return Objects.equals(this.arrivalDate, reservationRequest.arrivalDate) &&
            Objects.equals(this.departureDate, reservationRequest.departureDate) &&
            Objects.equals(this.email, reservationRequest.email) &&
            Objects.equals(this.firstName, reservationRequest.firstName) &&
            Objects.equals(this.lastName, reservationRequest.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrivalDate, departureDate, email, firstName, lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Body1 {\n");

        sb.append("    arrivalDate: ").append(toIndentedString(arrivalDate)).append("\n");
        sb.append("    departureDate: ").append(toIndentedString(departureDate)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
