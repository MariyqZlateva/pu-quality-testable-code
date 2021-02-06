package com.mariazlateva.puqualitytestablecode.kindergarden.validator;

import com.mariazlateva.puqualitytestablecode.kindergarden.domain.Administrator;
import com.mariazlateva.puqualitytestablecode.kindergarden.exception.EntityValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.mariazlateva.puqualitytestablecode.kindergarden.util.AppConstants.BASE_ENTITY_ID_IS_NULL;
import static com.mariazlateva.puqualitytestablecode.kindergarden.util.AppConstants.BASE_ENTITY_IS_NULL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BaseEntityValidatorTest {


    BaseEntityValidator baseEntityValidator;

    @BeforeEach
    void setUp() {
        this.baseEntityValidator = new BaseEntityValidator();
    }

    @Test
    void validateEntityOk() throws EntityValidationException {
        //given
        Administrator administrator = Administrator.builder().id(1L).build();
        //when then
        this.baseEntityValidator.validate(administrator);
    }

    @Test
    void validateEntityIsNull() {
        //given when
        Exception exception = assertThrows(EntityValidationException.class,
                () -> this.baseEntityValidator.validate(null));
        //then
        String exceptionMessage = exception.getMessage();
        assertEquals(BASE_ENTITY_IS_NULL, exceptionMessage);
    }

    @Test
    void validateEntityIdIsNull() {
        //given
        Administrator administrator = Administrator.builder().id(null).build();
        //when then
        Exception exception = assertThrows(EntityValidationException.class,
                () -> this.baseEntityValidator.validate(administrator));

        String exceptionMessage = exception.getMessage();
        assertEquals(BASE_ENTITY_ID_IS_NULL, exceptionMessage);
    }
}