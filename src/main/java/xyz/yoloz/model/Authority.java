package xyz.yoloz.model;

import javax.persistence.*;

/**
 * Created by tienhd on 11/2/16.
 */
@Entity
@Table(name = "ca_authority")
public class Authority extends BaseEntity{
    @Column(name = "authority_key")
    String authorityKey;
    @Column(name = "authority_value")
    String authorityValue;
    @Column(name = "description")
    String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "authority_group_id")
    AuthorityGroup authorityGroup;

    public String getAuthorityKey() {
        return authorityKey;
    }

    public void setAuthorityKey(String authorityKey) {
        this.authorityKey = authorityKey;
    }

    public String getAuthorityValue() {
        return authorityValue;
    }

    public void setAuthorityValue(String authorityValue) {
        this.authorityValue = authorityValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AuthorityGroup getAuthorityGroup() {
        return authorityGroup;
    }

    public void setAuthorityGroup(AuthorityGroup authorityGroup) {
        this.authorityGroup = authorityGroup;
    }
}
