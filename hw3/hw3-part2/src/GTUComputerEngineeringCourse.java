import java.io.*;
import java.util.LinkedList;

/**
 * Linked list üzerinde yapılacak operasyonların methodlarını içeren bir classtır.
 * Bu operasyonlar temel olarak getByCode(),listSemesterCourses(),getByRange() dir.
 * Ayrıca bu operasyonların yapıldı courseLinkedList adınaki LinkedListi de data field olarak tutar.
 *
 */

public class GTUComputerEngineeringCourse {
    /**
     * Bu data field Course lardan oluşan bir LinkedList'i tutar.
     */
    private SpeacialLinkedList<Course> courseLinkedList = new SpeacialLinkedList<>();

    /**
     *
     * @return courseLinkedList return edilir
     */
    public SpeacialLinkedList<Course>  getCourseLinkedList(){
        return  courseLinkedList;
    }
    /**
     *
     * @param fileName Course hakkındaki bilgilerin alındığı dosya adıdır.
     * @return eğer dosya başarılı bir şekilde açıldıysa ture return edilir, açılmadıysa false return edilir
     * @throws IOException
     */
    public boolean readCSV(String fileName) throws IOException {
        File f = new File(fileName);   // dosya açılır
        if (!(f.exists() && !f.isDirectory())) {  // dosya açılmazsa exception fırlatılır
            throw new FileNotFoundException();
        }
        String line;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        int counter = 0;

        while ((line = br.readLine()) != null) {   // son satıra kadar her bir satırdaki dersin özellikleri
            //bir course objesine ardından temp e atılır
            Course temp = new Course();
            if (counter == 0) {
                counter++;
            } else {
                String[] column = line.split(";");

                temp.setSemester(Integer.parseInt(column[0]));
                temp.setCode(column[1]);
                temp.setTitle(column[2]);
                temp.setEctsCredits(Integer.parseInt(column[3]));
                temp.setGtuCredits(Integer.parseInt(column[4]));
                temp.setHTL(column[5]);

                courseLinkedList.add(temp);
            }
        }
        return true;
    }

    /**
     * Ekrana course lardan oluşan listeyi print etmek için kullanılan methodtur
     */
    public void printList() {
        System.out.println("Semester - Course Code - Course Title -             ECTS Credits - GTU Credits - H-T-L");
        for (int i = 0; i < courseLinkedList.size(); i++) {   //her bir course un özelliği ekrana yazdırılır
            Course a = courseLinkedList.get(i);
            System.out.println(a.getSemester() + "          " + a.getCode() + "      " + a.getTitle() + "   " + a.getEctsCredits() + "   " + a.getGtuCredits() + "   " + a.getHTL());
        }
    }

    /**
     * Parametre olarak aldığı listeyi ekrana basar
     * @param b ekrana bastırılmak istenen listedir
     */
    public void printList(LinkedList<Course> b) {
        System.out.println("Semester - Course Code - Course Title -             ECTS Credits - GTU Credits - H-T-L");
        for (int i = 0; i < b.size(); i++) { //her bir course un özelliği ekrana yazdırılır
            Course a = b.get(i);
            System.out.println(a.getSemester() + "          " + a.getCode() + "      " + a.getTitle() + "   " + a.getEctsCredits() + "   " + a.getGtuCredits() + "   " + a.getHTL());
        }
    }

    /**
     * Bir ders kodu alır ve eğer o ders koduna sahip bir Course objesi yada objeleri varsa bu objeler bir LinkedListe atılır
     * ardından bu LinkedList return edilir
     * @param code ders kodudur
     * @return eğer o kodun karşılığı bir ders varsa o ders bir linked liste atılır ve o linked list return edilir
     * @throws Exception eğer ders kodu bulunamadıysa exception fırlatılır
     */
    public LinkedList<Course> getByCode(String code) throws Exception {
        LinkedList<Course> a = new LinkedList<Course>();
        for (int i = 0; i < courseLinkedList.size(); i++) {   // linkedlist içinde gezilir ve aynı koda sahip olanlar bir linkedlistte toplanır
            if (code.equals(courseLinkedList.get(i).getCode())) {
                a.add(courseLinkedList.get(i));
            }
        }
        if (a.size() == 0) {
            throw new Exception("Cannot found " + code + " course code\n");
        }
        return a;
    }

    /**
     * Parametre olarak alınan semester daki tüm Course objeleri bulunur ve başka birLinkedliste atılıp o LinkedList return edilir
     * @param semester akademik eğitim dönemidir
     * @return parametre olarak alınan semesterdeki tüm Course objeleri bir LinkedListe atılır ve o linked list return edilir
     * @throws Exception eğer olmayan bir semester girilirse exception fırlatılır
     */
    public LinkedList<Course> listSemesterCourses(int semester) throws Exception {
        LinkedList<Course> a = new LinkedList<Course>();
        for (int i = 0; i < courseLinkedList.size(); i++) {// aynı semesterdeki course lar tespit edilip bir linkedliste atılır
            if (semester == courseLinkedList.get(i).getSemester()) {
                a.add(courseLinkedList.get(i));
            }
        }
        if (a.size() == 0) {
            throw new Exception("Cannot found any course in " + semester + ". semester\n");
        }
        return a;
    }

    /**
     * Başlangıç ve bitiş indexi alır ve bu indexler arasındaki Course objelerini başka bir LinkedListe atar ve
     * ardından bu LinkedListi return eder.
     * @param start_index başlangıç indexidir
     * @param last_index bitiş indexidir
     * @return başlangıç indexi ile bitş indexi arasındaki elemanları bir LinkedListe atar ve o linkedListi return eder.
     * @throws Exception eğer indexlar yaynlış girilirse Exception fırlatılır
     */
    public LinkedList<Course> getByRange(int start_index, int last_index) throws Exception {
        LinkedList<Course> a = new LinkedList<Course>();

        if (start_index < 0 || last_index > courseLinkedList.size()) {
            throw new Exception("Out of index");
        }

        for (int i = start_index; i <= last_index; i++) { // iki index arasındaki elemanlar linkedliste atılır
            a.add(courseLinkedList.get(i));

        }
        if (a.size() == 0) {
            throw new Exception("Cannot found any course from " + start_index + ". index to " + last_index + ". index.");
        }
        return a;
    }

}






