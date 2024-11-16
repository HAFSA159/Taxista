package com.taxi.taxista.mapper;

import com.taxi.taxista.DTO.CustomerDTO;
import com.taxi.taxista.entity.Customer;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-16T19:58:27+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toEntity(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDTO.getId() );
        customer.setFirstname( customerDTO.getFirstname() );
        customer.setLastname( customerDTO.getLastname() );

        return customer;
    }

    @Override
    public CustomerDTO toDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( customer.getId() );
        customerDTO.setFirstname( customer.getFirstname() );
        customerDTO.setLastname( customer.getLastname() );

        return customerDTO;
    }

    @Override
    public void updateEntityFromDTO(CustomerDTO dto, Customer entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        entity.setFirstname( dto.getFirstname() );
        entity.setLastname( dto.getLastname() );
    }
}
