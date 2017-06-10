package com.mit.law.controller.firebase;

import com.mit.law.controller.interfaces.OnResponse;
import com.mit.law.controller.interfaces.OnResponseThirdParties;
import com.mit.law.model.Notification;
import com.mit.law.model.ThirdParties;

import java.util.List;

/**
 * Created by ASUS on 6/10/2017.
 */

public class RequestController implements OnResponse,OnResponseThirdParties{

    TagsForLawIdController tagsForLawIdController;
    ThirdPartyListForTagsController thirdPartyListForTagsController;

    List<String> tagList;
    List<ThirdParties> thirdParties;
    List<Notification>notifications;
    String lawId;
    String description;


    public RequestController(String lawId,String description){
        this.lawId=lawId;
        this.description=description;
        tagsForLawIdController=new TagsForLawIdController(this,lawId);

    }
    @Override
    public void responded(Object tags) {
        tagList=(List<String>)tags;
        NotifyThirdPartyListForTagsController notifyThirdPartyListForTagsController=new NotifyThirdPartyListForTagsController(this,tagList,lawId,description);
    }

    @Override
    public void respondedThird(Object third) {
        thirdParties=(List<ThirdParties>)third;
    }
}
