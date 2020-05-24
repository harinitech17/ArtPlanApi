package com.artplanapp.service;

import com.artplanapp.model.artplanuser.ArtPlanUser;

import java.util.List;

public interface ArtPlanUserService {

    void addArtPlanUser(ArtPlanUser artPlanUser);
    ArtPlanUser getArtPlanUser(String artPlanUserId);
    List<ArtPlanUser> getAllArtPlanUsers();
    void updateArtPlanUser(ArtPlanUser artPlanUser);
    void deleteArtPlanUser(String artPlanUserId);
}
