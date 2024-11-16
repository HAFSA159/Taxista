package com.taxi.taxista.repository;

import com.taxi.taxista.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT AVG(r.prix) FROM Reservation r")
    double findAveragePricePerKm();

    @Query("SELECT AVG(r.distanceKm) FROM Reservation r")
    double findAverageDistance();

    @Query("SELECT FUNCTION('HOUR', r.heureDebutCourse) as heure, COUNT(r) as nombre " +
            "FROM Reservation r " +
            "GROUP BY FUNCTION('HOUR', r.heureDebutCourse) " +
            "ORDER BY heure")
    List<Object[]> findHourlyDistribution();

    @Query("SELECT r.adresseDepart as zone, COUNT(r) as nombre " +
            "FROM Reservation r " +
            "GROUP BY r.adresseDepart " +
            "ORDER BY nombre DESC")
    List<Object[]> findPopularZones();
}
