/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg02phonebook2018;

import java.util.Scanner;

/**
 *
 * @author mhcrnl
 */
public class Controller {
    
    Contact contact;
    Scanner input = new Scanner(System.in);
    boolean check = true;
    String[] meniu = { "\t\t====Agenda Telefonica=====\n", "\t1.Adauga contact.\n",
        "\t9.Iesire din program.\n",
    "Introduceti optiunea dumneavoastra:"};
    
    public void start(){
        while(check){
            afiseazaMeniu();
            int optiune = input.nextInt();
            input.nextLine();//goleste linia lui nextInt()
            switch(optiune){
                case 1:
                    adaugaContact();
                    break;
                case 2:
                    
                    break;
                  
                case 9:
                    System.out.println("Iesire din program. La revedere!!");
                    check = false;
                    break;
                default:
                    System.out.println("Optiunea dumneavostra nu exista!!!");
                    break;
            }
        }
        
    }
    
    private void afiseazaMeniu(){
        for(int i = 0; i < meniu.length; i++){
            System.out.println(meniu[i]);
        }
    }
    
    private void adaugaContact(){
        try {
            String nume, prenume, telefon, email;
            System.out.println("Introduceti numele contactului: ");
            nume = input.nextLine();
            System.out.println("Introduceti prenumele contactului: ");
            prenume = input.nextLine();
            System.out.println("Introduceti numarul de telefon al contactului: ");
            telefon = input.nextLine();
            System.out.println("Introduceti emailul contactului: ");
            email = input.nextLine();
            contact = new Contact(nume, prenume, telefon, email);
            System.out.println("Contactul: "+contact+" a fost adaugat cu succes!");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
