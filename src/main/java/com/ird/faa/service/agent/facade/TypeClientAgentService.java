package com.ird.faa.service.agent.facade;

import java.util.List;
import com.ird.faa.bean.TypeClient;
import com.ird.faa.ws.rest.provided.vo.TypeClientVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeClientAgentService extends AbstractService<TypeClient,Long,TypeClientVo>{





/**
    * delete TypeClient from database
    * @param id - id of TypeClient to be deleted
    *
    */
    int deleteById(Long id);









}
