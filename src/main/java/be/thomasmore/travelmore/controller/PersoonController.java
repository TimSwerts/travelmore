package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Persoon;
import be.thomasmore.travelmore.service.PersoonService;
import be.thomasmore.travelmore.util.SessionUtils;
import org.apache.http.HttpRequest;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;


@ManagedBean
@ViewScoped
public class PersoonController implements Serializable {

    @Inject
    PersoonService persoonService;

    Persoon loginPersoon = new Persoon();

    public Persoon getLoginPersoon() {
        return loginPersoon;
    }

    public void setLoginPersoon(Persoon loginPersoon) {
        this.loginPersoon = loginPersoon;
    }



    public String login(){
        Persoon persoon = persoonService.controleerEmailWachtwoord(loginPersoon);

        if (persoon != null ){
            maakLoginSessie(persoon);
        }
        return "index";
    }

    public Persoon ingelogdeGebruiker(){
        HttpSession session = SessionUtils.getSession();
        return (Persoon) session.getAttribute("Gebruiker");
    }


    private void maakLoginSessie(Persoon persoon){
        HttpSession session = SessionUtils.getSession();
        session.setMaxInactiveInterval(15*60);
        session.setAttribute("Gebruiker", persoon);
        System.out.println("heej");
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }

    public boolean aangemeld(){
        return ingelogdeGebruiker() != null;
    }

    public void test(){
        System.out.println(aangemeld());
    }


}
