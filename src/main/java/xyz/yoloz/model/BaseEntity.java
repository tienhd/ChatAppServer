package xyz.yoloz.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseEntity
{
    @Id
    @Column (name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Version
    @Column(name = "version", nullable = false)
    protected Long version;

    @Column (name = "created_date", nullable = false)
    protected Date createdDate;

    @Column (name = "updated_date", nullable = false)
    protected Date updatedDate;

    @Column (name = "deleted", nullable = false)
    protected boolean deleted = false;

    @PrePersist
    protected void onBaseCreate() {
        Date now = new Date();
        if (createdDate == null) {
            createdDate = now;
        }

        updatedDate = now;
    }

    @PreUpdate
    protected void onBaseUpdate() {
        updatedDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate)
    {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate()
    {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate)
    {
        this.updatedDate = updatedDate;
    }

    public Long getVersion()
    {
        return version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }
}
