package com.example.Guy.Service;

import com.example.Guy.Dao.Model.Campaign;
import com.example.Guy.Dao.Model.Product;

import java.util.List;

public interface OnlineAdsService {

    Campaign createCampaign(Campaign campaign);
    Product serverAd(String category);
    List<Campaign> getAllActiveCampaigns();
}
