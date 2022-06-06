package com.ird.faa.service.agent.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.QuittanceIndemniser;
        import com.ird.faa.bean.Devise;
import com.ird.faa.dao.QuittanceIndemniserDao;
import com.ird.faa.service.agent.facade.QuittanceIndemniserAgentService;
        import com.ird.faa.service.agent.facade.DeviseAgentService;

import com.ird.faa.ws.rest.provided.vo.QuittanceIndemniserVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class QuittanceIndemniserAgentServiceImpl extends AbstractServiceImpl<QuittanceIndemniser> implements QuittanceIndemniserAgentService {

@Autowired
private QuittanceIndemniserDao quittanceIndemniserDao;

        @Autowired
        private DeviseAgentService deviseService ;


@Autowired
private EntityManager entityManager;


@Override
public List<QuittanceIndemniser> findAll(){
        return quittanceIndemniserDao.findAll();
}

        @Override
        public List<QuittanceIndemniser> findByDeviseReference(String reference){
        return quittanceIndemniserDao.findByDeviseReference(reference);
        }

        @Override
        @Transactional
        public int deleteByDeviseReference(String reference){
        return quittanceIndemniserDao.deleteByDeviseReference(reference);
        }

        @Override
        public List<QuittanceIndemniser> findByDeviseId(Long id){
        return quittanceIndemniserDao.findByDeviseId(id);
        }

        @Override
        @Transactional
        public int deleteByDeviseId(Long id){
        return quittanceIndemniserDao.deleteByDeviseId(id);
        }

    @Override
    public QuittanceIndemniser findByReference(String reference){
    if( reference==null) return null;
    return quittanceIndemniserDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return quittanceIndemniserDao.deleteByReference(reference);
    }
    @Override
    public QuittanceIndemniser findByIdOrReference(QuittanceIndemniser quittanceIndemniser){
    QuittanceIndemniser resultat=null;
    if(quittanceIndemniser != null){
    if(StringUtil.isNotEmpty(quittanceIndemniser.getId())){
    resultat= quittanceIndemniserDao.getOne(quittanceIndemniser.getId());
    }else if(StringUtil.isNotEmpty(quittanceIndemniser.getReference())) {
    resultat= quittanceIndemniserDao.findByReference(quittanceIndemniser.getReference());
    }
    }
    return resultat;
    }

@Override
public QuittanceIndemniser findById(Long id){
if(id==null) return null;
return quittanceIndemniserDao.getOne(id);
}

@Override
public QuittanceIndemniser findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(quittanceIndemniserDao.findById(id).isPresent())  {
quittanceIndemniserDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public QuittanceIndemniser update(QuittanceIndemniser quittanceIndemniser){
QuittanceIndemniser foundedQuittanceIndemniser = findById(quittanceIndemniser.getId());
if(foundedQuittanceIndemniser==null) return null;
else{
return  quittanceIndemniserDao.save(quittanceIndemniser);
}
}

@Override
public QuittanceIndemniser save (QuittanceIndemniser quittanceIndemniser){

    QuittanceIndemniser result =null;
    QuittanceIndemniser foundedQuittanceIndemniser = findByReference(quittanceIndemniser.getReference());
    if(foundedQuittanceIndemniser == null){



    findDevise(quittanceIndemniser);

    QuittanceIndemniser savedQuittanceIndemniser = quittanceIndemniserDao.save(quittanceIndemniser);

    result = savedQuittanceIndemniser;
    }

    return result;
}

@Override
public List<QuittanceIndemniser> save(List<QuittanceIndemniser> quittanceIndemnisers){
List<QuittanceIndemniser> list = new ArrayList<>();
for(QuittanceIndemniser quittanceIndemniser: quittanceIndemnisers){
list.add(save(quittanceIndemniser));
}
return list;
}



@Override
@Transactional
public int delete(QuittanceIndemniser quittanceIndemniser){
    if(quittanceIndemniser.getReference()==null) return -1;

    QuittanceIndemniser foundedQuittanceIndemniser = findByReference(quittanceIndemniser.getReference());
    if(foundedQuittanceIndemniser==null) return -1;
quittanceIndemniserDao.delete(foundedQuittanceIndemniser);
return 1;
}


public List<QuittanceIndemniser> findByCriteria(QuittanceIndemniserVo quittanceIndemniserVo){

String query = "SELECT o FROM QuittanceIndemniser o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",quittanceIndemniserVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",quittanceIndemniserVo.getReference());
        query += SearchUtil.addConstraintDate( "o", "dateReception","=",quittanceIndemniserVo.getDateReception());
        query += SearchUtil.addConstraintDate( "o", "dateAjout","=",quittanceIndemniserVo.getDateAjout());
            query += SearchUtil.addConstraint( "o", "objet","LIKE",quittanceIndemniserVo.getObjet());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",quittanceIndemniserVo.getLibelle());
            query += SearchUtil.addConstraintMinMaxDate("o","dateReception",quittanceIndemniserVo.getDateReceptionMin(),quittanceIndemniserVo.getDateReceptionMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateAjout",quittanceIndemniserVo.getDateAjoutMin(),quittanceIndemniserVo.getDateAjoutMax());
    if(quittanceIndemniserVo.getDeviseVo()!=null){
        query += SearchUtil.addConstraint( "o", "devise.id","=",quittanceIndemniserVo.getDeviseVo().getId());
            query += SearchUtil.addConstraint( "o", "devise.reference","LIKE",quittanceIndemniserVo.getDeviseVo().getReference());
    }

    query+= " ORDER BY o.dateAjout";
return entityManager.createQuery(query).getResultList();
}

    private void findDevise(QuittanceIndemniser quittanceIndemniser){
        Devise loadedDevise =deviseService.findByIdOrReference(quittanceIndemniser.getDevise());

    if(loadedDevise==null ) {
    return;
    }
    quittanceIndemniser.setDevise(loadedDevise);
    }

@Override
@Transactional
public void delete(List<QuittanceIndemniser> quittanceIndemnisers){
if(ListUtil.isNotEmpty(quittanceIndemnisers)){
quittanceIndemnisers.forEach(e->quittanceIndemniserDao.delete(e));
}
}
@Override
public void update(List<QuittanceIndemniser> quittanceIndemnisers){
if(ListUtil.isNotEmpty(quittanceIndemnisers)){
quittanceIndemnisers.forEach(e->quittanceIndemniserDao.save(e));
}
}





    }
