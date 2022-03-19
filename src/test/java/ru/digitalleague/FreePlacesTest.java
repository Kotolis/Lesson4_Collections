package ru.digitalleague;

import org.junit.Assert;
import org.junit.Test;
import ru.digitalleague.storage_example.Storage;

public class FreePlacesTest extends Annotations {

    /**
     * Тест проверки наличия свободных полок на складе
     */
    @Test
    public void getFreePlacesTest(){
        int count = Storage.getFreePlaces();
        Assert.assertEquals(1, count);
    }

    /**
     * Тест проверки наличии свободных полок при заполненном складе
     */
    @Test
    public void getFreePlacesWithMaxSizeTest(){
        Storage.addObject("headphones", 9);
        int count = Storage.getFreePlaces();
        Assert.assertEquals(0, count);
    }

    /**
     * Тест проверки наличия свободных полок при пустом складе
     */
    @Test
    public void getFreePlacesWithEmpty() {
        Storage.storage.clear();
        int count = Storage.getFreePlaces();
        Assert.assertEquals(3, count);
    }





}
