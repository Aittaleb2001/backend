package com.ird.faa.service.agent.facade;

import java.util.List;
import com.ird.faa.bean.Sinistre;
import com.ird.faa.ws.rest.provided.vo.SinistreVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface SinistreAgentService extends AbstractService<Sinistre,Long,SinistreVo>{



    /**
    * find Sinistre from database by reference (reference)
    * @param reference - reference of Sinistre
    * @return the founded Sinistre , If no Sinistre were
    *         found in database return  null.
    */
    Sinistre findByReference(String reference);

    /**
    * find Sinistre from database by id (PK) or reference (reference)
    * @param id - id of Sinistre
    * @param reference - reference of Sinistre
    * @return the founded Sinistre , If no Sinistre were
    *         found in database return  null.
    */
    Sinistre findByIdOrReference(Sinistre sinistre);


/**
    * delete Sinistre from database
    * @param id - id of Sinistre to be deleted
    *
    */
    int deleteById(Long id);



    List<Sinistre> findByTypeSinistreId(Long id);

    int deleteByTypeSinistreId(Long id);
    List<Sinistre> findByClientReference(String reference);

    int deleteByClientReference(String reference);

    List<Sinistre> findByClientId(Long id);

    int deleteByClientId(Long id);


    /**
    * delete Sinistre from database by reference (reference)
    *
    * @param reference - reference of Sinistre to be deleted
    * @return 1 if Sinistre deleted successfully
    */
    int deleteByReference(String reference);





}
