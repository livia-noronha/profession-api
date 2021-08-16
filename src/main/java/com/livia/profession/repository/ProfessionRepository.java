package com.livia.profession.repository;

import com.livia.profession.modelo.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {

}
