package com.mariazlateva.puqualitytestablecode.kindergarden.validator;

import com.mariazlateva.puqualitytestablecode.kindergarden.basemodel.BasePerson;
import com.mariazlateva.puqualitytestablecode.kindergarden.exception.EntityValidationException;

public class BasePersonValidator {

    public static void validate(BasePerson basePerson) throws EntityValidationException {

        BaseEntityValidator.validate(basePerson);

        String firstName = basePerson.getFirstName();
        if (firstName == null) {
            throw new EntityValidationException("First Name Is Null");
        }

        if (firstName.isBlank()) {
            throw new EntityValidationException("First Name Is Blank");
        }

        String lastName = basePerson.getLastName();
        if (lastName == null) {
            throw new EntityValidationException("Last Name Is Null");
        }

        if (lastName.isBlank()) {
            throw new EntityValidationException("Last Name Is Blank");
        }
    }

}