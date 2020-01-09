import java.util.Scanner;

public class Ocean {
        String[][] OceanMap() {
            String[][] oceanMap = new String[10][10];
            int y, x;
            for (y = 0; y < 10; y++) {
                for (x = 0; x < 10; x++) {
                    oceanMap[y][x] = " |";
                }
            }
            return oceanMap;
        }
    static String[] Position(String message) {
        Scanner obj = new Scanner(System.in);
        System.out.println(message);
        String input = obj.nextLine();
        input = input.toUpperCase();
        //System.out.println(input);
        String[] position = input.split(",");
        return position;
    }
    static void ShipPosition(int[] position, int placed, int shipSize, String[][] map) {
        if (placed == 1) {
            for (int i = 0; i < shipSize; i++) {
                map[position[0] + i][position[1]] = "V|";
            }
        } else if (placed == 2) {
            for (int i = 0; i < shipSize; i++) {
                map[position[0]][(position[1]) + i] = "V|";
            }
        }
    }
    static void Shoot(String[][] mapPlayer, String[][] mapShoot, int[] shoot){
            if(mapPlayer[shoot[0]][shoot[1]].equals("V|")){
                mapShoot[shoot[0]][shoot[1]] = "X|";
                mapPlayer[shoot[0]][shoot[1]] = "X|";
            }else if (mapPlayer[shoot[0]][shoot[1]].equals(" |")){
                mapShoot[shoot[0]][shoot[1]] = "O|";
            }else{
                System.out.println("You shoot same place as before");
            }
    }
}
