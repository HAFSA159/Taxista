package com.taxi.taxista.mapper;

import com.taxi.taxista.DTO.DriverDTO;
import com.taxi.taxista.entity.Driver;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-16T19:58:27+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class DriverMapperImpl implements DriverMapper {

    @Override
    public Driver toEntity(DriverDTO driverDTO) {
        if ( driverDTO == null ) {
            return null;
        }

        Driver driver = new Driver();

        driver.setId( driverDTO.getId() );
        driver.setFirstname( driverDTO.getFirstname() );
        driver.setLastname( driverDTO.getLastname() );
        driver.setStatus( driverDTO.getStatus() );
        driver.setAvailabilityStart( driverDTO.getAvailabilityStart() );
        driver.setAvailabilityEnd( driverDTO.getAvailabilityEnd() );

        return driver;
    }

    @Override
    public DriverDTO toDTO(Driver driver) {
        if ( driver == null ) {
            return null;
        }

        DriverDTO driverDTO = new DriverDTO();

        driverDTO.setId( driver.getId() );
        driverDTO.setFirstname( driver.getFirstname() );
        driverDTO.setLastname( driver.getLastname() );
        driverDTO.setStatus( driver.getStatus() );
        driverDTO.setAvailabilityStart( driver.getAvailabilityStart() );
        driverDTO.setAvailabilityEnd( driver.getAvailabilityEnd() );

        return driverDTO;
    }

    @Override
    public void updateEntityFromDTO(DriverDTO dto, Driver entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        entity.setFirstname( dto.getFirstname() );
        entity.setLastname( dto.getLastname() );
        entity.setStatus( dto.getStatus() );
        entity.setAvailabilityStart( dto.getAvailabilityStart() );
        entity.setAvailabilityEnd( dto.getAvailabilityEnd() );
    }
}
