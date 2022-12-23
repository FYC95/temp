package fyc.epss.interceptor;

import fyc.epss.domain.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Boolean flag = true;
       /* System.out.println("Interceptor运作了");
        String uri = request.getRequestURI();
        if (uri.indexOf("/adminar/login")>=0){
            flag = true;//允许放行
        }
        HttpSession session = request.getSession();
        Boolean loginStatus = (Boolean)session.getAttribute("loginStatus");
        Admin admin = (Admin)session.getAttribute("ADMIN_SESSION");
        if (loginStatus && admin !=null){
            flag = true;
        }
        //如果不是前后端分离项目，转发到登录页面
//        request.setAttribute("msg","请登录");
//        request.getRequestDispatcher("../index").forward(request,response);
//        如果是前后端分离项目,重定向
        response.sendRedirect("http://localhost:63342/SpringFrameFront/AjaxJsonRequest.html");
*/


        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
