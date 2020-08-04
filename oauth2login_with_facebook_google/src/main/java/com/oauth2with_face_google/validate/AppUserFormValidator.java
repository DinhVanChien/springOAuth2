package com.oauth2with_face_google.validate;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
public class AppUserFormValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
