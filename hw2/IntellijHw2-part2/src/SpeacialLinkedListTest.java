
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SpeacialLinkedListTest {

    @Test
    void disable() throws IOException {
        System.out.println("------------------DISABLE METHOD TESTING-----------------------------");
        boolean flag= false;
        try {
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");
            System.out.println("3.indexteki eleman disable edilecek");
            assertEquals(true, a.getCourseLinkedList().disable(3));
            System.out.println("Disabled elemanlar ekrana basılacak");
            a.printList(a.getCourseLinkedList().showDisabled());
            System.out.println("3.indexteki eleman başarıyla disable edildi");
            System.out.println("3.indexteki eleman tekrar disable edilmeye çalışılacak");
            assertEquals(false, a.getCourseLinkedList().disable(3));
            System.out.println("False return etti");
            System.out.println("Yanlış bir index disable edilmeye çalışılacak");
            a.getCourseLinkedList().disable(-1);
        }
        catch (Exception e){
            System.out.println(e);
            flag=true;
        }
        assertTrue(flag);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");

    }

    @Test
    void enable() {
        System.out.println("--------------------ENABLE METHOD TESTING-------------------------------");

        boolean flag= false;
        try {
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");
            System.out.println("3. ve 4.indexteki elemanlar disable edilecek");
            assertEquals(true, a.getCourseLinkedList().disable(3));
            assertEquals(true, a.getCourseLinkedList().disable(4));
            System.out.println("Disabled elemanlar ekrana basılacak");
            a.printList(a.getCourseLinkedList().showDisabled());
            System.out.println("3.indexteki eleman başarıyla disable edildi");
            System.out.println("4.indexteki eleman başarıyla disable edildi");

            System.out.println("3.indexteki eleman enable edilecek");
            assertEquals(true, a.getCourseLinkedList().enable(3));
            System.out.println("3.indexteki eleman başarıyla enable edildi");

            System.out.println("Disabled elemanlar ekrana basılacak");
            a.printList(a.getCourseLinkedList().showDisabled());

            System.out.println("3.indexteki eleman tekrar enable edilmeye çalışılacak");
            assertEquals(false, a.getCourseLinkedList().enable(3));
            System.out.println("False return etti");
            System.out.println("Olmayan bir indexteki eleman enable edilmye çalışılacak");
            assertEquals(false, a.getCourseLinkedList().enable(-1));
        }
        catch (Exception e){
            System.out.println(e);
            flag=true;
        }
        assertTrue(flag);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");

    }

    @Test
    void showDisabled() throws IOException {
        System.out.println("------------------SHOW DISABLED METHOD TESTING------------------------------");

        try {
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");
            System.out.println("3. ve 4.indexteki elemanlar disable edilecek");
            assertEquals(true, a.getCourseLinkedList().disable(3));
            assertEquals(true, a.getCourseLinkedList().disable(4));
            System.out.println("Disabled elemanlar ekrana basılacak");
            a.printList(a.getCourseLinkedList().showDisabled());
            System.out.println("3.indexteki eleman başarıyla disable edildi");
            System.out.println("4.indexteki eleman başarıyla disable edildi");

            System.out.println("3. ve 4. indexlerdeki elemanlar enable edilecek");
            assertEquals(true, a.getCourseLinkedList().enable(3));
            assertEquals(true, a.getCourseLinkedList().enable(4));
            System.out.println("3.indexteki eleman başarıyla enable edildi");
            System.out.println("4.indexteki eleman başarıyla enable edildi");
            System.out.println("Disabled elemanlar ekrana basılacak");
            a.printList(a.getCourseLinkedList().showDisabled());
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");

    }

    @Test
    void remove() {
        System.out.println("--------------------REMOVE0 METHOD TESTING---------------------------------");

        boolean flag=false;
        try{
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");
            System.out.println("-------------NORMAL LİSTE------------");
            a.printList(a.getCourseLinkedList());
            System.out.println("-------------------------------------");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Listede parametresiz remove işlemi yapılır");
            a.getCourseLinkedList().remove();
            System.out.println("Listenin ilk elemanı disable edilir");
            a.getCourseLinkedList().disable(0);
            System.out.println("Tekrar parametresiz remove işlemi denenir");
            a.getCourseLinkedList().remove();

        }
        catch (Exception e){
            System.out.println(e);
            flag=true;
        }
        assertTrue(flag);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");

    }

    @Test
    void remove1() {
        System.out.println("----------------------REMOVE1 METHOD TESTING-----------------------------");

        boolean flag=false;
        try{
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");
            System.out.println("-------------NORMAL LİSTE------------");
            a.printList(a.getCourseLinkedList());
            System.out.println("-------------------------------------");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Listede index alan remove işlemi 1. index için yapılır");
            a.getCourseLinkedList().remove(1);
            System.out.println("Listenin 2.indexindeki elemanı disable edilir");
            a.getCourseLinkedList().disable(2);
            System.out.println("Tekrar index alan remove işlemi 2. index için yapılmya çalışılır");
            a.getCourseLinkedList().remove(2);

        }
        catch (Exception e){
            System.out.println(e);
            flag=true;
        }
        assertTrue(flag);
         flag=false;
        try{
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");

            System.out.println("Listenin -1. indexi remove methoduna gönderilir");
            a.getCourseLinkedList().remove(-1);

        }
        catch (Exception e){
            System.out.println(e);
            flag=true;
        }
        assertTrue(flag);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");

    }

    @Test
    void get() {
        System.out.println("-----------------------GET METHOD TESTING--------------------------------");

        boolean flag=false;
        try{
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");
            System.out.println("-------------NORMAL LİSTE------------");
            a.printList(a.getCourseLinkedList());
            System.out.println("-------------------------------------");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Listenin 1. indexi get ile alınır");
            Course course1 =new Course();
            course1=a.getCourseLinkedList().get(1);
            System.out.println("Listenin 1. indexi get ile başarıyla alındı");


            System.out.println("Listenin 2.indexindeki elemanı disable edilir");
            a.getCourseLinkedList().disable(2);

            System.out.println("Listenin 2. indexi get ile alınmaya çalışılır");
            Course course2 =new Course();
            course2=a.getCourseLinkedList().get(2);

        }
        catch (Exception e){
            System.out.println(e);
            flag=true;
        }
        assertTrue(flag);

        flag=false;
        try{
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");
            System.out.println("Listenin -1. indexi get edilmeye çalışılır");
            Course course1 =new Course();
            course1=a.getCourseLinkedList().get(-1);
        }
        catch (Exception e){
            System.out.println(e);
            flag=true;
        }
        assertTrue(flag);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");

    }

    @Test
    void set() {
        System.out.println("-------------------SET METHOD TESTING----------------------------");

        boolean flag=false;
        try{
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");
            System.out.println("Listenin 1. indexine Course objesi set edilir");
            Course course1 =new Course();
            course1=a.getCourseLinkedList().set(1,new Course());
            System.out.println("Listenin 1. indexine başarıyla set işlemi yapıldı");


            System.out.println("Listenin 2.indexindeki elemanı disable edilir");
            a.getCourseLinkedList().disable(2);

            System.out.println("Listenin 2. indexine Course objesi set edilmeye çalışıldı");
            Course course2 =new Course();
            course2=a.getCourseLinkedList().set(2,new Course());

        }
        catch (Exception e){
            System.out.println(e);
            flag=true;
        }
        assertTrue(flag);

        flag=false;
        try{
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");
            System.out.println("Listenin -1. indexine Course objesi set edilir");
            Course course1 =new Course();
            course1=a.getCourseLinkedList().set(-1,new Course());
        }
        catch (Exception e){
            System.out.println(e);
            flag=true;
        }
        assertTrue(flag);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");

    }

    @Test
    void size() throws IOException {
        System.out.println("-------------------SIZE METHOD TESTING--------------------------------");

        try {
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");
            System.out.println("-------------NORMAL LİSTE------------");
            a.printList(a.getCourseLinkedList());
            System.out.println("-------------------------------------");
            System.out.println("-------------------------------------------------------------------");
            int eskiSize=a.getCourseLinkedList().size();
            System.out.println("Listenin başlangıçtaki size'ı : " + eskiSize);
            System.out.println("Listeden 5,6,7 ve 8. indexlerdeki elemanlar disable edilecek ");
            a.getCourseLinkedList().disable(5);
            a.getCourseLinkedList().disable(6);
            a.getCourseLinkedList().disable(7);
            a.getCourseLinkedList().disable(8);
            System.out.println("Yeni size'ın 4 azalması gerekmektedir ");
            System.out.println("Yeni size = "+a.getCourseLinkedList().size() );
            assertEquals(eskiSize-4,a.getCourseLinkedList().size());
        }
        catch (Exception e){
           System.out.println(e);
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");

    }

    @Test
    void listIterator() {
        System.out.println("-------------------LISTITERATOR METHOD TESTING----------------------------");

        boolean flag=false;
        try{
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");
            System.out.println("Listenin 1. indexi listIterator methoduna gönderilir");
            a.getCourseLinkedList().listIterator(1);
            System.out.println("Method başarıyla çalıştı");


            System.out.println("Listenin 2. indexindeki elemanı disable edilir");
            a.getCourseLinkedList().disable(2);

            System.out.println("Listenin 2. indexi listIterator methoduna gönderilir");
            a.getCourseLinkedList().listIterator(2);
        }
        catch (Exception e){
            System.out.println(e);
            flag=true;
        }
        assertTrue(flag);

        flag=false;
        try{
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");

            System.out.println("Listenin -1. indexi listIterator methoduna gönderilir");
            a.getCourseLinkedList().listIterator(-1);

        }
        catch (Exception e){
            System.out.println(e);
            flag=true;
        }
        assertTrue(flag);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------");

    }

}