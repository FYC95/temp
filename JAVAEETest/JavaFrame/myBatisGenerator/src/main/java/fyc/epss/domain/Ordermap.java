package fyc.epss.domain;

import lombok.*;

import java.util.Date;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ordermap {
    private Integer id;

    private Integer aid;

    private Integer fid;

    private Date uptime;

}