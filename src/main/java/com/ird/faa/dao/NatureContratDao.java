package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.NatureContrat;


@Repository
public interface NatureContratDao extends JpaRepository<NatureContrat,Long> {



@Query("SELECT item FROM NatureContrat item ")
List<NatureContrat> findAll();





}
