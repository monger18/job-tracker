package com.satyam.jobtracker.user;

import org.springframework.data.jpa.repository.JpaRepository;

// No custom methods yet. The inherited findById, save and deleteById are enough for now.
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
