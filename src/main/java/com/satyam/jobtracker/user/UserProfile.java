package com.satyam.jobtracker.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    // Same value as users.id: the profile's primary key IS its foreign key.
    @Id
    @Column(name = "user_id")
    private Long id;

    // @MapsId copies this user's id into the field above when the profile is saved.
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    private String phone;

    private String location;

    @Column(name = "current_company")
    private String currentCompany;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "years_of_experience", precision = 3, scale = 1)
    private BigDecimal yearsOfExperience;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(name = "github_url")
    private String githubUrl;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected UserProfile() {
    }

    public UserProfile(User user, String fullName) {
        this.user = user;
        this.fullName = fullName;
    }

    public Long getId() { return id; }

    public User getUser() { return user; }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public String getCurrentCompany() { return currentCompany; }

    public void setCurrentCompany(String currentCompany) { this.currentCompany = currentCompany; }

    public String getJobTitle() { return jobTitle; }

    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public BigDecimal getYearsOfExperience() { return yearsOfExperience; }

    public void setYearsOfExperience(BigDecimal yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    public String getLinkedinUrl() { return linkedinUrl; }

    public void setLinkedinUrl(String linkedinUrl) { this.linkedinUrl = linkedinUrl; }

    public String getGithubUrl() { return githubUrl; }

    public void setGithubUrl(String githubUrl) { this.githubUrl = githubUrl; }

    public Instant getUpdatedAt() { return updatedAt; }
}
