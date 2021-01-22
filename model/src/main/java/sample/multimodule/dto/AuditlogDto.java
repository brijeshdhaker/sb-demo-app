/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.multimodule.dto;

import sample.multimodule.domain.AuditLog;
import lombok.Data;

/**
 *
 * @author brijeshdhaker
 */
@Data
@SuppressWarnings("all")
public class AuditlogDto {
    
    public long id;
    public String auditType;
    public String eventAction;
    public String eventMessage;
    public String refrenceId;
    public String refrenceType;
    public String userid;
    public String addTs;
    public String updateTs;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public String getEventAction() {
        return eventAction;
    }

    public void setEventAction(String eventAction) {
        this.eventAction = eventAction;
    }

    public String getEventMessage() {
        return eventMessage;
    }

    public void setEventMessage(String eventMessage) {
        this.eventMessage = eventMessage;
    }

    public String getRefrenceId() {
        return refrenceId;
    }

    public void setRefrenceId(String refrenceId) {
        this.refrenceId = refrenceId;
    }

    public String getRefrenceType() {
        return refrenceType;
    }

    public void setRefrenceType(String refrenceType) {
        this.refrenceType = refrenceType;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAddTs() {
        return addTs;
    }

    public void setAddTs(String addTs) {
        this.addTs = addTs;
    }

    public String getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(String updateTs) {
        this.updateTs = updateTs;
    }
    
    public AuditLog toEntity(){
        
        AuditLog auditLog = new AuditLog();
        auditLog.setId(this.id);
        
        auditLog.setDescription(this.eventMessage);
        auditLog.setEventAction(this.eventAction);
        auditLog.setUserid(this.userid);
        
        return  auditLog;
        
    }
    
}
