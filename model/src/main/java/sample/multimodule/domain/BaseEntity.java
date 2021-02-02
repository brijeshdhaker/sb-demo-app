/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.multimodule.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import sample.multimodule.utilities.converters.LocalDateTimeConverter;

/**
 *
 * @author brijeshdhaker
 */
public class BaseEntity implements Serializable {
    
    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name= "ADD_TS")
    private LocalDateTime createTs;
    
    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name= "UPD_TS")
    private LocalDateTime updateTs;
    
    @PrePersist
    public void prePersist(){
        createTs = updateTs = LocalDateTime.now();
    }
    
    @PreUpdate
    public void preUpdate(){
        updateTs = LocalDateTime.now();
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
    
    
}
