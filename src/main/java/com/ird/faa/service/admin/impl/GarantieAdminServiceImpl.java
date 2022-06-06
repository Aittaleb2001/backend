package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Garantie;
import com.ird.faa.dao.GarantieDao;
import com.ird.faa.service.admin.facade.GarantieAdminService;

import com.ird.faa.ws.rest.provided.vo.GarantieVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class GarantieAdminServiceImpl extends AbstractServiceImpl<Garantie> implements GarantieAdminService {

@Autowired
private GarantieDao garantieDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Garantie> findAll(){
        return garantieDao.findAll();
}

@Override
public Garantie findById(Long id){
if(id==null) return null;
return garantieDao.getOne(id);
}

@Override
public Garantie findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(garantieDao.findById(id).isPresent())  {
garantieDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Garantie update(Garantie garantie){
Garantie foundedGarantie = findById(garantie.getId());
if(foundedGarantie==null) return null;
else{
return  garantieDao.save(garantie);
}
}

@Override
public Garantie save (Garantie garantie){




    return garantieDao.save(garantie);


}

@Override
public List<Garantie> save(List<Garantie> garanties){
List<Garantie> list = new ArrayList<>();
for(Garantie garantie: garanties){
list.add(save(garantie));
}
return list;
}



@Override
@Transactional
public int delete(Garantie garantie){
    if(garantie.getId()==null) return -1;
    Garantie foundedGarantie = findById(garantie.getId());
    if(foundedGarantie==null) return -1;
garantieDao.delete(foundedGarantie);
return 1;
}


public List<Garantie> findByCriteria(GarantieVo garantieVo){

String query = "SELECT o FROM Garantie o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",garantieVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",garantieVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Garantie> garanties){
if(ListUtil.isNotEmpty(garanties)){
garanties.forEach(e->garantieDao.delete(e));
}
}
@Override
public void update(List<Garantie> garanties){
if(ListUtil.isNotEmpty(garanties)){
garanties.forEach(e->garantieDao.save(e));
}
}





    }
