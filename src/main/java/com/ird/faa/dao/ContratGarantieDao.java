package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.ContratGarantie;


@Repository
public interface ContratGarantieDao extends JpaRepository<ContratGarantie,Long> {



@Query("SELECT item FROM ContratGarantie item ")
List<ContratGarantie> findAll();



    List<ContratGarantie> findByContratNumAttestation(String numAttestation);
    int deleteByContratNumAttestation(String numAttestation);

    List<ContratGarantie> findByContratId(Long id);

    int deleteByContratId(Long id);

    List<ContratGarantie> findByGarantieId(Long id);

    int deleteByGarantieId(Long id);


}
