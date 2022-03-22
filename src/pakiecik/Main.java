package pakiecik;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int choice;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("""
                    ---MAIN-MENU---
                    1.Organiser menu
                    2.Animator menu
                    3.Participant menu
                    4.Exit""");
            choice =scanner.nextInt();
            switch (choice){
                case 1-> {Organiser organiser= new Organiser();
                    organiser.menu();}
                case 2->{Animator animator = new Animator();
                    animator.amenu();}
                case 3->{
                    Participant participant = new Participant();
                participant.pmenu();}
            }
        }while(choice!=4);
    }
}