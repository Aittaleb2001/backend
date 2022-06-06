package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Vehicule;


@Repository
public interface VehiculeDao extends JpaRepository<Vehicule,Long> {



@Query("SELECT item FROM Vehicule item ")
List<Vehicule> findAll();


    Vehicule findByReference(String reference);

    int deleteByReference(String reference);


    List<Vehicule> findByCarburantId(Long id);

    int deleteByCarburantId(Long id);

    List<Vehicule> findByTypeVehiculeId(Long id);

    int deleteByTypeVehiculeId(Long id);
    List<Vehicule> findByClientReference(String reference);
    int deleteByClientReference(String reference);

    List<Vehicule> findByClientId(Long id);

    int deleteByClientId(Long id);
    List<Vehicule> findByContratNumAttestation(String numAttestation);
    int deleteByContratNumAttestation(String numAttestation);

    List<Vehicule> findByContratId(Long id);

    int deleteByContratId(Long id);

    List<Vehicule> findByMarqueId(Long id);

    int deleteByMarqueId(Long id);


}
