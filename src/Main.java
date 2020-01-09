public class Main {
    public static void main(String[] args) {

        boolean game = true;
        while (game) {
            //      Create ships.
            Ship[] ship = possibleShipList();
            //      Create players
            Player[] players = playerList();
            //      Place ship on map
            initializePlayer(ship, players);
            //      Play game
            boolean player1Life = Check.checkShipMap(players[0].getMapPlayer());
            boolean player2Life = Check.checkShipMap(players[1].getMapPlayer());

            while (player1Life & player2Life) {
                playerMove(player1Life, player2Life, players[0], players[1]);
                playerMove(player2Life, player1Life, players[1], players[0]);
               /* if (player1Life) {  // Player1 move
                    Display.printMap(players[0].getShootMap());
                    String[] shot = Ocean.Position(players[0].getPlayerName()+" choose shot field");
                    boolean checkInput = Check.CheckInput(shot);
                    if (checkInput) {
                        int[] positionToInt = Display.convertY(shot);
                        Ocean.Shoot(players[1].getMapPlayer(), players[0].getShootMap(), positionToInt);
                        player2Life = Check.checkShipMap(players[1].getMapPlayer());
                    }
                } else {
                    System.out.println("Win " + players[1].getPlayerName());
                }

                if (player2Life) {  // Player2 move
                    Display.printMap(players[1].getShootMap());
                    String[] shot = Ocean.Position(players[1].getPlayerName()+" choose shot field");
                    boolean checkInput = Check.CheckInput(shot);
                    if (checkInput) {
                        int[] positionToInt = Display.convertY(shot);
                        Ocean.Shoot(players[0].getMapPlayer(), players[1].getShootMap(), positionToInt);
                        player1Life = Check.checkShipMap(players[0].getMapPlayer());
                    }
                } else {
                    System.out.println("Win " + players[0].getPlayerName());
                }*/
            }
            game = Check.Restart();
        }
    }

    public static void playerMove(boolean P1life, boolean P2life, Player player1, Player player2 ){
        if (P1life) {  // Player1 move
            Display.printMap(player1.getShootMap());
            String[] shot = Ocean.Position(player1.getPlayerName()+" choose shot field");
            boolean checkInput = Check.CheckInput(shot);
            if (checkInput) {
                int[] positionToInt = Display.convertY(shot);
                Ocean.Shoot(player2.getMapPlayer(), player1.getShootMap(), positionToInt);
                P2life = Check.checkShipMap(player2.getMapPlayer());
            }
        } else {
            System.out.println("Win " + player2.getPlayerName());
        }
    }

//    public static void initializeGame(Ship[] ship, Player[] players) {
//        for (Player player : players) {
//            initializePlayer(ship, player);
//        }
//    }

    private static void initializePlayer(Ship[] ship , Player[] players) {
        for (Player player : players)
            for (int n = 0; n < ship.length; n++) {
                String[][] playerMap = player.getMapPlayer();
                System.out.println(player.getPlayerName()+" "+ship[n].getShipName() + " have long " + ship[n].getShipLong());
                int placed = Display.selectPlaced();
                Display.printMap(playerMap);
                String[] position = Ocean.Position("Set position to your ship (e.g B,5): ");
                boolean checkInput = Check.CheckInput(position);
                if (checkInput) {
                    int[] positionToInt = Display.convertY(position);
                    boolean checkPosition = Check.CheckPosition(playerMap, positionToInt, placed, ship[n].getShipLong());
                    if (checkPosition) {
                        Ocean.ShipPosition(positionToInt, placed, ship[n].getShipLong(), playerMap);
                    } else {
                        n -= 1;
                    }
                } else {
                    n -= 1;
                }
            }
        }

    private static Player[] playerList() {
        Player[] players = new Player[2];
        players[0] = new Player("player 1");
        players[1] = new Player("player 2");
        return players;
    }

    private static Ship[] possibleShipList() {
        Ship[] ship = new Ship[1];
        ship[0] = new Ship("Carrier", 4);
        //ship[1] = new Ship("Submarine", 3);
       // ship[2] = new Ship("Cruiser",2);
        //ship[3] = new Ship("Cruiser",2);
        return ship;
    }
}