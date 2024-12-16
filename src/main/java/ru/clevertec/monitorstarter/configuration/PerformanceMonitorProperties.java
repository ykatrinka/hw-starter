package ru.clevertec.monitorstarter.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("performance-monitor")
public class PerformanceMonitorProperties {
    private boolean enable;
    private int minTime;

}
