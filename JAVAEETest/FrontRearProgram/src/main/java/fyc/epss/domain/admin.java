package fyc.epss.domain;

import fyc.epss.utils.DTutils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class admin implements Serializable {
    private List<info> infoList = new ArrayList<>();
    private List<business> businessesList = new ArrayList<>();
    private List<orderMap> orderMapsList = new ArrayList<>();
    private Integer id;
    private String adminName;
    private String password;
    private Timestamp uptime;
    private info info;

    public Integer getId() {
        return id;
    }

    public admin setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getAdminName() {
        return adminName;
    }

    public admin setAdminName(String adminName) {
        this.adminName = adminName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public admin setPassword(String password) {
        this.password = password;
        return this;
    }

    public Timestamp getUptime() {
        return uptime;
    }

    public admin setUptime(Timestamp uptime) {
        this.uptime = uptime;
        return this;
    }

    public info getInfo() {
        return info;
    }

    public admin setInfo(info info) {
        this.info = info;
        return this;
    }

    public admin() {}

    public admin(String adminName, String password) {
        this.adminName = adminName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", info=" + info +
                ", uptime=" + DTutils.funcname("yyyy年MM月dd日",uptime) +
                '}';
    }
}

