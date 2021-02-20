package com.upgrad.quora.service.business;

import com.upgrad.quora.service.dao.UserDao;
import com.upgrad.quora.service.entity.User;
import com.upgrad.quora.service.entity.UserAuth;
import com.upgrad.quora.service.exception.AuthorizationFailedException;
import com.upgrad.quora.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonBusinessService {

    @Autowired
    private UserDao userDao;

    @Autowired
    PasswordCryptographyProvider cryptographyProvider;

    public User userProfile(final String userUuid, final String authorizationToken) throws UserNotFoundException, AuthorizationFailedException {

        UserAuth userAuthTokenEntity = userDao.getUserAuthToken(authorizationToken);

        /*  If user is not logged IN */
        if(userAuthTokenEntity == null){
            throw new AuthorizationFailedException("ATHR-001","User has not signed in");
        }

        /*  User is logged out  */
        if(userAuthTokenEntity.getLogoutAt() != null){
            throw new AuthorizationFailedException("ATHR-002","User is signed out");
        }

        User userProfile = userDao.getUser(userUuid);
        if(userProfile == null){
            throw  new UserNotFoundException("USR-001","User with entered uuid does not exist");
        }
        return userProfile;
    }
}
