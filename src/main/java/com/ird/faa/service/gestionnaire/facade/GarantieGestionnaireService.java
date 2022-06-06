package com.ird.faa.service.gestionnaire.facade;

import java.util.List;
import com.ird.faa.bean.Garantie;
import com.ird.faa.ws.rest.provided.vo.GarantieVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface GarantieGestionnaireService extends AbstractService<Garantie,Long,GarantieVo>{





/**
    * delete Garantie from database
    * @param id - id of Garantie to be deleted
    *
    */
    int deleteById(Long id);









}
