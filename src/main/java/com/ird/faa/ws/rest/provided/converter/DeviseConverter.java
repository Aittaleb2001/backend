package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Devise;
import com.ird.faa.ws.rest.provided.vo.DeviseVo;

@Component
public class DeviseConverter extends AbstractConverter<Devise,DeviseVo>{


public  DeviseConverter(){
init(true);
}

@Override
public Devise toItem(DeviseVo vo) {
if (vo == null) {
return null;
} else {
Devise item = new Devise();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
        if(StringUtil.isNotEmpty(vo.getUnite()))
        item.setUnite(vo.getUnite());


return item;
}
}

@Override
public DeviseVo toVo(Devise item) {
if (item == null) {
return null;
} else {
DeviseVo vo = new DeviseVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(StringUtil.isNotEmpty(item.getUnite()))
        vo.setUnite(item.getUnite());


return vo;
}
}

public void init(Boolean value) {
}











}
