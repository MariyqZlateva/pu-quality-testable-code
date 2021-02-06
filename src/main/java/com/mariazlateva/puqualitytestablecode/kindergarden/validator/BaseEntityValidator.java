package com.mariazlateva.puqualitytestablecode.kindergarden.validator;

import com.mariazlateva.puqualitytestablecode.kindergarden.basemodel.BaseEntity;
import com.mariazlateva.puqualitytestablecode.kindergarden.exception.EntityValidationException;

public class BaseEntityValidator {

    public static void validate(BaseEntity entity) throws EntityValidationException {
        if (entity == null){
            throw new EntityValidationException("Entity is null");
        }
        if(entity.getId() == null){
            throw new EntityValidationException("Entity id is null");
        }
    }
}
