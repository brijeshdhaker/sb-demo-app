/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.multimodule.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sample.multimodule.domain.AuditType;
/**
 *
 * @author brijeshdhaker
 */
@Repository("auditTypeRepository")
public interface AuditTypeRepository extends PagingAndSortingRepository<AuditType, Integer> {
    
    @Query("select at from AuditType at where at.auditType=:type")
    Optional<AuditType> findByType(@Param("type") String type);
    
}
