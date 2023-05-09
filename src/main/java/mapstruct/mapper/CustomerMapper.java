package mapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import mapstruct.dto.CustomerDTO;
import mapstruct.entity.CustomerEntity;

@Mapper
public interface CustomerMapper {
	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
	CustomerDTO entityToDto(CustomerEntity e);
	CustomerEntity dtoToEntity(CustomerDTO d);
}
