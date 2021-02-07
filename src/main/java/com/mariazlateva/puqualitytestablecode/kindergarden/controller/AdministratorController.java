package com.mariazlateva.puqualitytestablecode.kindergarden.controller;

import com.mariazlateva.puqualitytestablecode.kindergarden.domain.Administrator;
import com.mariazlateva.puqualitytestablecode.kindergarden.service.AdministratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.mariazlateva.puqualitytestablecode.kindergarden.util.AppConstants.MAPPING_ADMIN_BASE;

@Slf4j
@RestController
@RequestMapping(MAPPING_ADMIN_BASE)
public class AdministratorController {

    private final AdministratorService administratorService;

    @Autowired
    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Administrator> findAllAdmins(){
        return this.administratorService.findAllAdmins();
    }

}
