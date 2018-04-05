package burhan;


import java.util.Scanner;

import static burhan.Hotel.*;


/**
 * Receptionist classi bir oteldeki bir receptionistin yapabilecegini operasyonlarin methodlarini icerir
 * ve SystemUsers classindan extend olur
 */
public class Receptionist extends SystemUsers {
    /**
     * Programdan çıkıldığında hangi tipteki sistemusers tan çıkıldığı hakkındaki bilgiyi ekrana basar
     */
    @Override
    public void printExitInfo(){
        System.out.println("Receptionist olarak çıkış yapıldı");
    }

    /**
     * Programa hangi tip kullanici tarafindan girildigi hakkinda bilgiyi ekrana basar
     */
    @Override
    public void printConfirmation(){
        System.out.println("Receptionist olarak giriş yapıldı");
    }

    /**
     *Receptionistin book yapmasini saglayan methoddur.
     * @param roomNumber Book edilmek istenen oda numarisini tutar
     * @return oda book edildiyse true edilmediyse false return edilir
     */
    @Override
    public boolean bookRoom(int roomNumber) throws Exception {

        int ID = 123;

        if (roomNumber <= numberOfRoom && numberOfBookedRoom < numberOfRoom) {
            if (rooms[roomNumber].isBooked == false) {
                rooms[roomNumber].receptionistID = ID;
                System.out.println("Receptionist ID'si Olarak "+ID+" seçildi.");
                this.setID(ID);
                rooms[roomNumber].isBooked = true;
                numberOfBookedRoom++;
                System.out.println((roomNumber+1) +". Oda Resepsiyonist tarafından Book yapıldı");
                return true;
            } else {
                System.out.printf((roomNumber+1) +". Oda Zaten Book Edilmiştir\n");
                return false;
            }
        } else {
            throw new Exception((roomNumber+1)  +" . Oda Yanlış Bir Oda Seçimidir");
        }
    }

    /**
     * Receptionistin checkIn yapmasini saglayan methodtur
     * @param roomNumber checkIn yapilmak istenen oda numarasini tutar
     * @return oda check in yapildiysa true , yapilamadiysa false return eder
     */
    public boolean checkIn(int roomNumber) throws Exception{

        int ID = 123;

        if(roomNumber<=numberOfRoom && checkedRoom<numberOfRoom){

            if(rooms[roomNumber].isBooked==false ||( rooms[roomNumber].isBooked==true && rooms[roomNumber].isChecked==false)){
                rooms[roomNumber].isChecked=true;
                if(rooms[roomNumber].isBooked==false){
                    System.out.println("Receptionist ID'si Olarak "+ID+" seçildi.");
                    rooms[roomNumber].receptionistID = ID;
                    this.setID(ID);

                }
                rooms[roomNumber].isBooked=true;

                checkedRoom++;
                System.out.println((roomNumber+1) +". Oda Resepsiyonist tarafından check-in yapıldı");
                return true;
            }
            else{
                System.out.printf((roomNumber+1) +". Oda Zaten Check-in Edilmiştir\n");
                return false;
            }
        }
        else{
            throw new Exception((roomNumber+1)  +" . Oda Yanlış Bir Oda Seçimidir\n");
        }
    }

    /**
     * Receptionistin checkOut yapmasini saglayan methodtur
     * @param roomNumber checkOut yapilmak istenen oda numarasini tutar
     * @return oda checkOut yapildiysa true , yapilamadiysa false return eder
     */
    public boolean checkOut(int roomNumber) throws Exception{
        if(roomNumber<=numberOfRoom ) {

            if (rooms[roomNumber].isChecked == true ) {
                rooms[roomNumber].isChecked = false;
                rooms[roomNumber].isBooked = false;
                rooms[roomNumber].guestName = null;
                rooms[roomNumber].receptionistID = 0;
                checkedRoom--;
                System.out.println((roomNumber+1) +". Oda Resepsiyonist tarafından check-out yapıldı ");
                return true;
            } else {
                System.out.printf((roomNumber+1) +" . Oda Zaten Not Checked Olan Bir Odadır\n");
                return false;
            }
        }
        else{
            throw new Exception((roomNumber+1)  +" . Oda Yanlış Bir Oda Seçimidir\n");

        }
    }

}
