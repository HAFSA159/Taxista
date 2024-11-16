package com.taxi.taxista.service;

import com.taxi.taxista.DTO.ReservationAnalyticsDTO;
import com.taxi.taxista.exception.ReservationAnalyticsException;
import com.taxi.taxista.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationAnalyticsService {

    private final ReservationRepository reservationRepository;
    private final ReservationAnalyticsMapper analyticsMapper;

    @Transactional(readOnly = true)
    public ReservationAnalyticsDTO getAnalytics() {
        try {
            double avgPrice = reservationRepository.findAveragePricePerKm();
            double avgDistance = reservationRepository.findAverageDistance();

            var hourlyDistribution = analyticsMapper.mapHourlyDistribution(
                    reservationRepository.findHourlyDistribution()
            );

            var popularZones = analyticsMapper.mapPopularZones(
                    reservationRepository.findPopularZones()
            );

            return analyticsMapper.toDTO(avgPrice, avgDistance,
                    hourlyDistribution, popularZones);

        } catch (Exception e) {
            throw new ReservationAnalyticsException(
                    "Erreur lors du calcul des analytics des réservations", e);
        }
    }
}
