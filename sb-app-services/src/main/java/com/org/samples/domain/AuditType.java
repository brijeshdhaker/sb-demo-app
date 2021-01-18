/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.samples.domain;

import com.org.samples.converters.LocalDateTimeConverter;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

/**
 *
 * @author brijeshdhaker
 */
@Entity
@Table(name= "AUDIT_TYPE")
public class AuditType implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "ID", updatable = false, nullable = false)
    private Integer id;

    @Column(name= "AUDIT_TYPE")
    private String auditType;
    
    @Column(name= "DESCRIPTION")
    private String description;
    
    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name= "ADD_TS")
    private LocalDateTime createTs;
    
    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name= "UPDATE_TS")
    private LocalDateTime updateTs;
    
    @PrePersist
    public void prePersist(){
        createTs = updateTs = LocalDateTime.now();
    }
    
    @PreUpdate
    public void preUpdate(){
        updateTs = LocalDateTime.now();
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateTs() {
        return createTs;
    }

    public void setCreateTs(LocalDateTime createTs) {
        this.createTs = createTs;
    }

    public LocalDateTime getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(LocalDateTime updateTs) {
        this.updateTs = updateTs;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditType)) {
            return false;
        }
        AuditType other = (AuditType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.org.samples.domain.AuditType[ id=" + id + " ]";
    }
    
}
