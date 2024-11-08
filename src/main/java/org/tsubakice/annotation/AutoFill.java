package org.tsubakice.annotation;





import org.tsubakice.resource.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，用于标识自动填充的公共字段
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AutoFill {
    // 数据库操作类型 UPDATE INSERT
    OperationType value();
}
