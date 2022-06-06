package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Vehicule;
import com.ird.faa.ws.rest.provided.vo.VehiculeVo;

@Component
public class VehiculeConverter extends AbstractConverter<Vehicule,VehiculeVo>{

        @Autowired
        private MarqueConverter marqueConverter ;
        @Autowired
        private TypeVehiculeConverter typeVehiculeConverter ;
        @Autowired
        private CarburantConverter carburantConverter ;
        @Autowired
        private ClientConverter clientConverter ;
        @Autowired
        private ContratConverter contratConverter ;
    private Boolean carburant;
    private Boolean typeVehicule;
    private Boolean client;
    private Boolean contrat;
    private Boolean marque;

public  VehiculeConverter(){
init(true);
}

@Override
public Vehicule toItem(VehiculeVo vo) {
if (vo == null) {
return null;
} else {
Vehicule item = new Vehicule();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getCodeVerification()))
        item.setCodeVerification(vo.getCodeVerification());
        if(StringUtil.isNotEmpty(vo.getMatricule()))
        item.setMatricule(vo.getMatricule());
        if(StringUtil.isNotEmpty(vo.getCylindree()))
        item.setCylindree(NumberUtil.toBigDecimal(vo.getCylindree()));
        if(StringUtil.isNotEmpty(vo.getVersion()))
        item.setVersion(vo.getVersion());
        if(StringUtil.isNotEmpty(vo.getPoidsEncharge()))
        item.setPoidsEncharge(NumberUtil.toBigDecimal(vo.getPoidsEncharge()));
        if(StringUtil.isNotEmpty(vo.getNombrePlaces()))
        item.setNombrePlaces(NumberUtil.toBigDecimal(vo.getNombrePlaces()));
        if(StringUtil.isNotEmpty(vo.getPuissanceFiscale()))
        item.setPuissanceFiscale(vo.getPuissanceFiscale());
    if(vo.getCarburantVo()!=null && this.carburant)
        item.setCarburant(carburantConverter.toItem(vo.getCarburantVo())) ;
    if(vo.getTypeVehiculeVo()!=null && this.typeVehicule)
        item.setTypeVehicule(typeVehiculeConverter.toItem(vo.getTypeVehiculeVo())) ;
    if(vo.getClientVo()!=null && this.client)
        item.setClient(clientConverter.toItem(vo.getClientVo())) ;
    if(vo.getContratVo()!=null && this.contrat)
        item.setContrat(contratConverter.toItem(vo.getContratVo())) ;
    if(vo.getMarqueVo()!=null && this.marque)
        item.setMarque(marqueConverter.toItem(vo.getMarqueVo())) ;


return item;
}
}

@Override
public VehiculeVo toVo(Vehicule item) {
if (item == null) {
return null;
} else {
VehiculeVo vo = new VehiculeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getCodeVerification()))
        vo.setCodeVerification(item.getCodeVerification());

        if(StringUtil.isNotEmpty(item.getMatricule()))
        vo.setMatricule(item.getMatricule());

        if(item.getCylindree()!=null)
        vo.setCylindree(NumberUtil.toString(item.getCylindree()));

        if(StringUtil.isNotEmpty(item.getVersion()))
        vo.setVersion(item.getVersion());

        if(item.getPoidsEncharge()!=null)
        vo.setPoidsEncharge(NumberUtil.toString(item.getPoidsEncharge()));

        if(item.getNombrePlaces()!=null)
        vo.setNombrePlaces(NumberUtil.toString(item.getNombrePlaces()));

        if(StringUtil.isNotEmpty(item.getPuissanceFiscale()))
        vo.setPuissanceFiscale(item.getPuissanceFiscale());

    if(item.getCarburant()!=null && this.carburant) {
        vo.setCarburantVo(carburantConverter.toVo(item.getCarburant())) ;
    }
    if(item.getTypeVehicule()!=null && this.typeVehicule) {
        vo.setTypeVehiculeVo(typeVehiculeConverter.toVo(item.getTypeVehicule())) ;
    }
    if(item.getClient()!=null && this.client) {
        vo.setClientVo(clientConverter.toVo(item.getClient())) ;
    }
    if(item.getContrat()!=null && this.contrat) {
                contratConverter.setVehicule(false);
        vo.setContratVo(contratConverter.toVo(item.getContrat())) ;
                contratConverter.setVehicule(true);
    }
    if(item.getMarque()!=null && this.marque) {
        vo.setMarqueVo(marqueConverter.toVo(item.getMarque())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    carburant = value;
    typeVehicule = value;
    client = value;
    contrat = value;
    marque = value;
}


        public MarqueConverter getMarqueConverter(){
        return this.marqueConverter;
        }
        public void setMarqueConverter(MarqueConverter marqueConverter ){
        this.marqueConverter = marqueConverter;
        }
        public TypeVehiculeConverter getTypeVehiculeConverter(){
        return this.typeVehiculeConverter;
        }
        public void setTypeVehiculeConverter(TypeVehiculeConverter typeVehiculeConverter ){
        this.typeVehiculeConverter = typeVehiculeConverter;
        }
        public CarburantConverter getCarburantConverter(){
        return this.carburantConverter;
        }
        public void setCarburantConverter(CarburantConverter carburantConverter ){
        this.carburantConverter = carburantConverter;
        }
        public ClientConverter getClientConverter(){
        return this.clientConverter;
        }
        public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
        }
        public ContratConverter getContratConverter(){
        return this.contratConverter;
        }
        public void setContratConverter(ContratConverter contratConverter ){
        this.contratConverter = contratConverter;
        }

    public boolean  isCarburant(){
    return this.carburant;
    }
    public void  setCarburant(boolean carburant){
    this.carburant = carburant;
    }
    public boolean  isTypeVehicule(){
    return this.typeVehicule;
    }
    public void  setTypeVehicule(boolean typeVehicule){
    this.typeVehicule = typeVehicule;
    }
    public boolean  isClient(){
    return this.client;
    }
    public void  setClient(boolean client){
    this.client = client;
    }
    public boolean  isContrat(){
    return this.contrat;
    }
    public void  setContrat(boolean contrat){
    this.contrat = contrat;
    }
    public boolean  isMarque(){
    return this.marque;
    }
    public void  setMarque(boolean marque){
    this.marque = marque;
    }




























}
