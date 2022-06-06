package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.QuittancePrime;
import com.ird.faa.ws.rest.provided.vo.QuittancePrimeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface QuittancePrimeChercheurService extends AbstractService<QuittancePrime,Long,QuittancePrimeVo>{





/**
    * delete QuittancePrime from database
    * @param id - id of QuittancePrime to be deleted
    *
    */
    int deleteById(Long id);


    List<QuittancePrime> findByContratNumAttestation(String numAttestation);

    int deleteByContratNumAttestation(String numAttestation);

    List<QuittancePrime> findByContratId(Long id);

    int deleteByContratId(Long id);







}
