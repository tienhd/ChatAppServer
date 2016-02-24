package xyz.yoloz.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by tienhd on 24/2/16.
 */
@Entity
public class AuthorityGroup extends BaseEntity
{
    @Column(name = "authority_group_key")
    String authorityKey;
    @Column(name = "authority_group_value")
    String authorityValue;
    @Column(name = "description")
    String description;

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
}
