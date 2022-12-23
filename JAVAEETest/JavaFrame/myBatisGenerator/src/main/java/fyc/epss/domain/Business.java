package fyc.epss.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Business {
    private Integer id;

    private Integer aid;

    private String password;

    private String businessname;

    private String businessaddress;

    private String businessexplain;

    private BigDecimal starprice;

    private BigDecimal deliveryprice;

    private Date uptime;
    //
    private List<Food> foods = new ArrayList<>();

}