package com.artplanapp.repository;

import com.artplanapp.model.artplanuser.ArtPlanUser;

import java.util.List;

public interface ArtPlanUserRepo {

    void addArtPlanUser(ArtPlanUser artPlanUser);

    ArtPlanUser getArtPlanUser(String artPlanUserId);

    default List<ArtPlanUser> getAllArtPlanUsers() {
        return null;
    }

    void updateArtPlanUser(ArtPlanUser artPlanUser);

    void deleteArtPlanUser(String artPlanUserId);


}
