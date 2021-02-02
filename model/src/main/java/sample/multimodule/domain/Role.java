/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.multimodule.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author brijeshdhaker
 */
@Entity
@Table(name= "ROLE")
public class Role extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ_GENERATOR")
    @SequenceGenerator(name= "ROLE_SEQ_GENERATOR", sequenceName = "ROLE_SEQUENCE", schema = "PUBLIC", allocationSize = 1)
    @Column(name= "ID", updatable = false, nullable = false)
    private Long id;
    
    @Column(name= "NAME")
    private String name;
    
    @Column(name= "STATUS")
    private String status;
    
    
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    @Override
    public String toString() {
        return "sample.multimodule.domain.Role[ id=" + id + " ]";
    }
}
