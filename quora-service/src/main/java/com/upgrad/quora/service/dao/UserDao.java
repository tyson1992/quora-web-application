package com.upgrad.quora.service.dao;

import com.upgrad.quora.service.entity.User;
import com.upgrad.quora.service.entity.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Repository
public class UserDao {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User createUser(User user){
        entityManager.persist(user);
        return user;
    }

    public User getUser(String userUuid) {
        try {
            return entityManager.createNamedQuery("userByUuid", User.class).setParameter("uuid", userUuid)
                    .getSingleResult();
        } catch(NoResultException n){
            return null;
        }
    }

    public User getUserByEmail(final String email) {
        try {
            return entityManager.createNamedQuery("userByEmail", User.class).setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public UserAuth createAuthToken(final UserAuth userAuthTokenEntity){
        entityManager.persist(userAuthTokenEntity);
        return userAuthTokenEntity;
    }

    public void updateUser(final User updatedUser){
        entityManager.merge(updatedUser);
    }

    public UserAuth getUserAuthToken(final String accessToken){
        try {
            return entityManager.createNamedQuery("userAuthTokenByAccessToken",
                    UserAuth.class).setParameter("accessToken", accessToken).getSingleResult();
        } catch (NoResultException nre){
            return null;
        }

    }

    public String deleteUser(final User user){
        entityManager.remove(user);
        return user.getUuid();
    }

}
