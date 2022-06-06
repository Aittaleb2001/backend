package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.NatureContrat;
import com.ird.faa.ws.rest.provided.vo.NatureContratVo;

@Component
public class NatureContratConverter extends AbstractConverter<NatureContrat,NatureContratVo>{


public  NatureContratConverter(){
init(true);
}

@Override
public NatureContrat toItem(NatureContratVo vo) {
if (vo == null) {
return null;
} else {
NatureContrat item = new NatureContrat();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());


return item;
}
}

@Override
public NatureContratVo toVo(NatureContrat item) {
if (item == null) {
return null;
} else {
NatureContratVo vo = new NatureContratVo();
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
