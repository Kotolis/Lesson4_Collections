package ru.digitalleague;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.digitalleague.storage_example.Storage;

import static org.junit.Assert.assertFalse;

public class AddObject {
    @Before
    public void setUp(){
        Storage.addObject("phone", 2);
        Storage.addObject("laptop", 6);
    }
    @After
    public void setUp2(){
        Storage.storage.clear();
    }
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
    public void addNewObject_negTest() {
        Storage.addObject("headphones", 8);
        Assert.assertTrue(Storage.isInStock("headphones"));
        Assert.assertEquals(9, Storage.getProductAmount("headphones"));
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
    public void addMaxAmount_negTest() {
        Storage.addObject("headphones", 7);
        Storage.addObject("headphones", 5);
        Assert.assertEquals(7, Storage.getProductAmount("headphones"));
    }

    @Test
    public void addNull_negTest() {
        Storage.addObject(null,6);
        Assert.assertFalse(Storage.isInStock(null));
    }

    @Test
    public void addWithMaxSizeTest() {
        Storage.addObject("headphones", 7);
        Storage.addObject("tablet", 8);
        Assert.assertFalse(Storage.isInStock("tablet"));
    }







}

