package ru.digitalleague;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.digitalleague.storage_example.Storage;

import static org.junit.Assert.assertFalse;

public class AddExistObjectTest extends Annotations{

    /**
     * Тест проверки добавления существующего товара
     */
    @Test
    public void addExistObject_posTest(){
        Storage.addObject("phone", 5);
        Assert.assertEquals(7, Storage.getProductAmount("phone"));
    }

    /**
     * Тест проверки добавления существующего товара с максимальным валидным количеством с помощью частичного добавления
     */
    @Test
    public void addMaxAmount_posTest(){
        Storage.addObject("headphones", 7);
        Storage.addObject("headphones", 3);
        Assert.assertEquals(10, Storage.getProductAmount("headphones"));
    }

    /**
     * Тест проверки добавления существующего товара с невалидным количеством с помощью частичного добавления
     */
    @Test
    public void addMaxAmount_negTest() {
        Storage.addObject("headphones", 7);
        Storage.addObject("headphones", 5);
        Assert.assertEquals(7, Storage.getProductAmount("headphones"));
    }

    /**
     * Тест проверки добавления существующего товара с отрицательным количеством элементов
     */
    @Test
    public void addExistWithNegative_negTest() {
        Storage.addObject("headphones", 6);
        Storage.addObject("headphones", -3);
        Assert.assertEquals(6, Storage.getProductAmount("headphones"));
    }


}
