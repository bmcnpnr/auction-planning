package com.check24.task.controller;

import com.check24.task.model.Advertisement;
import com.check24.task.model.BidRanking;
import com.check24.task.service.AuctionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class SearchAds {

    @Autowired
    private AuctionManager auctionManager;

    @RequestMapping("/searchAds")
    public String searchAds(@RequestParam(value = "searchKeyword") String searchKeyword) {
        List<Advertisement> advertisements = auctionManager.searchThroughAdsAndReturnResults(searchKeyword);
        if (advertisements != null && !advertisements.isEmpty()) {
            Collections.reverse(advertisements);
            StringBuilder adTitles = new StringBuilder();
            advertisements.forEach( item -> adTitles.append(item.getTitle()).append("<br/>"));
            return adTitles.toString();
        }

        return "No result is found";
    }

    @RequestMapping("/changeBidAlgorithm")
    public String changeBidAlgorithm() {
        if (auctionManager.getBidRanking().equals(BidRanking.RANK_BY_BID)) {
            auctionManager.setBidRanking(BidRanking.RANK_BY_REVENUE);
        } else {
            auctionManager.setBidRanking(BidRanking.RANK_BY_BID);
        }
        return "Algorithm is changed!";
    }
}
