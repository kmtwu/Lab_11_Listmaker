import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> myArrList = new ArrayList<>();
        String action;
        boolean YorN = false;
        String addValue;
        String insertValue;
        int insertPlace;
        int delPlace;
        String menuResponse;
        System.out.println("Hello! Welcome to myListMaker! You can make changes to your new list now!");
        do {
            printList(myArrList);
            System.out.println();
            menuResponse = getMenuResponse(in);
            if (menuResponse.equals("A") || menuResponse.equals("a")) {
                System.out.println("Enter the string you would like to add.");
                addValue = in.next();
                in.nextLine();
                addItem(myArrList, addValue);
            }
            else if (menuResponse.equals("D") || menuResponse.equals("d")) {
                for (int i = 0; i < myArrList.size(); i++) {
                    System.out.print("(" + (i + 1) + ". " + myArrList.get(i) + ") ");
                }
                delPlace = SafeInput.getRangedInt(in, "Enter the place of the item you would like to remove.", 1, myArrList.size());
                myArrList = delItem(myArrList, (delPlace - 1));
            }
            else if (menuResponse.equals("I") || menuResponse.equals("i")) {
                insertPlace = SafeInput.getRangedInt(in, "Enter the place of where you want to add the new item", 1, myArrList.size());
                System.out.println("Enter what value you want to add.");
                insertValue = in.next();
                in.nextLine();
                insertItem(myArrList, insertValue, insertPlace);
            }
            else if (menuResponse.equals("P") || menuResponse.equals("p")) {
                printList(myArrList);
            }
            else if (menuResponse.equals("Q") || menuResponse.equals("q")) {
                if (SafeInput.getYNConfirm(in, "Are you sure you'd like to quit?")) {
                    YorN = true;
                    System.out.println("Bye!");
                }
                else {
                    System.out.println("Oops!");
                }
            }
        } while (!YorN);
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
        for (int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println();
    }
}