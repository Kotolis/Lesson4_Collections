package ru.digitalleague;


import org.junit.Assert;
import org.junit.Test;
import ru.digitalleague.storage_example.Storage;



public class AddObjectTest extends Annotations {


    @Test
    public void isInStockTest_posTest() {
        Storage.addObject("headphones", 5);
        Assert.assertTrue(Storage.isInStock("headphones"));
    }

    @Test
    public void isInStockTest_negTest() {
        Storage.addObject("headphones", 7);
        Assert.assertFalse(Storage.isInStock("apple"));
    }

    @Test
    public void addNewObject_posTest() {
        Storage.addObject("headphones", 8);
        Assert.assertTrue(Storage.isInStock("headphones"));
        Assert.assertEquals(8, Storage.getProductAmount("headphones"));
    }


    @Test
    public void addWithNegativeAmountTest() {
        Storage.addObject("headphones", -1);
        Assert.assertFalse(Storage.isInStock("headphones"));
    }

    @Test
    public void addWrongAmount_negTest() {
        Storage.addObject("headphones", 11);
        Assert.assertFalse(Storage.isInStock("headphones"));
    }

    @Test
    public void addMaxAmount_posTest(){
        Storage.addObject("headphones", 7);
        Storage.addObject("headphones", 3);
        Assert.assertEquals(10, Storage.getProductAmount("headphones"));
    }


    @Test
    public void addNull_negTest() {
        Storage.addObject(null,6);
        Assert.assertFalse(Storage.isInStock(null));
    }

    @Test
    public void addWithMaxSize_negTest() {
        Storage.addObject("headphones", 7);
        Storage.addObject("tablet", 8);
        Assert.assertFalse(Storage.isInStock("tablet"));
    }







}

