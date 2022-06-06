package com.ird.faa.service.gestionnaire.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypeVehicule;
import com.ird.faa.dao.TypeVehiculeDao;
import com.ird.faa.service.gestionnaire.facade.TypeVehiculeGestionnaireService;

import com.ird.faa.ws.rest.provided.vo.TypeVehiculeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypeVehiculeGestionnaireServiceImpl extends AbstractServiceImpl<TypeVehicule> implements TypeVehiculeGestionnaireService {

@Autowired
private TypeVehiculeDao typeVehiculeDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypeVehicule> findAll(){
        return typeVehiculeDao.findAll();
}

@Override
public TypeVehicule findById(Long id){
if(id==null) return null;
return typeVehiculeDao.getOne(id);
}

@Override
public TypeVehicule findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(typeVehiculeDao.findById(id).isPresent())  {
typeVehiculeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypeVehicule update(TypeVehicule typeVehicule){
TypeVehicule foundedTypeVehicule = findById(typeVehicule.getId());
if(foundedTypeVehicule==null) return null;
else{
return  typeVehiculeDao.save(typeVehicule);
}
}

@Override
public TypeVehicule save (TypeVehicule typeVehicule){




    return typeVehiculeDao.save(typeVehicule);


}

@Override
public List<TypeVehicule> save(List<TypeVehicule> typeVehicules){
List<TypeVehicule> list = new ArrayList<>();
for(TypeVehicule typeVehicule: typeVehicules){
list.add(save(typeVehicule));
}
return list;
}



@Override
@Transactional
public int delete(TypeVehicule typeVehicule){
    if(typeVehicule.getId()==null) return -1;
    TypeVehicule foundedTypeVehicule = findById(typeVehicule.getId());
    if(foundedTypeVehicule==null) return -1;
typeVehiculeDao.delete(foundedTypeVehicule);
return 1;
}


public List<TypeVehicule> findByCriteria(TypeVehiculeVo typeVehiculeVo){

String query = "SELECT o FROM TypeVehicule o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeVehiculeVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeVehiculeVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeVehicule> typeVehicules){
if(ListUtil.isNotEmpty(typeVehicules)){
typeVehicules.forEach(e->typeVehiculeDao.delete(e));
}
}
@Override
public void update(List<TypeVehicule> typeVehicules){
if(ListUtil.isNotEmpty(typeVehicules)){
typeVehicules.forEach(e->typeVehiculeDao.save(e));
}
}





    }
