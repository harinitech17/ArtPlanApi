package com.artplanapp.rest;

import com.artplanapp.exception.ResourceNotFoundException;
import com.artplanapp.model.artplanuser.ArtPlanUser;
import com.artplanapp.service.ArtPlanUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/artplanuser")
public class ArtPlanUserRest {
    @Autowired
    ArtPlanUserService artPlanUserService;

    @GetMapping("/getartplanuser/{artPlanUserId}")
    public ResponseEntity<ArtPlanUser> getArtPlanUser(@PathVariable String artPlanUserId)
            throws ResourceNotFoundException {
        ArtPlanUser artPlanUser = artPlanUserService.getArtPlanUser(artPlanUserId);
        if(artPlanUser ==null)
        {
            throw new ResourceNotFoundException("ArtPlan User not found for this id :: " + artPlanUserId);
        }
        return new ResponseEntity<ArtPlanUser>(artPlanUser, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getallartplanusers")
    public List<ArtPlanUser> getAllArtPlannerUsers()
            throws ResourceNotFoundException {
        List<ArtPlanUser> artPlanUserList = artPlanUserService.getAllArtPlanUsers();
        if (artPlanUserList == null || artPlanUserList.size() == 0) {
            throw new ResourceNotFoundException("Wine users is empty");
        }
        return artPlanUserList;
    }

    @PostMapping("/addartplanuser")
    public ResponseEntity<ArtPlanUser> addArtPlanUser(@RequestBody ArtPlanUser artPlanUser) throws Exception
    {
        fieldCheck(artPlanUser, false);
        if (artPlanUser.getArtPlanUserId() != null) {
            if (artPlanUserService.getArtPlanUser(artPlanUser.getArtPlanUserId()) != null) {
                throw new Exception("Wine User already exist for this Id :: " + artPlanUser.getArtPlanUserId());
            }
        }
        artPlanUserService.addArtPlanUser(artPlanUser);
        return new ResponseEntity<ArtPlanUser>(artPlanUserService.getArtPlanUser(artPlanUser.getArtPlanUserId()), new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/updateartplanUser")
    public void updateWineUser(@RequestBody ArtPlanUser artPlanUser) throws Exception
    {
        fieldCheck(artPlanUser,true);
        if(artPlanUserService.getArtPlanUser(artPlanUser.getArtPlanUserId())==null) {
            throw new ResourceNotFoundException("Art Plan user not found for this id :: " + artPlanUser.getArtPlanUserId());
        }
        artPlanUserService.updateArtPlanUser(artPlanUser);
    }

    private void fieldCheck(ArtPlanUser artPlanUser, boolean update) throws Exception {

        if((artPlanUser.getArtPlanUserId()==null|| artPlanUser.getArtPlanUserId().equals(""))||
                (artPlanUser.getArtPlanUserEmail()==null|| artPlanUser.getArtPlanUserEmail().equals(""))||
                (artPlanUser.getArtPlanUserMobileNo()==null|| artPlanUser.getArtPlanUserMobileNo().equals(""))||
                (artPlanUser.getArtPlanUserName()==null|| artPlanUser.getArtPlanUserName().equals(""))) {
            throw new Exception ("Required fields are missing");
        }
    }

}
