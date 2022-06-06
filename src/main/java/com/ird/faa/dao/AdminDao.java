package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Admin;


@Repository
public interface AdminDao extends JpaRepository<Admin,Long> {

    Admin findByUsername(String username);


@Query("SELECT item FROM Admin item ")
List<Admin> findAll();


    Admin findByNumeroMatricule(String numeroMatricule);

    int deleteByNumeroMatricule(String numeroMatricule);



}
