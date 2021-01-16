package com.project.reservation.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import org.springframework.validation.annotation.Validated;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-01-09T19:06:38.954Z[GMT]")

public class ReservationDates {

    @JsonProperty("endDate")
    private String endDate = null;

    @JsonProperty("startDate")
    private String startDate = null;

    public ReservationDates endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Get endDate
     *
     * @return endDate
     **/
    @Schema(description = "")

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ReservationDates startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Get startDate
     *
     * @return startDate
     **/
    @Schema(description = "")

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReservationDates reservationDates = (ReservationDates) o;
        return Objects.equals(this.endDate, reservationDates.endDate) &&
            Objects.equals(this.startDate, reservationDates.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endDate, startDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Body {\n");

        sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
        sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
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
