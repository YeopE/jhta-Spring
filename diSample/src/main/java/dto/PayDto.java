package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayDto {
    private int paynum;
    private int buynum;
    private int payment;
    private String paymethod;
}
