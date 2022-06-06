package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Carburant;
import com.ird.faa.ws.rest.provided.vo.CarburantVo;

@Component
public class CarburantConverter extends AbstractConverter<Carburant,CarburantVo>{


public  CarburantConverter(){
init(true);
}

@Override
public Carburant toItem(CarburantVo vo) {
if (vo == null) {
return null;
} else {
Carburant item = new Carburant();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());


return item;
}
}

@Override
public CarburantVo toVo(Carburant item) {
if (item == null) {
return null;
} else {
CarburantVo vo = new CarburantVo();
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
