package fyc.epss.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 食品信息表
 * </p>
 *
 * @author fangyuchao
 * @since 2022-12-12
 */
public class Food implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 食品编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商家编号
     */
    private Integer aid;

    /**
     * 食品名
     */
    private String foodName;

    /**
     * 食品描述
     */
    private String foodExplain;

    /**
     * 食品价格
     */
    private BigDecimal foodPrice;

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
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public String getFoodExplain() {
        return foodExplain;
    }

    public void setFoodExplain(String foodExplain) {
        this.foodExplain = foodExplain;
    }
    public BigDecimal getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(BigDecimal foodPrice) {
        this.foodPrice = foodPrice;
    }
    public LocalDateTime getUptime() {
        return uptime;
    }

    public void setUptime(LocalDateTime uptime) {
        this.uptime = uptime;
    }

    @Override
    public String toString() {
        return "Food{" +
            "id=" + id +
            ", aid=" + aid +
            ", foodName=" + foodName +
            ", foodExplain=" + foodExplain +
            ", foodPrice=" + foodPrice +
            ", uptime=" + uptime +
        "}";
    }
}
