package com.ird.faa.service.gestionnaire.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Vehicule;
        import com.ird.faa.bean.Carburant;
        import com.ird.faa.bean.TypeVehicule;
        import com.ird.faa.bean.Client;
        import com.ird.faa.bean.Contrat;
        import com.ird.faa.bean.Marque;
import com.ird.faa.dao.VehiculeDao;
import com.ird.faa.service.gestionnaire.facade.VehiculeGestionnaireService;
        import com.ird.faa.service.gestionnaire.facade.MarqueGestionnaireService;
        import com.ird.faa.service.gestionnaire.facade.TypeVehiculeGestionnaireService;
        import com.ird.faa.service.gestionnaire.facade.CarburantGestionnaireService;
        import com.ird.faa.service.gestionnaire.facade.ClientGestionnaireService;
        import com.ird.faa.service.gestionnaire.facade.ContratGestionnaireService;

import com.ird.faa.ws.rest.provided.vo.VehiculeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class VehiculeGestionnaireServiceImpl extends AbstractServiceImpl<Vehicule> implements VehiculeGestionnaireService {

@Autowired
private VehiculeDao vehiculeDao;

        @Autowired
        private MarqueGestionnaireService marqueService ;
        @Autowired
        private TypeVehiculeGestionnaireService typeVehiculeService ;
        @Autowired
        private CarburantGestionnaireService carburantService ;
        @Autowired
        private ClientGestionnaireService clientService ;
        @Autowired
        private ContratGestionnaireService contratService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Vehicule> findAll(){
        return vehiculeDao.findAll();
}
        @Override
        public List<Vehicule> findByCarburantId(Long id){
        return vehiculeDao.findByCarburantId(id);
        }

        @Override
        @Transactional
        public int deleteByCarburantId(Long id){
        return vehiculeDao.deleteByCarburantId(id);
        }

        @Override
        public List<Vehicule> findByTypeVehiculeId(Long id){
        return vehiculeDao.findByTypeVehiculeId(id);
        }

        @Override
        @Transactional
        public int deleteByTypeVehiculeId(Long id){
        return vehiculeDao.deleteByTypeVehiculeId(id);
        }


        @Override
        public List<Vehicule> findByClientReference(String reference){
        return vehiculeDao.findByClientReference(reference);
        }

        @Override
        @Transactional
        public int deleteByClientReference(String reference){
        return vehiculeDao.deleteByClientReference(reference);
        }

        @Override
        public List<Vehicule> findByClientId(Long id){
        return vehiculeDao.findByClientId(id);
        }

        @Override
        @Transactional
        public int deleteByClientId(Long id){
        return vehiculeDao.deleteByClientId(id);
        }


        @Override
        public List<Vehicule> findByContratNumAttestation(String numAttestation){
        return vehiculeDao.findByContratNumAttestation(numAttestation);
        }

        @Override
        @Transactional
        public int deleteByContratNumAttestation(String numAttestation){
        return vehiculeDao.deleteByContratNumAttestation(numAttestation);
        }

        @Override
        public List<Vehicule> findByContratId(Long id){
        return vehiculeDao.findByContratId(id);
        }

        @Override
        @Transactional
        public int deleteByContratId(Long id){
        return vehiculeDao.deleteByContratId(id);
        }

        @Override
        public List<Vehicule> findByMarqueId(Long id){
        return vehiculeDao.findByMarqueId(id);
        }

        @Override
        @Transactional
        public int deleteByMarqueId(Long id){
        return vehiculeDao.deleteByMarqueId(id);
        }

    @Override
    public Vehicule findByReference(String reference){
    if( reference==null) return null;
    return vehiculeDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return vehiculeDao.deleteByReference(reference);
    }
    @Override
    public Vehicule findByIdOrReference(Vehicule vehicule){
    Vehicule resultat=null;
    if(vehicule != null){
    if(StringUtil.isNotEmpty(vehicule.getId())){
    resultat= vehiculeDao.getOne(vehicule.getId());
    }else if(StringUtil.isNotEmpty(vehicule.getReference())) {
    resultat= vehiculeDao.findByReference(vehicule.getReference());
    }
    }
    return resultat;
    }

@Override
public Vehicule findById(Long id){
if(id==null) return null;
return vehiculeDao.getOne(id);
}

@Override
public Vehicule findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(vehiculeDao.findById(id).isPresent())  {
vehiculeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Vehicule update(Vehicule vehicule){
Vehicule foundedVehicule = findById(vehicule.getId());
if(foundedVehicule==null) return null;
else{
return  vehiculeDao.save(vehicule);
}
}

@Override
public Vehicule save (Vehicule vehicule){

    Vehicule result =null;
    Vehicule foundedVehicule = findByReference(vehicule.getReference());
    if(foundedVehicule == null){



    findCarburant(vehicule);
    findTypeVehicule(vehicule);
    findClient(vehicule);
    findContrat(vehicule);
    findMarque(vehicule);

    Vehicule savedVehicule = vehiculeDao.save(vehicule);

    result = savedVehicule;
    }

    return result;
}

@Override
public List<Vehicule> save(List<Vehicule> vehicules){
List<Vehicule> list = new ArrayList<>();
for(Vehicule vehicule: vehicules){
list.add(save(vehicule));
}
return list;
}



@Override
@Transactional
public int delete(Vehicule vehicule){
    if(vehicule.getReference()==null) return -1;

    Vehicule foundedVehicule = findByReference(vehicule.getReference());
    if(foundedVehicule==null) return -1;
vehiculeDao.delete(foundedVehicule);
return 1;
}


public List<Vehicule> findByCriteria(VehiculeVo vehiculeVo){

String query = "SELECT o FROM Vehicule o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",vehiculeVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",vehiculeVo.getReference());
            query += SearchUtil.addConstraint( "o", "codeVerification","LIKE",vehiculeVo.getCodeVerification());
            query += SearchUtil.addConstraint( "o", "matricule","LIKE",vehiculeVo.getMatricule());
            query += SearchUtil.addConstraint( "o", "cylindree","=",vehiculeVo.getCylindree());
            query += SearchUtil.addConstraint( "o", "version","LIKE",vehiculeVo.getVersion());
            query += SearchUtil.addConstraint( "o", "poidsEncharge","=",vehiculeVo.getPoidsEncharge());
            query += SearchUtil.addConstraint( "o", "nombrePlaces","=",vehiculeVo.getNombrePlaces());
            query += SearchUtil.addConstraint( "o", "puissanceFiscale","LIKE",vehiculeVo.getPuissanceFiscale());
            query += SearchUtil.addConstraintMinMax("o","cylindree",vehiculeVo.getCylindreeMin(),vehiculeVo.getCylindreeMax());
            query += SearchUtil.addConstraintMinMax("o","poidsEncharge",vehiculeVo.getPoidsEnchargeMin(),vehiculeVo.getPoidsEnchargeMax());
            query += SearchUtil.addConstraintMinMax("o","nombrePlaces",vehiculeVo.getNombrePlacesMin(),vehiculeVo.getNombrePlacesMax());
    if(vehiculeVo.getCarburantVo()!=null){
        query += SearchUtil.addConstraint( "o", "carburant.id","=",vehiculeVo.getCarburantVo().getId());
    }

    if(vehiculeVo.getTypeVehiculeVo()!=null){
        query += SearchUtil.addConstraint( "o", "typeVehicule.id","=",vehiculeVo.getTypeVehiculeVo().getId());
    }

    if(vehiculeVo.getClientVo()!=null){
        query += SearchUtil.addConstraint( "o", "client.id","=",vehiculeVo.getClientVo().getId());
            query += SearchUtil.addConstraint( "o", "client.reference","LIKE",vehiculeVo.getClientVo().getReference());
    }

    if(vehiculeVo.getContratVo()!=null){
        query += SearchUtil.addConstraint( "o", "contrat.id","=",vehiculeVo.getContratVo().getId());
            query += SearchUtil.addConstraint( "o", "contrat.numAttestation","LIKE",vehiculeVo.getContratVo().getNumAttestation());
    }

    if(vehiculeVo.getMarqueVo()!=null){
        query += SearchUtil.addConstraint( "o", "marque.id","=",vehiculeVo.getMarqueVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findCarburant(Vehicule vehicule){
        Carburant loadedCarburant = null;
        if(vehicule.getCarburant() != null && vehicule.getCarburant().getId() !=null)
        loadedCarburant =carburantService.findById(vehicule.getCarburant().getId());

    if(loadedCarburant==null ) {
    return;
    }
    vehicule.setCarburant(loadedCarburant);
    }
    private void findTypeVehicule(Vehicule vehicule){
        TypeVehicule loadedTypeVehicule = null;
        if(vehicule.getTypeVehicule() != null && vehicule.getTypeVehicule().getId() !=null)
        loadedTypeVehicule =typeVehiculeService.findById(vehicule.getTypeVehicule().getId());

    if(loadedTypeVehicule==null ) {
    return;
    }
    vehicule.setTypeVehicule(loadedTypeVehicule);
    }
    private void findClient(Vehicule vehicule){
        Client loadedClient =clientService.findByIdOrReference(vehicule.getClient());

    if(loadedClient==null ) {
    return;
    }
    vehicule.setClient(loadedClient);
    }
    private void findContrat(Vehicule vehicule){
        Contrat loadedContrat =contratService.findByIdOrNumAttestation(vehicule.getContrat());

    if(loadedContrat==null ) {
    return;
    }
    vehicule.setContrat(loadedContrat);
    }
    private void findMarque(Vehicule vehicule){
        Marque loadedMarque = null;
        if(vehicule.getMarque() != null && vehicule.getMarque().getId() !=null)
        loadedMarque =marqueService.findById(vehicule.getMarque().getId());

    if(loadedMarque==null ) {
    return;
    }
    vehicule.setMarque(loadedMarque);
    }

@Override
@Transactional
public void delete(List<Vehicule> vehicules){
if(ListUtil.isNotEmpty(vehicules)){
vehicules.forEach(e->vehiculeDao.delete(e));
}
}
@Override
public void update(List<Vehicule> vehicules){
if(ListUtil.isNotEmpty(vehicules)){
vehicules.forEach(e->vehiculeDao.save(e));
}
}





    }
