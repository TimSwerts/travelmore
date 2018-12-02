package be.thomasmore.travelmore.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException{

    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        if(session == null || session.getAttribute("Gebruiker") == null){
            response.sendRedirect(request.getContextPath() + "/login.xhtml");
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy(){

    }
}
