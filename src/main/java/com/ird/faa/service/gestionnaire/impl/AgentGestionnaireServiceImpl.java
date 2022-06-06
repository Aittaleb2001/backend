package com.ird.faa.service.gestionnaire.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Agent;
import com.ird.faa.dao.AgentDao;
import com.ird.faa.service.gestionnaire.facade.AgentGestionnaireService;

import com.ird.faa.ws.rest.provided.vo.AgentVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class AgentGestionnaireServiceImpl extends AbstractServiceImpl<Agent> implements AgentGestionnaireService {

@Autowired
private AgentDao agentDao;



@Autowired
private EntityManager entityManager;

    @Override
    public Agent findByUsername(String username){
    return agentDao.findByUsername(username);
    }

@Override
public List<Agent> findAll(){
        return agentDao.findAll();
}
    @Override
    public Agent findByReference(String reference){
    if( reference==null) return null;
    return agentDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return agentDao.deleteByReference(reference);
    }
    @Override
    public Agent findByIdOrReference(Agent agent){
    Agent resultat=null;
    if(agent != null){
    if(StringUtil.isNotEmpty(agent.getId())){
    resultat= agentDao.getOne(agent.getId());
    }else if(StringUtil.isNotEmpty(agent.getReference())) {
    resultat= agentDao.findByReference(agent.getReference());
    }else if(StringUtil.isNotEmpty(agent.getUsername())) {
    resultat = agentDao.findByUsername(agent.getUsername());
    }
    }
    return resultat;
    }

@Override
public Agent findById(Long id){
if(id==null) return null;
return agentDao.getOne(id);
}

@Override
public Agent findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(agentDao.findById(id).isPresent())  {
agentDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Agent update(Agent agent){
Agent foundedAgent = findById(agent.getId());
if(foundedAgent==null) return null;
else{
return  agentDao.save(agent);
}
}
    private void prepareSave(Agent agent){
                agent.setCredentialsNonExpired(false);
                agent.setEnabled(false);
                agent.setAccountNonExpired(false);
                agent.setAccountNonLocked(false);
                agent.setPasswordChanged(false);




    }

@Override
public Agent save (Agent agent){
    prepareSave(agent);

    Agent result =null;
        Agent foundedAgent = findByReference(agent.getReference());
        Agent foundedAgentByUsername = findByReference(agent.getReference());
        if(foundedAgent == null && foundedAgentByUsername == null){




    Agent savedAgent = agentDao.save(agent);

    result = savedAgent;
    }

    return result;
}

@Override
public List<Agent> save(List<Agent> agents){
List<Agent> list = new ArrayList<>();
for(Agent agent: agents){
list.add(save(agent));
}
return list;
}



@Override
@Transactional
public int delete(Agent agent){
    if(agent.getReference()==null) return -1;

    Agent foundedAgent = findByReference(agent.getReference());
    if(foundedAgent==null) return -1;
agentDao.delete(foundedAgent);
return 1;
}


public List<Agent> findByCriteria(AgentVo agentVo){

String query = "SELECT o FROM Agent o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",agentVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",agentVo.getReference());
        query += SearchUtil.addConstraintDate( "o", "createdAt","=",agentVo.getCreatedAt());
        query += SearchUtil.addConstraintDate( "o", "updatedAt","=",agentVo.getUpdatedAt());
            query += SearchUtil.addConstraint( "o", "role","LIKE",agentVo.getRole());
            query += SearchUtil.addConstraint( "o", "credentialsNonExpired","=",agentVo.getCredentialsNonExpired());
            query += SearchUtil.addConstraint( "o", "enabled","=",agentVo.getEnabled());
            query += SearchUtil.addConstraint( "o", "accountNonExpired","=",agentVo.getAccountNonExpired());
            query += SearchUtil.addConstraint( "o", "accountNonLocked","=",agentVo.getAccountNonLocked());
            query += SearchUtil.addConstraint( "o", "passwordChanged","=",agentVo.getPasswordChanged());
        query += SearchUtil.addConstraintDate( "o", "createdAt","=",agentVo.getCreatedAt());
        query += SearchUtil.addConstraintDate( "o", "updatedAt","=",agentVo.getUpdatedAt());
            query += SearchUtil.addConstraint( "o", "username","LIKE",agentVo.getUsername());
            query += SearchUtil.addConstraint( "o", "password","LIKE",agentVo.getPassword());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",agentVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",agentVo.getNom());
            query += SearchUtil.addConstraintMinMaxDate("o","createdAt",agentVo.getCreatedAtMin(),agentVo.getCreatedAtMax());
            query += SearchUtil.addConstraintMinMaxDate("o","updatedAt",agentVo.getUpdatedAtMin(),agentVo.getUpdatedAtMax());
            query += SearchUtil.addConstraintMinMaxDate("o","createdAt",agentVo.getCreatedAtMin(),agentVo.getCreatedAtMax());
            query += SearchUtil.addConstraintMinMaxDate("o","updatedAt",agentVo.getUpdatedAtMin(),agentVo.getUpdatedAtMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Agent> agents){
if(ListUtil.isNotEmpty(agents)){
agents.forEach(e->agentDao.delete(e));
}
}
@Override
public void update(List<Agent> agents){
if(ListUtil.isNotEmpty(agents)){
agents.forEach(e->agentDao.save(e));
}
}





    }
