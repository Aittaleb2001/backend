package com.ird.faa.service.agent.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Client;
        import com.ird.faa.bean.TypeClient;
        import com.ird.faa.bean.ClientSininstre;
        import com.ird.faa.bean.Vehicule;
        import com.ird.faa.bean.Contrat;
import com.ird.faa.dao.ClientDao;
import com.ird.faa.service.agent.facade.ClientAgentService;
        import com.ird.faa.service.agent.facade.ClientSininstreAgentService;
        import com.ird.faa.service.agent.facade.VehiculeAgentService;
        import com.ird.faa.service.agent.facade.TypeClientAgentService;
        import com.ird.faa.service.agent.facade.ContratAgentService;

import com.ird.faa.ws.rest.provided.vo.ClientVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.ClientSininstre;
        import com.ird.faa.service.agent.facade.ClientSininstreAgentService;
        import com.ird.faa.bean.Vehicule;
        import com.ird.faa.service.agent.facade.VehiculeAgentService;
        import com.ird.faa.bean.Contrat;
        import com.ird.faa.service.agent.facade.ContratAgentService;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ClientAgentServiceImpl extends AbstractServiceImpl<Client> implements ClientAgentService {

@Autowired
private ClientDao clientDao;

        @Autowired
        private ClientSininstreAgentService clientSininstreService ;
        @Autowired
        private VehiculeAgentService vehiculeService ;
        @Autowired
        private TypeClientAgentService typeClientService ;
        @Autowired
        private ContratAgentService contratService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Client> findAll(){
        return clientDao.findAll();
}
        @Override
        public List<Client> findByTypeClientId(Long id){
        return clientDao.findByTypeClientId(id);
        }

        @Override
        @Transactional
        public int deleteByTypeClientId(Long id){
        return clientDao.deleteByTypeClientId(id);
        }

    @Override
    public Client findByReference(String reference){
    if( reference==null) return null;
    return clientDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return clientDao.deleteByReference(reference);
    }
    @Override
    public Client findByIdOrReference(Client client){
    Client resultat=null;
    if(client != null){
    if(StringUtil.isNotEmpty(client.getId())){
    resultat= clientDao.getOne(client.getId());
    }else if(StringUtil.isNotEmpty(client.getReference())) {
    resultat= clientDao.findByReference(client.getReference());
    }
    }
    return resultat;
    }

@Override
public Client findById(Long id){
if(id==null) return null;
return clientDao.getOne(id);
}

@Override
public Client findByIdWithAssociatedList(Long id){
    Client client  = findById(id);
    findAssociatedLists(client);
    return client;
}

    private void findAssociatedLists(Client client){
    if(client!=null && client.getId() != null) {
            List<ClientSininstre> clientSininstres = clientSininstreService.findByClientId(client.getId());
            client.setClientSininstres(clientSininstres);
            List<Vehicule> vehicule = vehiculeService.findByClientId(client.getId());
            client.setVehicule(vehicule);
            List<Contrat> contrat = contratService.findByClientId(client.getId());
            client.setContrat(contrat);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            clientSininstreService.deleteByClientId(id);
            vehiculeService.deleteByClientId(id);
            contratService.deleteByClientId(id);
    }
    }

    private void updateAssociatedLists(Client client){
    if(client !=null && client.getId() != null){
            List
            <List<ClientSininstre>> resultClientSininstres= clientSininstreService.getToBeSavedAndToBeDeleted(clientSininstreService.findByClientId(client.getId()),client.getClientSininstres());
            clientSininstreService.delete(resultClientSininstres.get(1));
            associateClientSininstre(client,resultClientSininstres.get(0));
            clientSininstreService.update(resultClientSininstres.get(0));

            List
            <List<Vehicule>> resultVehicule= vehiculeService.getToBeSavedAndToBeDeleted(vehiculeService.findByClientId(client.getId()),client.getVehicule());
            vehiculeService.delete(resultVehicule.get(1));
            associateVehicule(client,resultVehicule.get(0));
            vehiculeService.update(resultVehicule.get(0));

            List
            <List<Contrat>> resultContrat= contratService.getToBeSavedAndToBeDeleted(contratService.findByClientId(client.getId()),client.getContrat());
            contratService.delete(resultContrat.get(1));
            associateContrat(client,resultContrat.get(0));
            contratService.update(resultContrat.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(clientDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
clientDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Client update(Client client){
Client foundedClient = findById(client.getId());
if(foundedClient==null) return null;
else{
    updateAssociatedLists(client);
return  clientDao.save(client);
}
}

@Override
public Client save (Client client){

    Client result =null;
    Client foundedClient = findByReference(client.getReference());
    if(foundedClient == null){



    findTypeClient(client);

    Client savedClient = clientDao.save(client);

        saveClientSininstres(savedClient,client.getClientSininstres());
        saveVehicule(savedClient,client.getVehicule());
        saveContrat(savedClient,client.getContrat());
    result = savedClient;
    }

    return result;
}

@Override
public List<Client> save(List<Client> clients){
List<Client> list = new ArrayList<>();
for(Client client: clients){
list.add(save(client));
}
return list;
}

        private List<ClientSininstre> prepareClientSininstres(Client client,List<ClientSininstre> clientSininstres){
        for(ClientSininstre clientSininstre:clientSininstres ){
        clientSininstre.setClient(client);
        }
        return clientSininstres;
        }
        private List<Vehicule> prepareVehicule(Client client,List<Vehicule> vehicules){
        for(Vehicule vehicule:vehicules ){
        vehicule.setClient(client);
        }
        return vehicules;
        }
        private List<Contrat> prepareContrat(Client client,List<Contrat> contrats){
        for(Contrat contrat:contrats ){
        contrat.setClient(client);
        }
        return contrats;
        }


@Override
@Transactional
public int delete(Client client){
    if(client.getReference()==null) return -1;

    Client foundedClient = findByReference(client.getReference());
    if(foundedClient==null) return -1;
clientDao.delete(foundedClient);
return 1;
}


public List<Client> findByCriteria(ClientVo clientVo){

String query = "SELECT o FROM Client o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",clientVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",clientVo.getReference());
            query += SearchUtil.addConstraint( "o", "cin","LIKE",clientVo.getCin());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",clientVo.getNom());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",clientVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "activite","LIKE",clientVo.getActivite());
            query += SearchUtil.addConstraint( "o", "adresse","LIKE",clientVo.getAdresse());
        query += SearchUtil.addConstraintDate( "o", "datedeNaissance","=",clientVo.getDatedeNaissance());
            query += SearchUtil.addConstraint( "o", "numTelephone","=",clientVo.getNumTelephone());
            query += SearchUtil.addConstraintMinMaxDate("o","datedeNaissance",clientVo.getDatedeNaissanceMin(),clientVo.getDatedeNaissanceMax());
            query += SearchUtil.addConstraintMinMax("o","numTelephone",clientVo.getNumTelephoneMin(),clientVo.getNumTelephoneMax());
    if(clientVo.getTypeClientVo()!=null){
        query += SearchUtil.addConstraint( "o", "typeClient.id","=",clientVo.getTypeClientVo().getId());
    }

    query+= " ORDER BY o.datedeNaissance";
return entityManager.createQuery(query).getResultList();
}
        private  void saveClientSininstres(Client client,List<ClientSininstre> clientSininstres){

        if (ListUtil.isNotEmpty(client.getClientSininstres())) {
        List<ClientSininstre> savedClientSininstres = new ArrayList<>();
        clientSininstres.forEach(element -> {
        element.setClient(client);
         clientSininstreService.save(element);
        });
        client.setClientSininstres(savedClientSininstres);
        }
        }
        private  void saveVehicule(Client client,List<Vehicule> vehicule){

        if (ListUtil.isNotEmpty(client.getVehicule())) {
        List<Vehicule> savedVehicule = new ArrayList<>();
        vehicule.forEach(element -> {
        element.setClient(client);
         vehiculeService.save(element);
        });
        client.setVehicule(savedVehicule);
        }
        }
        private  void saveContrat(Client client,List<Contrat> contrat){

        if (ListUtil.isNotEmpty(client.getContrat())) {
        List<Contrat> savedContrat = new ArrayList<>();
        contrat.forEach(element -> {
        element.setClient(client);
         contratService.save(element);
        });
        client.setContrat(savedContrat);
        }
        }

    private void findTypeClient(Client client){
        TypeClient loadedTypeClient = null;
        if(client.getTypeClient() != null && client.getTypeClient().getId() !=null)
        loadedTypeClient =typeClientService.findById(client.getTypeClient().getId());

    if(loadedTypeClient==null ) {
    return;
    }
    client.setTypeClient(loadedTypeClient);
    }

@Override
@Transactional
public void delete(List<Client> clients){
if(ListUtil.isNotEmpty(clients)){
clients.forEach(e->clientDao.delete(e));
}
}
@Override
public void update(List<Client> clients){
if(ListUtil.isNotEmpty(clients)){
clients.forEach(e->clientDao.save(e));
}
}

        private void associateClientSininstre(Client client, List<ClientSininstre> clientSininstre) {
        if (ListUtil.isNotEmpty(clientSininstre)) {
        clientSininstre.forEach(e -> e.setClient(client));
        }
        }
        private void associateVehicule(Client client, List<Vehicule> vehicule) {
        if (ListUtil.isNotEmpty(vehicule)) {
        vehicule.forEach(e -> e.setClient(client));
        }
        }
        private void associateContrat(Client client, List<Contrat> contrat) {
        if (ListUtil.isNotEmpty(contrat)) {
        contrat.forEach(e -> e.setClient(client));
        }
        }




    }
