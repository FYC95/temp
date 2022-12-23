package fyc.epss.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fyc.epss.domain.orderMap;
import fyc.epss.services.orderMapServiceImpl;
import fyc.epss.utils.DataFlexPacking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/orderMap/updateOne.do")
public class ordermapUpdateOneServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //获取客户端传递过来的数据值
            Integer id = Integer.valueOf(req.getParameter("id"));
            Integer aid = Integer.valueOf(req.getParameter("aid"));
            Integer fid = Integer.valueOf(req.getParameter("businessExplain"));

            orderMap orderMap = new orderMap(aid,fid).setId(id);
            //调用service执行查询业务
            orderMapServiceImpl ordermapService = new orderMapServiceImpl();
            Integer num  = ordermapService.updateOne(orderMap);
            //封装查询结果
            DataFlexPacking mad = null;
            if(num<1)
                mad = DataFlexPacking.fail("修改订单数据失败");
            else
                mad = DataFlexPacking.success("修改订单数据成功");
            //转换为JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String ret = objectMapper.writeValueAsString(mad);
            //返回给view,因为是前后端分离，交互JSON数据，需要告知客户端
            PrintWriter writer = resp.getWriter();
            writer.print(ret);
            writer.flush();
            writer.close();
        }
}
