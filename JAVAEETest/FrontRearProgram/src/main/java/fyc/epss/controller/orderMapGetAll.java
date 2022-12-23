package fyc.epss.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fyc.epss.domain.infoVO;
import fyc.epss.domain.orderMapVO;
import fyc.epss.services.CommonService;
import fyc.epss.services.infoServiceImpl;
import fyc.epss.services.orderMapServiceImpl;
import fyc.epss.utils.DataFlexPacking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Map;

@WebServlet(urlPatterns = "/ordermap/list.do")
public class orderMapGetAll extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pages = Integer.valueOf(req.getParameter("pages"));
        Integer pageSize = Integer.valueOf(req.getParameter("pageSize"));
        pageSize = pageSize==null ? 10 : pageSize;//3
        pages = (pages==null) ? 0 : (pages-1) * pageSize;//1
        //处理检索条件
        String cond = req.getParameter("cond")==null?"":req.getParameter("cond");
        //通过工具类进行解码
        cond  = URLDecoder.decode(cond,"utf-8");
        System.out.println(cond);
        //
        orderMapVO businessVO = new orderMapVO();
        for (String s : cond.split("&")) {
            String[] ss1 = s.split("=");
            if("bidCon".equals(ss1[0]) && ss1.length>1)
                businessVO.setCon(ss1[1]);
            if("id".equals(ss1[0]) && ss1.length>1)
                businessVO.setId(Integer.valueOf(ss1[1]));
            if("businessName".equals(ss1[0]) && ss1.length>1)
                businessVO.setAid(Integer.valueOf(ss1[1]));
        }


        //调用service执行查询业务
        CommonService businessService = new orderMapServiceImpl();
        Map map = businessService.queryAll(pages, pageSize,businessVO);
        System.out.println(map);
        //封装查询结果
        DataFlexPacking mad = DataFlexPacking.success("查询商家数据成功").add("ret",map);
        //转换为JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String ret = objectMapper.writeValueAsString(mad);
        //返回给view,因为是前后端分离，交互JSON数据，需要告知客户端
        PrintWriter writer = resp.getWriter();
        writer.print(ret);
        writer.flush();
    }

}



