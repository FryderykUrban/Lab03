package pakiecik;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Organiser {

    public static void main(String[] args) {
        Organiser organiser = new Organiser();
        organiser.menu();
    }

    public Organiser() {
    }


    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n ORGANISER MENU ");
            System.out.println(" 1.Dodaj nowe wydarzenie.");
            System.out.println(" 2.Edytuj wydarzenie, wprowadź korekte.");
            System.out.println(" 3.Wyświetl wydarzenia.");
            System.out.println(" 4.Wyświetl uczestników.");
            System.out.println(" 5.Wyjdź. ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addEvent();
                case 2 -> editEvent();
                case 3 -> showEvents();
                case 4 -> showParticipants();

            }
        } while (choice != 5);


    }

    public void addEvent() {
        Data.readDataFromFile();
        String eventName;
        String eventDescription;
        String eventDate;
        String applicationDate;
        String status = "zgłoszone";
        int eventnr = Data.getEventsMapSize();
        float preparation = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe wydarzenia");
        eventName = scanner.nextLine();
        System.out.println("Podaj opis wydarzenia");
        eventDescription = scanner.nextLine();
        System.out.println("Podaj date wydarzenia [dd/mm/rrrr]");      //tutaj mozna pomyslec zeby z godzina i ze stringa na Date!!!
        eventDate = scanner.nextLine();
        System.out.println("Termin przesyłania zgłoszeń [dd/mm/rrrr]");
        applicationDate = scanner.nextLine();

        Data.addEvent(new Event(eventName, eventDescription, eventDate, applicationDate, status, preparation));
        String output = eventnr + ";" + eventName + ";" + eventDescription + ";" + eventDate + ";" + applicationDate + ";" + status + ";" + preparation + ";\n";
        try {
            Data.saveDataToFile(output);
        } catch (FileNotFoundException err) {
            System.out.println(err);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editEvent() {
        showEvents();
        int temp;
        String tempeventName;
        String tempeventDescription;
        String tempventDate;
        String tempapplicationDate;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer wydarzenia które chcesz edytować");
        temp = scanner.nextInt();
        System.out.println("Podaj nazwe wydarzenia");
        tempeventName = scanner.nextLine();
        tempeventName = scanner.nextLine();
        System.out.println("Podaj opis wydarzenia");
        tempeventDescription = scanner.nextLine();
        System.out.println("Podaj date wydarzenia [dd/mm/rrrr]");      //tutaj mozna pomyslec zeby z godzina i ze stringa na Date!!!
        tempventDate = scanner.nextLine();
        System.out.println("Podaj date składania aplikacji [dd/mm/rrrr]");
        tempapplicationDate = scanner.nextLine();
        String tempoutput;
        tempoutput = Data.editEvent2(temp, tempeventName, tempeventDescription, tempventDate, tempapplicationDate);
        try {
            Data.saveDataToFile(tempoutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showEvents() {
        System.out.println("NR   NAZWA WYDARZENIA   OPIS   DATA   DATA APLIKACJI   STATUS   PRZYGOTOWANIE");
        Data.readDataFromFile();
        Data.printEventMap(Data.getEvents());
    }

    public void showParticipants() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nr wydarzenia dla którego chcesz wyświetlić uczestników: ");
        int id = scanner.nextInt();
        Data.showParticipant(id);
    }
}






