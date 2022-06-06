package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Gestionnaire;


@Repository
public interface GestionnaireDao extends JpaRepository<Gestionnaire,Long> {

    Gestionnaire findByUsername(String username);


@Query("SELECT item FROM Gestionnaire item ")
List<Gestionnaire> findAll();


    Gestionnaire findByReference(String reference);

    int deleteByReference(String reference);



}
