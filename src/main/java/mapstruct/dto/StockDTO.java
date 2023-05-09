package mapstruct.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDTO implements BaseDTO{
	private String name;
	private int quantity;
	private long id;
}
