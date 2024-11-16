package com.taxi.taxista.mapper;

import com.taxi.taxista.DTO.ReservationDTO;
import com.taxi.taxista.entity.Reservation;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    // Define mapping logic here

    public ReservationDTO toDTO(Reservation reservation) {
        // Example conversion
        ReservationDTO dto = new ReservationDTO();
        dto.setId(reservation.getId());
        dto.setVehiculeType(reservation.getVehiculeType());
        dto.setStatus(reservation.getStatus());
        return dto;
    }

    public Reservation toEntity(ReservationDTO reservationDTO) {
        // Example conversion
        Reservation reservation = new Reservation();
        reservation.setVehiculeType(reservationDTO.getVehiculeType());
        reservation.setStatus(reservationDTO.getStatus());
        return reservation;
    }
}
