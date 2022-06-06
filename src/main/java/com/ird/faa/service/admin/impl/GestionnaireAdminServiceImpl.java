package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Gestionnaire;
import com.ird.faa.dao.GestionnaireDao;
import com.ird.faa.service.admin.facade.GestionnaireAdminService;

import com.ird.faa.ws.rest.provided.vo.GestionnaireVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class GestionnaireAdminServiceImpl extends AbstractServiceImpl<Gestionnaire> implements GestionnaireAdminService {

@Autowired
private GestionnaireDao gestionnaireDao;



@Autowired
private EntityManager entityManager;

    @Override
    public Gestionnaire findByUsername(String username){
    return gestionnaireDao.findByUsername(username);
    }

@Override
public List<Gestionnaire> findAll(){
        return gestionnaireDao.findAll();
}
    @Override
    public Gestionnaire findByReference(String reference){
    if( reference==null) return null;
    return gestionnaireDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return gestionnaireDao.deleteByReference(reference);
    }
    @Override
    public Gestionnaire findByIdOrReference(Gestionnaire gestionnaire){
    Gestionnaire resultat=null;
    if(gestionnaire != null){
    if(StringUtil.isNotEmpty(gestionnaire.getId())){
    resultat= gestionnaireDao.getOne(gestionnaire.getId());
    }else if(StringUtil.isNotEmpty(gestionnaire.getReference())) {
    resultat= gestionnaireDao.findByReference(gestionnaire.getReference());
    }else if(StringUtil.isNotEmpty(gestionnaire.getUsername())) {
    resultat = gestionnaireDao.findByUsername(gestionnaire.getUsername());
    }
    }
    return resultat;
    }

@Override
public Gestionnaire findById(Long id){
if(id==null) return null;
return gestionnaireDao.getOne(id);
}

@Override
public Gestionnaire findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(gestionnaireDao.findById(id).isPresent())  {
gestionnaireDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Gestionnaire update(Gestionnaire gestionnaire){
Gestionnaire foundedGestionnaire = findById(gestionnaire.getId());
if(foundedGestionnaire==null) return null;
else{
return  gestionnaireDao.save(gestionnaire);
}
}
    private void prepareSave(Gestionnaire gestionnaire){
                gestionnaire.setCredentialsNonExpired(false);
                gestionnaire.setEnabled(false);
                gestionnaire.setAccountNonExpired(false);
                gestionnaire.setAccountNonLocked(false);
                gestionnaire.setPasswordChanged(false);




    }

@Override
public Gestionnaire save (Gestionnaire gestionnaire){
    prepareSave(gestionnaire);

    Gestionnaire result =null;
        Gestionnaire foundedGestionnaire = findByReference(gestionnaire.getReference());
        Gestionnaire foundedGestionnaireByUsername = findByReference(gestionnaire.getReference());
        if(foundedGestionnaire == null && foundedGestionnaireByUsername == null){




    Gestionnaire savedGestionnaire = gestionnaireDao.save(gestionnaire);

    result = savedGestionnaire;
    }

    return result;
}

@Override
public List<Gestionnaire> save(List<Gestionnaire> gestionnaires){
List<Gestionnaire> list = new ArrayList<>();
for(Gestionnaire gestionnaire: gestionnaires){
list.add(save(gestionnaire));
}
return list;
}



@Override
@Transactional
public int delete(Gestionnaire gestionnaire){
    if(gestionnaire.getReference()==null) return -1;

    Gestionnaire foundedGestionnaire = findByReference(gestionnaire.getReference());
    if(foundedGestionnaire==null) return -1;
gestionnaireDao.delete(foundedGestionnaire);
return 1;
}


public List<Gestionnaire> findByCriteria(GestionnaireVo gestionnaireVo){

String query = "SELECT o FROM Gestionnaire o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",gestionnaireVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",gestionnaireVo.getReference());
            query += SearchUtil.addConstraint( "o", "numeroTelephone","=",gestionnaireVo.getNumeroTelephone());
            query += SearchUtil.addConstraint( "o", "email","LIKE",gestionnaireVo.getEmail());
            query += SearchUtil.addConstraint( "o", "role","LIKE",gestionnaireVo.getRole());
            query += SearchUtil.addConstraint( "o", "credentialsNonExpired","=",gestionnaireVo.getCredentialsNonExpired());
            query += SearchUtil.addConstraint( "o", "enabled","=",gestionnaireVo.getEnabled());
            query += SearchUtil.addConstraint( "o", "accountNonExpired","=",gestionnaireVo.getAccountNonExpired());
            query += SearchUtil.addConstraint( "o", "accountNonLocked","=",gestionnaireVo.getAccountNonLocked());
            query += SearchUtil.addConstraint( "o", "passwordChanged","=",gestionnaireVo.getPasswordChanged());
        query += SearchUtil.addConstraintDate( "o", "createdAt","=",gestionnaireVo.getCreatedAt());
        query += SearchUtil.addConstraintDate( "o", "updatedAt","=",gestionnaireVo.getUpdatedAt());
            query += SearchUtil.addConstraint( "o", "username","LIKE",gestionnaireVo.getUsername());
            query += SearchUtil.addConstraint( "o", "password","LIKE",gestionnaireVo.getPassword());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",gestionnaireVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",gestionnaireVo.getNom());
            query += SearchUtil.addConstraintMinMax("o","numeroTelephone",gestionnaireVo.getNumeroTelephoneMin(),gestionnaireVo.getNumeroTelephoneMax());
            query += SearchUtil.addConstraintMinMaxDate("o","createdAt",gestionnaireVo.getCreatedAtMin(),gestionnaireVo.getCreatedAtMax());
            query += SearchUtil.addConstraintMinMaxDate("o","updatedAt",gestionnaireVo.getUpdatedAtMin(),gestionnaireVo.getUpdatedAtMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Gestionnaire> gestionnaires){
if(ListUtil.isNotEmpty(gestionnaires)){
gestionnaires.forEach(e->gestionnaireDao.delete(e));
}
}
@Override
public void update(List<Gestionnaire> gestionnaires){
if(ListUtil.isNotEmpty(gestionnaires)){
gestionnaires.forEach(e->gestionnaireDao.save(e));
}
}





    }
