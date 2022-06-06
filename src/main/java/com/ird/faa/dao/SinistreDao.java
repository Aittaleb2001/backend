package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Sinistre;


@Repository
public interface SinistreDao extends JpaRepository<Sinistre,Long> {



@Query("SELECT item FROM Sinistre item ")
List<Sinistre> findAll();


    Sinistre findByReference(String reference);

    int deleteByReference(String reference);


    List<Sinistre> findByTypeSinistreId(Long id);

    int deleteByTypeSinistreId(Long id);
    List<Sinistre> findByClientReference(String reference);
    int deleteByClientReference(String reference);

    List<Sinistre> findByClientId(Long id);

    int deleteByClientId(Long id);


}
