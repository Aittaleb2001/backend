package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.NatureContrat;
import com.ird.faa.dao.NatureContratDao;
import com.ird.faa.service.admin.facade.NatureContratAdminService;

import com.ird.faa.ws.rest.provided.vo.NatureContratVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class NatureContratAdminServiceImpl extends AbstractServiceImpl<NatureContrat> implements NatureContratAdminService {

@Autowired
private NatureContratDao natureContratDao;



@Autowired
private EntityManager entityManager;


@Override
public List<NatureContrat> findAll(){
        return natureContratDao.findAll();
}

@Override
public NatureContrat findById(Long id){
if(id==null) return null;
return natureContratDao.getOne(id);
}

@Override
public NatureContrat findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(natureContratDao.findById(id).isPresent())  {
natureContratDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public NatureContrat update(NatureContrat natureContrat){
NatureContrat foundedNatureContrat = findById(natureContrat.getId());
if(foundedNatureContrat==null) return null;
else{
return  natureContratDao.save(natureContrat);
}
}

@Override
public NatureContrat save (NatureContrat natureContrat){




    return natureContratDao.save(natureContrat);


}

@Override
public List<NatureContrat> save(List<NatureContrat> natureContrats){
List<NatureContrat> list = new ArrayList<>();
for(NatureContrat natureContrat: natureContrats){
list.add(save(natureContrat));
}
return list;
}



@Override
@Transactional
public int delete(NatureContrat natureContrat){
    if(natureContrat.getId()==null) return -1;
    NatureContrat foundedNatureContrat = findById(natureContrat.getId());
    if(foundedNatureContrat==null) return -1;
natureContratDao.delete(foundedNatureContrat);
return 1;
}


public List<NatureContrat> findByCriteria(NatureContratVo natureContratVo){

String query = "SELECT o FROM NatureContrat o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",natureContratVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",natureContratVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<NatureContrat> natureContrats){
if(ListUtil.isNotEmpty(natureContrats)){
natureContrats.forEach(e->natureContratDao.delete(e));
}
}
@Override
public void update(List<NatureContrat> natureContrats){
if(ListUtil.isNotEmpty(natureContrats)){
natureContrats.forEach(e->natureContratDao.save(e));
}
}





    }
