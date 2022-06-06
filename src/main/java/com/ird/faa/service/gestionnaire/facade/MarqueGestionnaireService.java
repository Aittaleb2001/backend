package com.ird.faa.service.gestionnaire.facade;

import java.util.List;
import com.ird.faa.bean.Marque;
import com.ird.faa.ws.rest.provided.vo.MarqueVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface MarqueGestionnaireService extends AbstractService<Marque,Long,MarqueVo>{





/**
    * delete Marque from database
    * @param id - id of Marque to be deleted
    *
    */
    int deleteById(Long id);









}
