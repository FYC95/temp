package fyc.epss.pojo;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class info implements Serializable {
    private Integer id;
    private Integer aid;
    private admin admin;
    private String phone;
    private String avatar;
    private Boolean gender;
    private Timestamp uptime;


    public info(Integer aid, String phone, String avatar, Boolean gender) {
        this.aid = aid;
        this.phone = phone;
        this.avatar = avatar;
        this.gender = gender;
    }

    public info(Integer aid, String phone, Boolean gender) {
        this.aid = aid;
        this.phone = phone;
        this.gender = gender;
    }

    public info(Integer id, String phone, String avatar) {
        this.id = id;
        this.phone = phone;
        this.avatar = avatar;
    }

    public info(Integer id, Integer aid, String phone, String avatar, Boolean gender, Timestamp uptime) {
        this.id = id;
        this.aid = aid;
        this.phone = phone;
        this.avatar = avatar;
        this.gender = gender;
        this.uptime = uptime;
    }

}
