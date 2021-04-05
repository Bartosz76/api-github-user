package bm.app.apigithubuser.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Comparable<User>{

    @SerializedName("full_name")
    @Expose
    private String full_name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("clone_url")
    @Expose
    private String clone_url;
    @SerializedName(value = "stargazers_count")
    @Expose
    private Integer stars;
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    public User() {
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getClone_url() {
        return clone_url;
    }

    public void setClone_url(String clone_url) {
        this.clone_url = clone_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int compareTo(User user) {
        return this.stars - user.stars;
    }
}
