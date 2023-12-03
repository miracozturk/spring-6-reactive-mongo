package mozt.edu.reactivemongo.mappers;

import mozt.edu.reactivemongo.domain.Customer;
import mozt.edu.reactivemongo.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer CustomerDtoToCustomer(CustomerDto customerDto);
    CustomerDto CustomerToCustomerDto(Customer customer);
}
