package com.satyam.jobtracker.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // select ... from users where email = ?
    Optional<User> findByEmail(String email);

    // select count(*) > 0 ... where email = ?
    boolean existsByEmail(String email);
}
