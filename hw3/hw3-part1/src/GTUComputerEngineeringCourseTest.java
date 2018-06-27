import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GTUComputerEngineeringCourseTest {


    @org.junit.jupiter.api.Test
    void readCSV() throws IOException {
        System.out.println();
        System.out.println("-----------------------readCSV method testing-------------------------------------------");
        boolean flag=false;
        try {
            GTUComputerEngineeringCourse a=new GTUComputerEngineeringCourse();
            System.out.println("Yanlış bir dosya adı girildi.");
            a.readCSV("Courses(CSV)(Updated).csvv");

        }
        catch (Exception e){
            System.out.println("Exception fırlatıldı.");
            flag=true;
        }
        assertTrue(flag);

        try {
            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            System.out.println("Doğru dosya adı girildi.");
            assertEquals(true, a.readCSV("Courses(CSV)(Updated).csv"));
            System.out.println("Dosya başarıyla okundu.");
        }
        catch (Exception e){
            System.out.println("Exception fırlatıldı.");
            flag=true;
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }

    @org.junit.jupiter.api.Test
    void getByCode() {
        System.out.println();
        System.out.println("-----------------------getByCode method testing-----------------------------------------");
        boolean flag=false;
        try {
            GTUComputerEngineeringCourse a=new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");
            System.out.println("Yanlış bir course code girildi.");
            a.getByCode("YANLIS-DENEME");

        }
        catch (Exception e){
            System.out.println("Exception fırlatıldı.");
            flag=true;
        }
        assertTrue(flag);

        try {

            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");
            System.out.println("Doğru bir course code girildi.");
            assertEquals("Calculus I",a.getByCode("MATH 101").get(0).getTitle());
            System.out.println("Test başarıyla sonuçlandı");

        }
        catch (Exception e){
            System.out.println("Exception fırlatıldı.");
            flag=true;
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }

    @org.junit.jupiter.api.Test
    void listSemesterCourses() {
        System.out.println();
        System.out.println("-----------------------listSemesterCourses method testing-------------------------------");
        boolean flag=false;
        try {
            GTUComputerEngineeringCourse a=new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");
            System.out.println("Semester olarak 10 girildi");
            a.listSemesterCourses(10);

        }
        catch (Exception e){
            System.out.println("Exception fırlatıldı.");
            flag=true;
        }
        assertTrue(flag);

        try {

            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");

            System.out.println("Semester olarak 4 girildi.");
            assertEquals("Data Structures And Algorithms",a.listSemesterCourses(4).get(0).getTitle());
            assertEquals("Linearr Algebra and Differantial Equations",a.listSemesterCourses(4).get(1).getTitle());
            assertEquals("Logic Circuits And Design",a.listSemesterCourses(4).get(2).getTitle());
            assertEquals("Logic Circuits And Design Laboratory",a.listSemesterCourses(4).get(3).getTitle());
            assertEquals("Teknik Olmayan Se�meli (SSB)",a.listSemesterCourses(4).get(4).getTitle());
            assertEquals("Academic English",a.listSemesterCourses(4).get(5).getTitle());
            System.out.println("Test başarıyla sonuçlandı");


        }
        catch (Exception e){
            System.out.println("Exception fırlatıldı.");
            flag=true;
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }


    @org.junit.jupiter.api.Test
    void getByRange() {
        System.out.println();
        System.out.println("-----------------------getByRange method testing----------------------------------------");
        boolean flag=false;
        try {
            GTUComputerEngineeringCourse a=new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");
            System.out.println("Range 1-0 seçildi");
            a.getByRange(1,0);

        }
        catch (Exception e){
            System.out.println("Exception fırlatıldı.");
            flag=true;
        }
        assertTrue(flag);

        try {

            GTUComputerEngineeringCourse a = new GTUComputerEngineeringCourse();
            a.readCSV("Courses(CSV)(Updated).csv");

            System.out.println("Range 1-2 seçildi");

            assertEquals("Introduction To Computer Engineering",a.getByRange(1,2).get(0).getTitle());
            assertEquals("Introduction To Computer Science Laboratory",a.getByRange(1,2).get(1).getTitle());
            System.out.println("Test başarıyla sonuçlandı");

        }
        catch (Exception e){
            System.out.println("Exception fırlatıldı.");
            flag=true;
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }
}