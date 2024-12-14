package ru.clevertec.monitorstarter.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import ru.clevertec.monitorstarter.Constant;
import ru.clevertec.monitorstarter.configuration.PerformanceMonitorProperties;

@Slf4j
@Aspect
@RequiredArgsConstructor
public class PerformanceMonitorAspect {

    private final PerformanceMonitorProperties properties;

    @Pointcut("@annotation(ru.clevertec.monitorstarter.annotation.MonitorPerformance)")
    public void monitorPerformanceMethods() {
    }

    @Around("monitorPerformanceMethods()")
    public Object monitor(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;

        if (resultTime >= properties.getMinTime()) {
            log.info(Constant.MESSAGE_MONITOR_METHOD_WITH_RESULT,
                    joinPoint.getSignature().getName(),
                    resultTime);
        }

        return result;
    }
}
