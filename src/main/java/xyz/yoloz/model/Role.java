package xyz.yoloz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by tienhd on 11/2/16.
 */
@Entity
@Table(name = "ca_role")
public class Role extends BaseEntity{
    @Column(name = "role")
    String role;
    @Column(name = "description")
    String description;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (!role.equals(role1.role)) return false;
        return description.equals(role1.description);

    }

    @Override
    public int hashCode() {
        int result = role.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
