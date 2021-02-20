package com.upgrad.quora.api.controller;


import com.upgrad.quora.api.model.UserDeleteResponse;
import com.upgrad.quora.api.model.UserDetailsResponse;
import com.upgrad.quora.service.business.CommonBusinessService;
import com.upgrad.quora.service.business.UserAdminBusinessService;
import com.upgrad.quora.service.entity.User;
import com.upgrad.quora.service.exception.AuthorizationFailedException;
import com.upgrad.quora.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CommonController {

    @Autowired
    CommonBusinessService commonBusinessService;
    @RequestMapping(method = RequestMethod.GET, path = "/userprofile/{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDetailsResponse> userProfile(@RequestHeader("authorization") final String authorization, @PathVariable("userId")
    final String userId) throws AuthorizationFailedException, UserNotFoundException {
        User userDetails = commonBusinessService.userProfile(userId,authorization);
        UserDetailsResponse userDetailsResponse = new UserDetailsResponse().firstName(userDetails.getFirstName()).lastName(userDetails.getLastName())
                .userName(userDetails.getUserName()).aboutMe(userDetails.getAboutMe()).contactNumber(userDetails.getContactNumber())
                .country(userDetails.getCountry()).dob(userDetails.getDob()).emailAddress(userDetails.getEmail());
        return new ResponseEntity<>(userDetailsResponse,HttpStatus.OK);
    }
}
