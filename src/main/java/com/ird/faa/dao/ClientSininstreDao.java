package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.ClientSininstre;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface ClientSininstreDao extends JpaRepository<ClientSininstre,Long> {



@Query("SELECT item FROM ClientSininstre item ORDER BY item.dateSinistre ASC ")
List<ClientSininstre> findAll();


    ClientSininstre findByRef(String ref);

    int deleteByRef(String ref);

    List<ClientSininstre> findByClientReference(String reference);
    int deleteByClientReference(String reference);

    List<ClientSininstre> findByClientId(Long id);

    int deleteByClientId(Long id);
    List<ClientSininstre> findBySinistreReference(String reference);
    int deleteBySinistreReference(String reference);

    List<ClientSininstre> findBySinistreId(Long id);

    int deleteBySinistreId(Long id);
    List<ClientSininstre> findByQuittanceIndemniserReference(String reference);
    int deleteByQuittanceIndemniserReference(String reference);

    List<ClientSininstre> findByQuittanceIndemniserId(Long id);

    int deleteByQuittanceIndemniserId(Long id);


}
