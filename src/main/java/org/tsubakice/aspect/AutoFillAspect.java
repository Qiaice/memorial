package org.tsubakice.aspect;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.tsubakice.annotation.AutoFill;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import org.tsubakice.common.OperationType;

import static org.tsubakice.common.AutoFillConstant.*;


/**
 * 自定义切面 实现公共字段自动填充
 *
 * @author Maynormoe
 */

@Aspect
@Component
@Slf4j
public class AutoFillAspect {
    /**
     * 切入点
     */
    private static final String POINTCUT_EXPRESSION = "execution(* org.tsubakice.mapper.*.*(..)) && @annotation(org.tsubakice.annotation.AutoFill)";

    @Pointcut(POINTCUT_EXPRESSION)
    public void autoFillPointCut() {
    }


    /**
     * 插入操作
     *
     * @param joinPoint 操作类型
     */
    @Before("autoFillPointCut()")
    public void insert(JoinPoint joinPoint) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        log.info("公共字段开始自动填充...操作类型{}", joinPoint.getSignature().getName());
        // 获取当前被拦截方法上的操作类型
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();//方法签名对象
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);
        OperationType value = autoFill.value();
        // 获取当前被拦截方法的参数, 即实体对象
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }
        Object entity = args[0];
        //准备赋值数据
        LocalDateTime now = LocalDateTime.now();
        //根据不同的操作类型，为对应的属性赋值
        if (value == OperationType.INSERT) {
            //为四个公共字段赋值
            Method setCreateTime=entity.getClass().getDeclaredMethod(SET_CREATE_TIME, LocalDateTime.class);
            Method setUpdateTime=entity.getClass().getDeclaredMethod(SET_UPDATE_TIME, LocalDateTime.class);

            //通过反射为对象赋值
            setCreateTime.invoke(entity, now);
            setUpdateTime.invoke(entity, now);
        } else if (value == OperationType.UPDATE) {
            //为两个公共字段赋值
            Method setUpdateTime=entity.getClass().getDeclaredMethod(SET_UPDATE_TIME, LocalDateTime.class);

            //通过反射为对象赋值
            setUpdateTime.invoke(entity, now);

        }
    }


}
