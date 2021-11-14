package com.example.Guy.Service;

import com.example.Guy.Dao.Model.Campaign;
import com.example.Guy.Dao.Model.Product;
import com.example.Guy.Exceptions.ExistsException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OnlineAdsServiceImpl implements OnlineAdsService{

    HashMap<String, Campaign> campaignHashMap = new HashMap<>(); // Hash between campaign id to campaign object

    @Resource(name = "loadProductsFromJson")
    HashMap<Integer, Product> productHashMap = new HashMap<>(); // Hash between product id to product object
    @Override
    public Campaign createCampaign(Campaign campaign) {
        Campaign camp = new Campaign(campaign.getCampaignName(), campaign.getProductsId(),campaign.getStartDate(),campaign.getBid());
        if(!campaignHashMap.containsKey(campaign.getCampaignName())){
            return campaignHashMap.put(campaign.getCampaignName(),camp);
        }
            throw new ExistsException();
    }

    @Override
    public Product serverAd(String category) {

        Product p = Collections.max(productHashMap.values().stream().filter(x -> category.equals(x.getCategory())).collect(Collectors.toList()), Comparator.comparing(Product::getPrice));
        if(ObjectUtils.isEmpty(p))  return Collections.max(productHashMap.values(), Comparator.comparing(Product::getPrice));
            return p;
    }

    @Override
    public List<Campaign> getAllActiveCampaigns() {
        return campaignHashMap.values().stream().filter(x->addDaysForDate(x.getStartDate(),10).before(new Date())).collect(Collectors.toList());
    }

    public Date addDaysForDate(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

}
