package com.ird.faa.service.gestionnaire.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.QuittancePrime;
        import com.ird.faa.bean.Contrat;
import com.ird.faa.dao.QuittancePrimeDao;
import com.ird.faa.service.gestionnaire.facade.QuittancePrimeGestionnaireService;
        import com.ird.faa.service.gestionnaire.facade.ContratGestionnaireService;

import com.ird.faa.ws.rest.provided.vo.QuittancePrimeVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class QuittancePrimeGestionnaireServiceImpl extends AbstractServiceImpl<QuittancePrime> implements QuittancePrimeGestionnaireService {

@Autowired
private QuittancePrimeDao quittancePrimeDao;

        @Autowired
        private ContratGestionnaireService contratService ;


@Autowired
private EntityManager entityManager;


@Override
public List<QuittancePrime> findAll(){
        return quittancePrimeDao.findAll();
}

        @Override
        public List<QuittancePrime> findByContratNumAttestation(String numAttestation){
        return quittancePrimeDao.findByContratNumAttestation(numAttestation);
        }

        @Override
        @Transactional
        public int deleteByContratNumAttestation(String numAttestation){
        return quittancePrimeDao.deleteByContratNumAttestation(numAttestation);
        }

        @Override
        public List<QuittancePrime> findByContratId(Long id){
        return quittancePrimeDao.findByContratId(id);
        }

        @Override
        @Transactional
        public int deleteByContratId(Long id){
        return quittancePrimeDao.deleteByContratId(id);
        }


@Override
public QuittancePrime findById(Long id){
if(id==null) return null;
return quittancePrimeDao.getOne(id);
}

@Override
public QuittancePrime findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(quittancePrimeDao.findById(id).isPresent())  {
quittancePrimeDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public QuittancePrime update(QuittancePrime quittancePrime){
QuittancePrime foundedQuittancePrime = findById(quittancePrime.getId());
if(foundedQuittancePrime==null) return null;
else{
return  quittancePrimeDao.save(quittancePrime);
}
}

@Override
public QuittancePrime save (QuittancePrime quittancePrime){



    findContrat(quittancePrime);

    return quittancePrimeDao.save(quittancePrime);


}

@Override
public List<QuittancePrime> save(List<QuittancePrime> quittancePrimes){
List<QuittancePrime> list = new ArrayList<>();
for(QuittancePrime quittancePrime: quittancePrimes){
list.add(save(quittancePrime));
}
return list;
}



@Override
@Transactional
public int delete(QuittancePrime quittancePrime){
    if(quittancePrime.getId()==null) return -1;
    QuittancePrime foundedQuittancePrime = findById(quittancePrime.getId());
    if(foundedQuittancePrime==null) return -1;
quittancePrimeDao.delete(foundedQuittancePrime);
return 1;
}


public List<QuittancePrime> findByCriteria(QuittancePrimeVo quittancePrimeVo){

String query = "SELECT o FROM QuittancePrime o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",quittancePrimeVo.getId());
            query += SearchUtil.addConstraint( "o", "primeNette","=",quittancePrimeVo.getPrimeNette());
            query += SearchUtil.addConstraint( "o", "taxe","=",quittancePrimeVo.getTaxe());
            query += SearchUtil.addConstraint( "o", "accessoires","LIKE",quittancePrimeVo.getAccessoires());
            query += SearchUtil.addConstraint( "o", "totalTtc","=",quittancePrimeVo.getTotalTtc());
            query += SearchUtil.addConstraint( "o", "totalQuittance","=",quittancePrimeVo.getTotalQuittance());
            query += SearchUtil.addConstraint( "o", "totalPaye","=",quittancePrimeVo.getTotalPaye());
            query += SearchUtil.addConstraint( "o", "rest","=",quittancePrimeVo.getRest());
            query += SearchUtil.addConstraintMinMax("o","primeNette",quittancePrimeVo.getPrimeNetteMin(),quittancePrimeVo.getPrimeNetteMax());
            query += SearchUtil.addConstraintMinMax("o","taxe",quittancePrimeVo.getTaxeMin(),quittancePrimeVo.getTaxeMax());
            query += SearchUtil.addConstraintMinMax("o","totalTtc",quittancePrimeVo.getTotalTtcMin(),quittancePrimeVo.getTotalTtcMax());
            query += SearchUtil.addConstraintMinMax("o","totalQuittance",quittancePrimeVo.getTotalQuittanceMin(),quittancePrimeVo.getTotalQuittanceMax());
            query += SearchUtil.addConstraintMinMax("o","totalPaye",quittancePrimeVo.getTotalPayeMin(),quittancePrimeVo.getTotalPayeMax());
            query += SearchUtil.addConstraintMinMax("o","rest",quittancePrimeVo.getRestMin(),quittancePrimeVo.getRestMax());
    if(quittancePrimeVo.getContratVo()!=null){
        query += SearchUtil.addConstraint( "o", "contrat.id","=",quittancePrimeVo.getContratVo().getId());
            query += SearchUtil.addConstraint( "o", "contrat.numAttestation","LIKE",quittancePrimeVo.getContratVo().getNumAttestation());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findContrat(QuittancePrime quittancePrime){
        Contrat loadedContrat =contratService.findByIdOrNumAttestation(quittancePrime.getContrat());

    if(loadedContrat==null ) {
    return;
    }
    quittancePrime.setContrat(loadedContrat);
    }

@Override
@Transactional
public void delete(List<QuittancePrime> quittancePrimes){
if(ListUtil.isNotEmpty(quittancePrimes)){
quittancePrimes.forEach(e->quittancePrimeDao.delete(e));
}
}
@Override
public void update(List<QuittancePrime> quittancePrimes){
if(ListUtil.isNotEmpty(quittancePrimes)){
quittancePrimes.forEach(e->quittancePrimeDao.save(e));
}
}





    }
