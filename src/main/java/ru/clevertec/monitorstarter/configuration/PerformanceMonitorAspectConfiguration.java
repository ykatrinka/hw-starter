package ru.clevertec.monitorstarter.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.clevertec.monitorstarter.aop.PerformanceMonitorAspect;

@Configuration
public class PerformanceMonitorAspectConfiguration {

    @Bean
    @ConditionalOnProperty(value = "performance-monitor.enable", havingValue = "true")
    public PerformanceMonitorAspect performanceMonitorAspect(PerformanceMonitorProperties properties) {
        return new PerformanceMonitorAspect(properties);
    }

    @Bean
    public PerformanceMonitorProperties performanceMonitorProperties() {
        return new PerformanceMonitorProperties();
    }

}
