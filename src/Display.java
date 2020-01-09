import java.util.Scanner;

class Display {


    static void printMap(String[][] maps) {
        //      printing map
        String[] y = {"A |", "B |", "C |", "D |", "E |", "F |", "G |", "H |", "I |", "J |", "K |"};
        System.out.println("   1 2 3 4 5 6 7 8 9 10");
        System.out.println("   ____________________");
        int i = 0;
        for (String[] list : maps) {
            String line = "";
            for (String field : list) {
                line += field;
            }
            System.out.println(y[i] + line);
            i++;
        }
    }

    static int selectPlaced() {
        //      select vertical or horizontal
        while (true) {
            System.out.println("1-> vertical\n" + "2->horizontal");
            Scanner obj = new Scanner(System.in);
            System.out.println("Select your placed: ");
            try {
                int placed = obj.nextInt();
                if (placed == 1 || placed == 2) {
                    return placed;
                } else {
                    System.out.println("Wrong choice");
                }
            } catch (Exception e) {
                System.out.println("Wrong choice");
            }
        }
    }

    static int[] convertY(String[] position) {
        //      convert input letter to number
        String[] y = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        int Y;
        int X;
        X = Integer.parseInt(position[1]);

        for (int i = 0; 1 < 10; i++) {
            if (position[0].equals(y[i])) {
                Y = i;
                return new int[]{Y, X - 1};
            }
        }
    }

    static void displaySpace(){
        for(int i=0; i<=50; i++)
            System.out.println("\n");
    }
}