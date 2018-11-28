package be.thomasmore.travelmore.controller;

import be.thomasmore.travelmore.domain.Gebruiker;
import be.thomasmore.travelmore.service.GebruikerService;
import sun.rmi.runtime.Log;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@ManagedBean
@ViewScoped
public class GebruikerController implements Serializable {
    public Gebruiker newGebruiker = new Gebruiker();
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public Gebruiker getNewGebruiker() {
        return newGebruiker;
    }

    public void setNewGebruiker(Gebruiker newGebruiker) {
        this.newGebruiker = newGebruiker;
    }

    @Inject
    private GebruikerService gebruikerService;

    public String registreer(String controleWachtwoord) {
        //gebruiker op inactief zetten
        newGebruiker.setActief(false);

        //controle gegevens
        if (newGebruiker.getWachtwoord().equals(controleWachtwoord) && !gebruikerService.controleerEmailGebruikt(newGebruiker) && validate(newGebruiker.getEmail()) && checkRRN()) {
            System.out.println("Succes");
            newGebruiker.stuurBevestigingsMail();
            gebruikerService.insert(newGebruiker);

            return "login";
        }
        return "registreer";
    }

    private Boolean checkRRN() {
        //  Format datum
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        //  RRnummer opsplitsen in de verschillende delen
        String RRnummer = newGebruiker.getRijksregisternummer();
        String[] rrnummerDelen = RRnummer.split("-");
        String datumRR = rrnummerDelen[0];
        String controlenummerRRArray = rrnummerDelen[1];
        String[] geboorteDatumRRArray = datumRR.split("\\.");
        String[] controleRR = controlenummerRRArray.split("\\.");
        String geboortedatumHeel = df.format(newGebruiker.getGeboortedatum());
        String geboortedatumRR = geboorteDatumRRArray[2] + "/" + geboorteDatumRRArray[1] + "/" + geboorteDatumRRArray[0];
        String geboortedatumKort = geboortedatumHeel.substring(0, 6) + geboortedatumHeel.substring(8, 10);

        //  Kijk of geboortedatum en RRnummer overeenkomen
        if (geboortedatumKort.equals(geboortedatumRR)) {
            //  Check controlegetal
            int rest = 97 - (Integer.parseInt(geboorteDatumRRArray[0] + geboorteDatumRRArray[1] + geboorteDatumRRArray[2] + controleRR[0]) % 97);

            if (controleRR[1].equals(rest + "")) {
                return true;
            }
        }
        return false;
    }

    public String login() {


        return "login";
    }

    //  Validate email
    private static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}
