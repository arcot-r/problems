package mapstruct.entity;

import lombok.Data;

@Data
public class StockEntity implements BaseEntity {
	private String stockName;
	private int stockQty;
	private long stockId;
}
