package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.QuittanceIndemniser;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface QuittanceIndemniserDao extends JpaRepository<QuittanceIndemniser,Long> {



@Query("SELECT item FROM QuittanceIndemniser item ORDER BY item.dateAjout ASC ")
List<QuittanceIndemniser> findAll();


    QuittanceIndemniser findByReference(String reference);

    int deleteByReference(String reference);

    List<QuittanceIndemniser> findByDeviseReference(String reference);
    int deleteByDeviseReference(String reference);

    List<QuittanceIndemniser> findByDeviseId(Long id);

    int deleteByDeviseId(Long id);


}
