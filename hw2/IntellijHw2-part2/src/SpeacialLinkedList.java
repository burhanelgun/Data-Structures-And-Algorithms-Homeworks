
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * LinkedListten extend olmuştur ve içinde temel olarak enable disable showDisabled methodları ek olarak implement edilmiştir.
 * Ayrıca remove , get ,set ,size,listIterator override edilip yeniden implement edilmiştir
 * @param <E> generic bir classtır
 */
public class SpeacialLinkedList<E> extends LinkedList<E> {
    /**
     * disabled olan elemanların indexlerini tutar
     */
    private LinkedList<Integer> disabledItemsIndexes = new LinkedList<Integer>();

    /**
     *
     * Bir enabled eleman disabled edilmek isteniyorsa bu methoda indexi gönderilir ve o elamanın indexi disabledItemsIndexes adlı linked liste atılır
     * @param index disabled edilmek istenen elemanın indexidir
     * @return eğer istenilen eleman disabled edilebildiyse true return edilir, eğer edilemediyse false return edilir
     * @throws IndexOutOfBoundsException eğer index size dan falza ise exception fırlatılır
     */
    public boolean disable(int index) throws IndexOutOfBoundsException{
        if(index<0 || index>=super.size()){//index kontrolü yapılır
            throw new IndexOutOfBoundsException("Böyle bir index yok");
        }
        for(int i = 0; i<disabledItemsIndexes.size();i++){ //zaten disabled edilmişse false return edilir
            if(disabledItemsIndexes.get(i)==index){
                return false;
            }
        }
        disabledItemsIndexes.add(index);  // disabled edilmek istenen elemanın indexi disableItemsIndexes linked listine eklenir
        return true;
    }

    /**
     * Bir disabled eleman enabled edilmek isteniyorsa bu methoda indexi gönderilir ve o elamanın indexi disabledItemsIndexes adlı linked listten remove edilir
     * @param index enabled edilmek istenen elemanın indexidir
     * @return eğer istenilen eleman enabled edilebildiyse true return edilir, eğer edilemediyse false return edilir.
     */
    public boolean enable(int index){
        if(index<0 || index>=this.size()){  // index kontrolü yapılır
            throw new IndexOutOfBoundsException("Böyle bir index yok");
        }
        for(int i = 0;i<disabledItemsIndexes.size();i++){ // eğer bir index disabled listesinde yer alıyorsa onu ordan remove ederiz ve artık enabled olmuştur
            if(disabledItemsIndexes.get(i)==index){
                disabledItemsIndexes.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Disabled olan elemanları bir link liste toplar
     * @return disabled olan elamnaları bir linked liste atar ve o linked listi return eder.
     */
   public LinkedList<E> showDisabled(){
        LinkedList disabledItems = new LinkedList();
        for(int i=0;i<disabledItemsIndexes.size();i++){  // tüm disabled elemnalar bir linkedlistte topanır
            disabledItems.add(super.get(disabledItemsIndexes.get(i)));
        }
        return disabledItems;
    }

    /**
     * alınan linked listi print eder
     * @param b linked list alır ve onu print eder
     */
    public void printList(LinkedList b) {

        for (int i = 0; i < b.size(); i++) { // linked list print edilir
            System.out.println(b.get(i));
        }
    }

    /**
     * Listenin başındaki elemanı remove eder ama disabled olup olmadığını kontrol eder
     * @return super in removeu return edilir.
     * @throws RuntimeException eğer disabled edilmiş bir eleman remove edilmek istenirsa exception fırlatılır
     */
    @Override
    public E remove() throws RuntimeException{
        for(int i = 0;i<disabledItemsIndexes.size();i++){  // eğer başlangıçtaki eleman disabled değilse remove edilir
            if(disabledItemsIndexes.get(i)==0){
                throw new RuntimeException("Listenin başındaki eleman disable olduğu için remove işlemi yapılamamaktadır.");
            }
        }
        return super.remove();
    }

    /**
     * Listenin j. elemanı remove eder ama disabled olup olmadığını kontrol eder
     * @param j remove edilmek istenen elemanın indexidir
     * @return super in remove methodu return edilir
     * @throws RuntimeException yanlış bir index veya disabled bir index verilirse exception fırlatılır
     */
    @Override
    public E remove(int j) throws RuntimeException {
        if(j<0 || j>=this.size()){ // index kontrolü
            throw new IndexOutOfBoundsException("Böyle bir index yok");
        }
        for(int i = 0;i<disabledItemsIndexes.size();i++){ // eğer j. indexteki eleman disabled değilse remove ediir
            if(disabledItemsIndexes.get(i)==j){
                throw new RuntimeException(j+". index teki eleman disable olduğu için remove işlemi yapılamadı");
            }
        }
        return super.remove(j);
    }

    /**
     * Bir obje alır ve onu liste içinde arar eğer disabled değilse o obje remove edilir
     * @param o remove edilmek istenen objedir
     * @return super ın remove u  return edilir
     * @throws RuntimeException yanlış bir index veya disabled bir index verilirse exception fırlatılır
     */
    @Override
    public boolean remove(Object o)throws RuntimeException {
        int index=-1;
        for(int i = 0;i<super.size();i++){
            if(o.equals(super.get(i))){
                index=i;
                for(int k = 0;k<disabledItemsIndexes.size();k++){ // eğer o objesi nin bulunduğu index i disabled değilse o objesi remove edilir
                    if(disabledItemsIndexes.get(k)==index){
                        throw new RuntimeException(index+". index te bulunan obje disable olduğu için remove işlemi yapılamadı");
                    }
                }
            }
        }
        return super.remove(o);
    }

    /**
     * Bir index alır ve o indexteki elemanı eğer disabled değilse return eder
     * @param j return edilmesini istenen elemanın indexidir
     * @return super in get i çağırılır
     * @throws RuntimeException yanlış bir index veya disabled bir index verilirse exception fırlatılır
     */
    @Override
    public E get(int j) throws RuntimeException{
        if(j<0 || j>=this.size()){// index kontrolü
            throw new IndexOutOfBoundsException("Böyle bir index yok");
        }
        for(int i = 0;i<disabledItemsIndexes.size();i++){ // eğer get edilmek istenen index disabled değilse get edilir
            if(disabledItemsIndexes.get(i)==j){
                throw new RuntimeException(j+". index teki eleman disable olduğu için get işlemi yapılamadı");
            }
        }
        return super.get(j);
    }

    /**
     * Bir index ve bir eleman alır ve o index eğer disabled değilse set işlemi yapılır
     * @param j set edilmek istenen indextir
     * @param e set edilmek istenen elemandır
     * @return super in set i çağırılır
     * @throws RuntimeException yanlış bir index veya disabled bir index verilirse exception fırlatılır
     */
    @Override
    public E set(int j, E e) throws RuntimeException {
        if(j<0 || j>=this.size()){  // index kontrolü
            throw new IndexOutOfBoundsException("Böyle bir index yok");
        }
        for(int i = 0;i<disabledItemsIndexes.size();i++){  // eğer set edilmek istenen elemanın ,set edilmek istendiği yerde bir disabled eleman yoksa set edilir
            if(disabledItemsIndexes.get(i)==j){
                throw new RuntimeException(j+". index teki eleman disable olduğu için set işlemi yapılamadı");
            }
        }
        return super.set(j, e);
    }

    /**
     * LinkedListin size ını return eder fakat disabled itemleri saymaz
     * @return linked listin enable elemanlarının size ını return eder
     */
    @Override
    public int size() {
        int size = super.size()-disabledItemsIndexes.size(); //disabled elemanların size ı normal size dan çıkartılır venormal size return edilir
        return size;
    }

    /**
     * ALınan parametreye göre başlangıç bir listIterator olusturulur fakat alınan parametredeki elemanın disable olmaması gereklidir
     * @param j  listiteratorun başlangıçı için seçilen indextir
     * @return super ın listiterator u return edilir
     * @throws RuntimeException yanlış bir index veya disabled bir index verilirse exception fırlatılır

     */
    @Override
    public ListIterator<E> listIterator(int j) throws RuntimeException {
        if(j<0 || j>=this.size()){  // index kontrolü
            throw new IndexOutOfBoundsException("Böyle bir index yok");
        }
        for(int i = 0;i<disabledItemsIndexes.size();i++){ // eğer parametre olarak gelen index disabled değilse listıterator oluşturulur.
            if(disabledItemsIndexes.get(i)==j){
                throw new RuntimeException(j+". index teki eleman disable olduğu için listIterator işlemi yapılamadı");
            }
        }
        return super.listIterator(j);
    }
}