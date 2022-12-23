package fyc.epss.domain;

import lombok.*;

import java.util.Date;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer id;

    private String adminname;

    private String password;

    private Date uptime;

    private Info info;

}