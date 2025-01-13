package com.posgre.posgredbapp.repository;

import com.posgre.posgredbapp.model.Dueño;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDueñoRepository extends JpaRepository<Dueño, Long> {
}