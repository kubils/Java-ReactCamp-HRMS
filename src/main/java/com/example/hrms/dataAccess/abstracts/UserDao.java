package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    boolean existsByemail(String email);
}
