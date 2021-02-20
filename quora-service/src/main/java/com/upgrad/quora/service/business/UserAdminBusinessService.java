package com.upgrad.quora.service.business;

import com.upgrad.quora.service.dao.UserDao;
import com.upgrad.quora.service.entity.User;
import com.upgrad.quora.service.entity.UserAuth;
import com.upgrad.quora.service.exception.AuthorizationFailedException;
import com.upgrad.quora.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAdminBusinessService {

    @Autowired
    private UserDao userDao;

    @Autowired
    PasswordCryptographyProvider cryptographyProvider;

    public User userDelete(final String userUuid, final String authorizationToken) throws UserNotFoundException, AuthorizationFailedException {

        UserAuth userAuthTokenEntity = userDao.getUserAuthToken(authorizationToken);

        /*  If user is not logged IN */
        if(userAuthTokenEntity == null){
            throw new AuthorizationFailedException("ATHR-001","User has not signed in");
        }

        /*  User is logged out  */
        if(userAuthTokenEntity.getLogoutAt() != null){
            throw new AuthorizationFailedException("ATHR-002","User is signed out");
        }

        /*  if role of user us nonadmin */
        User isAdminUser = userDao.getUser(userAuthTokenEntity.getUserId().getUuid());
        if(isAdminUser.getRole().equals("nonadmin")){
            throw new AuthorizationFailedException("ATHR-003","Unauthorized Access, Entered user is not an admin");
        }

        User userToBeDeleted = userDao.getUser(userUuid);
        if(userToBeDeleted == null){
            throw  new UserNotFoundException("USR-001","User with entered uuid to be deleted does not exis");
        }
        userDao.deleteUser(userToBeDeleted);
        return userToBeDeleted;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public User createUser(final User user){

        String password = user.getPassword();
        if(password == null){
            user.setPassword("proman@123");
        }
        String[] encryptedText = cryptographyProvider.encrypt(user.getPassword());
        user.setSalt(encryptedText[0]);
        user.setPassword(encryptedText[1]);
        return userDao.createUser(user);

    }

}
