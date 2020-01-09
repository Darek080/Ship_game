import java.util.Scanner;
class Player {
        private String playerName;
        private Ocean maps = new Ocean();
        private String[][] mapPlayer = maps.oceanMap();
        private String [][] shootMap = maps.oceanMap();

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

    static Player[] playerList() {
        //      Create players
        Player[] players = new Player[2];
        players[0] = new Player("player 1");
        players[1] = new Player("player 2");
        return players;
    }

    static void playerMove(boolean life, Player player1, Player player2 ){
        if (life) {  // Player move
            Display.printMap(player1.getShootMap());
            String[] shot = Ocean.position(player1.getPlayerName()+" choose shot field (e.g B,5)");
            boolean checkInput = Check.checkInput(shot);
            if (checkInput) {
                int[] positionToInt = Display.convertY(shot);
                Ocean.shoot(player2.getMapPlayer(), player1.getShootMap(), positionToInt);

            }
        } else {
            System.out.println("Win " + player2.getPlayerName());
        }
    }
}
