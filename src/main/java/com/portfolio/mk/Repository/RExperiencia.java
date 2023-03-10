package com.portfolio.mk.Repository;

import com.portfolio.mk.Entity.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer> {
    public Optional<Experiencia>findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
