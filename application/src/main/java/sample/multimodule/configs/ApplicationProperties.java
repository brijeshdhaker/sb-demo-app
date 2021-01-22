/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.multimodule.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * @author brijeshdhaker
 */
@ConfigurationProperties(prefix = "prefix")
public class ApplicationProperties {
    
}
