package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Carburant;
import com.ird.faa.dao.CarburantDao;
import com.ird.faa.service.admin.facade.CarburantAdminService;

import com.ird.faa.ws.rest.provided.vo.CarburantVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CarburantAdminServiceImpl extends AbstractServiceImpl<Carburant> implements CarburantAdminService {

@Autowired
private CarburantDao carburantDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Carburant> findAll(){
        return carburantDao.findAll();
}

@Override
public Carburant findById(Long id){
if(id==null) return null;
return carburantDao.getOne(id);
}

@Override
public Carburant findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(carburantDao.findById(id).isPresent())  {
carburantDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Carburant update(Carburant carburant){
Carburant foundedCarburant = findById(carburant.getId());
if(foundedCarburant==null) return null;
else{
return  carburantDao.save(carburant);
}
}

@Override
public Carburant save (Carburant carburant){




    return carburantDao.save(carburant);


}

@Override
public List<Carburant> save(List<Carburant> carburants){
List<Carburant> list = new ArrayList<>();
for(Carburant carburant: carburants){
list.add(save(carburant));
}
return list;
}



@Override
@Transactional
public int delete(Carburant carburant){
    if(carburant.getId()==null) return -1;
    Carburant foundedCarburant = findById(carburant.getId());
    if(foundedCarburant==null) return -1;
carburantDao.delete(foundedCarburant);
return 1;
}


public List<Carburant> findByCriteria(CarburantVo carburantVo){

String query = "SELECT o FROM Carburant o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",carburantVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",carburantVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Carburant> carburants){
if(ListUtil.isNotEmpty(carburants)){
carburants.forEach(e->carburantDao.delete(e));
}
}
@Override
public void update(List<Carburant> carburants){
if(ListUtil.isNotEmpty(carburants)){
carburants.forEach(e->carburantDao.save(e));
}
}





    }
