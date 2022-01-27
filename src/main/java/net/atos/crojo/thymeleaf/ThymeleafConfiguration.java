package net.atos.crojo.thymeleaf;

import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import nz.net.ultraq.thymeleaf.layoutdialect.decorators.strategies.GroupingStrategy;

/**
 * ThymeleafConfig
 */
@Configuration
 public class ThymeleafConfiguration {
    
    public SpringTemplateEngine thymeleafLayoutEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.addDialect(new LayoutDialect(new GroupingStrategy()));
        return engine;
    }
    
}