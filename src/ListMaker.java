import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ListMaker {

    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        final String menuPrompt = "A - add D - Delete I - Insert P - Print Q - Quit";
        boolean running = true;
        String item = "";
        String cmd = "";
        String quitYN = "";
        int userSelection;

        do {
            displayMenu();
            cmd = SafeInput.getRegExString(in, menuPrompt, "[AaDdIiPpQq]");
            switch(cmd) {
                case "A":
                case "a":
                    item = SafeInput.getNonZeroLenString(in, "Enter the item you would like: ");
                    list.add(item);
                    running = false;
                case "D":
                case "d":
                    item = SafeInput.getNonZeroLenString(in, "Deleting the last item.");
                    list.remove(list.size() - 1);
                    running = false;

                case "I":
                case "i":
                    item = SafeInput.getNonZeroLenString(in, "Insert item at a specific spot in the list");
                    int placeHolder = in.nextInt();
                    list.add(placeHolder, item);
                    running = false;

                case "P":
                case "p":
                    System.out.println("1 - for regular list");
                    int thing = in.nextInt();
                    if(thing == 1) {
                        displayList();
                    }
                    else if(thing == 2) {
                        displayNumberedList();
                    }
                    running = false;
                case "Q":
                case "q":
                    System.out.println("Would you like to quit? Y/N");
                    quitYN = in.nextLine();
                    if(quitYN.equals("Y")) {
                        running = false;
                    }
                    else {
                        running = true;
                    }
            }

        }while(running);

    }

    public static void displayMenu() {
        System.out.println("A - add D - Delete I - Insert P - Print Q - Quit");
    }

    public static void displayNumberedList() {

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }

    }

    public static void displayList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


}