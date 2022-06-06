package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Garantie;


@Repository
public interface GarantieDao extends JpaRepository<Garantie,Long> {



@Query("SELECT item FROM Garantie item ")
List<Garantie> findAll();





}
