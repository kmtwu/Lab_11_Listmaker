import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> myArrList = new ArrayList<>();
        String action;

    }
    private static String getMenuResponse(Scanner pipe){
        System.out.println("Enter A/a add an item, D/d to delete an item, I/i to insert an item, P/p to print the list, and enter Q/q to quit.");
        String input;
        boolean cont = true;
        do {
            input = pipe.next();
            if(input.equals("A") || input.equals("a") || input.equals("D") || input.equals("d") || input.equals("I") || input.equals("i") || input.equals("P") || input.equals("p") || input.equals("Q") || input.equals("q")) {
                cont = false;
            }
            else {
                System.out.println("Invalid input!");
                System.out.println("Enter A/a add an item, D/d to delete an item, I/i to insert an item, P/p to print the list, and enter Q/q to quit.");
                pipe.nextLine();
            }
        } while(cont);
        return input;
    }
    private static ArrayList<String> addItem (ArrayList<String> myList, String appendItem) {
        myList.add(appendItem);
        return myList;
    }
    private static ArrayList<String> delItem (ArrayList<String> myList, int delPlace) {
        ArrayList<String> newList = new ArrayList<>();
        for (int i = 0; i < myList.size(); i++) {
            if (!(i == delPlace)){
                newList.add(myList.get(i));
            }
        }
        return newList;
    }
    private static ArrayList<String> insertItem (ArrayList<String> myList, String newItem, int newPlace) {
         myList.add(newPlace - 1, newItem);
         return myList;
    }
    private static void printList (ArrayList<String> myList) {
        for (int i = 0; i < myList.size(); i++)
    }
}