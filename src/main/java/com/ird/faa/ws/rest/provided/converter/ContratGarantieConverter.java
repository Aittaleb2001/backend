package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.ContratGarantie;
import com.ird.faa.ws.rest.provided.vo.ContratGarantieVo;

@Component
public class ContratGarantieConverter extends AbstractConverter<ContratGarantie,ContratGarantieVo>{

        @Autowired
        private GarantieConverter garantieConverter ;
        @Autowired
        private ContratConverter contratConverter ;
    private Boolean contrat;
    private Boolean garantie;

public  ContratGarantieConverter(){
init(true);
}

@Override
public ContratGarantie toItem(ContratGarantieVo vo) {
if (vo == null) {
return null;
} else {
ContratGarantie item = new ContratGarantie();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getContratVo()!=null && this.contrat)
        item.setContrat(contratConverter.toItem(vo.getContratVo())) ;
    if(vo.getGarantieVo()!=null && this.garantie)
        item.setGarantie(garantieConverter.toItem(vo.getGarantieVo())) ;


return item;
}
}

@Override
public ContratGarantieVo toVo(ContratGarantie item) {
if (item == null) {
return null;
} else {
ContratGarantieVo vo = new ContratGarantieVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

    if(item.getContrat()!=null && this.contrat) {
        vo.setContratVo(contratConverter.toVo(item.getContrat())) ;
    }
    if(item.getGarantie()!=null && this.garantie) {
        vo.setGarantieVo(garantieConverter.toVo(item.getGarantie())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    contrat = value;
    garantie = value;
}


        public GarantieConverter getGarantieConverter(){
        return this.garantieConverter;
        }
        public void setGarantieConverter(GarantieConverter garantieConverter ){
        this.garantieConverter = garantieConverter;
        }
        public ContratConverter getContratConverter(){
        return this.contratConverter;
        }
        public void setContratConverter(ContratConverter contratConverter ){
        this.contratConverter = contratConverter;
        }

    public boolean  isContrat(){
    return this.contrat;
    }
    public void  setContrat(boolean contrat){
    this.contrat = contrat;
    }
    public boolean  isGarantie(){
    return this.garantie;
    }
    public void  setGarantie(boolean garantie){
    this.garantie = garantie;
    }






}
