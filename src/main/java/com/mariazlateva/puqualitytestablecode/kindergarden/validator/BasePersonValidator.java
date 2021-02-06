package com.mariazlateva.puqualitytestablecode.kindergarden.validator;

import com.mariazlateva.puqualitytestablecode.kindergarden.basemodel.BasePerson;
import com.mariazlateva.puqualitytestablecode.kindergarden.exception.EntityValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.mariazlateva.puqualitytestablecode.kindergarden.util.AppConstants.*;

@Component
public class BasePersonValidator {

    private final BaseEntityValidator baseEntityValidator;

    @Autowired
    public BasePersonValidator(BaseEntityValidator baseEntityValidator) {
        this.baseEntityValidator = baseEntityValidator;
    }

    public void validate(BasePerson basePerson) throws EntityValidationException {

        this.baseEntityValidator.validate(basePerson);

        String firstName = basePerson.getFirstName();
        if (firstName == null) {
            throw new EntityValidationException(BASE_PERSON_FIRST_NAME_IS_NULL);
        }

        if (firstName.isBlank()) {
            throw new EntityValidationException(BASE_PERSON_FIRST_NAME_IS_EMPTY);
        }

        String lastName = basePerson.getLastName();
        if (lastName == null) {
            throw new EntityValidationException(BASE_PERSON_LAST_NAME_IS_NULL);
        }

        if (lastName.isBlank()) {
            throw new EntityValidationException(BASE_PERSON_LAST_NAME_IS_EMPTY);
        }
    }

}