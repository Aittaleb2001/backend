package com.ird.faa.service.gestionnaire.facade;

import java.util.List;
import com.ird.faa.bean.ContratGarantie;
import com.ird.faa.ws.rest.provided.vo.ContratGarantieVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ContratGarantieGestionnaireService extends AbstractService<ContratGarantie,Long,ContratGarantieVo>{





/**
    * delete ContratGarantie from database
    * @param id - id of ContratGarantie to be deleted
    *
    */
    int deleteById(Long id);


    List<ContratGarantie> findByContratNumAttestation(String numAttestation);

    int deleteByContratNumAttestation(String numAttestation);

    List<ContratGarantie> findByContratId(Long id);

    int deleteByContratId(Long id);

    List<ContratGarantie> findByGarantieId(Long id);

    int deleteByGarantieId(Long id);







}
