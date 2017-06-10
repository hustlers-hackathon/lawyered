package com.mit.law.controller.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mit.law.model.LocationRules;

/**
 * Created by ASUS on 6/10/2017.
 */

public class LocationRulesController {
    DatabaseReference mLsRule;
    LocationRules locationRules;

    public LocationRulesController(LocationRules ls){
        this.locationRules=ls;
        mLsRule= FirebaseDatabase.getInstance().getReference().child("lsRules");
        String key=mLsRule.push().getKey();
        locationRules.setLid(key);
        mLsRule.child(key).setValue(locationRules);
    }
}
