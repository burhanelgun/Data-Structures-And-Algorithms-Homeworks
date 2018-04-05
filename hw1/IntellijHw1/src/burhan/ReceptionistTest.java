package burhan;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceptionistTest {



    @Test
    void bookRoom() throws Exception {
        System.out.println("*********************************BOOK ROOM UNIT TEST******************************************");

        int[] testArr={2,3,101}; // 0. index iki defa book yapılmak istenen odanın numarasıdır, 1.index hem check hem book yapılmak istenen odanın numarasıdır,
        //2. index olmayan bir odanın numarasıdır

        HotelGuest a = new HotelGuest();
        Hotel b = new Hotel();
        System.out.println("Kayıt Dosyasından Odalar ve Durumları Okundu");
        b.readRoomStatusFromFile();
        Receptionist c= new Receptionist();
        assertEquals(true,a.bookRoom(testArr[0]));// 2. odaya book yapılıyor true döndürmeli
        b.printRoomStatus();

        System.out.println(testArr[0]+1+". odaya tekrar book yapılmak istendi");
        assertEquals(false,a.bookRoom(testArr[0])); // 2. odaya tekrar book yapılmak isteniyor false döndürmeli
        b.printRoomStatus();


        try {
            a.bookRoom(testArr[2]-1); //oda sayısından fazla bir sayı gönderiliyor ve exception fırlatmalıdır
            System.out.println("roomNumber olarak  oda sayısından fazla bir değer girildi");

        } catch (Exception e) {
            System.out.println(""+e);
            assertTrue(true);
        }

        c.checkIn(testArr[1]); //3. odaya checkin yapılıyor
        b.printRoomStatus();


        System.out.println(testArr[1]+1+". odaya book yapılmak istendi");

        assertEquals(false,a.bookRoom(testArr[1])); //3. odaya book yapılmak istenirsa false döndürmeli çünkü zaten check in yapılmıştır
        b.printRoomStatus();



    }


    @Test
    void checkIn() throws Exception {
        System.out.println("**************************CHECK IN UNIT TEST*********************************************");

        int[] testArr={2,3,101}; // 0. index iki defa check in yapılmak istenen odanın numarasıdır, 1.index hem book hem check in yapılmak istenen odanın numarasıdır,
        //2. index olmayan bir odanın numarasıdır

        HotelGuest a = new HotelGuest();
        Hotel b = new Hotel();
        Receptionist c= new Receptionist();
        System.out.println("Kayıt Dosyasından Odalar ve Durumları Okundu");
        b.readRoomStatusFromFile();
        assertEquals(true,c.checkIn(testArr[0]));
        b.printRoomStatus();

        System.out.println(testArr[0]+1+". odaya tekrar check in yapılmak istendi");
        assertEquals(false,c.checkIn(testArr[0]));
        b.printRoomStatus();


        try {
            c.checkIn(testArr[2]-1);
            System.out.println("roomNumber olarak  oda sayısından fazla bir değer girildi");
        } catch (Exception e) {
            System.out.println(""+e);
            assertTrue(true);
        }

        c.bookRoom(testArr[1]); //3. odaya book yapılıyor
        b.printRoomStatus();


        System.out.println(testArr[1]+1+". odaya book yapılmak istendi");


        assertEquals(true,c.checkIn(testArr[1])); //3. odaya book yapılmak istenirsa false döndürmeli çünkü zaten check in yapılmıştır
        b.printRoomStatus();


    }


    @Test
    void checkOut()throws Exception {
        System.out.println("*********************************CHECK OUT UNIT TEST******************************************");

        int[] testArr={2,101}; // 0. index iki defa check out yapılmak istenen odanın numarasıdır,2. index olmayan bir odanın numarasıdır

        HotelGuest a = new HotelGuest();
        Hotel b = new Hotel();
        System.out.println("Kayıt Dosyasından Odalar ve Durumları Okundu");
        b.readRoomStatusFromFile();
        Receptionist c= new Receptionist();
        assertEquals(true,c.checkIn(testArr[0]));
        b.printRoomStatus();
        assertEquals(true,c.checkOut(testArr[0]));
        b.printRoomStatus();
        System.out.println(testArr[0]+1+". odaya tekrar check out yapılmak istendi");
        assertEquals(false,c.checkOut(testArr[0]));
        b.printRoomStatus();


        try {
            c.checkOut(testArr[1]-1);
            System.out.println("roomNumber olarak  oda sayısından fazla bir değer girildi");

        } catch (Exception e) {
            System.out.println(""+e);
            assertTrue(true);
        }


    }

}