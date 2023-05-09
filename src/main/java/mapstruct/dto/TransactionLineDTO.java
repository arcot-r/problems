package mapstruct.dto;

import java.util.Set;

import lombok.Data;

@Data
public class TransactionLineDTO implements BaseDTO {
	private long lineId;
	private String lineItemName;
	private Set<StockDTO> stocks;
}
