package com.tutorialpro.tutorialpro.repository;

import com.tutorialpro.tutorialpro.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * get user by given email .
     * @param email
     * @return
     */
    public User findByEmail(String email);

    /**
     * get user by given token .
     * @param token
     * @return
     */
    public User findByToken(String token);

    /**
     * get user by given username .
     * @param username
     * @return
     */
    public User findUserByUsername(String username);

    /**
     * update user by given id and token .
     * @param token
     * @param id
     */
    @Query("update User u set u.active=true where u.token=:token and u.id=:id")
    @Modifying
    @Transactional
    public void activeUserByTokenAndId(@Param("token") String token, @Param("id") int id);
}
