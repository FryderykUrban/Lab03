package pakiecik;

import java.io.IOException;
import java.util.Scanner;


public class Participant {


    public static void main(String[] args) {

        Participant participant = new Participant();
        participant.pmenu();
    }

    public Participant() {}


    public void pmenu() {
            Scanner scanner = new Scanner(System.in);
            int choice;
            do{

        System.out.println("\n PARTICIPANT MENU ");
        System.out.println(" 1.Lista wydarzeń.");
        System.out.println(" 2.Zgłaszanie chęci uczestnictwa w wydarzeniu.");
        System.out.println(" 3.Lista zapotrzebowania.");
        System.out.println(" 4.Zgłoś chęć zrealizowania zapotrzebowania");
        System.out.println(" 5.Wyjdź.");

        choice = scanner.nextInt();
        switch (choice) {
            case 1 -> showEvents();
            case 2 -> wTP();
            case 3 -> requistionList();
            case 4 -> declaration();

        }}while(choice!=5);
    }
    public void showEvents () {
        System.out.println("NR   NAZWA WYDARZENIA   OPIS   DATA   DATA APLIKACJI   STATUS   PRZYGOTOWANIE");
        Data.readDataFromFile();
        Data.printEventMap(Data.getEvents());
    }
    public void wTP()
    {
        String name;
        showEvents();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer wydarzenia w którym chcesz uczestniczyć?");
        int nr = scanner.nextInt();
        System.out.println("Podaj swoje imie");
        name =scanner.nextLine();
        name =scanner.nextLine();
        Data.addParticipant(nr,name);

    }
    public void requistionList(){
        System.out.println("NR WYDARZENIA   PRZEDMIOT   POTRZEBNA ILOŚĆ   ILOŚĆ ZGŁOSZONA   NR REALIZACJI");
        Data.readProductsFromFile();
        Data.printProductMap(Data.getProducts());
    }
    public void declaration()
    {
        Data.readDeclarationFromFile();
        String name;
        String product;
        int amount ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer realizacji zamowienia");
        int nr= scanner.nextInt();
        System.out.println("Podaj swoje imie");
        name= scanner.nextLine();
        name= scanner.nextLine();
        System.out.println("Podaj nazwe produktu który chcesz przyniesc");
        product = scanner.nextLine();
        System.out.println("Podaj ilość którą chcesz przyniesc");
        amount = scanner.nextInt();
        String status = "oczekująca";
        Data.addDeclaration(new Declaration(name,product,amount,status));
        String output = nr+";"+name+";"+product+";"+amount+";"+status+";\n";
        try{
            Data.saveDeclarationToFile(output);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}