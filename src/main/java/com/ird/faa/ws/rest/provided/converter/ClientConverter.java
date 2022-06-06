package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Client;
import com.ird.faa.ws.rest.provided.vo.ClientVo;

@Component
public class ClientConverter extends AbstractConverter<Client,ClientVo>{

        @Autowired
        private ClientSininstreConverter clientSininstreConverter ;
        @Autowired
        private VehiculeConverter vehiculeConverter ;
        @Autowired
        private TypeClientConverter typeClientConverter ;
        @Autowired
        private ContratConverter contratConverter ;
    private Boolean typeClient;
        private Boolean clientSininstres;
        private Boolean vehicule;
        private Boolean contrat;

public  ClientConverter(){
init(true);
}

@Override
public Client toItem(ClientVo vo) {
if (vo == null) {
return null;
} else {
Client item = new Client();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getCin()))
        item.setCin(vo.getCin());
        if(StringUtil.isNotEmpty(vo.getNom()))
        item.setNom(vo.getNom());
        if(StringUtil.isNotEmpty(vo.getPrenom()))
        item.setPrenom(vo.getPrenom());
        if(StringUtil.isNotEmpty(vo.getActivite()))
        item.setActivite(vo.getActivite());
        if(StringUtil.isNotEmpty(vo.getAdresse()))
        item.setAdresse(vo.getAdresse());
        if(StringUtil.isNotEmpty(vo.getDatedeNaissance()))
        item.setDatedeNaissance(DateUtil.parse(vo.getDatedeNaissance()));
        if(StringUtil.isNotEmpty(vo.getNumTelephone()))
        item.setNumTelephone(NumberUtil.toBigDecimal(vo.getNumTelephone()));
    if(vo.getTypeClientVo()!=null && this.typeClient)
        item.setTypeClient(typeClientConverter.toItem(vo.getTypeClientVo())) ;

        if(ListUtil.isNotEmpty(vo.getClientSininstresVo()) && this.clientSininstres)
            item.setClientSininstres(clientSininstreConverter.toItem(vo.getClientSininstresVo()));
        if(ListUtil.isNotEmpty(vo.getVehiculeVo()) && this.vehicule)
            item.setVehicule(vehiculeConverter.toItem(vo.getVehiculeVo()));
        if(ListUtil.isNotEmpty(vo.getContratVo()) && this.contrat)
            item.setContrat(contratConverter.toItem(vo.getContratVo()));

return item;
}
}

@Override
public ClientVo toVo(Client item) {
if (item == null) {
return null;
} else {
ClientVo vo = new ClientVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getCin()))
        vo.setCin(item.getCin());

        if(StringUtil.isNotEmpty(item.getNom()))
        vo.setNom(item.getNom());

        if(StringUtil.isNotEmpty(item.getPrenom()))
        vo.setPrenom(item.getPrenom());

        if(StringUtil.isNotEmpty(item.getActivite()))
        vo.setActivite(item.getActivite());

        if(StringUtil.isNotEmpty(item.getAdresse()))
        vo.setAdresse(item.getAdresse());

        if(item.getDatedeNaissance()!=null)
        vo.setDatedeNaissance(DateUtil.formateDate(item.getDatedeNaissance()));
        if(item.getNumTelephone()!=null)
        vo.setNumTelephone(NumberUtil.toString(item.getNumTelephone()));

    if(item.getTypeClient()!=null && this.typeClient) {
        vo.setTypeClientVo(typeClientConverter.toVo(item.getTypeClient())) ;
    }
        if(this.clientSininstres && ListUtil.isNotEmpty(item.getClientSininstres())){
        clientSininstreConverter.init(true);
        clientSininstreConverter.setClient(false);
        vo.setClientSininstresVo(clientSininstreConverter.toVo(item.getClientSininstres()));
        clientSininstreConverter.setClient(true);
        }
        if(this.vehicule && ListUtil.isNotEmpty(item.getVehicule())){
        vehiculeConverter.init(true);
        vehiculeConverter.setClient(false);
        vo.setVehiculeVo(vehiculeConverter.toVo(item.getVehicule()));
        vehiculeConverter.setClient(true);
        }
        if(this.contrat && ListUtil.isNotEmpty(item.getContrat())){
        contratConverter.init(true);
        contratConverter.setClient(false);
        vo.setContratVo(contratConverter.toVo(item.getContrat()));
        contratConverter.setClient(true);
        }

return vo;
}
}

    public void initList(Boolean value) {
            this.clientSininstres = value;
            this.vehicule = value;
            this.contrat = value;
    }
public void init(Boolean value) {
    typeClient = value;
    initList(value);
}


        public ClientSininstreConverter getClientSininstreConverter(){
        return this.clientSininstreConverter;
        }
        public void setClientSininstreConverter(ClientSininstreConverter clientSininstreConverter ){
        this.clientSininstreConverter = clientSininstreConverter;
        }
        public VehiculeConverter getVehiculeConverter(){
        return this.vehiculeConverter;
        }
        public void setVehiculeConverter(VehiculeConverter vehiculeConverter ){
        this.vehiculeConverter = vehiculeConverter;
        }
        public TypeClientConverter getTypeClientConverter(){
        return this.typeClientConverter;
        }
        public void setTypeClientConverter(TypeClientConverter typeClientConverter ){
        this.typeClientConverter = typeClientConverter;
        }
        public ContratConverter getContratConverter(){
        return this.contratConverter;
        }
        public void setContratConverter(ContratConverter contratConverter ){
        this.contratConverter = contratConverter;
        }

    public boolean  isTypeClient(){
    return this.typeClient;
    }
    public void  setTypeClient(boolean typeClient){
    this.typeClient = typeClient;
    }





















        public Boolean  isClientSininstres(){
        return this.clientSininstres ;
        }
        public void  setClientSininstres(Boolean clientSininstres ){
        this.clientSininstres  = clientSininstres ;
        }



        public Boolean  isVehicule(){
        return this.vehicule ;
        }
        public void  setVehicule(Boolean vehicule ){
        this.vehicule  = vehicule ;
        }



        public Boolean  isContrat(){
        return this.contrat ;
        }
        public void  setContrat(Boolean contrat ){
        this.contrat  = contrat ;
        }


}
