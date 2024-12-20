package com.taxi.taxista.service;

import com.taxi.taxista.DTO.VehiculeAnalyticsDTO;
import com.taxi.taxista.DTO.VehiculeDTO;
import com.taxi.taxista.entity.Vehicule;
import com.taxi.taxista.entity.enums.VehiculeStatus;
import com.taxi.taxista.entity.enums.VehiculeType;
import com.taxi.taxista.exception.VehiculeNotFoundException;
import com.taxi.taxista.mapper.VehiculeMapper;
import com.taxi.taxista.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
public class VehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehiculeMapper;

    @Autowired
    public VehiculeService(VehiculeRepository vehiculeRepository, VehiculeMapper vehiculeMapper) {
        this.vehiculeRepository = vehiculeRepository;
        this.vehiculeMapper = vehiculeMapper;
    }

    public VehiculeDTO saveVehicule(@Valid VehiculeDTO vehiculeDTO) {
        Vehicule vehicule = vehiculeMapper.toEntity(vehiculeDTO);
        Vehicule savedVehicule = vehiculeRepository.save(vehicule);
        return vehiculeMapper.toDTO(savedVehicule);
    }

    public Page<VehiculeDTO> findAll(int page, int size) {
        return vehiculeRepository.findAll(PageRequest.of(page, size))
                .map(vehiculeMapper::toDTO);
    }

    public Optional<VehiculeDTO> getVehiculeById(Long id) {
        return Optional.ofNullable(vehiculeRepository.findById(id)
                .map(vehiculeMapper::toDTO)
                .orElseThrow(() -> new VehiculeNotFoundException(id)));
    }

    public void deleteVehicule(Long id) {
        if (!vehiculeRepository.existsById(id)) {
            throw new VehiculeNotFoundException(id);
        }
        vehiculeRepository.deleteById(id);
    }

    public VehiculeDTO updateVehicule(Long id, @Valid VehiculeDTO updatedVehiculeDTO) {
        Vehicule existingVehicule = vehiculeRepository.findById(id).orElseThrow(() -> new VehiculeNotFoundException(id));

        vehiculeMapper.updateEntityFromDTO(updatedVehiculeDTO, existingVehicule);
        Vehicule updatedVehicule = vehiculeRepository.save(existingVehicule);
        return vehiculeMapper.toDTO(updatedVehicule);
    }

    public List<VehiculeDTO> getVehiculesByType(VehiculeType type) {

        List<Vehicule> vehicules = vehiculeRepository.findByType(type);
        return vehicules.stream()
                .map(vehiculeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public VehiculeAnalyticsDTO getVehiculeAnalytics() {
        VehiculeAnalyticsDTO analyticsDTO = new VehiculeAnalyticsDTO();

        // Average Mileage by Type
        Map<VehiculeType, Double> averageMileageByType = new HashMap<>();
        List<Object[]> averageMileageResults = vehiculeRepository.findAverageMileageByType();
        for (Object[] result : averageMileageResults) {
            VehiculeType type = (VehiculeType) result[0];
            Double averageMileage = (Double) result[1];
            averageMileageByType.put(type, averageMileage);
        }
        analyticsDTO.setAverageMileageByType(averageMileageByType);

        // Utilization Rate by Type
//        Map<VehiculeType, Double> utilizationRateByType = new HashMap<>();
//        List<Object[]> utilizationRateResults = vehiculeRepository.findUtilizationRateByType();
//        for (Object[] result : utilizationRateResults) {
//            VehiculeType type = (VehiculeType) result[0];
//            Double utilizationRate = (Double) result[1];
//            utilizationRateByType.put(type, utilizationRate);
//        }
//        analyticsDTO.setUtilizationRateByType(utilizationRateByType);

        // Fleet Status Count
        Map<VehiculeStatus, Long> fleetStatusCount = new HashMap<>();
        List<Object[]> fleetStatusResults = vehiculeRepository.countVehiclesByStatus();
        for (Object[] result : fleetStatusResults) {
            VehiculeStatus status = (VehiculeStatus) result[0];
            Long count = (Long) result[1];
            fleetStatusCount.put(status, count);
        }
        analyticsDTO.setFleetStatusCount(fleetStatusCount);

        return analyticsDTO;
    }
}
