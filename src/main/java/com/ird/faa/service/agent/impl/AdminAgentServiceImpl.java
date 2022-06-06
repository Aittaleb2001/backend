package com.ird.faa.service.agent.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Admin;
import com.ird.faa.dao.AdminDao;
import com.ird.faa.service.agent.facade.AdminAgentService;

import com.ird.faa.ws.rest.provided.vo.AdminVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class AdminAgentServiceImpl extends AbstractServiceImpl<Admin> implements AdminAgentService {

@Autowired
private AdminDao adminDao;



@Autowired
private EntityManager entityManager;

    @Override
    public Admin findByUsername(String username){
    return adminDao.findByUsername(username);
    }

@Override
public List<Admin> findAll(){
        return adminDao.findAll();
}
    @Override
    public Admin findByNumeroMatricule(String numeroMatricule){
    if( numeroMatricule==null) return null;
    return adminDao.findByNumeroMatricule(numeroMatricule);
    }

    @Override
    @Transactional
    public int deleteByNumeroMatricule(String  numeroMatricule) {
    return adminDao.deleteByNumeroMatricule(numeroMatricule);
    }
    @Override
    public Admin findByIdOrNumeroMatricule(Admin admin){
    Admin resultat=null;
    if(admin != null){
    if(StringUtil.isNotEmpty(admin.getId())){
    resultat= adminDao.getOne(admin.getId());
    }else if(StringUtil.isNotEmpty(admin.getNumeroMatricule())) {
    resultat= adminDao.findByNumeroMatricule(admin.getNumeroMatricule());
    }else if(StringUtil.isNotEmpty(admin.getUsername())) {
    resultat = adminDao.findByUsername(admin.getUsername());
    }
    }
    return resultat;
    }

@Override
public Admin findById(Long id){
if(id==null) return null;
return adminDao.getOne(id);
}

@Override
public Admin findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(adminDao.findById(id).isPresent())  {
adminDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Admin update(Admin admin){
Admin foundedAdmin = findById(admin.getId());
if(foundedAdmin==null) return null;
else{
return  adminDao.save(admin);
}
}
    private void prepareSave(Admin admin){
                admin.setCredentialsNonExpired(false);
                admin.setEnabled(false);
                admin.setAccountNonExpired(false);
                admin.setAccountNonLocked(false);
                admin.setPasswordChanged(false);




    }

@Override
public Admin save (Admin admin){
    prepareSave(admin);

    Admin result =null;
        Admin foundedAdmin = findByNumeroMatricule(admin.getNumeroMatricule());
        Admin foundedAdminByUsername = findByNumeroMatricule(admin.getNumeroMatricule());
        if(foundedAdmin == null && foundedAdminByUsername == null){




    Admin savedAdmin = adminDao.save(admin);

    result = savedAdmin;
    }

    return result;
}

@Override
public List<Admin> save(List<Admin> admins){
List<Admin> list = new ArrayList<>();
for(Admin admin: admins){
list.add(save(admin));
}
return list;
}



@Override
@Transactional
public int delete(Admin admin){
    if(admin.getNumeroMatricule()==null) return -1;

    Admin foundedAdmin = findByNumeroMatricule(admin.getNumeroMatricule());
    if(foundedAdmin==null) return -1;
adminDao.delete(foundedAdmin);
return 1;
}


public List<Admin> findByCriteria(AdminVo adminVo){

String query = "SELECT o FROM Admin o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",adminVo.getId());
            query += SearchUtil.addConstraint( "o", "numeroMatricule","LIKE",adminVo.getNumeroMatricule());
            query += SearchUtil.addConstraint( "o", "emailPrincipale","LIKE",adminVo.getEmailPrincipale());
            query += SearchUtil.addConstraint( "o", "formationEnManagement","=",adminVo.getFormationEnManagement());
            query += SearchUtil.addConstraint( "o", "role","LIKE",adminVo.getRole());
            query += SearchUtil.addConstraint( "o", "credentialsNonExpired","=",adminVo.getCredentialsNonExpired());
            query += SearchUtil.addConstraint( "o", "enabled","=",adminVo.getEnabled());
            query += SearchUtil.addConstraint( "o", "accountNonExpired","=",adminVo.getAccountNonExpired());
            query += SearchUtil.addConstraint( "o", "accountNonLocked","=",adminVo.getAccountNonLocked());
            query += SearchUtil.addConstraint( "o", "passwordChanged","=",adminVo.getPasswordChanged());
        query += SearchUtil.addConstraintDate( "o", "createdAt","=",adminVo.getCreatedAt());
        query += SearchUtil.addConstraintDate( "o", "updatedAt","=",adminVo.getUpdatedAt());
            query += SearchUtil.addConstraint( "o", "username","LIKE",adminVo.getUsername());
            query += SearchUtil.addConstraint( "o", "password","LIKE",adminVo.getPassword());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",adminVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",adminVo.getNom());
            query += SearchUtil.addConstraintMinMaxDate("o","createdAt",adminVo.getCreatedAtMin(),adminVo.getCreatedAtMax());
            query += SearchUtil.addConstraintMinMaxDate("o","updatedAt",adminVo.getUpdatedAtMin(),adminVo.getUpdatedAtMax());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Admin> admins){
if(ListUtil.isNotEmpty(admins)){
admins.forEach(e->adminDao.delete(e));
}
}
@Override
public void update(List<Admin> admins){
if(ListUtil.isNotEmpty(admins)){
admins.forEach(e->adminDao.save(e));
}
}





    }
