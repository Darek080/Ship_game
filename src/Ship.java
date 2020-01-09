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
}
