package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Carburant;


@Repository
public interface CarburantDao extends JpaRepository<Carburant,Long> {



@Query("SELECT item FROM Carburant item ")
List<Carburant> findAll();





}
