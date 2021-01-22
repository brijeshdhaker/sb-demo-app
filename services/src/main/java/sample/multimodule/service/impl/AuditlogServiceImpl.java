/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.multimodule.service.impl;

import java.util.ArrayList;
import java.util.List;
import sample.multimodule.domain.AuditLog;
import sample.multimodule.dto.AuditlogDto;
import sample.multimodule.utilities.exceptions.AppException;
import sample.multimodule.repository.AuditlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.multimodule.service.AuditlogService;

/**
 *
 * @author brijeshdhaker
 */
@Service("auditlogService")
public class AuditlogServiceImpl implements AuditlogService{
    
    @Autowired
    AuditlogRepository auditlogRepository;
    
    public AuditlogDto getAuditlog(Integer id) throws AppException{
        AuditLog auditlog = auditlogRepository.findById(Long.valueOf(id)).orElse(null);
        AuditlogDto dto = auditlog.toDTO();
        return dto;
    }
    
    public List<AuditlogDto> getAuditlogs() throws AppException{
        List<AuditlogDto> dtos = new ArrayList<>();
        Iterable<AuditLog> auditlogs = auditlogRepository.findAll();
        for(AuditLog l : auditlogs){
            AuditlogDto dto = l.toDTO();
            dtos.add(dto);
        }
        return dtos;
    }
}
