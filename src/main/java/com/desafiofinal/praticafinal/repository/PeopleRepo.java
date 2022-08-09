package com.desafiofinal.praticafinal.repository;

import com.desafiofinal.praticafinal.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepo extends JpaRepository<Manager, Long> {
}
