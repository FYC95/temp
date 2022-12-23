package fyc.epss.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    private Integer id;

    private Integer aid;

    private String foodname;

    private String foodexplain;

    private BigDecimal foodprice;

    private Date uptime;

}