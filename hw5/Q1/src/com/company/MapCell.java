package com.company;

/**
 * Bir map entry sini(map cell) temsil eden classtir
 * @param <E> generic tiptedir
 */
public class MapCell<E> {
    /**
     * Map pairlerinden key i tutar
     */
    private E key;
    /**
     * Map pairlerinden value yu tutar
     */
    private E value;

    /**
     * Constuructordur
     * @param key key alir ve kendi keyine atar
     * @param value value alir ve kendi value suna atar
     */
    MapCell(E key, E value) {
        this.key = key;
        this.value = value;
    }

    /**
     * getter key
     * @return key
     */
    public E getKey() {
        return key;
    }

    /**
     * setter key
     * @param key key
     */
    public void setKey(E key) {
        this.key = key;
    }

    /**
     * setter value
     * @param value value
     */
    public void setValue(E value) {
        this.value = value;
    }

    /**
     * getter value
     * @return value
     */
    public E getValue() {
        return value;
    }
}
