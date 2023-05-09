package mapstruct.dto;

import java.util.List;

import lombok.Data;

@Data
public class TransactionDTO implements BaseDTO{
	private long transactionId;
	private String transactionName;
	private List<TransactionLineDTO> lines;
}
