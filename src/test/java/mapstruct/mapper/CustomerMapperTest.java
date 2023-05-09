package mapstruct.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import mapstruct.dto.CustomerDTO;

class CustomerMapperTest {

	@Test
	void test() {
		CustomerDTO customer = new CustomerDTO();
		customer.setFirstName("RRRR");
		customer.setLastName("NNNN");
		var customerEntity = Mappers.getMapper(CustomerMapper.class).dtoToEntity(customer);
		assertNotNull(customerEntity);
		assertEquals(customerEntity.getFirstName(), "RRRR");
		assertEquals(customerEntity.getLastName(), "NNNN");
	}

}
