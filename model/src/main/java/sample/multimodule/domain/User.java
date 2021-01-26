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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import sample.multimodule.dto.UserDto;
import sample.multimodule.utilities.converters.LocalDateTimeConverter;

/**
 *
 * @author brijeshdhaker
 */
@Entity
@Table(name= "USERS")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ_GENERATOR")
    @SequenceGenerator(name= "USERS_SEQ_GENERATOR", sequenceName = "USERS_SEQUENCE", schema = "PUBLIC", allocationSize = 1)
    @Column(name= "USERID", updatable = false, nullable = false)
    private Long id;
   
    @Column(name= "USERNAME")
    private String name;
   
    @Column(name= "EMAIL")
    private String email;
    
    @Column(name= "STATUS")
    private String status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sample.multimodule.domain.User[ id=" + id + " ]";
    }

    public UserDto toDTO() {
        UserDto dto = new UserDto();
        dto.setId(this.id);
        dto.setName(this.name);
        dto.setEmail(this.email);
        dto.setStatus(this.status);
        return  dto;
    }
}
