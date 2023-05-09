package mapstruct.entity;

import java.util.Set;

import lombok.Data;

@Data
public class TransactionLineEntity implements BaseEntity {
	private long lineId;
	private String lineItemName;
	private Set<StockEntity> stocks;
}
