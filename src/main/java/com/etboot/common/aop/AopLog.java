package com.etboot.common.aop;

import com.etboot.common.utils.SecurityUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
public class AopLog {
    Logger logger = LoggerFactory.getLogger(AopLog.class);
    @Autowired
    HttpServletRequest request;
    @Autowired
    SecurityUtil securityUtil;

    @Pointcut("execution(public * com.etboot..controller..*.*(..))")
    public void log() {
    }

    @Before("log()")
    public synchronized void doBefore(JoinPoint joinPoint) {
        // 记录下请求内容
        logger.info("Request URL(" + request.getMethod() + "): " + request.getRequestURL().toString());
        logger.info("Client IP: " + request.getRemoteAddr());
        logger.info("Full Path: " + joinPoint.getSignature().getDeclaringTypeName());
        logger.info("Class: " + joinPoint.getSignature().getDeclaringType().getSimpleName());
        logger.info("Method: " + joinPoint.getSignature().getName());
        String user = "no user logged";
        try {
            user = securityUtil.getCurrUser().getUsername();
        } catch (Exception e){}
        logger.info("User: " + user);

        // logger.info("Params: " + new Gson().toJson(joinPoint.getArgs()));
        // logger.info("Params: " + JSON.toJSONString(joinPoint.getArgs()));
        // 获取所有参数：
        logger.info("Params: ");
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = (String) enu.nextElement();
            if (!"image".equals(paraName)) {
                logger.info("\t" + paraName + ": " + request.getParameter(paraName));
            }
        }
        logger.info(" - - - - - - - - - - - - - - - ");
    }
}
