package com.mariazlateva.puqualitytestablecode.kindergarden.service;

import com.mariazlateva.puqualitytestablecode.kindergarden.domain.Administrator;
import com.mariazlateva.puqualitytestablecode.kindergarden.exception.AdministratorNotFoundException;
import com.mariazlateva.puqualitytestablecode.kindergarden.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mariazlateva.puqualitytestablecode.kindergarden.util.AppConstants.ADMIN_NOT_FOUND;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public AdministratorServiceImpl(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public List<Administrator> findAllAdmins() {
        return this.administratorRepository.findAll();
    }

    @Override
    public Administrator findAdminById(Long id) {
        return this.administratorRepository
                .findById(id)
                .orElseThrow(() -> new AdministratorNotFoundException(String.format(ADMIN_NOT_FOUND, id)));
    }
}
