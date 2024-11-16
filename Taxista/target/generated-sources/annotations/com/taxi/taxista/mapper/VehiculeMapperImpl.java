package com.taxi.taxista.mapper;

import com.taxi.taxista.DTO.VehiculeDTO;
import com.taxi.taxista.entity.Vehicule;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-16T19:58:27+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class VehiculeMapperImpl implements VehiculeMapper {

    @Override
    public Vehicule toEntity(VehiculeDTO vehiculeDTO) {
        if ( vehiculeDTO == null ) {
            return null;
        }

        Vehicule vehicule = new Vehicule();

        vehicule.setId( vehiculeDTO.getId() );
        vehicule.setModel( vehiculeDTO.getModel() );
        vehicule.setRegistrationNumber( vehiculeDTO.getRegistrationNumber() );
        vehicule.setMileage( vehiculeDTO.getMileage() );
        vehicule.setStatus( vehiculeDTO.getStatus() );
        vehicule.setType( vehiculeDTO.getType() );

        return vehicule;
    }

    @Override
    public VehiculeDTO toDTO(Vehicule vehicule) {
        if ( vehicule == null ) {
            return null;
        }

        VehiculeDTO vehiculeDTO = new VehiculeDTO();

        vehiculeDTO.setId( vehicule.getId() );
        vehiculeDTO.setModel( vehicule.getModel() );
        vehiculeDTO.setRegistrationNumber( vehicule.getRegistrationNumber() );
        vehiculeDTO.setMileage( vehicule.getMileage() );
        vehiculeDTO.setStatus( vehicule.getStatus() );
        vehiculeDTO.setType( vehicule.getType() );

        return vehiculeDTO;
    }

    @Override
    public void updateEntityFromDTO(VehiculeDTO dto, Vehicule entity) {
        if ( dto == null ) {
            return;
        }

        entity.setModel( dto.getModel() );
        entity.setRegistrationNumber( dto.getRegistrationNumber() );
        entity.setMileage( dto.getMileage() );
        entity.setStatus( dto.getStatus() );
        entity.setType( dto.getType() );
    }
}
