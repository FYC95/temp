package fyc.epss.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 详细信息表
 * </p>
 *
 * @author fangyuchao
 * @since 2022-12-12
 */
public class Info implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 信息编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 管理员编号
     */
    private Integer aid;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户头像
     */
    private String avater;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 记录修改时间
     */
    private LocalDateTime uptime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }
    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    public LocalDateTime getUptime() {
        return uptime;
    }

    public void setUptime(LocalDateTime uptime) {
        this.uptime = uptime;
    }

    @Override
    public String toString() {
        return "Info{" +
            "id=" + id +
            ", aid=" + aid +
            ", phone=" + phone +
            ", avater=" + avater +
            ", gender=" + gender +
            ", uptime=" + uptime +
        "}";
    }
}
