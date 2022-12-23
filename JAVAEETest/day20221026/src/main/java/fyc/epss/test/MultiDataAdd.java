package fyc.epss.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import fyc.epss.utils.DataFlexPacking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

@WebServlet(urlPatterns = "/dataAdd")
public class MultiDataAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setHeader("Access-Control-Allow-Origin", "*");

        String name = "房玉超";
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        HashSet<Double> doubles = new HashSet<>();
        doubles.add(2.0);
        doubles.add(3.0);
        doubles.add(1.0);
        DataFlexPacking dfp = DataFlexPacking.success("查询成功").add("name",name).add("整数",integers).add("浮点数",doubles);
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(dfp);
        writer.print(s);
        writer.close();
    }
}
