/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.multimodule.service;

import java.util.List;
import sample.multimodule.dto.AuditlogDto;
import sample.multimodule.utilities.exceptions.AppException;



/**
 *
 * @author brijeshdhaker
 */
public interface AuditlogService {
    
    public AuditlogDto getAuditlog(Integer id) throws AppException;
    
    public List<AuditlogDto> getAuditlogs() throws AppException;
}
