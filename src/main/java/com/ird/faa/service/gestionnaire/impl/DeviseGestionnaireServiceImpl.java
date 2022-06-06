package com.ird.faa.service.gestionnaire.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Devise;
import com.ird.faa.dao.DeviseDao;
import com.ird.faa.service.gestionnaire.facade.DeviseGestionnaireService;

import com.ird.faa.ws.rest.provided.vo.DeviseVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class DeviseGestionnaireServiceImpl extends AbstractServiceImpl<Devise> implements DeviseGestionnaireService {

@Autowired
private DeviseDao deviseDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Devise> findAll(){
        return deviseDao.findAll();
}
    @Override
    public Devise findByReference(String reference){
    if( reference==null) return null;
    return deviseDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return deviseDao.deleteByReference(reference);
    }
    @Override
    public Devise findByIdOrReference(Devise devise){
    Devise resultat=null;
    if(devise != null){
    if(StringUtil.isNotEmpty(devise.getId())){
    resultat= deviseDao.getOne(devise.getId());
    }else if(StringUtil.isNotEmpty(devise.getReference())) {
    resultat= deviseDao.findByReference(devise.getReference());
    }
    }
    return resultat;
    }

@Override
public Devise findById(Long id){
if(id==null) return null;
return deviseDao.getOne(id);
}

@Override
public Devise findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(deviseDao.findById(id).isPresent())  {
deviseDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Devise update(Devise devise){
Devise foundedDevise = findById(devise.getId());
if(foundedDevise==null) return null;
else{
return  deviseDao.save(devise);
}
}

@Override
public Devise save (Devise devise){

    Devise result =null;
    Devise foundedDevise = findByReference(devise.getReference());
    if(foundedDevise == null){




    Devise savedDevise = deviseDao.save(devise);

    result = savedDevise;
    }

    return result;
}

@Override
public List<Devise> save(List<Devise> devises){
List<Devise> list = new ArrayList<>();
for(Devise devise: devises){
list.add(save(devise));
}
return list;
}



@Override
@Transactional
public int delete(Devise devise){
    if(devise.getReference()==null) return -1;

    Devise foundedDevise = findByReference(devise.getReference());
    if(foundedDevise==null) return -1;
deviseDao.delete(foundedDevise);
return 1;
}


public List<Devise> findByCriteria(DeviseVo deviseVo){

String query = "SELECT o FROM Devise o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",deviseVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",deviseVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",deviseVo.getReference());
            query += SearchUtil.addConstraint( "o", "unite","LIKE",deviseVo.getUnite());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Devise> devises){
if(ListUtil.isNotEmpty(devises)){
devises.forEach(e->deviseDao.delete(e));
}
}
@Override
public void update(List<Devise> devises){
if(ListUtil.isNotEmpty(devises)){
devises.forEach(e->deviseDao.save(e));
}
}





    }
