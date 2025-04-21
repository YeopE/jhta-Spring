package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BuyDto {
    private int buynum;
    private String id;
    private String pname;
    private int price;
    private int amount;
    private Date regdate;
}
