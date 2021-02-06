package com.mariazlateva.puqualitytestablecode.kindergarden.service;

import com.mariazlateva.puqualitytestablecode.kindergarden.domain.Administrator;

import java.util.List;

public interface AdministratorService {
    List<Administrator> findAllAdmins();

    Administrator findAdminById(Long id);
}
