package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Persoon;
import be.thomasmore.travelmore.service.PersoonService;
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
@RequestScoped
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

    private void maakLoginSessie(Persoon persoon){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();

        try{
            request.login(persoon.getEmail(), persoon.getWachtwoord());
        } catch (ServletException e){
            System.out.println("heej");
        }
    }
}
