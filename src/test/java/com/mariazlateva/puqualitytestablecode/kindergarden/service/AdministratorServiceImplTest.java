package com.mariazlateva.puqualitytestablecode.kindergarden.service;

import com.mariazlateva.puqualitytestablecode.kindergarden.domain.Administrator;
import com.mariazlateva.puqualitytestablecode.kindergarden.exception.AdministratorNotFoundException;
import com.mariazlateva.puqualitytestablecode.kindergarden.repository.AdministratorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AdministratorServiceImplTest {

    @Mock
    AdministratorRepository administratorRepository;

    AdministratorServiceImpl administratorService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.administratorService = new AdministratorServiceImpl(this.administratorRepository);
    }

    @Test
    void findAllAdmins() {
        //given
        List<Administrator> administrators = new ArrayList<>();
        administrators.add(Administrator.builder().id(1L).firstName("Admin One").lastName("Admin One Last").build());
        administrators.add(Administrator.builder().id(2L).firstName("Admin Two").lastName("Admin Two Last").build());
        when(this.administratorRepository.findAll()).thenReturn(administrators);

        //when
        List<Administrator> receivedAdmins = this.administratorService.findAllAdmins();

        //then
        assertEquals(2L, receivedAdmins.size());
        verify(administratorRepository).findAll();

    }

    @Test
    void findAdminById() {
        //given
        Administrator admin = Administrator.builder()
                .id(1L)
                .firstName("Admin One")
                .lastName("Admin One Last")
                .build();
        when(this.administratorRepository.findById(anyLong())).thenReturn(Optional.ofNullable(admin));

        //when
        Administrator administrator = this.administratorService.findAdminById(1L);

        //then
        assertNotNull(administrator);
        assertEquals("Admin One", administrator.getFirstName());
        verify(administratorRepository).findById(anyLong());
    }

    @Test
    void findAdminByIdNotFound() {
        //given
        String expectedMessage = "Admin with ID = 1 not found";
        when(this.administratorRepository.findById(anyLong())).thenReturn(Optional.empty());

        //when
       Exception exception = assertThrows(AdministratorNotFoundException.class,
                () -> this.administratorService.findAdminById(1L));
        //then
        assertEquals(exception.getMessage(), expectedMessage);
    }

}