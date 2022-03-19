package ru.digitalleague;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import ru.digitalleague.storage_example.Storage;

public class RemoveObjectTest extends Annotations{

    /**
     * Тест проверки удаления существующего товара со склада
     */
    @Test
    public void removeObject_posTest(){
        Storage.removeObject("laptop");
        Assert.assertFalse(Storage.isInStock("laptop"));
    }

    /**
     * Тест проверки удаления со склада не существующего товара
     */
    @Test
    public void removeNotFound_negTest(){
        Assert.assertFalse(Storage.removeObject("apple"));
    }


    /**
     * Тест проверки удаления товара со склада с не валидным наименованием
     */
    @Test
    public void removeNullTest(){
        Storage.addObject(null, 6);
        Storage.removeObject(null);
        Assert.assertFalse(Storage.isInStock(null));

    }

    /**
     * Тест проверки удаления всех товаров со склада
     */
    @Test
    public void removeAll_posTest(){
        Storage.removeObject("phone");
        Storage.removeObject("laptop");
        Assert.assertTrue(Storage.storage.isEmpty());
    }

    /**
     * Тест проверки повторного удаления товара с пустого склада
     */
    @Test
    public void removeAll_negTest(){
        Storage.removeObject("phone");
        Storage.removeObject("laptop");
        Assert.assertFalse(Storage.removeObject("laptop"));
    }

    /**
     * Тест проверки получения количества не существующего товара
     */
    @Test
    public void getRemoveAmountTest(){
        Storage.removeObject("phone");
        Storage.removeObject("laptop");
        Assert.assertEquals(0, Storage.getProductAmount("laptop"));
    }


}
