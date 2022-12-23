package fyc.epss.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DTutils {
    public static String funcname(String pattern, Timestamp src){
        pattern = null == pattern ? "yyyy年MM月dd日" : pattern;
//        Timestamp cDate = rs.getTimestamp("uptime");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String s = simpleDateFormat.format(src);
        return s;
    }
}
