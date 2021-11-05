package com.canermastan.registrationandlogin.dao;

import com.canermastan.registrationandlogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long>{
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(String email);
}
