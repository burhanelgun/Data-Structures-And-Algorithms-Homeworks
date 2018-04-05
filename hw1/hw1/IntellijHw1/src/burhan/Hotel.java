package burhan;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Bir otelin içinde bulunan nesneleri ve operasyonları barındırır.
 */
public class Hotel {
    /**
     * rooms arrayi Room lardan olusur.Icerisinde Room objelerini tutan bir arraydir,composition kullanilmistir.
     */
    static protected Room [] rooms;
    /**
     * receptiontist data memberi Receptionist tipindedir ve Hotel has a Receptionist ilkesini saglar, composition kullanilmistir
     */
    static protected Receptionist receptionist;
    /**
     * numberOfRoom , oteldeki oda sayisini tutar
     */
    static protected int numberOfRoom;
    /**
     * numberOfBookedRoom, oteldeki rezerve oda sayisini tutar
     */
    static protected int numberOfBookedRoom;
    /**
     * checkedRoom, oteldeki check-in yapilmis oda sayisini tutar

     */
    static protected int checkedRoom;

    /**
     * Hotel classinin constructoru dur ve icinde Room objelerinden olusan array olusturulur ve Receptionist objesi olusturulur.
     */
    Hotel(){
        numberOfRoom=9;
        rooms = new Room[numberOfRoom];
        for(int i=0;i<numberOfRoom;i++){
            rooms[i]=new Room();
        }
        receptionist = new Receptionist();
    }

    Hotel(int n){
        numberOfRoom=n;
        rooms = new Room[numberOfRoom];
        for(int i=0;i<numberOfRoom;i++){
            rooms[i]=new Room();
        }
        receptionist = new Receptionist();
    }


    /**
     * Receptionistin veya hotel guest inin bilgilendirilmesi icin oda numaralarini, odalarin book, check in, check out durumlarini ve bu islemin
     * kim tarafindan yapildigini ekrana basar
     */
    public void printRoomStatus(){
        System.out.println("---------------------- ROOMS --------------------------");
        System.out.printf("ID -    BOOK    - Check IN/OUT");
        int i=0;
        for (i=0;i<numberOfRoom; i++){
            if (this.rooms[i].receptionistID != 0 || this.rooms[i].guestName != null){
                System.out.println(" - NAME/ID ");
                break;
            }
        }
        if(i==numberOfRoom){
            System.out.println();
        }
        for(int counter = 0; counter<numberOfRoom; counter++) {
            System.out.print(this.rooms[counter].roomID + "  - ");
            if (this.rooms[counter].isBooked == true) {
                System.out.print("  BOOKED   - ");
            } else {
                System.out.print("NOT BOOKED - ");
            }
            if (this.rooms[counter].isChecked == true) {
                System.out.print("  CHECKED");
            } else {
                System.out.print("NOT CHECKED");
            }
            if (this.rooms[counter].receptionistID == 0 && this.rooms[counter].guestName == null) {
                System.out.println();
            }
            if (this.rooms[counter].receptionistID != 0 || this.rooms[counter].guestName != null){

                if (this.rooms[counter].receptionistID == 0) {
                    System.out.println("  - " + rooms[counter].guestName);

                } else {
                    System.out.println("  - " + rooms[counter].receptionistID);
                }
            }

        }
        System.out.println("-------------------------------------------------------");

    }

    /**
     * Hotel guesti veya receptionist ten biri odalarla alakali bir islem yapip isini bitirdiginde en son programdan cikarken bu method calistirilir
     * ve o anki odalarin durumlari , odalarin kimler tarafindan isleme tutuldugu ve oda numaralari room arrayinden okunarak dosyaya yazilir.
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public void writeFileRoomStatus() throws FileNotFoundException,UnsupportedEncodingException{
        PrintWriter writer = new PrintWriter("record.csv", "UTF-8");
        for(int i = 0; i<this.numberOfRoom; i++){
            if(this.rooms[i].isBooked==true){
                writer.print(this.rooms[i].roomID + ",booked");
            }
            else{
                writer.print(this.rooms[i].roomID + ",unbooked");
            }
            if(this.rooms[i].isChecked==true){
                writer.print(",checked");
            }
            else{
                writer.print(",unchecked");
            }
            if(this.rooms[i].receptionistID>0){
                writer.print(","+this.rooms[i].receptionistID);
            }
            else if(this.rooms[i].guestName!=null){
                writer.print(","+this.rooms[i].guestName);
            }
            else {
                writer.print(",-");

            }
            writer.println();
        }
        writer.close();
        this.printRoomStatus();
    }

    /**
     * En basta program calisirken kayit dosyasi olmayabilir .Bu yuzden bu method her ihtimale karsi yeni bir dosya acip icine
     * odalarin bilgisini giren methoddur.
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public void beginARecordFile() throws FileNotFoundException,UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("record.csv", "UTF-8");
        for (int i = 0; i < this.numberOfRoom; i++) {
                writer.print(i+1);
                writer.print(",unbooked");
                writer.print(",unchecked");
                writer.print(",-");
                writer.println();
        }
        writer.close();
    }

    /**
     * Verilen path teki dosyadan gerekli olan bilgilerini okur ve onlari Room objelerinden olusmus array elemanlarinin data memberlerina atar.
     */
    public void readRoomStatusFromFile(){
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader("record.csv"))) {

            int counter = 0 ;
            while ((line = br.readLine())!=null && line.length()!=0) {


                String[] country = line.split(cvsSplitBy);

                this.rooms[counter].roomID=Integer.parseInt(country[0]);

                if(country[1].equals(new String("unbooked"))){
                    this.rooms[counter].isBooked=false;
                }
                if(country[1].equals(new String("booked"))){
                    this.rooms[counter].isBooked=true;
                }

                if(country[2].equals(new String("unchecked"))){
                    this.rooms[counter].isChecked=false;
                }
                if(country[2].equals(new String("checked"))){
                    this.rooms[counter].isChecked=true;
                }

                if(!country[3].equals(new String("-"))) {
                    if (this.rooms[counter].receptionistID == 0) {
                        this.rooms[counter].guestName = country[3];
                    } else {
                        this.rooms[counter].receptionistID = Integer.parseInt(country[3]);
                    }
                }
                counter++;
            }
            this.printRoomStatus();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sistem kullanicisina Receptionist mi yoksa Hotel Gust mi oldugunu sorar
     * @return eger kullanici Guest ise 1, Receptionist ise 2 return edilir.
     */
    public int askUserType() throws InputMismatchException{
        int n=0;
        while(n!=1 && n!=2 ) {
            System.out.printf("Guest Enter : 1\nReceptionist Enter : 2\n");
            Scanner reader = new Scanner(System.in);
            n = reader.nextInt();
            if(n!=1 && n!=2){
                System.out.printf("Yanlış Giriş Yaptınız Tekrar Deneyiniz\n");
            }
        }
        System.out.println("Kullanıcı tipi soruldu");
        return n;
    }

    /**
     * Hotel guest kullanicisina operasyon tipini sorar yani kullanicidan input alir
     * @return  Book icin 1, Cancel Reservation icin 2 , Exit icin 3 return edilir.
     */
    public int askHotelGuestOperationType() throws InputMismatchException{
        int n=0;
        while(n!=1 && n!=2 && n!=3){
            Scanner reader = new Scanner(System.in);
            System.out.printf("Book Enter : 1\nCancel Reservation : 2\nExit Enter : 3\n");
            n = reader.nextInt();
            if(n!=1 && n!=2 && n!=3){
                System.out.printf("Yanlış Giriş Yaptınız Tekrar Deneyiniz\n");
            }
        }
        System.out.println("Hotel guest ten operasyon tipi alındı");
        return n;
    }

    /**
     * Receptionist kullanicisina operasyon tipini sorar yani kulanicidan input alir.
     * @return Check-in icin 1, Check-out icin 2, Book icin 3, Cancel Reservation icin 4, Exit icin 5 return edilir.
     */
    public int askReceptionistOperationType() throws InputMismatchException{
        int n=0;
        while(n!=1 && n!=2 && n!=3 && n!=4 && n!=5) {
            Scanner reader = new Scanner(System.in);
            System.out.printf("Check-in : 1\nCheck-out : 2\nBook Enter : 3\nCancel Reservation : 4\nExit : 5\n");
            n = reader.nextInt();
            if(n!=1 && n!=2 && n!=3 && n!=4 && n!=5){
                System.out.printf("Yanlış Giriş Yaptınız Tekrar Deneyiniz\n");
            }
        }
        System.out.println("Receptionist ten operasyon tipi alındı");
        return n;
    }


    /**
     * Sistem kullanicisina sectigi operasyonu hangi odada yapacagini sormak icin input alir.
     * @return girilen oda id si return edilir
     */
    public int askUserRoomID() throws InputMismatchException{
        int k=0;
        while(k>numberOfRoom || k<1) {
            Scanner reader = new Scanner(System.in);
            System.out.printf("Enter room id : ");
            k = reader.nextInt();
            if(k>numberOfRoom || k<1){
                System.out.printf("Yanlış Giriş Yaptınız Tekrar Deneyiniz\n");
            }
        }
        k--;
        System.out.println("Hotel guest tarafından room id si girildi ");
        return k;
    }

    /**
     * Bir oteldeki bir odayi temsil eder.
     */
    protected class Room{
        /**
         * isBooked boolean datamemberi odanin Book edilip edilmedigi bilgisini tutar
         */
        protected boolean isBooked;
        /**
         * isChecked boolean datamemberi odanin Check-in edilip edilmedigi bilgisini tutar
         */
        protected boolean isChecked;
        /**
         *roomID integer datamemberi odanin id sini tutar
         */
        protected int roomID;
        /**
         * receptionistID integer datamemberi odayi book yada check in yapan Receptionist in id sini tutar
         */
        protected int receptionistID = 0;
        /**
         * guestName string datamemberi odayi book yapan guestin adini tutar
         */
        protected String guestName;
    }
}
