package burhan;


import java.io.*;
import java.util.InputMismatchException;

/**
 * main class
 */
public class main {
    /**
     * main method
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException,Exception {
        //System.setIn(new FileInputStream(input))


        int [] tesTarr={1,4}; // 0. index HotelGuest in operasyonlarının test edildiği odanın numarasıdır, 1.index Receptionist in operasyonlarının test edildiği odanın numarasıdır

        try {
            Hotel hotel = new Hotel();
            SystemUsers systemUsers;


            File f = new File("");

           if(!(f.exists() && !f.isDirectory())) {
                hotel.beginARecordFile();
           }
            System.out.println("Kayıt Dosyasından Odalar ve Durumları Okundu");
            hotel.readRoomStatusFromFile();


            systemUsers = new HotelGuest();
            systemUsers.printConfirmation();

            hotel.printRoomStatus();
            System.out.println();
            System.out.println();
            systemUsers.bookRoom(tesTarr[0]);
            hotel.printRoomStatus();
            System.out.println();
            System.out.println();
            System.out.println("Aynı Odaya Tekrar Book Yapılmak İstendi");
            systemUsers.bookRoom(tesTarr[0]);


            hotel.printRoomStatus();
            System.out.println();
            System.out.println();
            systemUsers.cancelReservation(tesTarr[0]);

            hotel.printRoomStatus();
            System.out.println();
            System.out.println();
            System.out.println("Aynı oda tekrar cancel yapılmak istendi");
            systemUsers.cancelReservation(tesTarr[0]);

            systemUsers.printExitInfo();



            System.out.println("----------------------------------------------------------------------------------------");


            SystemUsers systemUsers2 = new Receptionist();
            systemUsers2.printConfirmation();

            hotel.printRoomStatus();
            System.out.println();
            System.out.println();
            hotel.receptionist.checkIn(tesTarr[1]);

            hotel.printRoomStatus();
            System.out.println();
            System.out.println();
            System.out.println("Aynı oda tekrar check-in yapılmak istendi");
            hotel.receptionist.checkIn(tesTarr[1]);

            hotel.printRoomStatus();
            System.out.println();
            System.out.println();
            System.out.println("Check-in yapılmış odada , cancel yapılmak istenirse");
            hotel.receptionist.cancelReservation(tesTarr[1]);

            hotel.printRoomStatus();
            System.out.println();
            System.out.println();
            hotel.receptionist.checkOut(tesTarr[1]);

            hotel.printRoomStatus();
            System.out.println();
            System.out.println();
            hotel.receptionist.bookRoom(tesTarr[1]);

            hotel.printRoomStatus();
            System.out.println();
            System.out.println();
            hotel.receptionist.cancelReservation(tesTarr[1]);
            hotel.printRoomStatus();

            hotel.writeFileRoomStatus();
            System.out.println("Kayıt Dosyasına Odalar ve Durumları Yazıldı");

            hotel.printRoomStatus();
            System.out.println();
            System.out.println();
            hotel.receptionist.cancelReservation(12); // exception fırtlattırmak için yazılmıştır
            hotel.printRoomStatus();

            systemUsers2.printExitInfo();
            System.exit(1);




        }
        catch(InputMismatchException e){
            System.out.println("Sayı beklenen yere, harf girdiniz");
        }
        catch(FileNotFoundException e){
            System.out.println("Kayıt dosyası bulunamadı");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("roomNumber'ı fazla girdiniz");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}

