package fyc.epss.pojo;

import fyc.epss.pojo.business;
import fyc.epss.pojo.info;
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
public class admin implements Serializable {
 private Integer id;
    private String adminName;
    private String password;
    private Timestamp uptime;
    private info info;



    public admin(String adminName, String password) {
        this.adminName = adminName;
        this.password = password;
    }

}

