/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.samples.services;

import com.org.samples.domain.AuditLog;
import com.org.samples.dto.AuditlogDto;
import com.org.samples.exceptions.AppException;
import com.org.samples.repositories.AuditlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author brijeshdhaker
 */
@Service("auditlogService")
public class AuditlogService {
    
    @Autowired
    AuditlogRepository auditlogRepository;
    
    public AuditlogDto getAuditlog(Integer id) throws AppException{
        AuditLog auditlog = auditlogRepository.findById(Long.valueOf(id)).orElse(null);
        AuditlogDto dto = auditlog.toDTO();
        return dto;
    }
}
