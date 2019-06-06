package com.check24.task.test;

import com.check24.task.model.Advertisement;
import com.check24.task.model.BidRanking;
import com.check24.task.service.AuctionManager;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AuctionManagerTest {

    private AuctionManager auctionManager;

    @Before
    public void initTest() {
        auctionManager = new AuctionManager();
    }

    @Test
    public void checckIfAuctionIsCreatedProperly() {
        assertEquals(BidRanking.RANK_BY_BID, auctionManager.getBidRanking());
        assertNotNull(auctionManager.getAuctionDataHolder());
        assertNotNull(auctionManager.getAuctionDataHolder().getAuction());
        assertNotNull(auctionManager.getAuctionDataHolder().getAuction().getAdvertisements());
    }

    @Test
    public void searchAlgorithmByBidTest() {
        List<Advertisement> adList = auctionManager.searchThroughAdsAndReturnResults("car");
        assertEquals(3, adList.size());
        assertEquals(10, (int)adList.get(0).getPricePerClick());
        assertEquals(20, (int)adList.get(1).getPricePerClick());
        assertEquals(30, (int)adList.get(2).getPricePerClick());
        List<Advertisement> adList2 = auctionManager.searchThroughAdsAndReturnResults("flower");
        assertEquals(1, adList2.size());
        assertEquals(10, (int)adList2.get(0).getPricePerClick());
        List<Advertisement> adList3 = auctionManager.searchThroughAdsAndReturnResults("toy");
        assertEquals(2, adList3.size());
        assertEquals(20, (int)adList3.get(0).getPricePerClick());
        assertEquals(30, (int)adList3.get(1).getPricePerClick());
    }

    @Test
    public void changeAlgorithmTest() {
        auctionManager.setBidRanking(BidRanking.RANK_BY_REVENUE);
        assertEquals(BidRanking.RANK_BY_REVENUE, auctionManager.getBidRanking());
    }

    @Test
    public void searchAlgorithmByRevenueTest() {
        auctionManager.setBidRanking(BidRanking.RANK_BY_REVENUE);
        List<Advertisement> adList = auctionManager.searchThroughAdsAndReturnResults("car");
        assertNotNull(adList);
        assertEquals(3, adList.size());
        assertEquals(500, (int)adList.get(0).getRevenue());
        assertEquals(700, (int)adList.get(1).getRevenue());
        assertEquals(900, (int)adList.get(2).getRevenue());
        List<Advertisement> adList2 = auctionManager.searchThroughAdsAndReturnResults("flower");
        assertNotNull(adList2);
        assertEquals(1, adList2.size());
        assertEquals(500, (int)adList2.get(0).getRevenue());
        List<Advertisement> adList3 = auctionManager.searchThroughAdsAndReturnResults("toy");
        assertNotNull(adList3);
        assertEquals(2, adList3.size());
        assertEquals(700, (int)adList3.get(0).getRevenue());
        assertEquals(900, (int)adList3.get(1).getRevenue());
    }

    @Test
    public void noResultFoundTest() {
        List<Advertisement> adList = auctionManager.searchThroughAdsAndReturnResults("ferrari");
        assertNull(adList);
    }


}
