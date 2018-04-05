
import java.io.IOException;
import java.util.LinkedList;

public class main {

    public static void printList(LinkedList b) {

        for (int i = 0; i < b.size(); i++) {
            System.out.println(b.get(i));
        }
    }
    public static void main(String[] args) throws IOException {

        try {
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();

            System.out.println("LinkedList in içi dosyadan okunan verilerle dolduruldu");


            a.readCSV("Courses(CSV)(Updated).csv");


            System.out.println("-------------NORMAL LİSTE------------");
            a.printList(a.getCourseLinkedList());
            System.out.println("-------------------------------------");
            System.out.println("-------------------------------------------------------------------");

            System.out.println("Hiçbir disable eleman yokken size : " + a.getCourseLinkedList().size());

            System.out.println("0 , 1 ve 2. indexler disable edilir ");

            a.getCourseLinkedList().disable(0);
            a.getCourseLinkedList().disable(1);
            a.getCourseLinkedList().disable(2);

            System.out.println("-------------showDisabled methodunun return değeri ekrana basılır------------------");
            a.printList(a.getCourseLinkedList().showDisabled());
            System.out.println("-----------------------------------------------------------------------------------");


            System.out.println("3 adet disable eleman varken size : " + a.getCourseLinkedList().size());

            System.out.println("Disable olan 0. indexi remove etmek istersek");
            a.getCourseLinkedList().remove(0);

        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("-------------------------------------------------------------------");
        }
        try {
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();

            System.out.println("LinkedList in içi dosyadan okunan verilerle dolduruldu");


            a.readCSV("Courses(CSV)(Updated).csv");


            System.out.println("0 , 1 ve 2. indexler disable edilir ");

            a.getCourseLinkedList().disable(0);
            a.getCourseLinkedList().disable(1);
            a.getCourseLinkedList().disable(2);


            System.out.println("Disable olan 1. indexe Course set etmek istersek");
            a.getCourseLinkedList().set(1,new Course());

        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("-------------------------------------------------------------------");

        }
        try {
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();

            System.out.println("LinkedList in içi dosyadan okunan verilerle dolduruldu");


            a.readCSV("Courses(CSV)(Updated).csv");

            System.out.println("0 , 1 ve 2. indexler disable edilir ");

            a.getCourseLinkedList().disable(0);
            a.getCourseLinkedList().disable(1);
            a.getCourseLinkedList().disable(2);


            System.out.println("Disable olan 2. indexi get etmek istersek");
            a.getCourseLinkedList().get(2);

        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("-------------------------------------------------------------------");

        }
        try {
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();

            System.out.println("LinkedList in içi dosyadan okunan verilerle dolduruldu");


            a.readCSV("Courses(CSV)(Updated).csv");

            System.out.println("0 , 1 ve 2. indexler disable edilir ");

            a.getCourseLinkedList().disable(0);
            a.getCourseLinkedList().disable(1);
            a.getCourseLinkedList().disable(2);


            System.out.println("Disable olan 2. indexte listIterator çalıştırmak istersek etmek istersek");
            a.getCourseLinkedList().listIterator(2);

        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("-------------------------------------------------------------------");

        }
        try {
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();

            System.out.println("LinkedList in içi dosyadan okunan verilerle doldurulduu");


            a.readCSV("Courses(CSV)(Updated).csv");

            System.out.println("-------------NORMAL LİSTE------------");
            a.printList(a.getCourseLinkedList());
            System.out.println("-------------------------------------");
            System.out.println("-------------------------------------------------------------------");

            System.out.println("0 , 1 ve 2. indexler disable edilir ");

            a.getCourseLinkedList().disable(0);
            a.getCourseLinkedList().disable(1);
            a.getCourseLinkedList().disable(2);

            System.out.println("-------------showDisabled methodunun return değeri ekrana basılır------------------");
            a.printList(a.getCourseLinkedList().showDisabled());
            System.out.println("-----------------------------------------------------------------------------------");


            a.getCourseLinkedList().enable(1);

            System.out.println("1. indexteki eleman enable edilir. ");

            System.out.println("-------------showDisabled methodunun return değeri ekrana basılır------------------");
            a.printList(a.getCourseLinkedList().showDisabled());
            System.out.println("-----------------------------------------------------------------------------------");


        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("-------------------------------------------------------------------");
        }

    }
}
