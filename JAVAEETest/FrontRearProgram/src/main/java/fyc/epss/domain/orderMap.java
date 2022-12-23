package fyc.epss.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class orderMap implements Serializable {
    private Integer id;
    private Integer aid;
    private Integer fid;
    private Timestamp uptime;

    public Integer getId() {
        return id;
    }

    public orderMap setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Timestamp getUptime() {
        return uptime;
    }

    public orderMap setUptime(Timestamp uptime) {
        this.uptime = uptime;
        return this;
    }

    public orderMap() {}

    public orderMap(Integer aid, Integer fid) {
        this.aid = aid;
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "orderMap{" +
                "id=" + id +
                ", aid=" + aid +
                ", fid=" + fid +
                ", uptime=" + uptime +
                '}';
    }
}
