package com.example.cf_api.repository;

import com.example.cf_api.entity.CittadinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CittadinoRepo extends JpaRepository<CittadinoEntity, Integer> {
    Optional<CittadinoEntity> findByCodiceFiscale(String codiceFiscale);
}
