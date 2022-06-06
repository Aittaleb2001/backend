package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.TypeSinistre;
import com.ird.faa.ws.rest.provided.vo.TypeSinistreVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeSinistreAdminService extends AbstractService<TypeSinistre,Long,TypeSinistreVo>{





/**
    * delete TypeSinistre from database
    * @param id - id of TypeSinistre to be deleted
    *
    */
    int deleteById(Long id);









}
