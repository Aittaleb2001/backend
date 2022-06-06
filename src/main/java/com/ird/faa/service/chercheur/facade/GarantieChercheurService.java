package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Garantie;
import com.ird.faa.ws.rest.provided.vo.GarantieVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface GarantieChercheurService extends AbstractService<Garantie,Long,GarantieVo>{





/**
    * delete Garantie from database
    * @param id - id of Garantie to be deleted
    *
    */
    int deleteById(Long id);









}
