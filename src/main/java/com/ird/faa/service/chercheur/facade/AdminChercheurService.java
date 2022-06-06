package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Admin;
import com.ird.faa.ws.rest.provided.vo.AdminVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface AdminChercheurService extends AbstractService<Admin,Long,AdminVo>{

    Admin findByUsername(String username);


    /**
    * find Admin from database by numeroMatricule (reference)
    * @param numeroMatricule - reference of Admin
    * @return the founded Admin , If no Admin were
    *         found in database return  null.
    */
    Admin findByNumeroMatricule(String numeroMatricule);

    /**
    * find Admin from database by id (PK) or numeroMatricule (reference)
    * @param id - id of Admin
    * @param numeroMatricule - reference of Admin
    * @return the founded Admin , If no Admin were
    *         found in database return  null.
    */
    Admin findByIdOrNumeroMatricule(Admin admin);


/**
    * delete Admin from database
    * @param id - id of Admin to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Admin from database by numeroMatricule (reference)
    *
    * @param numeroMatricule - reference of Admin to be deleted
    * @return 1 if Admin deleted successfully
    */
    int deleteByNumeroMatricule(String numeroMatricule);





}
