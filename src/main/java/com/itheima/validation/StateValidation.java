package com.itheima.validation;

import com.itheima.anno.State;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //提供校验规则,返回false校验不通过
        if(value == null){
            return false;
        }
        if (value.equals("已发布")||value.equals("草稿")){
            return true;
        }
        return false;
    }
}
