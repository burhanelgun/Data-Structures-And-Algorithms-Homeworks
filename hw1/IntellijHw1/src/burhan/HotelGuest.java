package burhan;


import java.util.Scanner;

import static burhan.Hotel.numberOfBookedRoom;
import static burhan.Hotel.numberOfRoom;
import static burhan.Hotel.rooms;

/**
 * Bir hotel guestinin yapabilecegi operasyonlarin methodlarini barindirir.SystemUsers abstract classindan extend olur.
 */
public class HotelGuest extends SystemUsers {
    /**
     * Programdan cikildiginda hangi tipteki sistemusers tan cikildigi hakkindaki bilgiyi ekrana basar
     */
    @Override
    public void printExitInfo(){
        System.out.println("Hotel Guest olarak çıkış yapıldı");
    }
    /**
     * Programa hangi tip kullanici tarafindan girildigi hakkinda bilgiyi ekrana basar
     */
    @Override
    public void printConfirmation(){
        System.out.println("Hotel Guest olarak giriş yapıldı");
    }
    /**
     *Hotel Guest in book yapmasini saglayan methoddur.
     * @param roomNumber Book edilmek istenen oda numarisini tutar
     * @return oda book edildiyse true edilmediyse false return edilir
     */
    @Override
    public boolean bookRoom(int roomNumber) throws Exception{

        String name="Burhan";

        if (roomNumber <= numberOfRoom && numberOfBookedRoom < numberOfRoom) {
            if (rooms[roomNumber].isBooked == false) {
                System.out.println("Hotel Guest İsmi Olarak "+name+" seçildi.");
                rooms[roomNumber].guestName = name;
                this.setName(name);
                rooms[roomNumber].isBooked = true;
                numberOfBookedRoom++;
                System.out.println((roomNumber+1) +". Oda Hotel Guest tarafından Book yapıldı");
                return true;
            } else {
                System.out.printf((roomNumber+1) +". Oda Zaten Book Edilmiş\n");
                return false;
            }
        } else {
            throw new Exception((roomNumber+1) +" . Oda Yanlış Bir Oda Seçimidir\n");
        }
    }

}
