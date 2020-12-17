package com.wxd.my_mall.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 统一日志处理切面
 */
@Aspect
@Component
public class WebLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.wxd.my_mall.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
    }

    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) throws Throwable {
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String, String> headers = new HashMap<>();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            headers.put(key, value);
        }
        String method = request.getMethod();
        String url = request.getRequestURL().toString();

        String pid = UUID.randomUUID().toString();
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method controllerMethod = methodSignature.getMethod();
        Object[] args = joinPoint.getArgs();
        Object reqBody = getReqBody(controllerMethod, args);
        Map<String, Object> reqParams = getParameter(controllerMethod, args);
        String s1 = String.format("REQUEST[%s] url: %s, method: %s, headers: %s ", pid, url, method, headers);
        s1 += reqParams.isEmpty() ? "" : "request params: " + reqParams.toString();
        s1 += reqBody != null ? " body: " + reqBody.toString() : "";
        LOGGER.info(s1);

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        LOGGER.info(String.format("RESPONSE[%s]: %s, cost time: %ss", pid, result, (endTime - startTime) / 1000.0));
        return result;
    }

    private Object getReqBody(Method method, Object[] args) {
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            RequestBody requestBody = parameter.getAnnotation(RequestBody.class);
            if (requestBody != null) {
                return args[i];
            }
        }
        return null;
    }

    private Map<String, Object> getParameter(Method method, Object[] args) {
        Map<String, Object> reqParams = new HashMap<>();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            RequestParam requestParam = parameter.getAnnotation(RequestParam.class);
            if (requestParam != null) {
                String paramName = requestParam.value().equals("") ? parameter.getName() : requestParam.value();
                reqParams.put(paramName, args[i]);
            }
        }
        return reqParams;
    }
}
