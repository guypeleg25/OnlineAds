package com.example.Guy.Dao.Model;https://github.com/guypeleg25/OnlineAds/blob/master/src/main/java/com/example/Guy/Dao/Model/Campaign.java

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Campaign implements Serializable {

    String campaignName;
    List<Integer> productsId;
    @JsonFormat(startDate=JsonFormat.Date.STRING, pattern="dd-MM-yyyy")
    Date startDate;
    Long bid;

}
