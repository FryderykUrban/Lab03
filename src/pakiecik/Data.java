package pakiecik;

import java.io.*;
import java.util.*;


public class Data {
    private static Map<Integer, Event> data;
    private static Map<Integer, Product> products;
    private static Map<Integer, Declaration> dec;

    public static void addProduct(Product product) {
        products.put(products.keySet().size() + 1, product);
    }
    public static void addDeclaration(Declaration declaration) {
        dec.put(dec.keySet().size() + 1, declaration);
    }

    public static void addEvent(Event event) {
        data.put(data.keySet().size() + 1, event);
    }

    public static Map<Integer, Event> getEvents() {return data;}

    public static Map<Integer, Product> getProducts() {
        return products;
    }
    public static Map<Integer, Declaration> getDeclaration() {
        return dec;
    }

    public static void readDataFromFile() {
        data = new HashMap<>();

        File file = new File("C:\\Users\\cukro\\IdeaProjects\\lab03_pop\\src\\pakiecik\\data");

        Scanner scanner;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] temp = scanner.nextLine().split(";");
                data.put(Integer.parseInt(temp[0]), new Event(temp[1], temp[2], temp[3], temp[4], temp[5], Float.parseFloat(temp[6])));
            }
        } catch (FileNotFoundException err) {
            System.out.println(err);
        }

    }
    public static void readProductsFromFile() {
        products= new HashMap<>();
        File file = new File("C:\\Users\\cukro\\IdeaProjects\\lab03_pop\\src\\pakiecik\\products");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] temp = scanner.nextLine().split(";");
                products.put(Integer.parseInt(temp[0]), new Product(temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]),Integer.parseInt(temp[4]) ));
            }
        } catch (FileNotFoundException err) {
            System.out.println(err);
    }
        }

    public static void readParticipantsFromFile() {

        File file = new File("C:\\Users\\cukro\\IdeaProjects\\lab03_pop\\src\\pakiecik\\participants");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] temp = scanner.nextLine().split(";");
                data.get((Integer.parseInt(temp[0]))).getParticipants().add(temp[1]);

            }
        } catch (FileNotFoundException err) {
            System.out.println(err);
        }
        }

    public static void readDeclarationFromFile() {
        dec = new HashMap<>();

        File file = new File("C:\\Users\\cukro\\IdeaProjects\\lab03_pop\\src\\pakiecik\\declaration");

        Scanner scanner;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] temp = scanner.nextLine().split(";");
                dec.put(Integer.parseInt(temp[0]), new Declaration((temp[1]), temp[2], Integer.parseInt(temp[3]), temp[4]));
            }
        } catch (FileNotFoundException err) {
            System.out.println(err);
        }}


    public static void saveDataToFile(String output) throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\cukro\\IdeaProjects\\lab03_pop\\src\\pakiecik\\data", true);
        fw.write(output);
        fw.close();
    }
    public static void saveProductsToFile(String output) throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\cukro\\IdeaProjects\\lab03_pop\\src\\pakiecik\\products", true);
        fw.write(output);
        fw.close();
    }
    public static void saveParticipantsToFile(String output) throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\cukro\\IdeaProjects\\lab03_pop\\src\\pakiecik\\participants", true);
        fw.write(output);
        fw.close();
    }
    public static void saveDeclarationToFile(String output) throws IOException {
        FileWriter fw = new FileWriter("C:\\Users\\cukro\\IdeaProjects\\lab03_pop\\src\\pakiecik\\declaration", true);
        fw.write(output);
        fw.close();
    }

    public static int getEventsMapSize() {
        return data.size();
    }
    public static int getProductsMapSize() {
        return products.size();
    }

    public static String editEvent2(int temp, String n, String o, String d, String da) {

        data.get(temp).setEventName(n);
        data.get(temp).setEventDescription(o);
        data.get(temp).setEventDate(d);
        data.get(temp).setApplicationDate(da);
        String tempstatus = "edytowany";
        data.get(temp).setStatus(tempstatus);
        return (temp + ";" + data.get(temp).getEventName() + ";" + data.get(temp).getEventDescription() + ";" + data.get(temp).getEventDate() + ";" + data.get(temp).getApplicationDate() + ";" + data.get(temp).getStatus() + ";" + data.get(temp).getPreparation() + "\n");
    }
    public static void acceptDeclaration(int nr)
    {
        String tempstatus="zaakceptowany";
        dec.get(nr).setStatus(tempstatus);
        String tempoutput= nr+";"+dec.get(nr).getWho()+";"+dec.get(nr).getWhat()+";"+dec.get(nr).getAmount()+";"+dec.get(nr).getStatus()+";\n";
        try{
        saveDeclarationToFile(tempoutput);
            } catch (IOException err) {
            System.out.println(err);
        }
    }

    public static void printEventMap(Map<Integer, Event> map) {
        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + (entry.getValue()).getEventName() + " " + (entry.getValue()).getEventDescription() + " " + (entry.getValue()).getEventDate() + " " + (entry.getValue()).getApplicationDate() + " " + (entry.getValue()).getStatus() + " " + (entry.getValue()).getPreparation());
        });
    }
    public static void printProductMap(Map<Integer, Product> map) {
        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + (entry.getValue()).getProductName() + " " + (entry.getValue()).getNeededAmonutOfProduct() + " " + (entry.getValue()).getProvidedAmountOfProduct()+ " " + (entry.getValue()).getNrr());
        });
    }
    public static void printDeclarationMap(Map<Integer, Declaration> map) {
        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + (entry.getValue()).getWho() + " " + (entry.getValue()).getWhat()+ " " + (entry.getValue()).getAmount()+" " + (entry.getValue()).getStatus());
        });
    }

    public static void addParticipant(int nr, String name) {

        int j = data.get(nr).getParticipants().size();
        data.get(nr).getParticipants().add(j, name);
        String output = nr+";"+data.get(nr).getParticipants()+"\n";
        try{
            Data.saveParticipantsToFile(output);
        } catch (IOException e) {
            e.printStackTrace();
        }

            }
    public static void showParticipant(int id) {
        readDataFromFile();
        readParticipantsFromFile();
        System.out.println(data.get(id).getParticipants());

                }
        }
