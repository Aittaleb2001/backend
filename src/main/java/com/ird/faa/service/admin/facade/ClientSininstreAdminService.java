package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.ClientSininstre;
import com.ird.faa.ws.rest.provided.vo.ClientSininstreVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ClientSininstreAdminService extends AbstractService<ClientSininstre,Long,ClientSininstreVo>{



    /**
    * find ClientSininstre from database by ref (reference)
    * @param ref - reference of ClientSininstre
    * @return the founded ClientSininstre , If no ClientSininstre were
    *         found in database return  null.
    */
    ClientSininstre findByRef(String ref);

    /**
    * find ClientSininstre from database by id (PK) or ref (reference)
    * @param id - id of ClientSininstre
    * @param ref - reference of ClientSininstre
    * @return the founded ClientSininstre , If no ClientSininstre were
    *         found in database return  null.
    */
    ClientSininstre findByIdOrRef(ClientSininstre clientSininstre);


/**
    * delete ClientSininstre from database
    * @param id - id of ClientSininstre to be deleted
    *
    */
    int deleteById(Long id);


    List<ClientSininstre> findByClientReference(String reference);

    int deleteByClientReference(String reference);

    List<ClientSininstre> findByClientId(Long id);

    int deleteByClientId(Long id);
    List<ClientSininstre> findBySinistreReference(String reference);

    int deleteBySinistreReference(String reference);

    List<ClientSininstre> findBySinistreId(Long id);

    int deleteBySinistreId(Long id);
    List<ClientSininstre> findByQuittanceIndemniserReference(String reference);

    int deleteByQuittanceIndemniserReference(String reference);

    List<ClientSininstre> findByQuittanceIndemniserId(Long id);

    int deleteByQuittanceIndemniserId(Long id);


    /**
    * delete ClientSininstre from database by ref (reference)
    *
    * @param ref - reference of ClientSininstre to be deleted
    * @return 1 if ClientSininstre deleted successfully
    */
    int deleteByRef(String ref);





}
