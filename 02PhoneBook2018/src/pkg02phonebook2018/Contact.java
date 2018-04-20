/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg02phonebook2018;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mhcrnl
 */
public class Contact extends Persoana implements Serializable {
    
    private String nume;
    private String prenume;
    private ArrayList<String> numereTel = new ArrayList(); 
    private ArrayList<String> emailuri = new ArrayList();
    /**
     * <b>Contructor<b>
     * @param nume
     * @param prenume
     * @param numereTel
     * @param emailuri
     * @throws Exception 
     */
    public Contact(String nume, String prenume, String numereTel, 
            String email) throws Exception{
        super(nume, prenume);
        this.numereTel.add(numereTel);
        this.emailuri.add(email);
    }
    
    public void adaugaNrNou(String numarTel) throws Exception{
        if(numarTel == null || numarTel.length() > 10) 
            throw new Exception("Numarul de telefon trebuie sa aiba 10 numere!");
        this.numereTel.add(numarTel);
    }
    
    public void adaugaEmailNou(String email) throws Exception{
        if(email == null || email.length() < 6)
            throw new Exception("Adresa de mail este incorecta!");
        this.emailuri.add(email);
    }
    
    public void afiseazaNumereTel(String nume){
        //ArrayList<String> lista;
        if(super.getNume().equals(nume)){
            System.out.println("Numerele de contact pentru: "+super.toString());
            for(String tel: numereTel) 
                System.out.println(tel.toString());
        }
        //return null;
    }
    
    public void afiseazaEmail(String nume){
        if(super.getNume().equals(nume)){
            System.out.println("Emailurile de contat pentru: "+super.toString());
            for(String email: emailuri){
                System.out.println(email.toString());
            }
        }
    }
    
    @Override
    public String toString(){
        return super.toString() + numereTel + emailuri;
    }
    
    public static void test2(){
        try{
            Contact cont = new Contact("Ludovic", "Orban", "0123456789", "orban@gmail.com");
            System.out.println(cont.getNrCrt()+" : "+cont.toString());
            cont.adaugaNrNou("0722270796");
            cont.adaugaEmailNou("liviu@gmail.com");
            cont.afiseazaNumereTel("Ludovic");
            System.out.println(cont);
            cont.afiseazaEmail("Ludovic");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
