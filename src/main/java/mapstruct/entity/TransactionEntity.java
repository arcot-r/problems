package mapstruct.entity;

import java.util.List;

import lombok.Data;

@Data
public class TransactionEntity implements BaseEntity {
	private long transactionId;
	private String transactionName;
	private List<TransactionLineEntity> lines;
}
