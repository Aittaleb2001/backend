package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Sinistre;
import com.ird.faa.ws.rest.provided.vo.SinistreVo;

@Component
public class SinistreConverter extends AbstractConverter<Sinistre,SinistreVo>{

        @Autowired
        private TypeSinistreConverter typeSinistreConverter ;
        @Autowired
        private ClientConverter clientConverter ;
    private Boolean typeSinistre;
    private Boolean client;

public  SinistreConverter(){
init(true);
}

@Override
public Sinistre toItem(SinistreVo vo) {
if (vo == null) {
return null;
} else {
Sinistre item = new Sinistre();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());
        if(StringUtil.isNotEmpty(vo.getCause()))
        item.setCause(vo.getCause());
        if(StringUtil.isNotEmpty(vo.getObjet()))
        item.setObjet(vo.getObjet());
    if(vo.getTypeSinistreVo()!=null && this.typeSinistre)
        item.setTypeSinistre(typeSinistreConverter.toItem(vo.getTypeSinistreVo())) ;
    if(vo.getClientVo()!=null && this.client)
        item.setClient(clientConverter.toItem(vo.getClientVo())) ;


return item;
}
}

@Override
public SinistreVo toVo(Sinistre item) {
if (item == null) {
return null;
} else {
SinistreVo vo = new SinistreVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());

        if(StringUtil.isNotEmpty(item.getCause()))
        vo.setCause(item.getCause());

        if(StringUtil.isNotEmpty(item.getObjet()))
        vo.setObjet(item.getObjet());

    if(item.getTypeSinistre()!=null && this.typeSinistre) {
        vo.setTypeSinistreVo(typeSinistreConverter.toVo(item.getTypeSinistre())) ;
    }
    if(item.getClient()!=null && this.client) {
        vo.setClientVo(clientConverter.toVo(item.getClient())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    typeSinistre = value;
    client = value;
}


        public TypeSinistreConverter getTypeSinistreConverter(){
        return this.typeSinistreConverter;
        }
        public void setTypeSinistreConverter(TypeSinistreConverter typeSinistreConverter ){
        this.typeSinistreConverter = typeSinistreConverter;
        }
        public ClientConverter getClientConverter(){
        return this.clientConverter;
        }
        public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
        }

    public boolean  isTypeSinistre(){
    return this.typeSinistre;
    }
    public void  setTypeSinistre(boolean typeSinistre){
    this.typeSinistre = typeSinistre;
    }
    public boolean  isClient(){
    return this.client;
    }
    public void  setClient(boolean client){
    this.client = client;
    }














}
