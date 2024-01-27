package com.itheima.anno;

import com.itheima.validation.StateValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotEmpty;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented//元注解
@Constraint(validatedBy = {StateValidation.class})//指定校验规则的类
@Target({FIELD})//元注解
@Retention(RUNTIME)//元注解
public @interface State {
    //提供校验失败后的提示信息
    String message() default "state参数的属性只能是已发布/草稿";
    //指定分组
    Class<?>[] groups() default { };
    //负载 获取到State注解的附加信息,不用太关注
    Class<? extends Payload>[] payload() default { };
}
