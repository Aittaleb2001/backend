package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Sinistre;
        import com.ird.faa.bean.TypeSinistre;
        import com.ird.faa.bean.Client;
import com.ird.faa.dao.SinistreDao;
import com.ird.faa.service.admin.facade.SinistreAdminService;
        import com.ird.faa.service.admin.facade.TypeSinistreAdminService;
        import com.ird.faa.service.admin.facade.ClientAdminService;

import com.ird.faa.ws.rest.provided.vo.SinistreVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class SinistreAdminServiceImpl extends AbstractServiceImpl<Sinistre> implements SinistreAdminService {

@Autowired
private SinistreDao sinistreDao;

        @Autowired
        private TypeSinistreAdminService typeSinistreService ;
        @Autowired
        private ClientAdminService clientService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Sinistre> findAll(){
        return sinistreDao.findAll();
}
        @Override
        public List<Sinistre> findByTypeSinistreId(Long id){
        return sinistreDao.findByTypeSinistreId(id);
        }

        @Override
        @Transactional
        public int deleteByTypeSinistreId(Long id){
        return sinistreDao.deleteByTypeSinistreId(id);
        }


        @Override
        public List<Sinistre> findByClientReference(String reference){
        return sinistreDao.findByClientReference(reference);
        }

        @Override
        @Transactional
        public int deleteByClientReference(String reference){
        return sinistreDao.deleteByClientReference(reference);
        }

        @Override
        public List<Sinistre> findByClientId(Long id){
        return sinistreDao.findByClientId(id);
        }

        @Override
        @Transactional
        public int deleteByClientId(Long id){
        return sinistreDao.deleteByClientId(id);
        }

    @Override
    public Sinistre findByReference(String reference){
    if( reference==null) return null;
    return sinistreDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return sinistreDao.deleteByReference(reference);
    }
    @Override
    public Sinistre findByIdOrReference(Sinistre sinistre){
    Sinistre resultat=null;
    if(sinistre != null){
    if(StringUtil.isNotEmpty(sinistre.getId())){
    resultat= sinistreDao.getOne(sinistre.getId());
    }else if(StringUtil.isNotEmpty(sinistre.getReference())) {
    resultat= sinistreDao.findByReference(sinistre.getReference());
    }
    }
    return resultat;
    }

@Override
public Sinistre findById(Long id){
if(id==null) return null;
return sinistreDao.getOne(id);
}

@Override
public Sinistre findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(sinistreDao.findById(id).isPresent())  {
sinistreDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Sinistre update(Sinistre sinistre){
Sinistre foundedSinistre = findById(sinistre.getId());
if(foundedSinistre==null) return null;
else{
return  sinistreDao.save(sinistre);
}
}

@Override
public Sinistre save (Sinistre sinistre){

    Sinistre result =null;
    Sinistre foundedSinistre = findByReference(sinistre.getReference());
    if(foundedSinistre == null){



    findTypeSinistre(sinistre);
    findClient(sinistre);

    Sinistre savedSinistre = sinistreDao.save(sinistre);

    result = savedSinistre;
    }

    return result;
}

@Override
public List<Sinistre> save(List<Sinistre> sinistres){
List<Sinistre> list = new ArrayList<>();
for(Sinistre sinistre: sinistres){
list.add(save(sinistre));
}
return list;
}



@Override
@Transactional
public int delete(Sinistre sinistre){
    if(sinistre.getReference()==null) return -1;

    Sinistre foundedSinistre = findByReference(sinistre.getReference());
    if(foundedSinistre==null) return -1;
sinistreDao.delete(foundedSinistre);
return 1;
}


public List<Sinistre> findByCriteria(SinistreVo sinistreVo){

String query = "SELECT o FROM Sinistre o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",sinistreVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",sinistreVo.getReference());
            query += SearchUtil.addConstraint( "o", "description","LIKE",sinistreVo.getDescription());
            query += SearchUtil.addConstraint( "o", "cause","LIKE",sinistreVo.getCause());
            query += SearchUtil.addConstraint( "o", "objet","LIKE",sinistreVo.getObjet());
    if(sinistreVo.getTypeSinistreVo()!=null){
        query += SearchUtil.addConstraint( "o", "typeSinistre.id","=",sinistreVo.getTypeSinistreVo().getId());
    }

    if(sinistreVo.getClientVo()!=null){
        query += SearchUtil.addConstraint( "o", "client.id","=",sinistreVo.getClientVo().getId());
            query += SearchUtil.addConstraint( "o", "client.reference","LIKE",sinistreVo.getClientVo().getReference());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findTypeSinistre(Sinistre sinistre){
        TypeSinistre loadedTypeSinistre = null;
        if(sinistre.getTypeSinistre() != null && sinistre.getTypeSinistre().getId() !=null)
        loadedTypeSinistre =typeSinistreService.findById(sinistre.getTypeSinistre().getId());

    if(loadedTypeSinistre==null ) {
    return;
    }
    sinistre.setTypeSinistre(loadedTypeSinistre);
    }
    private void findClient(Sinistre sinistre){
        Client loadedClient =clientService.findByIdOrReference(sinistre.getClient());

    if(loadedClient==null ) {
    return;
    }
    sinistre.setClient(loadedClient);
    }

@Override
@Transactional
public void delete(List<Sinistre> sinistres){
if(ListUtil.isNotEmpty(sinistres)){
sinistres.forEach(e->sinistreDao.delete(e));
}
}
@Override
public void update(List<Sinistre> sinistres){
if(ListUtil.isNotEmpty(sinistres)){
sinistres.forEach(e->sinistreDao.save(e));
}
}





    }
