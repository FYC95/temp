package fyc.epss.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(urlPatterns = "*.do")
public class CharacterFilter implements Filter {
    private String charCode;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Character就绪了");
        Filter.super.init(filterConfig);
        charCode = "utf-8";
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        System.out.println("过滤了一个setCharacterEncoding");
        httpServletRequest.setCharacterEncoding(this.charCode);
        httpServletResponse.setCharacterEncoding(this.charCode);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Character过滤结束");
        Filter.super.destroy();
    }
}
