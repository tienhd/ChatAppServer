package xyz.yoloz.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by tienhd on 25/2/16.
 */
@MappedSuperclass
public abstract class BaseAuthEntity extends BaseEntity {

    @Column (name = "auth_user_id", nullable = false)
    public Long authUserId;

    @MapsId (value = "authUserId")
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "auth_user_id")
    @JsonIgnore
    public UserAccount authUser;

    public Long getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(Long authUserId) {
        this.authUserId = authUserId;
    }

    public UserAccount getAuthUser() {
        return authUser;
    }

    public void setAuthUser(UserAccount authUser) {
        this.authUser = authUser;
    }
}
