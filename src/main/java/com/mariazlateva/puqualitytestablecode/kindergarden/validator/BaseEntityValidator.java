package com.mariazlateva.puqualitytestablecode.kindergarden.validator;

import com.mariazlateva.puqualitytestablecode.kindergarden.basemodel.BaseEntity;
import com.mariazlateva.puqualitytestablecode.kindergarden.exception.EntityValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.mariazlateva.puqualitytestablecode.kindergarden.util.AppConstants.BASE_ENTITY_ID_IS_NULL;
import static com.mariazlateva.puqualitytestablecode.kindergarden.util.AppConstants.BASE_ENTITY_IS_NULL;

@Slf4j
@Component
public class BaseEntityValidator {

    /**
     * validate BaseEntity fields
     * @param entity of type BaseEntity
     * @throws EntityValidationException if entity is null
     * @throws EntityValidationException if entity id is null
     */
    public void validate(BaseEntity entity) throws EntityValidationException {
        if (entity == null) {
            throw new EntityValidationException(BASE_ENTITY_IS_NULL);
        }
        if (entity.getId() == null) {
            throw new EntityValidationException(BASE_ENTITY_ID_IS_NULL);
        }
    }
}
