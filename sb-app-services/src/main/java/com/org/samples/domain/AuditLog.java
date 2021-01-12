/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.samples.domain;

import com.org.samples.converters.LocalDateTimeConverter;
import com.org.samples.dto.AuditlogDto;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author brijeshdhaker
 */
@Entity
@Table(name= "AUDITLOG")
public class AuditLog implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUDITLOG_SEQ_GENERATOR")
    @SequenceGenerator(name= "AUDITLOG_SEQ_GENERATOR", sequenceName = "AUDITLOG_SEQUENCE", schema = "APP_DB_MGR", allocationSize = 1)
    @Column(name= "ID", updatable = false, nullable = false)
    private Long id;
    
    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn( name = "AUDIT_TYPE", referencedColumnName = "AUDIT_TYPE")
    private AuditType auditType;
    
    @Column(name= "EVENT_ACTION")
    private String eventAction;
    
    @Column(name= "DESCRIPTION")
    private String description;
    
    @Column(name= "REF_ID")
    private String refrenceId;
    
    @Column(name= "REF_TYPE")
    private String referenceType;
    
    @Column(name= "USERID")
    private String userid;
    
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuditType getAuditType() {
        return auditType;
    }

    public void setAuditType(AuditType auditType) {
        this.auditType = auditType;
    }

    public String getEventAction() {
        return eventAction;
    }

    public void setEventAction(String eventAction) {
        this.eventAction = eventAction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRefrenceId() {
        return refrenceId;
    }

    public void setRefrenceId(String refrenceId) {
        this.refrenceId = refrenceId;
    }

    public String getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(String referenceType) {
        this.referenceType = referenceType;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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
        if (!(object instanceof AuditLog)) {
            return false;
        }
        AuditLog other = (AuditLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.samples.domain.AuditLog[ id=" + id + " ]";
    }

    public AuditlogDto toDTO() {
        
        AuditlogDto dto = new AuditlogDto();
        dto.setId(this.getId());
        dto.setAuditType(this.getAuditType().getAuditType());
        
        dto.setEventAction(this.eventAction);
        dto.setEventMessage(this.description);
        
        dto.setRefrenceId(this.refrenceId);
        dto.setRefrenceType(this.referenceType);
        dto.setUserid(this.userid);
        dto.setAddTs(this.getCreateTs().toString());
        dto.setUpdateTs(this.getUpdateTs().toString());
        
        return  dto;
    }
    
}
