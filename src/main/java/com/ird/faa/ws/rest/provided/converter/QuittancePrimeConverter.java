package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.QuittancePrime;
import com.ird.faa.ws.rest.provided.vo.QuittancePrimeVo;

@Component
public class QuittancePrimeConverter extends AbstractConverter<QuittancePrime,QuittancePrimeVo>{

        @Autowired
        private ContratConverter contratConverter ;
    private Boolean contrat;

public  QuittancePrimeConverter(){
init(true);
}

@Override
public QuittancePrime toItem(QuittancePrimeVo vo) {
if (vo == null) {
return null;
} else {
QuittancePrime item = new QuittancePrime();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getPrimeNette()))
        item.setPrimeNette(NumberUtil.toBigDecimal(vo.getPrimeNette()));
        if(StringUtil.isNotEmpty(vo.getTaxe()))
        item.setTaxe(NumberUtil.toBigDecimal(vo.getTaxe()));
        if(StringUtil.isNotEmpty(vo.getAccessoires()))
        item.setAccessoires(vo.getAccessoires());
        if(StringUtil.isNotEmpty(vo.getTotalTtc()))
        item.setTotalTtc(NumberUtil.toBigDecimal(vo.getTotalTtc()));
        if(StringUtil.isNotEmpty(vo.getTotalQuittance()))
        item.setTotalQuittance(NumberUtil.toBigDecimal(vo.getTotalQuittance()));
        if(StringUtil.isNotEmpty(vo.getTotalPaye()))
        item.setTotalPaye(NumberUtil.toBigDecimal(vo.getTotalPaye()));
        if(StringUtil.isNotEmpty(vo.getRest()))
        item.setRest(NumberUtil.toBigDecimal(vo.getRest()));
    if(vo.getContratVo()!=null && this.contrat)
        item.setContrat(contratConverter.toItem(vo.getContratVo())) ;


return item;
}
}

@Override
public QuittancePrimeVo toVo(QuittancePrime item) {
if (item == null) {
return null;
} else {
QuittancePrimeVo vo = new QuittancePrimeVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(item.getPrimeNette()!=null)
        vo.setPrimeNette(NumberUtil.toString(item.getPrimeNette()));

        if(item.getTaxe()!=null)
        vo.setTaxe(NumberUtil.toString(item.getTaxe()));

        if(StringUtil.isNotEmpty(item.getAccessoires()))
        vo.setAccessoires(item.getAccessoires());

        if(item.getTotalTtc()!=null)
        vo.setTotalTtc(NumberUtil.toString(item.getTotalTtc()));

        if(item.getTotalQuittance()!=null)
        vo.setTotalQuittance(NumberUtil.toString(item.getTotalQuittance()));

        if(item.getTotalPaye()!=null)
        vo.setTotalPaye(NumberUtil.toString(item.getTotalPaye()));

        if(item.getRest()!=null)
        vo.setRest(NumberUtil.toString(item.getRest()));

    if(item.getContrat()!=null && this.contrat) {
                contratConverter.setQuittancePrime(false);
        vo.setContratVo(contratConverter.toVo(item.getContrat())) ;
                contratConverter.setQuittancePrime(true);
    }

return vo;
}
}

public void init(Boolean value) {
    contrat = value;
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


















}
