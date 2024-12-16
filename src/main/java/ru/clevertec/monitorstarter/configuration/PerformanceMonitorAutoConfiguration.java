package ru.clevertec.monitorstarter.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.clevertec.monitorstarter.aop.PerformanceMonitorAspect;

@Configuration
@EnableConfigurationProperties(PerformanceMonitorProperties.class)
public class PerformanceMonitorAutoConfiguration {

    @Configuration
    public class PerformanceMonitorAspectConfiguration {
        @Bean
        @ConditionalOnProperty(value = "performance-monitor.enable", havingValue = "true")
        public PerformanceMonitorAspect performanceMonitorAspect(PerformanceMonitorProperties properties) {
            return new PerformanceMonitorAspect(properties);
        }
    }

}
