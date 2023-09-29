package com.example.a0922i1projectmobilephone.repository;

import com.example.a0922i1projectmobilephone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT u.user_name FROM user u WHERE u.user_name = :username", nativeQuery = true)
    User findByUsername(@Param("username") String username); // tìm kiếm user có tồn tại trong DB không

    @Query(value = "SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.username = :username",nativeQuery = true)
    boolean existsByUsername(@Param("username") String username);

    @Query(value = "SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = :email",nativeQuery = true)
    boolean existsByEmail(@Param("email") String email);


    User save(User user);
}
