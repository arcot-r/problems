package mapstruct.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mapstruct.factory.Mappers;

import mapstruct.dto.CustomerDTO;
import mapstruct.dto.StockDTO;
import mapstruct.dto.TransactionDTO;
import mapstruct.dto.TransactionLineDTO;
import mapstruct.entity.TransactionEntity;
import mapstruct.mapper.CustomerMapper;
import mapstruct.mapper.TransactionMapper;

public class MapStructRunner {

	public static void main(String[] args) {
		MapStructRunner r = new MapStructRunner();
		TransactionEntity entity = Mappers.getMapper(TransactionMapper.class).DTOToEntity(r.buildDTO());
		System.out.println("Entity=" + entity);

		CustomerDTO customer = new CustomerDTO();
		customer.setFirstName("RRRR");
		customer.setLastName("NNNN");
		var customerEntity = CustomerMapper.INSTANCE.dtoToEntity(customer);
		System.out.println(
				"firstName=" + customerEntity.getFirstName() + "\t" + "lastName=" + customerEntity.getLastName());

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
}
