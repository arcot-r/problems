package mapstruct.mapper;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import mapstruct.dto.StockDTO;
import mapstruct.entity.StockEntity;

@Mapper(config= IgnoreUnmappedMapperConfig.class)
public interface StockMapper extends BaseMapper<StockEntity, StockDTO> {
	StockMapper INSTANCE = Mappers.getMapper( StockMapper.class ); 
	@Mapping(target="stockId", source="id")
	@Mapping(target="stockName", source="name")
	@Mapping(target="stockQty", source="quantity")
	StockEntity DTOToEntity(StockDTO t);

	@InheritInverseConfiguration
	StockDTO entityToDTO(StockEntity e);
	
	@InheritConfiguration
	List<StockEntity> map(List<StockDTO> t);

}
