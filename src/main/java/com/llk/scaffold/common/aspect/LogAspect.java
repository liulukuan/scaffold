package com.llk.scaffold.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @className: LogAspect
 * @description: 日志切面
 * @author: LiuLukuan
 * @date: 2019/11/9 14:19
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    /**
     * 解决多线程问题
     */
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 配置切入点 该方法无方法体 主要为了让同类中其他方法使用此切入点
     */
    @Pointcut("@annotation( com.llk.scaffold.common.aspect.Log)")
    public void webLog() {
    }

    /**
     * 配置环绕通知,使用在方法logPointcut()上注册的切入点
     *
     * @param joinPoint join point for advice
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (attributes != null) {
            //获取请求
            HttpServletRequest request = attributes.getRequest();
            if (request != null) {
                // 记录下请求内容
                log.info("URL : " + request.getRequestURL().toString());
                log.info("HTTP_METHOD : " + request.getMethod());
                log.info("IP : " + request.getRemoteAddr());
                log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." +
                        joinPoint.getSignature().getName());
                log.info("ARGS： : " + Arrays.toString(joinPoint.getArgs()));
            }
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("RESPONSE : " + ret);
        log.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }
}
