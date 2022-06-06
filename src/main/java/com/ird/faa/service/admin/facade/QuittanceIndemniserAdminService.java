package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.QuittanceIndemniser;
import com.ird.faa.ws.rest.provided.vo.QuittanceIndemniserVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface QuittanceIndemniserAdminService extends AbstractService<QuittanceIndemniser,Long,QuittanceIndemniserVo>{



    /**
    * find QuittanceIndemniser from database by reference (reference)
    * @param reference - reference of QuittanceIndemniser
    * @return the founded QuittanceIndemniser , If no QuittanceIndemniser were
    *         found in database return  null.
    */
    QuittanceIndemniser findByReference(String reference);

    /**
    * find QuittanceIndemniser from database by id (PK) or reference (reference)
    * @param id - id of QuittanceIndemniser
    * @param reference - reference of QuittanceIndemniser
    * @return the founded QuittanceIndemniser , If no QuittanceIndemniser were
    *         found in database return  null.
    */
    QuittanceIndemniser findByIdOrReference(QuittanceIndemniser quittanceIndemniser);


/**
    * delete QuittanceIndemniser from database
    * @param id - id of QuittanceIndemniser to be deleted
    *
    */
    int deleteById(Long id);


    List<QuittanceIndemniser> findByDeviseReference(String reference);

    int deleteByDeviseReference(String reference);

    List<QuittanceIndemniser> findByDeviseId(Long id);

    int deleteByDeviseId(Long id);


    /**
    * delete QuittanceIndemniser from database by reference (reference)
    *
    * @param reference - reference of QuittanceIndemniser to be deleted
    * @return 1 if QuittanceIndemniser deleted successfully
    */
    int deleteByReference(String reference);





}
