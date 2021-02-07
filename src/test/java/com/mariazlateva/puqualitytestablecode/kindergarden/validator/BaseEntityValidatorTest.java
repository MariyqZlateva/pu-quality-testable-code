package com.mariazlateva.puqualitytestablecode.kindergarden.validator;

import com.mariazlateva.puqualitytestablecode.kindergarden.basemodel.BaseEntity;
import com.mariazlateva.puqualitytestablecode.kindergarden.domain.Administrator;
import com.mariazlateva.puqualitytestablecode.kindergarden.exception.EntityValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.mariazlateva.puqualitytestablecode.kindergarden.util.AppConstants.BASE_ENTITY_ID_IS_NULL;
import static com.mariazlateva.puqualitytestablecode.kindergarden.util.AppConstants.BASE_ENTITY_IS_NULL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_PLACEHOLDER;

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

    @ParameterizedTest(name = ARGUMENTS_PLACEHOLDER)
    @MethodSource("baseEntityProvider")
    void validateParameterized(BaseEntity baseEntity, String expectedMessage) {
        Exception exception = assertThrows(EntityValidationException.class,
                () -> this.baseEntityValidator.validate(baseEntity));
        String exceptionMessage = exception.getMessage();
        assertEquals(expectedMessage, exceptionMessage);
    }

    //==private methods==
    private static Stream<Arguments> baseEntityProvider() {
        return Stream.of(
                Arguments.of(null, BASE_ENTITY_IS_NULL),
                Arguments.of(Administrator.builder().id(null).build(), BASE_ENTITY_ID_IS_NULL)
        );

    }

}