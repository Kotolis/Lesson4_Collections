package ru.digitalleague;


import org.junit.Assert;
import org.junit.Test;
import ru.digitalleague.storage_example.Storage;



public class AddObjectTest extends Annotations {

    /**
     * Тест поиска существующего товара на складе
     */
    @Test
    public void isInStockTest_posTest() {
        Storage.addObject("headphones", 5);
        Assert.assertTrue(Storage.isInStock("headphones"));
    }


    /**
     * Тест поиска не существующего товара на складе
     */
    @Test
    public void isInStockTest_negTest() {
        Storage.addObject("headphones", 7);
        Assert.assertFalse(Storage.isInStock("apple"));
    }


    /**
     * Тест проверки добавления товара с верным наименованием  и количеством
     */
    @Test
    public void addNewObject_posTest() {
        Storage.addObject("headphones", 8);
        Assert.assertTrue(Storage.isInStock("headphones"));
        Assert.assertEquals(8, Storage.getProductAmount("headphones"));
    }


    /**
     * Тест проверки добавления товара с отрицательным количеством
     */
    @Test
    public void addWithNegativeAmountTest() {
        Storage.addObject("headphones", -1);
        Assert.assertFalse(Storage.isInStock("headphones"));
    }


    /**
     * Тест проверки добавления товара с нулевым количеством
     */
    @Test
    public void addWithZeroAmountTest() {
        Storage.addObject("headphones", 0);
        Assert.assertFalse(Storage.isInStock("headphones"));

    }


    /**
     * Тест проверки добавления товара с невалидным количеством
     */
    @Test
    public void addWrongAmount_negTest() {
        Storage.addObject("headphones", 11);
        Assert.assertFalse(Storage.isInStock("headphones"));
    }


    /**
     * Тест проверки добавления товара с не валидным наименованием
     */
    @Test
    public void addNull_negTest() {
        Storage.addObject(null,6);
        Assert.assertFalse(Storage.isInStock(null));
    }

    /**
     * Тест проверки добавления товара при максимально заполненном складе
     */

    @Test
    public void addWithMaxSize_negTest() {
        Storage.addObject("headphones", 7);
        Storage.addObject("tablet", 8);
        Assert.assertFalse(Storage.isInStock("tablet"));
    }



}

