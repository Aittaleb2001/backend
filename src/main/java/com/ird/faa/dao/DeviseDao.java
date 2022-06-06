package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Devise;


@Repository
public interface DeviseDao extends JpaRepository<Devise,Long> {



@Query("SELECT item FROM Devise item ")
List<Devise> findAll();


    Devise findByReference(String reference);

    int deleteByReference(String reference);



}
