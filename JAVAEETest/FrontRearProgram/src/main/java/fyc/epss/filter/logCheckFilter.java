package fyc.epss.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import fyc.epss.utils.DataFlexPacking;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "*.do")

public class logCheckFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("logCheck就绪了");
    }

    public void destroy() {
        System.out.println("登录状态检查已销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            HttpSession session = httpServletRequest.getSession();

        if (session.getAttribute("status") !=null || httpServletRequest.getServletPath().indexOf("login.do")>=0 || httpServletRequest.getServletPath().indexOf("vcode.do")>=0 || httpServletRequest.getServletPath().indexOf("loginCheck.do") >=0){
            chain.doFilter(request, response);
            System.out.println("logCheck通过了");
        }else {
            DataFlexPacking mad = null;
            mad = DataFlexPacking.fail("login.html");
            ObjectMapper objectMapper = new ObjectMapper();
            String ret = objectMapper.writeValueAsString(mad);
            //返回给view,因为是前后端分离，交互JSON数据，需要告知客户端
            PrintWriter writer = response.getWriter();
            writer.print(ret);
            writer.flush();
            writer.close();
            return;
        }

    }
}
