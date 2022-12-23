package fyc.epss.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = "/login-session")
public class FilterCrossRegion implements Filter {
    public void init(FilterConfig config) throws ServletException {
        Filter.super.init(config);
        System.out.println("FilterCrossRegion已经就位");
    }

    public void destroy() {
        System.out.println("FilterCrossRegion已销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤了一个FilterCrossRegion");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        //设置允许跨域
        httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        //设置开启Cookie
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(request,response);
    }
}
