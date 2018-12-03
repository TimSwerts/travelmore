package be.thomasmore.travelmore.filter;

import be.thomasmore.travelmore.domain.Admin;
import be.thomasmore.travelmore.domain.Persoon;

import javax.persistence.DiscriminatorValue;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/")
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException{

    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);



        if(session == null || session.getAttribute("Gebruiker") == null  ){
            response.sendRedirect(request.getContextPath() + "/login.xhtml");
        } else {

            DiscriminatorValue val =  session.getAttribute("Gebruiker").getClass().getAnnotation(DiscriminatorValue.class);
            System.out.println(val.value());
            if (!val.value().equals("Admin")){
                response.sendRedirect(request.getContextPath() + "/login.xhtml");
            } else {
                chain.doFilter(req, res);
            }
        }
    }

    @Override
    public void destroy(){

    }
}
