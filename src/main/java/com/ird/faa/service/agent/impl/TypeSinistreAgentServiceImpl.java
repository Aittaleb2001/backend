package com.ird.faa.service.agent.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypeSinistre;
import com.ird.faa.dao.TypeSinistreDao;
import com.ird.faa.service.agent.facade.TypeSinistreAgentService;

import com.ird.faa.ws.rest.provided.vo.TypeSinistreVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypeSinistreAgentServiceImpl extends AbstractServiceImpl<TypeSinistre> implements TypeSinistreAgentService {

@Autowired
private TypeSinistreDao typeSinistreDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypeSinistre> findAll(){
        return typeSinistreDao.findAll();
}

@Override
public TypeSinistre findById(Long id){
if(id==null) return null;
return typeSinistreDao.getOne(id);
}

@Override
public TypeSinistre findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(typeSinistreDao.findById(id).isPresent())  {
typeSinistreDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypeSinistre update(TypeSinistre typeSinistre){
TypeSinistre foundedTypeSinistre = findById(typeSinistre.getId());
if(foundedTypeSinistre==null) return null;
else{
return  typeSinistreDao.save(typeSinistre);
}
}

@Override
public TypeSinistre save (TypeSinistre typeSinistre){




    return typeSinistreDao.save(typeSinistre);


}

@Override
public List<TypeSinistre> save(List<TypeSinistre> typeSinistres){
List<TypeSinistre> list = new ArrayList<>();
for(TypeSinistre typeSinistre: typeSinistres){
list.add(save(typeSinistre));
}
return list;
}



@Override
@Transactional
public int delete(TypeSinistre typeSinistre){
    if(typeSinistre.getId()==null) return -1;
    TypeSinistre foundedTypeSinistre = findById(typeSinistre.getId());
    if(foundedTypeSinistre==null) return -1;
typeSinistreDao.delete(foundedTypeSinistre);
return 1;
}


public List<TypeSinistre> findByCriteria(TypeSinistreVo typeSinistreVo){

String query = "SELECT o FROM TypeSinistre o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeSinistreVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeSinistreVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeSinistre> typeSinistres){
if(ListUtil.isNotEmpty(typeSinistres)){
typeSinistres.forEach(e->typeSinistreDao.delete(e));
}
}
@Override
public void update(List<TypeSinistre> typeSinistres){
if(ListUtil.isNotEmpty(typeSinistres)){
typeSinistres.forEach(e->typeSinistreDao.save(e));
}
}





    }
