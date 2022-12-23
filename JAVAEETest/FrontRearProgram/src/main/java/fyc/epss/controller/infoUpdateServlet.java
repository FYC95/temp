package fyc.epss.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fyc.epss.domain.business;
import fyc.epss.domain.info;
import fyc.epss.services.businessServiceImpl;
import fyc.epss.services.infoServiceImpl;
import fyc.epss.utils.DataFlexPacking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/info/updateOne.do")
public class infoUpdateServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //获取客户端传递过来的数据值
            Integer id = Integer.valueOf(req.getParameter("id"));
            Integer aid = Integer.valueOf(req.getParameter("aid"));
            String businessName = req.getParameter("businessName");
            Boolean businessExplain = Boolean.valueOf(req.getParameter("businessExplain"));
            info business = new info(aid,businessName,businessExplain).setId(id);
            //调用service执行查询业务
            infoServiceImpl infoService = new infoServiceImpl();
            Integer num  = infoService.updateOne(business);
            //封装查询结果
            DataFlexPacking mad = null;
            if(num<1)
                mad = DataFlexPacking.fail("修改商家数据失败");
            else
                mad = DataFlexPacking.success("修改商家数据成功");
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
