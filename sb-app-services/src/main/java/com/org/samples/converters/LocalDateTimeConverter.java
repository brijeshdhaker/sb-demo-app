/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.samples.converters;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.AttributeConverter;

/**
 *
 * @author brijeshdhaker
 */
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, java.sql.Timestamp>{

    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime x) {
        return x == null ? null: Timestamp.valueOf(x);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp y) {
        return y == null ? null : y.toLocalDateTime();
    }
    
}
