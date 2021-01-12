/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.samples.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.org.samples.domain.AuditLog;
import com.org.samples.domain.AuditType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 *
 * @author brijeshdhaker
 */
@Repository("auditlogRepository")
public interface AuditlogRepository extends PagingAndSortingRepository<AuditLog, Long> {
    
    @Query("select al from AuditLog al where al.auditType=:type")
    List<AuditLog> findByType(@Param("type") AuditType type);
    
    @Query("select al from AuditLog al where al.userid=:userid")
    List<AuditLog> findByUser(@Param("userid") String userid);
}
