package ru.clevertec.monitorstarter.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@AutoConfiguration
@EnableConfigurationProperties(PerformanceMonitorProperties.class)
@EnableAutoConfiguration
public class PerformanceMonitorAutoConfiguration {
}
