package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Contrat;
import com.ird.faa.ws.rest.provided.vo.ContratVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ContratChercheurService extends AbstractService<Contrat,Long,ContratVo>{



    /**
    * find Contrat from database by numAttestation (reference)
    * @param numAttestation - reference of Contrat
    * @return the founded Contrat , If no Contrat were
    *         found in database return  null.
    */
    Contrat findByNumAttestation(String numAttestation);

    /**
    * find Contrat from database by id (PK) or numAttestation (reference)
    * @param id - id of Contrat
    * @param numAttestation - reference of Contrat
    * @return the founded Contrat , If no Contrat were
    *         found in database return  null.
    */
    Contrat findByIdOrNumAttestation(Contrat contrat);


/**
    * delete Contrat from database
    * @param id - id of Contrat to be deleted
    *
    */
    int deleteById(Long id);



    List<Contrat> findByQuittancePrimeId(Long id);

    int deleteByQuittancePrimeId(Long id);

    List<Contrat> findByNatureContratId(Long id);

    int deleteByNatureContratId(Long id);
    List<Contrat> findByVehiculeReference(String reference);

    int deleteByVehiculeReference(String reference);

    List<Contrat> findByVehiculeId(Long id);

    int deleteByVehiculeId(Long id);
    List<Contrat> findByClientReference(String reference);

    int deleteByClientReference(String reference);

    List<Contrat> findByClientId(Long id);

    int deleteByClientId(Long id);


    /**
    * delete Contrat from database by numAttestation (reference)
    *
    * @param numAttestation - reference of Contrat to be deleted
    * @return 1 if Contrat deleted successfully
    */
    int deleteByNumAttestation(String numAttestation);





}
