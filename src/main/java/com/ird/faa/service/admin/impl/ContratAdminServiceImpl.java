package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Contrat;
        import com.ird.faa.bean.QuittancePrime;
        import com.ird.faa.bean.NatureContrat;
        import com.ird.faa.bean.Vehicule;
        import com.ird.faa.bean.Client;
        import com.ird.faa.bean.ContratGarantie;
import com.ird.faa.dao.ContratDao;
import com.ird.faa.service.admin.facade.ContratAdminService;
        import com.ird.faa.service.admin.facade.VehiculeAdminService;
        import com.ird.faa.service.admin.facade.NatureContratAdminService;
        import com.ird.faa.service.admin.facade.QuittancePrimeAdminService;
        import com.ird.faa.service.admin.facade.ClientAdminService;
        import com.ird.faa.service.admin.facade.ContratGarantieAdminService;

import com.ird.faa.ws.rest.provided.vo.ContratVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.ContratGarantie;
        import com.ird.faa.service.admin.facade.ContratGarantieAdminService;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ContratAdminServiceImpl extends AbstractServiceImpl<Contrat> implements ContratAdminService {

@Autowired
private ContratDao contratDao;

        @Autowired
        private VehiculeAdminService vehiculeService ;
        @Autowired
        private NatureContratAdminService natureContratService ;
        @Autowired
        private QuittancePrimeAdminService quittancePrimeService ;
        @Autowired
        private ClientAdminService clientService ;
        @Autowired
        private ContratGarantieAdminService contratGarantieService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Contrat> findAll(){
        return contratDao.findAll();
}
        @Override
        public List<Contrat> findByQuittancePrimeId(Long id){
        return contratDao.findByQuittancePrimeId(id);
        }

        @Override
        @Transactional
        public int deleteByQuittancePrimeId(Long id){
        return contratDao.deleteByQuittancePrimeId(id);
        }

        @Override
        public List<Contrat> findByNatureContratId(Long id){
        return contratDao.findByNatureContratId(id);
        }

        @Override
        @Transactional
        public int deleteByNatureContratId(Long id){
        return contratDao.deleteByNatureContratId(id);
        }


        @Override
        public List<Contrat> findByVehiculeReference(String reference){
        return contratDao.findByVehiculeReference(reference);
        }

        @Override
        @Transactional
        public int deleteByVehiculeReference(String reference){
        return contratDao.deleteByVehiculeReference(reference);
        }

        @Override
        public List<Contrat> findByVehiculeId(Long id){
        return contratDao.findByVehiculeId(id);
        }

        @Override
        @Transactional
        public int deleteByVehiculeId(Long id){
        return contratDao.deleteByVehiculeId(id);
        }


        @Override
        public List<Contrat> findByClientReference(String reference){
        return contratDao.findByClientReference(reference);
        }

        @Override
        @Transactional
        public int deleteByClientReference(String reference){
        return contratDao.deleteByClientReference(reference);
        }

        @Override
        public List<Contrat> findByClientId(Long id){
        return contratDao.findByClientId(id);
        }

        @Override
        @Transactional
        public int deleteByClientId(Long id){
        return contratDao.deleteByClientId(id);
        }

    @Override
    public Contrat findByNumAttestation(String numAttestation){
    if( numAttestation==null) return null;
    return contratDao.findByNumAttestation(numAttestation);
    }

    @Override
    @Transactional
    public int deleteByNumAttestation(String  numAttestation) {
    return contratDao.deleteByNumAttestation(numAttestation);
    }
    @Override
    public Contrat findByIdOrNumAttestation(Contrat contrat){
    Contrat resultat=null;
    if(contrat != null){
    if(StringUtil.isNotEmpty(contrat.getId())){
    resultat= contratDao.getOne(contrat.getId());
    }else if(StringUtil.isNotEmpty(contrat.getNumAttestation())) {
    resultat= contratDao.findByNumAttestation(contrat.getNumAttestation());
    }
    }
    return resultat;
    }

@Override
public Contrat findById(Long id){
if(id==null) return null;
return contratDao.getOne(id);
}

@Override
public Contrat findByIdWithAssociatedList(Long id){
    Contrat contrat  = findById(id);
    findAssociatedLists(contrat);
    return contrat;
}

    private void findAssociatedLists(Contrat contrat){
    if(contrat!=null && contrat.getId() != null) {
            List<ContratGarantie> contratGaranties = contratGarantieService.findByContratId(contrat.getId());
            contrat.setContratGaranties(contratGaranties);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            contratGarantieService.deleteByContratId(id);
    }
    }

    private void updateAssociatedLists(Contrat contrat){
    if(contrat !=null && contrat.getId() != null){
            List
            <List<ContratGarantie>> resultContratGaranties= contratGarantieService.getToBeSavedAndToBeDeleted(contratGarantieService.findByContratId(contrat.getId()),contrat.getContratGaranties());
            contratGarantieService.delete(resultContratGaranties.get(1));
            associateContratGarantie(contrat,resultContratGaranties.get(0));
            contratGarantieService.update(resultContratGaranties.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(contratDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
contratDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Contrat update(Contrat contrat){
Contrat foundedContrat = findById(contrat.getId());
if(foundedContrat==null) return null;
else{
    updateAssociatedLists(contrat);
return  contratDao.save(contrat);
}
}

@Override
public Contrat save (Contrat contrat){

    Contrat result =null;
    Contrat foundedContrat = findByNumAttestation(contrat.getNumAttestation());
    if(foundedContrat == null){



    findQuittancePrime(contrat);
    findNatureContrat(contrat);
    findVehicule(contrat);
    findClient(contrat);

    Contrat savedContrat = contratDao.save(contrat);

        saveContratGaranties(savedContrat,contrat.getContratGaranties());
    result = savedContrat;
    }

    return result;
}

@Override
public List<Contrat> save(List<Contrat> contrats){
List<Contrat> list = new ArrayList<>();
for(Contrat contrat: contrats){
list.add(save(contrat));
}
return list;
}

        private List<ContratGarantie> prepareContratGaranties(Contrat contrat,List<ContratGarantie> contratGaranties){
        for(ContratGarantie contratGarantie:contratGaranties ){
        contratGarantie.setContrat(contrat);
        }
        return contratGaranties;
        }


@Override
@Transactional
public int delete(Contrat contrat){
    if(contrat.getNumAttestation()==null) return -1;

    Contrat foundedContrat = findByNumAttestation(contrat.getNumAttestation());
    if(foundedContrat==null) return -1;
contratDao.delete(foundedContrat);
return 1;
}


public List<Contrat> findByCriteria(ContratVo contratVo){

String query = "SELECT o FROM Contrat o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",contratVo.getId());
            query += SearchUtil.addConstraint( "o", "numPolice","LIKE",contratVo.getNumPolice());
            query += SearchUtil.addConstraint( "o", "numAttestation","LIKE",contratVo.getNumAttestation());
        query += SearchUtil.addConstraintDate( "o", "dateEffet","=",contratVo.getDateEffet());
        query += SearchUtil.addConstraintDate( "o", "dateEcheance","=",contratVo.getDateEcheance());
        query += SearchUtil.addConstraintDate( "o", "dateSignature","=",contratVo.getDateSignature());
            query += SearchUtil.addConstraint( "o", "periode","LIKE",contratVo.getPeriode());
            query += SearchUtil.addConstraintMinMaxDate("o","dateEffet",contratVo.getDateEffetMin(),contratVo.getDateEffetMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateEcheance",contratVo.getDateEcheanceMin(),contratVo.getDateEcheanceMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateSignature",contratVo.getDateSignatureMin(),contratVo.getDateSignatureMax());
    if(contratVo.getQuittancePrimeVo()!=null){
        query += SearchUtil.addConstraint( "o", "quittancePrime.id","=",contratVo.getQuittancePrimeVo().getId());
    }

    if(contratVo.getNatureContratVo()!=null){
        query += SearchUtil.addConstraint( "o", "natureContrat.id","=",contratVo.getNatureContratVo().getId());
    }

    if(contratVo.getVehiculeVo()!=null){
        query += SearchUtil.addConstraint( "o", "vehicule.id","=",contratVo.getVehiculeVo().getId());
            query += SearchUtil.addConstraint( "o", "vehicule.reference","LIKE",contratVo.getVehiculeVo().getReference());
    }

    if(contratVo.getClientVo()!=null){
        query += SearchUtil.addConstraint( "o", "client.id","=",contratVo.getClientVo().getId());
            query += SearchUtil.addConstraint( "o", "client.reference","LIKE",contratVo.getClientVo().getReference());
    }

    query+= " ORDER BY o.dateSignature";
return entityManager.createQuery(query).getResultList();
}
        private  void saveContratGaranties(Contrat contrat,List<ContratGarantie> contratGaranties){

        if (ListUtil.isNotEmpty(contrat.getContratGaranties())) {
        List<ContratGarantie> savedContratGaranties = new ArrayList<>();
        contratGaranties.forEach(element -> {
        element.setContrat(contrat);
         contratGarantieService.save(element);
        });
        contrat.setContratGaranties(savedContratGaranties);
        }
        }

    private void findQuittancePrime(Contrat contrat){
        QuittancePrime loadedQuittancePrime = null;
        if(contrat.getQuittancePrime() != null && contrat.getQuittancePrime().getId() !=null)
        loadedQuittancePrime =quittancePrimeService.findById(contrat.getQuittancePrime().getId());

    if(loadedQuittancePrime==null ) {
    return;
    }
    contrat.setQuittancePrime(loadedQuittancePrime);
    }
    private void findNatureContrat(Contrat contrat){
        NatureContrat loadedNatureContrat = null;
        if(contrat.getNatureContrat() != null && contrat.getNatureContrat().getId() !=null)
        loadedNatureContrat =natureContratService.findById(contrat.getNatureContrat().getId());

    if(loadedNatureContrat==null ) {
    return;
    }
    contrat.setNatureContrat(loadedNatureContrat);
    }
    private void findVehicule(Contrat contrat){
        Vehicule loadedVehicule =vehiculeService.findByIdOrReference(contrat.getVehicule());

    if(loadedVehicule==null ) {
    return;
    }
    contrat.setVehicule(loadedVehicule);
    }
    private void findClient(Contrat contrat){
        Client loadedClient =clientService.findByIdOrReference(contrat.getClient());

    if(loadedClient==null ) {
    return;
    }
    contrat.setClient(loadedClient);
    }

@Override
@Transactional
public void delete(List<Contrat> contrats){
if(ListUtil.isNotEmpty(contrats)){
contrats.forEach(e->contratDao.delete(e));
}
}
@Override
public void update(List<Contrat> contrats){
if(ListUtil.isNotEmpty(contrats)){
contrats.forEach(e->contratDao.save(e));
}
}

        private void associateContratGarantie(Contrat contrat, List<ContratGarantie> contratGarantie) {
        if (ListUtil.isNotEmpty(contratGarantie)) {
        contratGarantie.forEach(e -> e.setContrat(contrat));
        }
        }




    }
