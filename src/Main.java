public class Main {
    public static void main(String[] args) {

        boolean game = true;
        while (game) {
            //      Create ships
            Ship[] ship = Ship.possibleShipList();
            //      Create players
            Player[] players = Player.playerList();
            //      Place ship on map
            Ship.initializePlayer(ship, players);
            //      Play game
            boolean player1Life = Check.checkShipMap(players[0].getMapPlayer());
            boolean player2Life = Check.checkShipMap(players[1].getMapPlayer());

            while (player1Life & player2Life) {
                Player.playerMove(player1Life, players[0], players[1]);
                player2Life = Check.checkShipMap(players[1].getMapPlayer());
                Player.playerMove(player2Life, players[1], players[0]);
                player1Life = Check.checkShipMap(players[0].getMapPlayer());
            }
            game = Check.restart();
        }
    }
}