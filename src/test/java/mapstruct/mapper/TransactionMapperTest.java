package mapstruct.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import mapstruct.dto.StockDTO;
import mapstruct.dto.TransactionDTO;
import mapstruct.dto.TransactionLineDTO;
import mapstruct.entity.StockEntity;
import mapstruct.entity.TransactionEntity;
import mapstruct.entity.TransactionLineEntity;

class TransactionMapperTest {

	@Test
	void testEntityCreation() {
		var entity = TransactionMapper.INSTANCE.DTOToEntity(buildDTO());
		assertEquals(entity.getTransactionId(), 21L);
	}
	
	@Test
	void testDtoCreation() {
		var dto = TransactionMapper.INSTANCE.entityToDTO(buildEntity());
		assertEquals(dto.getTransactionId(), 21L);
	}

	private TransactionDTO buildDTO() {
		StockDTO stock = new StockDTO();
		stock.setId(2L);
		stock.setName("Stock 1");
		stock.setQuantity(100);

		Set<StockDTO> stocks = new HashSet<>();
		stocks.add(stock);

		TransactionLineDTO line = new TransactionLineDTO();
		line.setLineId(1L);
		line.setLineItemName("first");
		line.setStocks(stocks);

		List<TransactionLineDTO> lines = new ArrayList<>();
		lines.add(line);

		TransactionDTO transaction = new TransactionDTO();
		transaction.setTransactionId(21L);
		transaction.setTransactionName("Transaction 1");
		transaction.setLines(lines);

		return transaction;

	}
	
	private TransactionEntity buildEntity() {
		StockEntity stock = new StockEntity();
		stock.setStockId(2L);
		stock.setStockName("Stock 1");
		stock.setStockQty(100);

		Set<StockEntity> stocks = new HashSet<>();
		stocks.add(stock);

		TransactionLineEntity line = new TransactionLineEntity();
		line.setLineId(1L);
		line.setLineItemName("first");
		line.setStocks(stocks);

		List<TransactionLineEntity> lines = new ArrayList<>();
		lines.add(line);

		TransactionEntity transaction = new TransactionEntity();
		transaction.setTransactionId(21L);
		transaction.setTransactionName("Transaction 1");
		transaction.setLines(lines);
		
		return transaction;
	}

}
