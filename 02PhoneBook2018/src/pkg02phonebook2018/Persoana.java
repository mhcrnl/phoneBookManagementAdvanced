/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg02phonebook2018;

import java.io.Serializable;

/**
 *
 * @author mhcrnl
 */
public class Persoana implements Serializable {
    
    private static int nrCrt; 
    private String nume;
    private String prenume;
    // Constructor        
    public Persoana(String nume, String prenume) throws Exception{
        if(!persoanaOk(nume, prenume)) 
            throw new Exception("Nume si prenume invalid!");
        this.nume = nume;
        this.prenume = prenume;
        nrCrt++;
    }
    //GET/SET Methods
    /**
     * @return the nrCrt
     */
    public int getNrCrt() {
        return nrCrt;
    }
    /**
     * @param nrCrt the nrCrt to set
     */
    public void setNrCrt(int nrCrt) {
        this.nrCrt = nrCrt;
    }
    /**
     * @return the nume
     */
    public String getNume() {
        return nume;
    }
    /**
     * @param nume the nume to set
     */
    public void setNume(String nume) throws Exception {
        if(nume == null || nume.length() < 2) 
            throw new Exception("Introduceti un nume!");
        this.nume = nume;
    }
    /**
     * @return the prenume
     */
    public String getPrenume() {
        return prenume;
    }
    /**
     * @param prenume the prenume to set
     */
    public void setPrenume(String prenume) throws Exception {
        if(prenume == null || prenume.length() < 2) 
            throw new Exception("Introduceti un prenume!");
        this.prenume = prenume;
    }
    @Override
    public String toString(){
        return nrCrt+". "+ nume+" "+prenume;
    }
    /**
     * Return true daca numele si prenumele sunt introduse
     * @param nume
     * @param prenume
     * @return 
     */
    private static boolean persoanaOk(String nume, String prenume){
        return nume != null && nume.length() > 0 && prenume != null 
                && prenume.length() > 0;
    }
    
    public static void test1(){
        try {
            Persoana pers = new Persoana("Liviu", "Plesoianu");
            System.out.println(pers.getNrCrt()+" : "+pers);
            pers.setNume("Vasile");
            System.out.println(pers.getNrCrt()+" : "+pers);
            pers.setPrenume("Dragnea");
            System.out.println(pers.getNrCrt()+" : "+pers);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
