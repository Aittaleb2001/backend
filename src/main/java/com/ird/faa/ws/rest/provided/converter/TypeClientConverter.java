package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TypeClient;
import com.ird.faa.ws.rest.provided.vo.TypeClientVo;

@Component
public class TypeClientConverter extends AbstractConverter<TypeClient,TypeClientVo>{


public  TypeClientConverter(){
init(true);
}

@Override
public TypeClient toItem(TypeClientVo vo) {
if (vo == null) {
return null;
} else {
TypeClient item = new TypeClient();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());


return item;
}
}

@Override
public TypeClientVo toVo(TypeClient item) {
if (item == null) {
return null;
} else {
TypeClientVo vo = new TypeClientVo();
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
