package com.artplanapp.service;

import com.artplanapp.model.artplanuser.ArtPlanUser;
import com.artplanapp.repository.ArtPlanUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtPlanUserServiceImpl implements ArtPlanUserService {
    @Autowired
    ArtPlanUserRepo ArtPlanUserRepo;

    @Override
    public void addArtPlanUser(ArtPlanUser artPlanUser) {
        ArtPlanUserRepo.addArtPlanUser(artPlanUser);
    }

    @Override
    public ArtPlanUser getArtPlanUser(String artPlanUserId) {
        return ArtPlanUserRepo.getArtPlanUser(artPlanUserId);
    }

    @Override
    public List<ArtPlanUser> getAllArtPlanUsers() {
        return ArtPlanUserRepo.getAllArtPlanUsers();
    }

    @Override
    public void updateArtPlanUser(ArtPlanUser artPlanUser) {
        ArtPlanUserRepo.updateArtPlanUser(artPlanUser);
    }

    @Override
    public void deleteArtPlanUser(String artPlanUserId) {
        ArtPlanUserRepo.deleteArtPlanUser(artPlanUserId);

    }
}
