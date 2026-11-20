package com.satyam.jobtracker.skill;

import com.satyam.jobtracker.user.UserProfile;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The "many" side owns the foreign key column (skills.profile_id).
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_id")
    private UserProfile profile;

    @Column(nullable = false)
    private String name;

    // STRING stores 'EXPERT'. The default (ORDINAL) would store 2, which breaks if the enum is reordered.
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SkillLevel level;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    protected Skill() {
    }

    public Skill(UserProfile profile, String name, SkillLevel level) {
        this.profile = profile;
        this.name = name;
        this.level = level;
    }

    public Long getId() { return id; }

    public UserProfile getProfile() { return profile; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public SkillLevel getLevel() { return level; }

    public void setLevel(SkillLevel level) { this.level = level; }

    public Instant getCreatedAt() { return createdAt; }
}
