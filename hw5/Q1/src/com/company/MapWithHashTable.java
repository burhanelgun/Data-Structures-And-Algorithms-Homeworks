package com.company;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Map interface i, bir open adressing hash table kullanilarak implement edilmistir.Ayrica collisions lar double hashing ile cozulur.
 */
public class MapWithHashTable implements Map
{
    /**
     * Map hucrelerinden(entry,cell) olusmus bir hashTable dir.
     */
    MapCell[] hashTable;
    /**
     * hashTable in en fazla eleman bulundurabilcek size ini tutar
     */
    int capacity;
    /**
     * hashTable icersinde bulunan key, value pairlerinin sayisini tutar
     */
    int elementsSize;

    /**
     * Gelen capacitye gore bir hash table olusturulur ve tum elemanlar null ie isaretlenir
     * @param capacity alinan capacitye gore bir hash map olusturulur
     */
    MapWithHashTable(int capacity) {
        this.capacity=capacity;
        hashTable = new MapCell[capacity];
        for(int i=0;i<capacity;i++){
            hashTable[i]=null;
        }
    }

    /**
     *
     * @return hashTable in o anki icerdigi eleman sayisini return eder.
     */
    @Override
    public int size() {
        return elementsSize;
    }

    /**
     * hashTable in bos olup olmadigi bilgisini verir.
     * @return eger hasTable hic bir eleman icermiyorsa true,en az bir eleman icerisiyorsa false retun eder.
     */
    @Override
    public boolean isEmpty() {
        return elementsSize == 0;
    }

    /**
     *  bir keyin hash tale da olup olmadigi bilgisini verir
     * @param o key alir
     * @return alinan key eger hash table da bulunuyorsa true, eger bulunmuyorsa false return edilir.
     */
    @Override
    public boolean containsKey(Object o) {
        return get(o)!=null && (!get(o).equals(new String("Deleted")) && !get(o).equals(-99) );
    }

    @Override
    public boolean containsValue(Object o) {
        return false;
    }

    /**
     * hashing yaparken collisionu azaltmak icin capacity e en yakin prime numberi return eden methodtur.
     * @return capaciity e en yakin prime numberi return eder.
     */
    public int getPrime()
    {
        for (int i = capacity - 1; i >= 1; i--)
        {
            int fact = 0;
            for (int j = 2; j <= (int) Math.sqrt(i); j++)
                if (i % j == 0)
                    fact++;
            if (fact == 0)
                return i;
        }
        return 5;
    }

    /**
     *gelen obje icin hash value uretir
     * @param x hashValuesi uretilmek istenen objedir
     * @return parametre olarak gelen objenin hashvaluesini return ederc
     */
    private int hashcode1(Object x )
    {
        int hashVal = x.hashCode( );
        hashVal %= capacity;
        if (hashVal < 0){
            hashVal += capacity;
        }
        return hashVal;
    }
    /**
     *gelen key objesi icin hash value uretir
     * @param x hashValuesi uretilmek istenen objedir
     * @return parametre olarak gelen objenin hashvaluesini return eder
     */
    private int hashcode2(Object x )
    {
        int hashVal = x.hashCode( );
        hashVal %= capacity;
        if (hashVal < 0){
            hashVal += capacity;
        }
        return getPrime() - hashVal % getPrime();
    }

    /**
     * Hashtable i print eder key ve value ile birlikte bu key valueniin hangi indexte oldugunu ekrana basar
     */
    public void printHashTable()
    {
        System.out.println("\nHash Table");
        for (int i = 0; i < capacity; i++)
            if (hashTable[i] != null){
                System.out.println("hasTable["+i+"]="+hashTable[i].getKey() +" , "+hashTable[i].getValue());
            }
            else{
                System.out.println("hasTable["+i+"]=null");

            }
    }

    /**
     * gelen key objesinin valuesi varsa return eder.
     * @param o key objesidir
     * @return gelen key objesinin valuesi return edilir
     */
    @Override
    public Object get(Object o) {
        int hash1 = hashcode1( o );
        int hash2 = hashcode2( o );

        while (hashTable[hash1]!=null && (Integer)hashTable[hash1].getKey()!=-99 && !hashTable[hash1].getKey().equals((Integer) o))
        {
            hash1 += hash2;
            hash1 %= capacity;
        }
        if(hashTable[hash1]!=null){
            return hashTable[hash1].getValue();
        }
        else {
            System.out.println("Boyle bir key bulunamamaktadir");

            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * map e yeni bir pair eklenemek icin kullanilan methodtur
     * @param o key degeridir
     * @param o2 value degeridir
     * @return eger pair put edildiyse , o pairin kendisi return edilir
     */
    @Override
    public Object put(Object o, Object o2) {
        if (elementsSize == capacity)
        {
            System.out.println("Table full");
            return null;
        }
        int hash1 = hashcode1(o );
        int hash2 = hashcode2( o );
        while (hashTable[hash1] != null && (Integer)hashTable[hash1].getKey()!=-99)
        {
            hash1 += hash2;
            hash1 %= capacity;
        }
        hashTable[hash1] = new MapCell( o, o2);
        elementsSize++;
        return  hashTable[hash1];
    }

    /**
     * Map ten bir key silinmek istendigindekullanilan fonksiyondur
     * @param o key degeridir
     * @return silinen pairin kendisini return eder.
     */
    @Override
    public Object remove(Object o) {
        int hash1 = hashcode1( o  );
        int hash2 = hashcode2( o );
        while (hashTable[hash1] != null && !hashTable[hash1].getKey().equals((Integer)o))
        {
            hash1 += hash2;
            hash1 %= capacity;
        }
        if( hashTable[hash1].getKey() instanceof String){
            hashTable[hash1].setKey("Deleted");
        }
        else if(hashTable[hash1].getKey() instanceof Integer){
            hashTable[hash1].setKey(-99);

        }
        if( hashTable[hash1].getValue() instanceof String){
            hashTable[hash1].setValue("Deleted");
        }
        else if(hashTable[hash1].getValue() instanceof Integer){
            hashTable[hash1].setValue(-99);

        }
        elementsSize--;
        return  hashTable[hash1];
    }

    @Override
    public void putAll(Map map) {

    }

    /**
     * tum map i silmek icin kullanilan methodtur.
     */
    @Override
    public void clear() {
        elementsSize = 0;
        for (int i = 0; i < capacity; i++){
            hashTable[i] = null;
        }
    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
