package com.ird.faa.service.gestionnaire.facade;

import java.util.List;
import com.ird.faa.bean.NatureContrat;
import com.ird.faa.ws.rest.provided.vo.NatureContratVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface NatureContratGestionnaireService extends AbstractService<NatureContrat,Long,NatureContratVo>{





/**
    * delete NatureContrat from database
    * @param id - id of NatureContrat to be deleted
    *
    */
    int deleteById(Long id);









}
