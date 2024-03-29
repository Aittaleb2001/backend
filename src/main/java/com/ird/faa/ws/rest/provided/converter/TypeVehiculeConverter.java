package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TypeVehicule;
import com.ird.faa.ws.rest.provided.vo.TypeVehiculeVo;

@Component
public class TypeVehiculeConverter extends AbstractConverter<TypeVehicule,TypeVehiculeVo>{


public  TypeVehiculeConverter(){
init(true);
}

@Override
public TypeVehicule toItem(TypeVehiculeVo vo) {
if (vo == null) {
return null;
} else {
TypeVehicule item = new TypeVehicule();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());


return item;
}
}

@Override
public TypeVehiculeVo toVo(TypeVehicule item) {
if (item == null) {
return null;
} else {
TypeVehiculeVo vo = new TypeVehiculeVo();
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
