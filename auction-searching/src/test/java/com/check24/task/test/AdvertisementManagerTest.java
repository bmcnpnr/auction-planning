package com.check24.task.test;

import com.check24.task.model.Advertisement;
import com.check24.task.service.AdvertisementManager;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class AdvertisementManagerTest {
    private AdvertisementManager advertisementManager;

    @Before
    public void initTest() {
        advertisementManager = new AdvertisementManager();
    }

    @Test
    public void testAdvertisementGeneration() {
        Advertisement advertisement = advertisementManager.generateAdvertisement("test1", "testDesc1",
                "testLink1", 5, 10);
        assertNotNull(advertisement);
        assertEquals("test1", advertisement.getTitle());
        assertEquals("testDesc1", advertisement.getDescription());
        assertEquals("testLink1", advertisement.getHyperLink());
    }

    @Test
    public void testIdGeneration() {
        Advertisement advertisement = advertisementManager.generateAdvertisement("test1", "testDesc1",
                "testLink1", 5, 10);
        assertEquals(0, (int)advertisement.getAdvertisementId());
        Advertisement advertisement2 = advertisementManager.generateAdvertisement("test1", "testDesc1",
                "testLink1", 5, 10);
        assertEquals(1, (int)advertisement2.getAdvertisementId());
        new HashSet<>().addAll(new Integer[]{});
        Stream.
    }

}
