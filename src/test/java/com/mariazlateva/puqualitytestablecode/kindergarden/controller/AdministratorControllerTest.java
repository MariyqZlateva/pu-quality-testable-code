package com.mariazlateva.puqualitytestablecode.kindergarden.controller;

import com.mariazlateva.puqualitytestablecode.kindergarden.domain.Administrator;
import com.mariazlateva.puqualitytestablecode.kindergarden.service.AdministratorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static com.mariazlateva.puqualitytestablecode.kindergarden.util.AppConstants.ADMIN_BASE_URL;
import static com.mariazlateva.puqualitytestablecode.kindergarden.util.AppConstants.API_BASE_URL;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AdministratorControllerTest {

    @Mock
    AdministratorService administratorService;

    @InjectMocks
    AdministratorController administratorController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(administratorController).build();
    }

    @Test
    void findAllAdmins() throws Exception {
        //given
        List<Administrator> administrators = new ArrayList<>();
        administrators.add(Administrator.builder().id(1L).firstName("Admin One").lastName("Admin One Last").build());
        administrators.add(Administrator.builder().id(2L).firstName("Admin Two").lastName("Admin Two Last").build());
        when(administratorService.findAllAdmins()).thenReturn(administrators);

        mockMvc.perform(get(API_BASE_URL + ADMIN_BASE_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void findAdminById() throws Exception {
        Administrator administrator = new Administrator(1L, "First", "Last");
        when(administratorService.findAdminById(anyLong())).thenReturn(administrator);

        mockMvc.perform(get(API_BASE_URL + ADMIN_BASE_URL + "/" + 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", equalTo("First")));
    }

}