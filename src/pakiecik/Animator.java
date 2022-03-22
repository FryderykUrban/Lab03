package pakiecik;

import java.io.IOException;
import java.util.Scanner;


public class Animator {

    public static void main(String[] args) {
        Animator animator = new Animator();
        animator.amenu();
    }

    public Animator() {
    }

    public void amenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n ANIMATOR MENU ");
            System.out.println(" 1.Stwórz liste zapotrzebowania na impreze.");
            System.out.println(" 2.Przejrzyj liste realizacji zapotrzebowania.");
            System.out.println(" 3.Zatwierdzenie propozycji zrealizowania zapotrzebowania.");
            System.out.println(" 4.Wyjdź.");

            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> addProduct();
                case 2 -> showDeclarations();
                case 3 -> acceptDeclarations();
            }
        } while (choice != 4);
    }


    public void addProduct() {
        Data.readDataFromFile();
        Data.printEventMap(Data.getEvents());
        Data.readProductsFromFile();
        String productName;
        int nAOP;
        int pAOP;//provided amount of product
        int nrr= Data.getProductsMapSize();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer wydarzenia na które jest potrzebne");
        int nr= scanner.nextInt();
        System.out.println("Podaj nazwe potrzebnego produktu");
        productName= scanner.nextLine();
        productName= scanner.nextLine();
        System.out.println("Podaj potrzebną ilość produktu");
        nAOP = scanner.nextInt();
        pAOP=0;
        Data.addProduct(new Product(productName,nAOP,pAOP,nrr));
        String output = nr+";"+productName+";"+nAOP+";"+pAOP+";"+nrr+";\n";
        try{
            Data.saveProductsToFile(output);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void showDeclarations()
    {
        System.out.println("NR REALIZACJI   KTO  CO   ILE   STATUS");
        Data.readDeclarationFromFile();
        Data.printDeclarationMap(Data.getDeclaration());
    }
    public void acceptDeclarations()
    {
        showDeclarations();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj numer realizacji która chcesz zaakceptować");
        int nr= scanner.nextInt();
        Data.acceptDeclaration(nr);
    }
}
