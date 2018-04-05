package burhan;

import static burhan.Hotel.numberOfBookedRoom;
import static burhan.Hotel.numberOfRoom;
import static burhan.Hotel.rooms;

/**
 * SystemUsers abstract classi bir oteldeki Sistem kullanicilarinin sahip oldugu data memberleri ve methodlari tutar.
 * Abstracttir cunku bookRoom,printConfirmation,printExitInfo methodlari sub classlarda farkli anlamlar icerecegi icin abstracttir.
 * Ayrica SystemUsersInt interfacesini implement eder
 */
public abstract class SystemUsers implements SystemUsersInt{
    /**
     * name String datamemberi sistem kullanicisinin adini tutar.
     */
    private String name;
    /**
     * ID String datamemberi sistem kullanicisinin ID sini tutar.
     */
    private int ID;

    /**
     * name icin getter methodu
     * @return name return eder
     */
    public String getName(){
        return name;
    }

    /**
     * ID icin getter
     * @return ID return eder
     */
    public int getID() {
        return ID;
    }

    /**
     * name icin setter
     * @param name alinir ve data member olan name a atanir.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ID icin setter
     * @param ID alinir ve data member olan ID ye atanir.
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     *
     * @param roomNumber Cancel reservation yapilmak istenen oda numarasini tutar
     * @return eger Reservasyon Cancel operasyonu gerceklesirse true return edilir, gerceklesmezse false return edilir
     */
    public boolean cancelReservation(int roomNumber) throws Exception{
        if (roomNumber < numberOfRoom && rooms[roomNumber].isBooked == true && rooms[roomNumber].isChecked == false) {
            rooms[roomNumber].isBooked = false;
            rooms[roomNumber].guestName = null;
            rooms[roomNumber].receptionistID = 0;
            numberOfBookedRoom--;
            System.out.println((roomNumber+1)  + ". Odanın Rezervasyon iptal edildi");
            return true;
        }
        else if(rooms[roomNumber].isChecked==true ){
            System.out.printf((roomNumber+1)  + ". Oda zaten check-in olduğu için rezervasyonunuzu iptal edemezsiniz.\n");
            return false;
        }
        else if(roomNumber > numberOfRoom || roomNumber<1){
            throw new Exception( (roomNumber+1) + ". Oda Yanlış Bir Oda Seçimidir\n");

        }
        else{
            System.out.printf((roomNumber+1) +" . Oda Zaten Not Booked tir\n");
            return false;
        }
    }
    /**
     * SystemUserin book yapmasini saglayan methoddur.
     * @param roomNumber Book edilmek istenen oda numarisini tutar
     * @return oda book edildiyse true edilmediyse false return edilir
     */
    public abstract boolean bookRoom(int roomNumber) throws Exception;
    /**
     * ekranda Receptionist olarakmi yoksa Hotel Guest olarak mi girildi bilgisini gosterir
     */
    public abstract void printConfirmation();
    /**
     * ekranda Receptionist olarak mi yoksa Hotel Guest olarak mi programdan cikildigi bilgisini gosterir
     */
    public abstract void printExitInfo();


}
