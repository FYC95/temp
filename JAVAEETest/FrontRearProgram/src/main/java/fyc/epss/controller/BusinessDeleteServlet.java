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
import java.util.List;

@WebServlet(urlPatterns = "/business/deleteOne.do")
public class BusinessDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("ids");
        String[] idArray = ids.split("-");
        Boolean b =false;
//        Integer id = Integer.valueOf(req.getParameter("id"));
        CommonService businessService = new businessServiceImpl();

        for (int i = 0; i < idArray.length; i++) {
            b = businessService.deleteOne(Integer.valueOf(idArray[i]));
        }


        DataFlexPacking dfp = null;
        if (b){
            dfp = DataFlexPacking.success("删除成功");
        }else {
            dfp = DataFlexPacking.fail("删除失败");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String ret = objectMapper.writeValueAsString(dfp);
        //返回给view，因为是前后端分离，交互JSON数据需要告知后端
        PrintWriter writer = resp.getWriter();
        writer.print(ret);
        writer.flush();
        writer.close();
        //封装查询结果
    }


}
