package mapstruct.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import mapstruct.dto.TransactionDTO;
import mapstruct.entity.TransactionEntity;

@Mapper(uses= {TransactionLineMapper.class})
public interface TransactionMapper extends BaseMapper<TransactionEntity, TransactionDTO> {
	TransactionMapper INSTANCE = Mappers.getMapper( TransactionMapper.class );
	
	TransactionEntity DTOToEntity(TransactionDTO t);
	
	@InheritInverseConfiguration
	TransactionDTO entityToDTO(TransactionEntity e);
	
	@InheritInverseConfiguration
	List<TransactionEntity> map(List<TransactionDTO> t);
	

}
