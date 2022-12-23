package fyc.epss.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fyc.epss.domain.business;
import fyc.epss.domain.food;
import fyc.epss.services.businessServiceImpl;
import fyc.epss.services.foodServiceImpl;
import fyc.epss.utils.DataFlexPacking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/food/updateOne.do")
public class foodUpdateServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //获取客户端传递过来的数据值
            Integer id = Integer.valueOf(req.getParameter("id"));
            String businessName = req.getParameter("businessName");
            Double businessExplain = Double.valueOf(req.getParameter("businessExplain"));
            food food = new food(id,businessName,businessExplain);
            //调用service执行查询业务
            foodServiceImpl foodService = new foodServiceImpl();
            Integer num  = foodService.updateOne(food);
            //封装查询结果
            DataFlexPacking mad = null;
            if(num<1)
                mad = DataFlexPacking.fail("修改食品数据失败");
            else
                mad = DataFlexPacking.success("修改食品数据成功");
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
