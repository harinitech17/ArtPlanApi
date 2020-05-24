package com.artplanapp.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.artplanapp.model.artplanuser.ArtPlanUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtPlanUserRepoImpl implements ArtPlanUserRepo {

    @Autowired
    private DynamoDBMapper mapper;
    private DynamoDBScanExpression scan;

    @Override
    public void addArtPlanUser(ArtPlanUser artPlanUser) {

        mapper.save(artPlanUser);
    }

    @Override
    public ArtPlanUser getArtPlanUser(String userId) {

        return mapper.load(ArtPlanUser.class,userId);
    }

    @Override
    public List<ArtPlanUser> getAllArtPlanUsers() {
//        Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
//        eav.put(":val1", new AttributeValue().withS(tenantId));
//        scan= new DynamoDBScanExpression();
//        scan.withFilterExpression("tenant_id = :val1").withExpressionAttributeValues(eav);
//        return mapper.scan(WineUser.class, scan);
        return null;
    }

    @Override
    public void updateArtPlanUser(ArtPlanUser artPlanUser) {
        mapper.save(artPlanUser);
    }

    @Override
    public void deleteArtPlanUser(String artPlanUserId) {
        mapper.delete(getArtPlanUser(artPlanUserId));

    }

}
