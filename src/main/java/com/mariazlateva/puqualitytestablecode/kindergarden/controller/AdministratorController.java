package com.mariazlateva.puqualitytestablecode.kindergarden.controller;

import com.mariazlateva.puqualitytestablecode.kindergarden.domain.Administrator;
import com.mariazlateva.puqualitytestablecode.kindergarden.service.AdministratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mariazlateva.puqualitytestablecode.kindergarden.util.AppConstants.ADMIN_BASE_URL;
import static com.mariazlateva.puqualitytestablecode.kindergarden.util.AppConstants.API_BASE_URL;

@Slf4j
@RestController
@RequestMapping(API_BASE_URL + ADMIN_BASE_URL)
public class AdministratorController {

    private final AdministratorService administratorService;

    @Autowired
    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Administrator> findAllAdmins() {
        return this.administratorService.findAllAdmins();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Administrator findAdminById(@PathVariable String id) {
        return this.administratorService.findAdminById(Long.valueOf(id));
    }

}
