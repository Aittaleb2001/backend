package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Devise;
import com.ird.faa.ws.rest.provided.vo.DeviseVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface DeviseChercheurService extends AbstractService<Devise,Long,DeviseVo>{



    /**
    * find Devise from database by reference (reference)
    * @param reference - reference of Devise
    * @return the founded Devise , If no Devise were
    *         found in database return  null.
    */
    Devise findByReference(String reference);

    /**
    * find Devise from database by id (PK) or reference (reference)
    * @param id - id of Devise
    * @param reference - reference of Devise
    * @return the founded Devise , If no Devise were
    *         found in database return  null.
    */
    Devise findByIdOrReference(Devise devise);


/**
    * delete Devise from database
    * @param id - id of Devise to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Devise from database by reference (reference)
    *
    * @param reference - reference of Devise to be deleted
    * @return 1 if Devise deleted successfully
    */
    int deleteByReference(String reference);





}
