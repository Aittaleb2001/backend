package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypeClient;
import com.ird.faa.dao.TypeClientDao;
import com.ird.faa.service.admin.facade.TypeClientAdminService;

import com.ird.faa.ws.rest.provided.vo.TypeClientVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypeClientAdminServiceImpl extends AbstractServiceImpl<TypeClient> implements TypeClientAdminService {

@Autowired
private TypeClientDao typeClientDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypeClient> findAll(){
        return typeClientDao.findAll();
}

@Override
public TypeClient findById(Long id){
if(id==null) return null;
return typeClientDao.getOne(id);
}

@Override
public TypeClient findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(typeClientDao.findById(id).isPresent())  {
typeClientDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypeClient update(TypeClient typeClient){
TypeClient foundedTypeClient = findById(typeClient.getId());
if(foundedTypeClient==null) return null;
else{
return  typeClientDao.save(typeClient);
}
}

@Override
public TypeClient save (TypeClient typeClient){




    return typeClientDao.save(typeClient);


}

@Override
public List<TypeClient> save(List<TypeClient> typeClients){
List<TypeClient> list = new ArrayList<>();
for(TypeClient typeClient: typeClients){
list.add(save(typeClient));
}
return list;
}



@Override
@Transactional
public int delete(TypeClient typeClient){
    if(typeClient.getId()==null) return -1;
    TypeClient foundedTypeClient = findById(typeClient.getId());
    if(foundedTypeClient==null) return -1;
typeClientDao.delete(foundedTypeClient);
return 1;
}


public List<TypeClient> findByCriteria(TypeClientVo typeClientVo){

String query = "SELECT o FROM TypeClient o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeClientVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeClientVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeClient> typeClients){
if(ListUtil.isNotEmpty(typeClients)){
typeClients.forEach(e->typeClientDao.delete(e));
}
}
@Override
public void update(List<TypeClient> typeClients){
if(ListUtil.isNotEmpty(typeClients)){
typeClients.forEach(e->typeClientDao.save(e));
}
}





    }
