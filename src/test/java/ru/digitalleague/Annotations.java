package ru.digitalleague;

import org.junit.After;
import org.junit.Before;
import ru.digitalleague.storage_example.Storage;

public class Annotations {
    @Before
    public void setUp(){
        Storage.addObject("phone", 2);
        Storage.addObject("laptop", 6);
    }
    @After
    public void setUp2() {
        Storage.storage.clear();
    }
}
