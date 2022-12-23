package fyc.epss.domain;

import lombok.*;

import java.util.Date;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Info {
    private Integer id;

    private Integer aid;

    private String phone;

    private String avater;

    private Boolean gender;

    private Date uptime;

    private Admin admin;

}