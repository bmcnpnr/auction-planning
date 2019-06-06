package com.check24.task.test;

import com.check24.task.datastorage.AuctionDataHolder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class AuctionDataHolderTest {
    private AuctionDataHolder dataholder;
    @Before
    public void initTest() {
        dataholder = new AuctionDataHolder();
    }

    @Test
    public void testAuctionIsNotGeneratedBeforehand() {
        assertNull(dataholder.getAuction());
    }

    @Test
    public void testAuctionGeneration() {
        dataholder.generateAuction();
        assertNotNull(dataholder.getAuction());
    }
}
