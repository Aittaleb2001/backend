package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Client;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface ClientDao extends JpaRepository<Client,Long> {



@Query("SELECT item FROM Client item ORDER BY item.datedeNaissance ASC ")
List<Client> findAll();


    Client findByReference(String reference);

    int deleteByReference(String reference);


    List<Client> findByTypeClientId(Long id);

    int deleteByTypeClientId(Long id);


}
