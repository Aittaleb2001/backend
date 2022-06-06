package com.ird.faa.service.agent.facade;

import java.util.List;
import com.ird.faa.bean.Gestionnaire;
import com.ird.faa.ws.rest.provided.vo.GestionnaireVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface GestionnaireAgentService extends AbstractService<Gestionnaire,Long,GestionnaireVo>{

    Gestionnaire findByUsername(String username);


    /**
    * find Gestionnaire from database by reference (reference)
    * @param reference - reference of Gestionnaire
    * @return the founded Gestionnaire , If no Gestionnaire were
    *         found in database return  null.
    */
    Gestionnaire findByReference(String reference);

    /**
    * find Gestionnaire from database by id (PK) or reference (reference)
    * @param id - id of Gestionnaire
    * @param reference - reference of Gestionnaire
    * @return the founded Gestionnaire , If no Gestionnaire were
    *         found in database return  null.
    */
    Gestionnaire findByIdOrReference(Gestionnaire gestionnaire);


/**
    * delete Gestionnaire from database
    * @param id - id of Gestionnaire to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Gestionnaire from database by reference (reference)
    *
    * @param reference - reference of Gestionnaire to be deleted
    * @return 1 if Gestionnaire deleted successfully
    */
    int deleteByReference(String reference);





}
