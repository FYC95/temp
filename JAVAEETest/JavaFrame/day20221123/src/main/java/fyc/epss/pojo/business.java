package fyc.epss.pojo;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class business implements Serializable {
    private Integer id;
    private String password;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private Double starPrice;
    private Double deliveryPrice;
    private int aid;
    private Timestamp uptime;
    public business(String password, String businessName) {
        this.password = password;
        this.businessName = businessName;
    }

    public business(Integer id, String businessName, String businessAddress) {
        this.id = id;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
    }




}
