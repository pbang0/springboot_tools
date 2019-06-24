package com.example.demo.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * 切面类，实现web层的日志切面
 * The type Web log acpect.
 * @author bo.peng
 */
@Component
@Aspect
@Slf4j
public class WebLogAspect {
    /**
     * 定义切入点，切入点为com.example.demo.aop.controller下的所有public任意参数的函数
     * Web log.
     */
    @Pointcut("execution(public * com.example.demo.aop.controller..*(..))")
    public void webLog(){}


    /**
     * Do before.
     * 前置通知：在连接点执行之前执行的通知
     * @param joinPoint the join point
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取session

        //输出请求内容
        System.out.println(" ******   请求来了   ****** ");
        System.out.println("URL :" + request.getRequestURI());
        System.out.println("HTTP_METHOD :" + request.getMethod());
        System.out.println("IP :" + request.getRemoteAddr());
        System.out.println("CLASS_METHOD :"+ joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        System.out.println("ARGS :"+ Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * Do after.
     * 后置通知：在连接点执行之后执行的通知（不论是正常返回还是异常退出）
     * @param joinPoint the join point
     */
    @After("webLog()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println(" ******   后置通知执行   ****** ");
    }


    /**
     * Do after returning.
     * 后置返回通知：在连接点返回之后执行
     *          注意点:    如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
     *                    如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     *                    returning：限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，
     *                    对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
     * @param ret the ret
     */
    @AfterReturning(returning = "ret" ,pointcut = "webLog()")
    public void doAfterReturning(Object ret){
        System.out.println(" ******   后置返回通知执行   ****** ");

        System.out.println("RESPONSE :" + ret);
    }

    /**
     * Do after throwing advice.
     * 后置异常通知 :目标方法抛出异常返回后执行
     * @param joinPoint the join point
     * @param exception the exception 目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知
     */
    @AfterThrowing(pointcut = "webLog()",throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint,Throwable exception){
        //目标方法名：
        System.out.println(joinPoint.getSignature().getName());
        if(exception instanceof NullPointerException){
            log.error("发生了空指针异常 !");
        }
    }

    @Around(value = "webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("环绕通知的目标方法名："+proceedingJoinPoint.getSignature().getName());
        try {
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }




}
