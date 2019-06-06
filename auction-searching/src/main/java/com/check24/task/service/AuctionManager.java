package com.check24.task.service;

import com.check24.task.datastorage.AuctionDataHolder;
import com.check24.task.model.Advertisement;
import com.check24.task.model.BidRanking;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AuctionManager {

    private AuctionDataHolder auctionDataHolder;
    private BidRanking bidRanking = BidRanking.RANK_BY_BID;

    public AuctionManager() {
        auctionDataHolder = new AuctionDataHolder();
        auctionDataHolder.generateAuction();
        createAuctionAndFillWithAds();
    }

    private void createAuctionAndFillWithAds() {
        generateAds();
        sortTheAdsByAlgorithm();
    }

    private void generateAds() {
        AdvertisementManager advertisementManager = new AdvertisementManager();
        Advertisement advertisement1 = advertisementManager.generateAdvertisement("advertisement1", "description1",
                "hyperlink1", 10, 500);
        advertisement1.getKeywords().addAll(Stream.of("candy", "flower", "car", "software").collect(Collectors.toList()));
        Advertisement advertisement2 = advertisementManager.generateAdvertisement("advertisement2", "description2",
                "hyperlink1", 30, 700);
        advertisement2.getKeywords().addAll(Stream.of("chocolate", "toy", "car", "software").collect(Collectors.toList()));
        Advertisement advertisement3 = advertisementManager.generateAdvertisement("advertisement3", "description3",
                "hyperlink1", 20, 900);
        advertisement3.getKeywords().addAll(Stream.of("chocolate", "toy", "car", "software").collect(Collectors.toList()));
        auctionDataHolder.getAuction().getAdvertisements().addAll(Stream.of(advertisement1, advertisement2, advertisement3).collect(Collectors.toList()));
    }

    public void sortTheAdsByAlgorithm() {
        if (bidRanking.equals(BidRanking.RANK_BY_BID)) {
            auctionDataHolder.getAuction().getAdvertisements().sort(Comparator.comparingInt(Advertisement::getPricePerClick));
        } else if (bidRanking.equals(BidRanking.RANK_BY_REVENUE)) {
            auctionDataHolder.getAuction().getAdvertisements().sort(Comparator.comparingInt(Advertisement::getRevenue));
        }
    }

    public List<Advertisement> searchThroughAdsAndReturnResults(String keyWord) {
        if (auctionDataHolder.getAuction().getAdvertisements().stream().anyMatch(item -> item.getKeywords().contains(keyWord))) {
            return auctionDataHolder.getAuction().getAdvertisements().stream().filter(item -> item.getKeywords().contains(keyWord)).collect(Collectors.toList());
        }
        return null;
    }

    public BidRanking getBidRanking() {
        return bidRanking;
    }

    public void setBidRanking(BidRanking bidRanking) {
        this.bidRanking = bidRanking;
        sortTheAdsByAlgorithm();
    }

    public AuctionDataHolder getAuctionDataHolder() {
        return auctionDataHolder;
    }
}
