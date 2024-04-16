package com.example.challenge.repository;

import com.example.challenge.entity.HistoricoChamadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoChamadasRepository extends JpaRepository<HistoricoChamadas, Long> {
}
