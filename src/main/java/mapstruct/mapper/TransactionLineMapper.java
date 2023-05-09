package mapstruct.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import mapstruct.dto.TransactionLineDTO;
import mapstruct.entity.TransactionLineEntity;

@Mapper(uses = { StockMapper.class }, config = IgnoreUnmappedMapperConfig.class)
public interface TransactionLineMapper extends BaseMapper<TransactionLineEntity, TransactionLineDTO> {
	TransactionLineMapper INSTANCE = Mappers.getMapper(TransactionLineMapper.class);

	TransactionLineEntity DTOToEntity(TransactionLineDTO t);

	@InheritInverseConfiguration
	TransactionLineDTO entityToDTO(TransactionLineEntity e);

	@InheritInverseConfiguration
	List<TransactionLineEntity> map(List<TransactionLineDTO> t);

}
