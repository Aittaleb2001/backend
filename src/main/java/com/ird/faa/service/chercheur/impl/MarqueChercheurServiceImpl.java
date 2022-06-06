package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Marque;
import com.ird.faa.dao.MarqueDao;
import com.ird.faa.service.chercheur.facade.MarqueChercheurService;

import com.ird.faa.ws.rest.provided.vo.MarqueVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class MarqueChercheurServiceImpl extends AbstractServiceImpl<Marque> implements MarqueChercheurService {

@Autowired
private MarqueDao marqueDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Marque> findAll(){
        return marqueDao.findAll();
}

@Override
public Marque findById(Long id){
if(id==null) return null;
return marqueDao.getOne(id);
}

@Override
public Marque findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(marqueDao.findById(id).isPresent())  {
marqueDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Marque update(Marque marque){
Marque foundedMarque = findById(marque.getId());
if(foundedMarque==null) return null;
else{
return  marqueDao.save(marque);
}
}

@Override
public Marque save (Marque marque){




    return marqueDao.save(marque);


}

@Override
public List<Marque> save(List<Marque> marques){
List<Marque> list = new ArrayList<>();
for(Marque marque: marques){
list.add(save(marque));
}
return list;
}



@Override
@Transactional
public int delete(Marque marque){
    if(marque.getId()==null) return -1;
    Marque foundedMarque = findById(marque.getId());
    if(foundedMarque==null) return -1;
marqueDao.delete(foundedMarque);
return 1;
}


public List<Marque> findByCriteria(MarqueVo marqueVo){

String query = "SELECT o FROM Marque o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",marqueVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",marqueVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Marque> marques){
if(ListUtil.isNotEmpty(marques)){
marques.forEach(e->marqueDao.delete(e));
}
}
@Override
public void update(List<Marque> marques){
if(ListUtil.isNotEmpty(marques)){
marques.forEach(e->marqueDao.save(e));
}
}





    }
