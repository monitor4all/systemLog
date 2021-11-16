package cn.monitor4all.logRecord.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yangzhendong
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OperationLog {

    String bizId();

    String bizType();

    String msg() default "";

    String tag() default "operation";

    DataPipelineEnum pipeline();
}
