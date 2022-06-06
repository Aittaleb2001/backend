package com.ird.faa.service.agent.facade;

import java.util.List;
import com.ird.faa.bean.Vehicule;
import com.ird.faa.ws.rest.provided.vo.VehiculeVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface VehiculeAgentService extends AbstractService<Vehicule,Long,VehiculeVo>{



    /**
    * find Vehicule from database by reference (reference)
    * @param reference - reference of Vehicule
    * @return the founded Vehicule , If no Vehicule were
    *         found in database return  null.
    */
    Vehicule findByReference(String reference);

    /**
    * find Vehicule from database by id (PK) or reference (reference)
    * @param id - id of Vehicule
    * @param reference - reference of Vehicule
    * @return the founded Vehicule , If no Vehicule were
    *         found in database return  null.
    */
    Vehicule findByIdOrReference(Vehicule vehicule);


/**
    * delete Vehicule from database
    * @param id - id of Vehicule to be deleted
    *
    */
    int deleteById(Long id);



    List<Vehicule> findByCarburantId(Long id);

    int deleteByCarburantId(Long id);

    List<Vehicule> findByTypeVehiculeId(Long id);

    int deleteByTypeVehiculeId(Long id);
    List<Vehicule> findByClientReference(String reference);

    int deleteByClientReference(String reference);

    List<Vehicule> findByClientId(Long id);

    int deleteByClientId(Long id);
    List<Vehicule> findByContratNumAttestation(String numAttestation);

    int deleteByContratNumAttestation(String numAttestation);

    List<Vehicule> findByContratId(Long id);

    int deleteByContratId(Long id);

    List<Vehicule> findByMarqueId(Long id);

    int deleteByMarqueId(Long id);


    /**
    * delete Vehicule from database by reference (reference)
    *
    * @param reference - reference of Vehicule to be deleted
    * @return 1 if Vehicule deleted successfully
    */
    int deleteByReference(String reference);





}
