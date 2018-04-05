import java.io.IOException;

public class main {
    public static void main(String[] args) throws Exception {
        try {
            GTUComputerEngineeringCourse a=new GTUComputerEngineeringCourse();

            System.out.println("LinkedList in içi dosyadan okunan verilerle dolduruldu");
            a.readCSV("Courses(CSV)(Updated).csv");

            System.out.println("Dosyanın içindeki veriler ekrana bastırılacak");
            a.printList();
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println();

            System.out.println("XXX XXX kodundaki dersler ekrana bastırılacak");
            a.printList(a.getByCode("XXX XXX"));
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println();

            System.out.println("8. Semesterdeki dersler ekrana bastırılacak");
            a.printList(a.listSemesterCourses(8));
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println();

            System.out.println("1.İndexten 5.İndexe kadar olan dersler ekrana bastırılacak");
            a.printList(a.getByRange(1,5));
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println();

        }
        catch (Exception e){
            System.out.println(e);
        }


        try{
            GTUComputerEngineeringCourse a=new GTUComputerEngineeringCourse();
            System.out.println("getByCode methoduna olmayan bir ders kodu gönderildi");
            a.printList(a.getByCode("DENEME"));
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println();
        }

        catch (Exception e){
            System.out.println(e);
        }

        try{
            GTUComputerEngineeringCourse a=new GTUComputerEngineeringCourse();
            System.out.println("listSemesterCourses methoduna 10. semester gönderildi");
            a.printList(a.listSemesterCourses(10));
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println();
        }

        catch (Exception e){
            System.out.println(e);
        }

        try{
            GTUComputerEngineeringCourse a=new GTUComputerEngineeringCourse();
            System.out.println("90 ile 95. indexler getByRange methoduna gönderildi");
            a.printList(a.getByRange(1,5));
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println();
        }

        catch (Exception e){
            System.out.println(e);
        }


    }
}


