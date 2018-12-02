package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Persoon;
import be.thomasmore.travelmore.service.PersoonService;
import be.thomasmore.travelmore.util.SessionUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.http.HttpRequest;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.DiscriminatorValue;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;


@ManagedBean
@RequestScoped
public class PersoonController implements Serializable {

    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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

        if (persoon != null){
            if (persoon.getActief()){
                maakLoginSessie(persoon);
                return "index";
            } else {
                 this.setMessage("Uw account is nog niet geactiveerd");
            }

        } else {
            this.setMessage("Onjuiste aanmeldgegevens");
        }


        return "login";

    }


    public Persoon getIngelogdePersoon(){
        HttpSession session = SessionUtils.getSession();
        Persoon pers = (Persoon) session.getAttribute("Gebruiker");
        if (pers == null) {
            return new Persoon();
        } else  {
            return pers;
        }
    }

    private void maakLoginSessie(Persoon persoon){
        HttpSession session = SessionUtils.getSession();
        session.setMaxInactiveInterval(15*60);
        session.setAttribute("Gebruiker", persoon);

        this.loginPersoon =persoon;
    }

    public String logout() {


        HttpSession session = SessionUtils.getSession();
        session.invalidate();

        return "index";
    }

    public Boolean isAangemeld(){
        HttpSession session = SessionUtils.getSession();
        return session.getAttribute("Gebruiker") != null;
    }

    public Boolean isAdmin(){


       if (!isAangemeld()){
           return false;
       } else {
           HttpSession session = SessionUtils.getSession();
           DiscriminatorValue val =  session.getAttribute("Gebruiker").getClass().getAnnotation(DiscriminatorValue.class);
           return val.value().equals("Admin");
       }
    }







}
