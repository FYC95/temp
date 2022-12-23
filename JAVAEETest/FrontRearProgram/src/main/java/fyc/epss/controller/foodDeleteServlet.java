package fyc.epss.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fyc.epss.services.CommonService;
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

@WebServlet(urlPatterns = "/food/deleteOne.do")
public class foodDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("ids");
        String[] idArray = ids.split("-");
        Boolean b =false;
//        Integer id = Integer.valueOf(req.getParameter("id"));
        CommonService foodService = new foodServiceImpl();

        for (int i = 0; i < idArray.length; i++) {
            b = foodService.deleteOne(Integer.valueOf(idArray[i]));
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
