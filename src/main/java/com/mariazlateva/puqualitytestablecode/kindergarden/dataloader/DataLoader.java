package com.mariazlateva.puqualitytestablecode.kindergarden.dataloader;

import com.mariazlateva.puqualitytestablecode.kindergarden.domain.Administrator;
import com.mariazlateva.puqualitytestablecode.kindergarden.repository.AdministratorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final AdministratorRepository administratorRepository;

    @Autowired
    public DataLoader(AdministratorRepository administratorRepository) {
        this.administratorRepository = administratorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadAdmins();


    }

    private void loadAdmins() {

        if (administratorRepository.count() != 0) {
            return;
        }

        List<Administrator> administratorList = new ArrayList<>();
        administratorList.add(Administrator.builder().id(1L).firstName("Peter").lastName("Petrov").build());
        administratorList.add(Administrator.builder().id(2L).firstName("Ivan").lastName("Ivanov").build());
        administratorList.add(Administrator.builder().id(3L).firstName("Ilia").lastName("Nikolov").build());
        administratorList.add(Administrator.builder().id(4L).firstName("Qna").lastName("Malinova").build());

        this.administratorRepository.saveAll(administratorList);
        log.info("Administrators was loaded");
    }

}
