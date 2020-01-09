import java.util.Scanner;
class Player {
        private String playerName;
        private Ocean maps = new Ocean();
        private String[][] mapPlayer = maps.OceanMap();
        private String [][] shootMap = maps.OceanMap();

        Player(String player){
            Scanner obj = new Scanner(System.in);
            System.out.println(player+" Enter your name");
            playerName = obj.nextLine();
        }
        String getPlayerName(){
            return playerName;
        }
        String[][] getMapPlayer(){
            return mapPlayer;
        }
        String[][] getShootMap(){
            return shootMap;
        }
}
