package com.satyam.jobtracker.skill;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    // "ProfileId" walks the relation: skill.profile.id. Uses the FK column, no join needed.
    List<Skill> findByProfileIdOrderByNameAsc(Long profileId);

    // Finds a skill only if it belongs to this profile: the ownership check in one query.
    Optional<Skill> findByIdAndProfileId(Long id, Long profileId);

    boolean existsByProfileIdAndNameIgnoreCase(Long profileId, String name);
}
