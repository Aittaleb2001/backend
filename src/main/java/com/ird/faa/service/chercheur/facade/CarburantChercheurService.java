package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Carburant;
import com.ird.faa.ws.rest.provided.vo.CarburantVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CarburantChercheurService extends AbstractService<Carburant,Long,CarburantVo>{





/**
    * delete Carburant from database
    * @param id - id of Carburant to be deleted
    *
    */
    int deleteById(Long id);









}
