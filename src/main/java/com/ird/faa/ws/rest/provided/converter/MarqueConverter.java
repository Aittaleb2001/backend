package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Marque;
import com.ird.faa.ws.rest.provided.vo.MarqueVo;

@Component
public class MarqueConverter extends AbstractConverter<Marque,MarqueVo>{


public  MarqueConverter(){
init(true);
}

@Override
public Marque toItem(MarqueVo vo) {
if (vo == null) {
return null;
} else {
Marque item = new Marque();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());


return item;
}
}

@Override
public MarqueVo toVo(Marque item) {
if (item == null) {
return null;
} else {
MarqueVo vo = new MarqueVo();
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
