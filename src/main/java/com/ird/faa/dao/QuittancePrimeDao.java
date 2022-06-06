package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.QuittancePrime;


@Repository
public interface QuittancePrimeDao extends JpaRepository<QuittancePrime,Long> {



@Query("SELECT item FROM QuittancePrime item ")
List<QuittancePrime> findAll();



    List<QuittancePrime> findByContratNumAttestation(String numAttestation);
    int deleteByContratNumAttestation(String numAttestation);

    List<QuittancePrime> findByContratId(Long id);

    int deleteByContratId(Long id);


}
