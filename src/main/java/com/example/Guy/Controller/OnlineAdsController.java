package com.example.Guy.Controller;

import com.example.Guy.Dao.Model.Campaign;
import com.example.Guy.Dao.Model.Product;
import com.example.Guy.Service.OnlineAdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/onlineAds")
public class OnlineAdsController {

    @Autowired
    OnlineAdsService onlineAdsService;//

    @RequestMapping(method = RequestMethod.POST, value = "/createCampaign")
    public Campaign createCampaign(@RequestBody  Campaign campaign){
        return onlineAdsService.createCampaign(campaign);
    }

    @RequestMapping(method = RequestMethod.GET , value = "/serveAd")
    public Product serverAd(String category){
        return onlineAdsService.serverAd(category);

    }@RequestMapping(method = RequestMethod.GET , value = "/getAllActiveCampaigns")
    public List<Campaign> getAllActiveCampaigns(){
        return onlineAdsService.getAllActiveCampaigns();
    }



}
