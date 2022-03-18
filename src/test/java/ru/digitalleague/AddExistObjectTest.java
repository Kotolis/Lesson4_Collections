package ru.digitalleague;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.digitalleague.storage_example.Storage;

import static org.junit.Assert.assertFalse;

public class AddExistObjectTest extends Annotations{


    @Test
    public void addExistObject_posTest(){
        Storage.addObject("phone", 5);
        Assert.assertEquals(7, Storage.getProductAmount("phone"));
    }

    @Test
    public void addMaxAmount_negTest() {
        Storage.addObject("headphones", 7);
        Storage.addObject("headphones", 5);
        Assert.assertEquals(7, Storage.getProductAmount("headphones"));
    }


}
