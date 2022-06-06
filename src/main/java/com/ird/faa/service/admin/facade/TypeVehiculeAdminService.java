package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.TypeVehicule;
import com.ird.faa.ws.rest.provided.vo.TypeVehiculeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeVehiculeAdminService extends AbstractService<TypeVehicule,Long,TypeVehiculeVo>{





/**
    * delete TypeVehicule from database
    * @param id - id of TypeVehicule to be deleted
    *
    */
    int deleteById(Long id);









}
