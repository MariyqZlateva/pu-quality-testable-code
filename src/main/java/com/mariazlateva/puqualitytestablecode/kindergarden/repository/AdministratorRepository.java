package com.mariazlateva.puqualitytestablecode.kindergarden.repository;

import com.mariazlateva.puqualitytestablecode.kindergarden.domain.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long>{

}
