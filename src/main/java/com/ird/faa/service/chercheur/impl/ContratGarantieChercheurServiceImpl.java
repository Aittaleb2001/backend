package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.ContratGarantie;
        import com.ird.faa.bean.Contrat;
        import com.ird.faa.bean.Garantie;
import com.ird.faa.dao.ContratGarantieDao;
import com.ird.faa.service.chercheur.facade.ContratGarantieChercheurService;
        import com.ird.faa.service.chercheur.facade.GarantieChercheurService;
        import com.ird.faa.service.chercheur.facade.ContratChercheurService;

import com.ird.faa.ws.rest.provided.vo.ContratGarantieVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ContratGarantieChercheurServiceImpl extends AbstractServiceImpl<ContratGarantie> implements ContratGarantieChercheurService {

@Autowired
private ContratGarantieDao contratGarantieDao;

        @Autowired
        private GarantieChercheurService garantieService ;
        @Autowired
        private ContratChercheurService contratService ;


@Autowired
private EntityManager entityManager;


@Override
public List<ContratGarantie> findAll(){
        return contratGarantieDao.findAll();
}

        @Override
        public List<ContratGarantie> findByContratNumAttestation(String numAttestation){
        return contratGarantieDao.findByContratNumAttestation(numAttestation);
        }

        @Override
        @Transactional
        public int deleteByContratNumAttestation(String numAttestation){
        return contratGarantieDao.deleteByContratNumAttestation(numAttestation);
        }

        @Override
        public List<ContratGarantie> findByContratId(Long id){
        return contratGarantieDao.findByContratId(id);
        }

        @Override
        @Transactional
        public int deleteByContratId(Long id){
        return contratGarantieDao.deleteByContratId(id);
        }

        @Override
        public List<ContratGarantie> findByGarantieId(Long id){
        return contratGarantieDao.findByGarantieId(id);
        }

        @Override
        @Transactional
        public int deleteByGarantieId(Long id){
        return contratGarantieDao.deleteByGarantieId(id);
        }


@Override
public ContratGarantie findById(Long id){
if(id==null) return null;
return contratGarantieDao.getOne(id);
}

@Override
public ContratGarantie findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(contratGarantieDao.findById(id).isPresent())  {
contratGarantieDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public ContratGarantie update(ContratGarantie contratGarantie){
ContratGarantie foundedContratGarantie = findById(contratGarantie.getId());
if(foundedContratGarantie==null) return null;
else{
return  contratGarantieDao.save(contratGarantie);
}
}

@Override
public ContratGarantie save (ContratGarantie contratGarantie){



    findContrat(contratGarantie);
    findGarantie(contratGarantie);

    return contratGarantieDao.save(contratGarantie);


}

@Override
public List<ContratGarantie> save(List<ContratGarantie> contratGaranties){
List<ContratGarantie> list = new ArrayList<>();
for(ContratGarantie contratGarantie: contratGaranties){
list.add(save(contratGarantie));
}
return list;
}



@Override
@Transactional
public int delete(ContratGarantie contratGarantie){
    if(contratGarantie.getId()==null) return -1;
    ContratGarantie foundedContratGarantie = findById(contratGarantie.getId());
    if(foundedContratGarantie==null) return -1;
contratGarantieDao.delete(foundedContratGarantie);
return 1;
}


public List<ContratGarantie> findByCriteria(ContratGarantieVo contratGarantieVo){

String query = "SELECT o FROM ContratGarantie o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",contratGarantieVo.getId());
    if(contratGarantieVo.getContratVo()!=null){
        query += SearchUtil.addConstraint( "o", "contrat.id","=",contratGarantieVo.getContratVo().getId());
            query += SearchUtil.addConstraint( "o", "contrat.numAttestation","LIKE",contratGarantieVo.getContratVo().getNumAttestation());
    }

    if(contratGarantieVo.getGarantieVo()!=null){
        query += SearchUtil.addConstraint( "o", "garantie.id","=",contratGarantieVo.getGarantieVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findContrat(ContratGarantie contratGarantie){
        Contrat loadedContrat =contratService.findByIdOrNumAttestation(contratGarantie.getContrat());

    if(loadedContrat==null ) {
    return;
    }
    contratGarantie.setContrat(loadedContrat);
    }
    private void findGarantie(ContratGarantie contratGarantie){
        Garantie loadedGarantie = null;
        if(contratGarantie.getGarantie() != null && contratGarantie.getGarantie().getId() !=null)
        loadedGarantie =garantieService.findById(contratGarantie.getGarantie().getId());

    if(loadedGarantie==null ) {
    return;
    }
    contratGarantie.setGarantie(loadedGarantie);
    }

@Override
@Transactional
public void delete(List<ContratGarantie> contratGaranties){
if(ListUtil.isNotEmpty(contratGaranties)){
contratGaranties.forEach(e->contratGarantieDao.delete(e));
}
}
@Override
public void update(List<ContratGarantie> contratGaranties){
if(ListUtil.isNotEmpty(contratGaranties)){
contratGaranties.forEach(e->contratGarantieDao.save(e));
}
}





    }
