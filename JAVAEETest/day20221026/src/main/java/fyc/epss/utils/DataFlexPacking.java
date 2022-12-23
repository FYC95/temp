package fyc.epss.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DataFlexPacking implements Serializable {

    private Integer statusCode;//404,200
    private String message;//提示信息文字
    private Map<String,Object> dataZone = new HashMap<>();

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getDataZone() {
        return dataZone;
    }

    public void setDataZone(Map<String, Object> dataZone) {
        this.dataZone = dataZone;
    }

    public static DataFlexPacking success(){
        String mes = "成功";
        return success(mes);
    }
    public static DataFlexPacking success(String mes){
        DataFlexPacking dfp = new DataFlexPacking();
        dfp.statusCode = 200;
        dfp.message = mes;
        return dfp;
    }
    public static DataFlexPacking fail(){
        String mes = "失败";
        return fail(mes);
    }
    public static DataFlexPacking fail(String mes){
        DataFlexPacking dfp = new DataFlexPacking();
        dfp.statusCode = 400;
        dfp.message = mes;
        return dfp;
    }

    public DataFlexPacking add(String key,Object value){
        dataZone.put(key, value);
        return this;
    }
}
