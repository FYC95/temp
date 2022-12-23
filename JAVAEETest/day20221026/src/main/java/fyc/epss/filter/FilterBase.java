package fyc.epss.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = "/login-session")
public class FilterBase implements Filter {
    public void init(FilterConfig config) throws ServletException {
        Filter.super.init(config);
        System.out.println("setCharacterEncoding已经就位");
    }

    public void destroy() {
        System.out.println("setCharacterEncoding已销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤了一个setCharacterEncoding");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        chain.doFilter(request,response);
    }
}
