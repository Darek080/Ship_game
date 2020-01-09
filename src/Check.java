
import java.util.Scanner;

public class Check {
    static boolean CheckInput(String[] position) {
        String[] y = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        boolean[] checked = new boolean[2];
        try {
            for (String ch : y) {
                if (position[0].equals(ch)) {
                    checked[0] = true;
                }
            }
            if (Integer.parseInt(position[1]) <= 10) {
                checked[1] = true;
            }
        } catch (Exception e) {
        } finally {
            if (checked[0] && checked[1]) {
                return true;
            } else {
                System.out.println("Wrong choice");
                return false;
            }
        }
    }

    static boolean CheckPosition(String[][] map, int[] position, int placed, int shipSize) {
        try {
            if (placed == 1) {
                for (int i = 0; i < shipSize; i++) {
                    if (map[position[0] + i][position[1] - 1].equals("V|")) {
                        System.out.println(" There is another ship ");
                        return false;
                    }
                }
            } else if (placed == 2) {
                for (int i = 0; i < shipSize; i++) {
                    if (map[position[0]][(position[1]) + i].equals("V|")) {
                        System.out.println(" There is another ship ");
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(" Ship does not fit in the map  ");
            return false;
        }
        return true;
    }

    static boolean checkShipMap(String[][] map) {
        int y, x;
        for (y = 0; y < 10; y++) {
            for (x = 0; x < 10; x++) {
                if (map[y][x].equals("V|")) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean Restart() {
        while (true) {
            Scanner obj = new Scanner(System.in);
            System.out.println("Do you want play again (y/n)");
            String input = obj.nextLine();
            input = input.toUpperCase();
            if (input.equals("Y")) {
                return true;
            } else if (input.equals("N")) {
                return false;
            } else {
                System.out.println("Wrong choice");
            }
        }
    }
}

