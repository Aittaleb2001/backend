package com.ird.faa.service.gestionnaire.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.ClientSininstre;
        import com.ird.faa.bean.Client;
        import com.ird.faa.bean.Sinistre;
        import com.ird.faa.bean.QuittanceIndemniser;
import com.ird.faa.dao.ClientSininstreDao;
import com.ird.faa.service.gestionnaire.facade.ClientSininstreGestionnaireService;
        import com.ird.faa.service.gestionnaire.facade.SinistreGestionnaireService;
        import com.ird.faa.service.gestionnaire.facade.QuittanceIndemniserGestionnaireService;
        import com.ird.faa.service.gestionnaire.facade.ClientGestionnaireService;

import com.ird.faa.ws.rest.provided.vo.ClientSininstreVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ClientSininstreGestionnaireServiceImpl extends AbstractServiceImpl<ClientSininstre> implements ClientSininstreGestionnaireService {

@Autowired
private ClientSininstreDao clientSininstreDao;

        @Autowired
        private SinistreGestionnaireService sinistreService ;
        @Autowired
        private QuittanceIndemniserGestionnaireService quittanceIndemniserService ;
        @Autowired
        private ClientGestionnaireService clientService ;


@Autowired
private EntityManager entityManager;


@Override
public List<ClientSininstre> findAll(){
        return clientSininstreDao.findAll();
}

        @Override
        public List<ClientSininstre> findByClientReference(String reference){
        return clientSininstreDao.findByClientReference(reference);
        }

        @Override
        @Transactional
        public int deleteByClientReference(String reference){
        return clientSininstreDao.deleteByClientReference(reference);
        }

        @Override
        public List<ClientSininstre> findByClientId(Long id){
        return clientSininstreDao.findByClientId(id);
        }

        @Override
        @Transactional
        public int deleteByClientId(Long id){
        return clientSininstreDao.deleteByClientId(id);
        }


        @Override
        public List<ClientSininstre> findBySinistreReference(String reference){
        return clientSininstreDao.findBySinistreReference(reference);
        }

        @Override
        @Transactional
        public int deleteBySinistreReference(String reference){
        return clientSininstreDao.deleteBySinistreReference(reference);
        }

        @Override
        public List<ClientSininstre> findBySinistreId(Long id){
        return clientSininstreDao.findBySinistreId(id);
        }

        @Override
        @Transactional
        public int deleteBySinistreId(Long id){
        return clientSininstreDao.deleteBySinistreId(id);
        }


        @Override
        public List<ClientSininstre> findByQuittanceIndemniserReference(String reference){
        return clientSininstreDao.findByQuittanceIndemniserReference(reference);
        }

        @Override
        @Transactional
        public int deleteByQuittanceIndemniserReference(String reference){
        return clientSininstreDao.deleteByQuittanceIndemniserReference(reference);
        }

        @Override
        public List<ClientSininstre> findByQuittanceIndemniserId(Long id){
        return clientSininstreDao.findByQuittanceIndemniserId(id);
        }

        @Override
        @Transactional
        public int deleteByQuittanceIndemniserId(Long id){
        return clientSininstreDao.deleteByQuittanceIndemniserId(id);
        }

    @Override
    public ClientSininstre findByRef(String ref){
    if( ref==null) return null;
    return clientSininstreDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String  ref) {
    return clientSininstreDao.deleteByRef(ref);
    }
    @Override
    public ClientSininstre findByIdOrRef(ClientSininstre clientSininstre){
    ClientSininstre resultat=null;
    if(clientSininstre != null){
    if(StringUtil.isNotEmpty(clientSininstre.getId())){
    resultat= clientSininstreDao.getOne(clientSininstre.getId());
    }else if(StringUtil.isNotEmpty(clientSininstre.getRef())) {
    resultat= clientSininstreDao.findByRef(clientSininstre.getRef());
    }
    }
    return resultat;
    }

@Override
public ClientSininstre findById(Long id){
if(id==null) return null;
return clientSininstreDao.getOne(id);
}

@Override
public ClientSininstre findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(clientSininstreDao.findById(id).isPresent())  {
clientSininstreDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public ClientSininstre update(ClientSininstre clientSininstre){
ClientSininstre foundedClientSininstre = findById(clientSininstre.getId());
if(foundedClientSininstre==null) return null;
else{
return  clientSininstreDao.save(clientSininstre);
}
}

@Override
public ClientSininstre save (ClientSininstre clientSininstre){

    ClientSininstre result =null;
    ClientSininstre foundedClientSininstre = findByRef(clientSininstre.getRef());
    if(foundedClientSininstre == null){



    findClient(clientSininstre);
    findSinistre(clientSininstre);
    findQuittanceIndemniser(clientSininstre);

    ClientSininstre savedClientSininstre = clientSininstreDao.save(clientSininstre);

    result = savedClientSininstre;
    }

    return result;
}

@Override
public List<ClientSininstre> save(List<ClientSininstre> clientSininstres){
List<ClientSininstre> list = new ArrayList<>();
for(ClientSininstre clientSininstre: clientSininstres){
list.add(save(clientSininstre));
}
return list;
}



@Override
@Transactional
public int delete(ClientSininstre clientSininstre){
    if(clientSininstre.getRef()==null) return -1;

    ClientSininstre foundedClientSininstre = findByRef(clientSininstre.getRef());
    if(foundedClientSininstre==null) return -1;
clientSininstreDao.delete(foundedClientSininstre);
return 1;
}


public List<ClientSininstre> findByCriteria(ClientSininstreVo clientSininstreVo){

String query = "SELECT o FROM ClientSininstre o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",clientSininstreVo.getId());
            query += SearchUtil.addConstraint( "o", "ref","LIKE",clientSininstreVo.getRef());
            query += SearchUtil.addConstraint( "o", "numPolice","LIKE",clientSininstreVo.getNumPolice());
        query += SearchUtil.addConstraintDate( "o", "dateSinistre","=",clientSininstreVo.getDateSinistre());
            query += SearchUtil.addConstraint( "o", "responsabilite","LIKE",clientSininstreVo.getResponsabilite());
            query += SearchUtil.addConstraint( "o", "numOrdre","=",clientSininstreVo.getNumOrdre());
            query += SearchUtil.addConstraint( "o", "refReglement","LIKE",clientSininstreVo.getRefReglement());
            query += SearchUtil.addConstraint( "o", "montantExpertise","=",clientSininstreVo.getMontantExpertise());
            query += SearchUtil.addConstraint( "o", "montantIndemniser","=",clientSininstreVo.getMontantIndemniser());
            query += SearchUtil.addConstraint( "o", "observation","LIKE",clientSininstreVo.getObservation());
            query += SearchUtil.addConstraintMinMaxDate("o","dateSinistre",clientSininstreVo.getDateSinistreMin(),clientSininstreVo.getDateSinistreMax());
            query += SearchUtil.addConstraintMinMax("o","numOrdre",clientSininstreVo.getNumOrdreMin(),clientSininstreVo.getNumOrdreMax());
            query += SearchUtil.addConstraintMinMax("o","montantExpertise",clientSininstreVo.getMontantExpertiseMin(),clientSininstreVo.getMontantExpertiseMax());
            query += SearchUtil.addConstraintMinMax("o","montantIndemniser",clientSininstreVo.getMontantIndemniserMin(),clientSininstreVo.getMontantIndemniserMax());
    if(clientSininstreVo.getClientVo()!=null){
        query += SearchUtil.addConstraint( "o", "client.id","=",clientSininstreVo.getClientVo().getId());
            query += SearchUtil.addConstraint( "o", "client.reference","LIKE",clientSininstreVo.getClientVo().getReference());
    }

    if(clientSininstreVo.getSinistreVo()!=null){
        query += SearchUtil.addConstraint( "o", "sinistre.id","=",clientSininstreVo.getSinistreVo().getId());
            query += SearchUtil.addConstraint( "o", "sinistre.reference","LIKE",clientSininstreVo.getSinistreVo().getReference());
    }

    if(clientSininstreVo.getQuittanceIndemniserVo()!=null){
        query += SearchUtil.addConstraint( "o", "quittanceIndemniser.id","=",clientSininstreVo.getQuittanceIndemniserVo().getId());
            query += SearchUtil.addConstraint( "o", "quittanceIndemniser.reference","LIKE",clientSininstreVo.getQuittanceIndemniserVo().getReference());
    }

    query+= " ORDER BY o.dateSinistre";
return entityManager.createQuery(query).getResultList();
}

    private void findClient(ClientSininstre clientSininstre){
        Client loadedClient =clientService.findByIdOrReference(clientSininstre.getClient());

    if(loadedClient==null ) {
    return;
    }
    clientSininstre.setClient(loadedClient);
    }
    private void findSinistre(ClientSininstre clientSininstre){
        Sinistre loadedSinistre =sinistreService.findByIdOrReference(clientSininstre.getSinistre());

    if(loadedSinistre==null ) {
    return;
    }
    clientSininstre.setSinistre(loadedSinistre);
    }
    private void findQuittanceIndemniser(ClientSininstre clientSininstre){
        QuittanceIndemniser loadedQuittanceIndemniser =quittanceIndemniserService.findByIdOrReference(clientSininstre.getQuittanceIndemniser());

    if(loadedQuittanceIndemniser==null ) {
    return;
    }
    clientSininstre.setQuittanceIndemniser(loadedQuittanceIndemniser);
    }

@Override
@Transactional
public void delete(List<ClientSininstre> clientSininstres){
if(ListUtil.isNotEmpty(clientSininstres)){
clientSininstres.forEach(e->clientSininstreDao.delete(e));
}
}
@Override
public void update(List<ClientSininstre> clientSininstres){
if(ListUtil.isNotEmpty(clientSininstres)){
clientSininstres.forEach(e->clientSininstreDao.save(e));
}
}





    }
