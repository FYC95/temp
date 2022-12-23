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

@WebServlet(urlPatterns = "/info/get.do")
public class infoGetOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取客户端传递过来的id值
        Integer id = Integer.valueOf(req.getParameter("id"));
        //调用service执行查询业务
        infoServiceImpl infoService = new infoServiceImpl();
        info info  = infoService.selectOne(id);
        //封装查询结果
        DataFlexPacking mad = null;
        if(info == null)
            mad = DataFlexPacking.fail("获取单个商家数据失败");
        else
            mad = DataFlexPacking.success("获取单个商家数据成功").add("bus",info);
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
