package fyc.epss.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fyc.epss.domain.business;
import fyc.epss.services.CommonService;
import fyc.epss.services.businessServiceImpl;
import fyc.epss.utils.DataFlexPacking;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/business/addOne.do")
public class BusinessInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取客户端传递过来的数据值
        String businessName = req.getParameter("businessName");
        String password = req.getParameter("password");
        String businessExplain = req.getParameter("businessExplain");
        String businessAddress = req.getParameter("businessAddress");
        business business = new business(password,businessName).setBusinessExplain(businessExplain).setBusinessAddress(businessAddress);
        //调用service执行查询业务
        businessServiceImpl businessService = new businessServiceImpl();
        Boolean num  = businessService.addOne(business);
        //封装查询结果
        DataFlexPacking mad = null;
        if(!num)
            mad = DataFlexPacking.fail("添加商家数据失败");
        else
            mad = DataFlexPacking.success("添加商家数据成功");
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
