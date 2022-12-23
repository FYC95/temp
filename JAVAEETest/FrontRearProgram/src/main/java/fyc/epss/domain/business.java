package fyc.epss.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class business implements Serializable {
    private List<food> foodList = new ArrayList<>();
    private Integer id;
    private String password;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private Double starPrice;
    private Double deliveryPrice;
    private int aid;
    private Timestamp uptime;

    public Integer getId() {
        return id;
    }

    public business setId(Integer id) {
        this.id = id;
        return this;
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

    public business setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
        return this;
    }

    public String getBusinessExplain() {
        return businessExplain;
    }

    public business setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
        return this;
    }

    public Double getStarPrice() {
        return starPrice;
    }

    public void setStarPrice(Double starPrice) {
        this.starPrice = starPrice;
    }

    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public int getAid() {
        return aid;
    }

    public business setAid(int aid) {
        this.aid = aid;
        return this;
    }

    public Timestamp getUptime() {
        return uptime;
    }

    public void setUptime(Timestamp uptime) {
        this.uptime = uptime;
    }

    public business() {}

    public business(String password, String businessName, String businessAddress) {
        this.password = password;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
    }

    public business(Integer id, String businessName, String businessAddress) {
        this.id = id;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
    }

    public business(String password, String businessName, String businessAddress, String businessExplain) {
        this.password = password;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessExplain = businessExplain;
    }

    public business(String password, String businessName, String businessAddress, Double starPrice, Double deliveryPrice, Timestamp uptime) {
        this.password = password;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.starPrice = starPrice;
        this.deliveryPrice = deliveryPrice;
        this.uptime = uptime;
    }

    public business(String password, String businessName) {
        this.password = password;
        this.businessName = businessName;
    }

    public business(Integer id, String password, String businessName, String businessAddress, String businessExplain, Double starPrice, Double deliveryPrice, int aid, Timestamp uptime) {
        this.id = id;
        this.password = password;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessExplain = businessExplain;
        this.starPrice = starPrice;
        this.deliveryPrice = deliveryPrice;
        this.aid = aid;
        this.uptime = uptime;
    }

    @Override
    public String toString() {
        return "business{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", businessName='" + businessName + '\'' +
                ", businessAddress='" + businessAddress + '\'' +
                ", businessExplain='" + businessExplain + '\'' +
                ", starPrice=" + starPrice +
                ", deliveryPrice=" + deliveryPrice +
                ", aid=" + aid +
                ", uptime=" + uptime +
                '}';
    }
}
