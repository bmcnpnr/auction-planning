package com.check24.task.service;

import com.check24.task.model.Advertisement;

import java.util.concurrent.atomic.AtomicInteger;

public class AdvertisementManager {
    private AtomicInteger advertisementCounter = new AtomicInteger(0);

    public Advertisement generateAdvertisement(String title, String description, String hyperLink, Integer pricePerClick, Integer revenue) {
        Advertisement advertisement = new Advertisement(title, description, hyperLink);
        advertisement.setAdvertisementId(advertisementCounter.getAndIncrement());
        advertisement.setPricePerClick(pricePerClick);
        advertisement.setRevenue(revenue);
        return advertisement;
    }
}
