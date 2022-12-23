package fyc.epss.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
@Getter
@Setter
@ToString
public class Admin {
    private Integer id;
    private String adminname;
    private String password;
    private Timestamp uptime;

}
