package fyc.epss.utils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class food implements Serializable {

    private Integer id;
    private String foodName;
    private String foodExplain;
    private Double foodPrice;
    private Integer bid;
    private Timestamp uptime;

    public Integer getId() {
        return id;
    }

    public food setId(Integer id) {
        this.id = id;
        return this;
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

    public food setFoodExplain(String foodExplain) {
        this.foodExplain = foodExplain;
        return this;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }



    public Timestamp getUptime() {
        return uptime;
    }

    public void setUptime(Timestamp uptime) {
        this.uptime = uptime;
    }

    public food(){}

    public food(Integer id, String foodName, Double foodPrice) {
        this.id = id;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public food(String foodName, Double foodPrice, Integer bid) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.bid = bid;
    }

    public food(String foodName, String foodExplain, Double foodPrice, Integer bid) {
        this.foodName = foodName;
        this.foodExplain = foodExplain;
        this.foodPrice = foodPrice;
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "food{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", foodExplain='" + foodExplain + '\'' +
                ", foodPrice=" + foodPrice +
                ", bid=" + bid +
                ", uptime=" + uptime +
                '}';
    }
}
