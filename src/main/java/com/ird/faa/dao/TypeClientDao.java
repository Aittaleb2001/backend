package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.TypeClient;


@Repository
public interface TypeClientDao extends JpaRepository<TypeClient,Long> {



@Query("SELECT item FROM TypeClient item ")
List<TypeClient> findAll();





}
