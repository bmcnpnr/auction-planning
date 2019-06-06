package com.check24.task.datastorage;

import com.check24.task.model.Auction;

public class AuctionDataHolder {
    private Auction auction;

    public void generateAuction() {
        this.auction = new Auction();
    }

    public Auction getAuction() {
        return auction;
    }
}
