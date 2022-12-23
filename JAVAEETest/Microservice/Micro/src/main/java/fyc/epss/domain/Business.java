package fyc.epss.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商家信息表
 * </p>
 *
 * @author fangyuchao
 * @since 2022-12-12
 */
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商家编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 管理员编号
     */
    private Integer aid;

    /**
     * 密码
     */
    private String password;

    /**
     * 商家名
     */
    private String businessName;

    /**
     * 商家地址
     */
    private String businessAddress;

    /**
     * 商家描述
     */
    private String businessExplain;

    /**
     * 起送价
     */
    private BigDecimal starPrice;

    /**
     * 配送价
     */
    private BigDecimal deliveryPrice;

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
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    public String getBusinessAddress() {
        return businessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }
    public String getBusinessExplain() {
        return businessExplain;
    }

    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }
    public BigDecimal getStarPrice() {
        return starPrice;
    }

    public void setStarPrice(BigDecimal starPrice) {
        this.starPrice = starPrice;
    }
    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }
    public LocalDateTime getUptime() {
        return uptime;
    }

    public void setUptime(LocalDateTime uptime) {
        this.uptime = uptime;
    }

    @Override
    public String toString() {
        return "Business{" +
            "id=" + id +
            ", aid=" + aid +
            ", password=" + password +
            ", businessName=" + businessName +
            ", businessAddress=" + businessAddress +
            ", businessExplain=" + businessExplain +
            ", starPrice=" + starPrice +
            ", deliveryPrice=" + deliveryPrice +
            ", uptime=" + uptime +
        "}";
    }
}
