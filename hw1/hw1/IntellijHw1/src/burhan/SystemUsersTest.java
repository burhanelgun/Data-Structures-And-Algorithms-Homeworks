package burhan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SystemUsersTest {

    @Test
    void cancelReservation() throws Exception {
        System.out.println("*********************************CANCEL UNIT TEST******************************************");

        int[] testArr = {2, 3, 101}; // 0. index iki defa cancel yapılmak istenen odanın numarasıdır, 1.index hem check in hem cancel yapılmak istenen odanın numarasıdır,
        //2. index olmayan bir odanın numarasıdır

        HotelGuest a = new HotelGuest();
        Hotel b = new Hotel();
        Receptionist c = new Receptionist();
        System.out.println("Kayıt Dosyasından Odalar ve Durumları Okundu");
        b.readRoomStatusFromFile();
        assertEquals(true, a.bookRoom(testArr[0]));
        b.printRoomStatus();
        assertEquals(true, a.cancelReservation(testArr[0]));
        b.printRoomStatus();
        System.out.println(testArr[0] + 1 + ". odaya tekrar cancel yapılmak istendi");
        assertEquals(false, a.cancelReservation(testArr[0]));
        b.printRoomStatus();

        try {
            System.out.println("roomNumber olarak  oda sayısından fazla bir değer girildi");
            a.cancelReservation(testArr[2]);

        } catch (Exception e) {
            System.out.println("" + e);
            assertTrue(true);
        }

        c.checkIn(testArr[1]);
        b.printRoomStatus();
        System.out.println(testArr[1]+1+". oda check in yapılmasına rağmen cancel yapılmaya çalışıldı");
        assertEquals(false, a.cancelReservation(testArr[1]));
        b.printRoomStatus();
    }

    @Test
    void bookRoom() throws Exception {
        System.out.println("*********************************BOOK ROOM UNIT TEST******************************************");

        int[] testArr = {2, 3, 101}; // 0. index iki defa book yapılmak istenen odanın numarasıdır, 1.index hem check hem book yapılmak istenen odanın numarasıdır,
        //2. index olmayan bir odanın numarasıdır

        HotelGuest a = new HotelGuest();
        Hotel b = new Hotel();
        System.out.println("Kayıt Dosyasından Odalar ve Durumları Okundu");
        b.readRoomStatusFromFile();
        Receptionist c = new Receptionist();
        assertEquals(true, a.bookRoom(testArr[0]));// 2. odaya book yapılıyor true döndürmeli
        b.printRoomStatus();

        System.out.println(testArr[0] + 1 + ". odaya tekrar book yapılmak istendi");
        assertEquals(false, a.bookRoom(testArr[0])); // 2. odaya tekrar book yapılmak isteniyor false döndürmeli
        b.printRoomStatus();


        try {
            a.bookRoom(testArr[2] - 1); //oda sayısından fazla bir sayı gönderiliyor ve exception fırlatmalıdır
            System.out.println("roomNumber olarak  oda sayısından fazla bir değer girildi");

        } catch (Exception e) {
            System.out.println("" + e);
            assertTrue(true);
        }

        c.checkIn(testArr[1]); //3. odaya checkin yapılıyor
        b.printRoomStatus();


        System.out.println(testArr[1] + 1 + ". odaya book yapılmak istendi");

        assertEquals(false, a.bookRoom(testArr[1])); //3. odaya book yapılmak istenirsa false döndürmeli çünkü zaten check in yapılmıştır
        b.printRoomStatus();

    }
}