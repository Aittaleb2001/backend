package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Garantie;
import com.ird.faa.ws.rest.provided.vo.GarantieVo;

@Component
public class GarantieConverter extends AbstractConverter<Garantie,GarantieVo>{


public  GarantieConverter(){
init(true);
}

@Override
public Garantie toItem(GarantieVo vo) {
if (vo == null) {
return null;
} else {
Garantie item = new Garantie();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());


return item;
}
}

@Override
public GarantieVo toVo(Garantie item) {
if (item == null) {
return null;
} else {
GarantieVo vo = new GarantieVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());


return vo;
}
}

public void init(Boolean value) {
}







}
