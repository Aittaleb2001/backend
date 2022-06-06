package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.ClientSininstre;
import com.ird.faa.ws.rest.provided.vo.ClientSininstreVo;

@Component
public class ClientSininstreConverter extends AbstractConverter<ClientSininstre,ClientSininstreVo>{

        @Autowired
        private SinistreConverter sinistreConverter ;
        @Autowired
        private QuittanceIndemniserConverter quittanceIndemniserConverter ;
        @Autowired
        private ClientConverter clientConverter ;
    private Boolean client;
    private Boolean sinistre;
    private Boolean quittanceIndemniser;

public  ClientSininstreConverter(){
init(true);
}

@Override
public ClientSininstre toItem(ClientSininstreVo vo) {
if (vo == null) {
return null;
} else {
ClientSininstre item = new ClientSininstre();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getRef()))
        item.setRef(vo.getRef());
        if(StringUtil.isNotEmpty(vo.getNumPolice()))
        item.setNumPolice(vo.getNumPolice());
        if(StringUtil.isNotEmpty(vo.getDateSinistre()))
        item.setDateSinistre(DateUtil.parse(vo.getDateSinistre()));
        if(StringUtil.isNotEmpty(vo.getResponsabilite()))
        item.setResponsabilite(vo.getResponsabilite());
        if(StringUtil.isNotEmpty(vo.getNumOrdre()))
        item.setNumOrdre(NumberUtil.toBigDecimal(vo.getNumOrdre()));
        if(StringUtil.isNotEmpty(vo.getRefReglement()))
        item.setRefReglement(vo.getRefReglement());
        if(StringUtil.isNotEmpty(vo.getMontantExpertise()))
        item.setMontantExpertise(NumberUtil.toBigDecimal(vo.getMontantExpertise()));
        if(StringUtil.isNotEmpty(vo.getMontantIndemniser()))
        item.setMontantIndemniser(NumberUtil.toBigDecimal(vo.getMontantIndemniser()));
        if(StringUtil.isNotEmpty(vo.getObservation()))
        item.setObservation(vo.getObservation());
    if(vo.getClientVo()!=null && this.client)
        item.setClient(clientConverter.toItem(vo.getClientVo())) ;
    if(vo.getSinistreVo()!=null && this.sinistre)
        item.setSinistre(sinistreConverter.toItem(vo.getSinistreVo())) ;
    if(vo.getQuittanceIndemniserVo()!=null && this.quittanceIndemniser)
        item.setQuittanceIndemniser(quittanceIndemniserConverter.toItem(vo.getQuittanceIndemniserVo())) ;


return item;
}
}

@Override
public ClientSininstreVo toVo(ClientSininstre item) {
if (item == null) {
return null;
} else {
ClientSininstreVo vo = new ClientSininstreVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getRef()))
        vo.setRef(item.getRef());

        if(StringUtil.isNotEmpty(item.getNumPolice()))
        vo.setNumPolice(item.getNumPolice());

        if(item.getDateSinistre()!=null)
        vo.setDateSinistre(DateUtil.formateDate(item.getDateSinistre()));
        if(StringUtil.isNotEmpty(item.getResponsabilite()))
        vo.setResponsabilite(item.getResponsabilite());

        if(item.getNumOrdre()!=null)
        vo.setNumOrdre(NumberUtil.toString(item.getNumOrdre()));

        if(StringUtil.isNotEmpty(item.getRefReglement()))
        vo.setRefReglement(item.getRefReglement());

        if(item.getMontantExpertise()!=null)
        vo.setMontantExpertise(NumberUtil.toString(item.getMontantExpertise()));

        if(item.getMontantIndemniser()!=null)
        vo.setMontantIndemniser(NumberUtil.toString(item.getMontantIndemniser()));

        if(StringUtil.isNotEmpty(item.getObservation()))
        vo.setObservation(item.getObservation());

    if(item.getClient()!=null && this.client) {
        vo.setClientVo(clientConverter.toVo(item.getClient())) ;
    }
    if(item.getSinistre()!=null && this.sinistre) {
        vo.setSinistreVo(sinistreConverter.toVo(item.getSinistre())) ;
    }
    if(item.getQuittanceIndemniser()!=null && this.quittanceIndemniser) {
        vo.setQuittanceIndemniserVo(quittanceIndemniserConverter.toVo(item.getQuittanceIndemniser())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    client = value;
    sinistre = value;
    quittanceIndemniser = value;
}


        public SinistreConverter getSinistreConverter(){
        return this.sinistreConverter;
        }
        public void setSinistreConverter(SinistreConverter sinistreConverter ){
        this.sinistreConverter = sinistreConverter;
        }
        public QuittanceIndemniserConverter getQuittanceIndemniserConverter(){
        return this.quittanceIndemniserConverter;
        }
        public void setQuittanceIndemniserConverter(QuittanceIndemniserConverter quittanceIndemniserConverter ){
        this.quittanceIndemniserConverter = quittanceIndemniserConverter;
        }
        public ClientConverter getClientConverter(){
        return this.clientConverter;
        }
        public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
        }

    public boolean  isClient(){
    return this.client;
    }
    public void  setClient(boolean client){
    this.client = client;
    }
    public boolean  isSinistre(){
    return this.sinistre;
    }
    public void  setSinistre(boolean sinistre){
    this.sinistre = sinistre;
    }
    public boolean  isQuittanceIndemniser(){
    return this.quittanceIndemniser;
    }
    public void  setQuittanceIndemniser(boolean quittanceIndemniser){
    this.quittanceIndemniser = quittanceIndemniser;
    }


























}
