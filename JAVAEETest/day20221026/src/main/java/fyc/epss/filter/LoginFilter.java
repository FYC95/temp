package fyc.epss.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns = "/login-session")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("登陆过滤已经就位");
    }

    public void destroy() {
            System.out.println("登陆过滤已销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("登陆过滤");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String[] urls = {"/login-session","/index.jsp"};
        String url = httpServletRequest.getRequestURI();
        for (int i = 0; i < urls.length; i++) {
            if (url.indexOf(urls[i]) > -1){
                chain.doFilter(request,response);
            }else {
                HttpSession session = httpServletRequest.getSession();
                if (session.getAttribute("sta") != null && (Boolean) session.getAttribute("sta") == true){
                    chain.doFilter(request,response);
                }else {
                    String contextpath = httpServletRequest.getContextPath();
                    System.out.println(contextpath);
                    httpServletResponse.sendRedirect(contextpath +"/index.jsp?mes=没有权限");
                }
            }
        }

//        chain.doFilter(httpServletRequest, httpServletResponse);
    }
}
