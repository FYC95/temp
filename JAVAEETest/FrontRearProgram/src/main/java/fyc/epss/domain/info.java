package fyc.epss.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class info implements Serializable {
    private Integer id;
    private Integer aid;
    private admin admin;
    private String phone;
    private String avatar;
    private Boolean gender;
    private Timestamp uptime;

    public Integer getId() {
        return id;
    }

    public info setId(Integer id) {
        this.id = id;
        return this;
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

    public info setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Timestamp getUptime() {
        return uptime;
    }

    public void setUptime(Timestamp uptime) {
        this.uptime = uptime;
    }

    public info() {}

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

    @Override
    public String toString() {
        return "info{" +
                "id=" + id +
                ", aid=" + aid +
                ", admin=" + admin +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", gender=" + gender +
                ", uptime=" + uptime +
                '}';
    }
}
