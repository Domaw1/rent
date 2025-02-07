package ru.costumes.rental.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

public class BookingStatusId implements Serializable {
    private Integer booking;
    private Integer status;

    public BookingStatusId() {}

    public BookingStatusId(Integer booking, Integer status) {
        this.booking = booking;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingStatusId that = (BookingStatusId) o;
        return Objects.equals(booking, that.booking) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(booking, status);
    }
}
