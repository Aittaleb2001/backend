package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.QuittanceIndemniser;
import com.ird.faa.ws.rest.provided.vo.QuittanceIndemniserVo;

@Component
public class QuittanceIndemniserConverter extends AbstractConverter<QuittanceIndemniser,QuittanceIndemniserVo>{

        @Autowired
        private DeviseConverter deviseConverter ;
    private Boolean devise;

public  QuittanceIndemniserConverter(){
init(true);
}

@Override
public QuittanceIndemniser toItem(QuittanceIndemniserVo vo) {
if (vo == null) {
return null;
} else {
QuittanceIndemniser item = new QuittanceIndemniser();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getDateReception()))
        item.setDateReception(DateUtil.parse(vo.getDateReception()));
        if(StringUtil.isNotEmpty(vo.getDateAjout()))
        item.setDateAjout(DateUtil.parse(vo.getDateAjout()));
        if(StringUtil.isNotEmpty(vo.getObjet()))
        item.setObjet(vo.getObjet());
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
    if(vo.getDeviseVo()!=null && this.devise)
        item.setDevise(deviseConverter.toItem(vo.getDeviseVo())) ;


return item;
}
}

@Override
public QuittanceIndemniserVo toVo(QuittanceIndemniser item) {
if (item == null) {
return null;
} else {
QuittanceIndemniserVo vo = new QuittanceIndemniserVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getDateReception()!=null)
        vo.setDateReception(DateUtil.formateDate(item.getDateReception()));
        if(item.getDateAjout()!=null)
        vo.setDateAjout(DateUtil.formateDate(item.getDateAjout()));
        if(StringUtil.isNotEmpty(item.getObjet()))
        vo.setObjet(item.getObjet());

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

    if(item.getDevise()!=null && this.devise) {
        vo.setDeviseVo(deviseConverter.toVo(item.getDevise())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    devise = value;
}


        public DeviseConverter getDeviseConverter(){
        return this.deviseConverter;
        }
        public void setDeviseConverter(DeviseConverter deviseConverter ){
        this.deviseConverter = deviseConverter;
        }

    public boolean  isDevise(){
    return this.devise;
    }
    public void  setDevise(boolean devise){
    this.devise = devise;
    }














}
