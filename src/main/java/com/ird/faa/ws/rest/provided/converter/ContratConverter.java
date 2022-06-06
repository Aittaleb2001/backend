package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Contrat;
import com.ird.faa.ws.rest.provided.vo.ContratVo;

@Component
public class ContratConverter extends AbstractConverter<Contrat,ContratVo>{

        @Autowired
        private VehiculeConverter vehiculeConverter ;
        @Autowired
        private NatureContratConverter natureContratConverter ;
        @Autowired
        private QuittancePrimeConverter quittancePrimeConverter ;
        @Autowired
        private ClientConverter clientConverter ;
        @Autowired
        private ContratGarantieConverter contratGarantieConverter ;
    private Boolean quittancePrime;
    private Boolean natureContrat;
    private Boolean vehicule;
    private Boolean client;
        private Boolean contratGaranties;

public  ContratConverter(){
init(true);
}

@Override
public Contrat toItem(ContratVo vo) {
if (vo == null) {
return null;
} else {
Contrat item = new Contrat();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getNumPolice()))
        item.setNumPolice(vo.getNumPolice());
        if(StringUtil.isNotEmpty(vo.getNumAttestation()))
        item.setNumAttestation(vo.getNumAttestation());
        if(StringUtil.isNotEmpty(vo.getDateEffet()))
        item.setDateEffet(DateUtil.parse(vo.getDateEffet()));
        if(StringUtil.isNotEmpty(vo.getDateEcheance()))
        item.setDateEcheance(DateUtil.parse(vo.getDateEcheance()));
        if(StringUtil.isNotEmpty(vo.getDateSignature()))
        item.setDateSignature(DateUtil.parse(vo.getDateSignature()));
        if(StringUtil.isNotEmpty(vo.getPeriode()))
        item.setPeriode(vo.getPeriode());
    if(vo.getQuittancePrimeVo()!=null && this.quittancePrime)
        item.setQuittancePrime(quittancePrimeConverter.toItem(vo.getQuittancePrimeVo())) ;
    if(vo.getNatureContratVo()!=null && this.natureContrat)
        item.setNatureContrat(natureContratConverter.toItem(vo.getNatureContratVo())) ;
    if(vo.getVehiculeVo()!=null && this.vehicule)
        item.setVehicule(vehiculeConverter.toItem(vo.getVehiculeVo())) ;
    if(vo.getClientVo()!=null && this.client)
        item.setClient(clientConverter.toItem(vo.getClientVo())) ;

        if(ListUtil.isNotEmpty(vo.getContratGarantiesVo()) && this.contratGaranties)
            item.setContratGaranties(contratGarantieConverter.toItem(vo.getContratGarantiesVo()));

return item;
}
}

@Override
public ContratVo toVo(Contrat item) {
if (item == null) {
return null;
} else {
ContratVo vo = new ContratVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getNumPolice()))
        vo.setNumPolice(item.getNumPolice());

        if(StringUtil.isNotEmpty(item.getNumAttestation()))
        vo.setNumAttestation(item.getNumAttestation());

        if(item.getDateEffet()!=null)
        vo.setDateEffet(DateUtil.formateDate(item.getDateEffet()));
        if(item.getDateEcheance()!=null)
        vo.setDateEcheance(DateUtil.formateDate(item.getDateEcheance()));
        if(item.getDateSignature()!=null)
        vo.setDateSignature(DateUtil.formateDate(item.getDateSignature()));
        if(StringUtil.isNotEmpty(item.getPeriode()))
        vo.setPeriode(item.getPeriode());

    if(item.getQuittancePrime()!=null && this.quittancePrime) {
                quittancePrimeConverter.setContrat(false);
        vo.setQuittancePrimeVo(quittancePrimeConverter.toVo(item.getQuittancePrime())) ;
                quittancePrimeConverter.setContrat(true);
    }
    if(item.getNatureContrat()!=null && this.natureContrat) {
        vo.setNatureContratVo(natureContratConverter.toVo(item.getNatureContrat())) ;
    }
    if(item.getVehicule()!=null && this.vehicule) {
                vehiculeConverter.setContrat(false);
        vo.setVehiculeVo(vehiculeConverter.toVo(item.getVehicule())) ;
                vehiculeConverter.setContrat(true);
    }
    if(item.getClient()!=null && this.client) {
        vo.setClientVo(clientConverter.toVo(item.getClient())) ;
    }
        if(this.contratGaranties && ListUtil.isNotEmpty(item.getContratGaranties())){
        contratGarantieConverter.init(true);
        contratGarantieConverter.setContrat(false);
        vo.setContratGarantiesVo(contratGarantieConverter.toVo(item.getContratGaranties()));
        contratGarantieConverter.setContrat(true);
        }

return vo;
}
}

    public void initList(Boolean value) {
            this.contratGaranties = value;
    }
public void init(Boolean value) {
    quittancePrime = value;
    natureContrat = value;
    vehicule = value;
    client = value;
    initList(value);
}


        public VehiculeConverter getVehiculeConverter(){
        return this.vehiculeConverter;
        }
        public void setVehiculeConverter(VehiculeConverter vehiculeConverter ){
        this.vehiculeConverter = vehiculeConverter;
        }
        public NatureContratConverter getNatureContratConverter(){
        return this.natureContratConverter;
        }
        public void setNatureContratConverter(NatureContratConverter natureContratConverter ){
        this.natureContratConverter = natureContratConverter;
        }
        public QuittancePrimeConverter getQuittancePrimeConverter(){
        return this.quittancePrimeConverter;
        }
        public void setQuittancePrimeConverter(QuittancePrimeConverter quittancePrimeConverter ){
        this.quittancePrimeConverter = quittancePrimeConverter;
        }
        public ClientConverter getClientConverter(){
        return this.clientConverter;
        }
        public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
        }
        public ContratGarantieConverter getContratGarantieConverter(){
        return this.contratGarantieConverter;
        }
        public void setContratGarantieConverter(ContratGarantieConverter contratGarantieConverter ){
        this.contratGarantieConverter = contratGarantieConverter;
        }

    public boolean  isQuittancePrime(){
    return this.quittancePrime;
    }
    public void  setQuittancePrime(boolean quittancePrime){
    this.quittancePrime = quittancePrime;
    }
    public boolean  isNatureContrat(){
    return this.natureContrat;
    }
    public void  setNatureContrat(boolean natureContrat){
    this.natureContrat = natureContrat;
    }
    public boolean  isVehicule(){
    return this.vehicule;
    }
    public void  setVehicule(boolean vehicule){
    this.vehicule = vehicule;
    }
    public boolean  isClient(){
    return this.client;
    }
    public void  setClient(boolean client){
    this.client = client;
    }























        public Boolean  isContratGaranties(){
        return this.contratGaranties ;
        }
        public void  setContratGaranties(Boolean contratGaranties ){
        this.contratGaranties  = contratGaranties ;
        }


}
