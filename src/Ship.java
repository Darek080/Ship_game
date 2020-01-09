public class Ship {

     private String shipName;
     private int shipLong;

     Ship(String name, int large){
         this.shipName = name;
         this.shipLong = large;
     }
     public String toString(){
         return shipName+" have long "+ shipLong;
     }
     String getShipName() {
         return shipName;
     }
     int getShipLong() {
         return shipLong;
     }

    static Ship[] possibleShipList() {
        //      Create ships.
        Ship[] ship = new Ship[4];
        ship[0] = new Ship("Carrier", 4);
        ship[1] = new Ship("Submarine", 3);
        ship[2] = new Ship("Cruiser",2);
        ship[3] = new Ship("Cruiser",2);
        return ship;
    }

    static void initializePlayer(Ship[] ship , Player[] players) {
        //      placing ships on the map by the player
        for (Player player : players) {
            for (int n = 0; n < ship.length; n++) {
                String[][] playerMap = player.getMapPlayer();
                System.out.println(player.getPlayerName() + " " + ship[n].getShipName() + " have long " + ship[n].getShipLong());
                Display.printMap(playerMap);
                int placed = Display.selectPlaced();
                String[] position = Ocean.position("Set position to your ship (e.g B,5): ");
                boolean checkInput = Check.checkInput(position);
                if (checkInput) {
                    int[] positionToInt = Display.convertY(position);
                    boolean checkPosition = Check.checkPosition(playerMap, positionToInt, placed, ship[n].getShipLong());
                    if (checkPosition) {
                        Ocean.shipPosition(positionToInt, placed, ship[n].getShipLong(), playerMap);
                    } else {
                        n -= 1;
                    }
                } else {
                    n -= 1;
                }
            }
            Display.displaySpace();
        }
    }
}
