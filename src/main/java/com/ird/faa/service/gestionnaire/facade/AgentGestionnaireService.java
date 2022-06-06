package com.ird.faa.service.gestionnaire.facade;

import java.util.List;
import com.ird.faa.bean.Agent;
import com.ird.faa.ws.rest.provided.vo.AgentVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface AgentGestionnaireService extends AbstractService<Agent,Long,AgentVo>{

    Agent findByUsername(String username);


    /**
    * find Agent from database by reference (reference)
    * @param reference - reference of Agent
    * @return the founded Agent , If no Agent were
    *         found in database return  null.
    */
    Agent findByReference(String reference);

    /**
    * find Agent from database by id (PK) or reference (reference)
    * @param id - id of Agent
    * @param reference - reference of Agent
    * @return the founded Agent , If no Agent were
    *         found in database return  null.
    */
    Agent findByIdOrReference(Agent agent);


/**
    * delete Agent from database
    * @param id - id of Agent to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Agent from database by reference (reference)
    *
    * @param reference - reference of Agent to be deleted
    * @return 1 if Agent deleted successfully
    */
    int deleteByReference(String reference);





}
