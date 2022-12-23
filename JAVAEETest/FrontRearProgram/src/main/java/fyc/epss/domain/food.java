package fyc.epss.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class food implements Serializable {
    private List<orderMap> orderMapsList = new ArrayList<>();
    private Integer id;
    private String foodName;
    private String foodExplain;
    private Double foodPrice;
    private Integer bid;
    private business business;
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

    public food setFoodName(String foodName) {
        this.foodName = foodName;
        return this;
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

    public food setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
        return this;
    }

    public Integer getBid() {
        return bid;
    }

    public food setBid(Integer bid) {
        this.bid = bid;
        return this;
    }

    public business getBusiness() {
        return business;
    }

    public void setBusiness(business business) {
        this.business = business;
    }

    public Timestamp getUptime() {
        return uptime;
    }

    public food setUptime(Timestamp uptime) {
        this.uptime = uptime;
        return this;
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
                ", business=" + business +
                ", uptime=" + uptime +
                '}';
    }
}
