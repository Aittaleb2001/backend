package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Contrat;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface ContratDao extends JpaRepository<Contrat,Long> {



@Query("SELECT item FROM Contrat item ORDER BY item.dateSignature ASC ")
List<Contrat> findAll();


    Contrat findByNumAttestation(String numAttestation);

    int deleteByNumAttestation(String numAttestation);


    List<Contrat> findByQuittancePrimeId(Long id);

    int deleteByQuittancePrimeId(Long id);

    List<Contrat> findByNatureContratId(Long id);

    int deleteByNatureContratId(Long id);
    List<Contrat> findByVehiculeReference(String reference);
    int deleteByVehiculeReference(String reference);

    List<Contrat> findByVehiculeId(Long id);

    int deleteByVehiculeId(Long id);
    List<Contrat> findByClientReference(String reference);
    int deleteByClientReference(String reference);

    List<Contrat> findByClientId(Long id);

    int deleteByClientId(Long id);


}
