package com.mariazlateva.puqualitytestablecode.kindergarden.validator;

import com.mariazlateva.puqualitytestablecode.kindergarden.basemodel.BaseEntity;
import com.mariazlateva.puqualitytestablecode.kindergarden.basemodel.BasePerson;
import com.mariazlateva.puqualitytestablecode.kindergarden.domain.Administrator;
import com.mariazlateva.puqualitytestablecode.kindergarden.exception.EntityValidationException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.stream.Stream;

import static com.mariazlateva.puqualitytestablecode.kindergarden.util.AppConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_PLACEHOLDER;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Slf4j
class BasePersonValidatorTest {

    @Mock
    BaseEntityValidator baseEntityValidator;

    BasePersonValidator basePersonValidator;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.basePersonValidator = new BasePersonValidator(baseEntityValidator);
    }

    @Test
    void validateBasePersonIsOK() throws EntityValidationException {
        //given
        Administrator admin = Administrator.builder()
                .id(1L)
                .firstName("Admin One")
                .lastName("Admin One Last")
                .build();
        //when then
        this.basePersonValidator.validate(admin);
        verify(baseEntityValidator, times(1)).validate(any(BaseEntity.class));
    }


    @ParameterizedTest(name = ARGUMENTS_PLACEHOLDER)
    @MethodSource("basePersonProvider")
    void validateParameterized(BasePerson basePerson, String expectedMessage) {
        Exception exception = assertThrows(EntityValidationException.class,
                () -> this.basePersonValidator.validate(basePerson));
        String exceptionMessage = exception.getMessage();
        assertEquals(expectedMessage, exceptionMessage);
    }

    //== private methods ==
    private static Stream<Arguments> basePersonProvider() {
        return Stream.of(
                Arguments.of(Administrator.builder().id(1L).firstName(null).lastName("Admin One Last").build(), BASE_PERSON_FIRST_NAME_IS_NULL),
                Arguments.of(Administrator.builder().id(1L).firstName("Admin One").lastName(null).build(), BASE_PERSON_LAST_NAME_IS_NULL),
                Arguments.of(Administrator.builder().id(1L).firstName("").lastName("Admin One Last").build(), BASE_PERSON_FIRST_NAME_IS_EMPTY),
                Arguments.of(Administrator.builder().id(1L).firstName("Admin One").lastName("").build(), BASE_PERSON_LAST_NAME_IS_EMPTY)
        );
    }

}