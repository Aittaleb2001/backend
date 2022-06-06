package  com.ird.faa.ws.rest.provided.facade.gestionnaire;

import com.ird.faa.service.gestionnaire.facade.GarantieGestionnaireService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.ird.faa.bean.Garantie;
import com.ird.faa.ws.rest.provided.converter.GarantieConverter;
import com.ird.faa.ws.rest.provided.vo.GarantieVo;

@Api("Manages garantie services")
@RestController
@RequestMapping("api/gestionnaire/garantie")
public class GarantieRestGestionnaire {

@Autowired
private GarantieGestionnaireService garantieService;

@Autowired
private GarantieConverter garantieConverter;


            @ApiOperation("Updates the specified  garantie")
            @PutMapping("/")
            public  GarantieVo update(@RequestBody  GarantieVo  garantieVo){
            Garantie garantie = garantieConverter.toItem(garantieVo);
            garantie = garantieService.update(garantie);
            return garantieConverter.toVo(garantie);
            }

    @ApiOperation("Finds a list of all garanties")
    @GetMapping("/")
    public List<GarantieVo> findAll(){
        return garantieConverter.toVo(garantieService.findAll());
    }

    @ApiOperation("Finds a garantie with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public GarantieVo findByIdWithAssociatedList(@PathVariable Long id){
    return garantieConverter.toVo(garantieService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search garantie by a specific criteria")
    @PostMapping("/search")
    public List<GarantieVo> findByCriteria(@RequestBody GarantieVo garantieVo){
        return garantieConverter.toVo(garantieService.findByCriteria(garantieVo));
        }

            @ApiOperation("Finds a garantie by id")
            @GetMapping("/id/{id}")
            public GarantieVo findById(@PathVariable Long id){
            return garantieConverter.toVo(garantieService.findById(id));
            }

            @ApiOperation("Saves the specified  garantie")
            @PostMapping("/")
            public GarantieVo save(@RequestBody GarantieVo garantieVo){
            Garantie garantie = garantieConverter.toItem(garantieVo);
            garantie = garantieService.save(garantie);
            return garantieConverter.toVo(garantie);
            }

            @ApiOperation("Delete the specified garantie")
            @DeleteMapping("/")
            public int delete(@RequestBody GarantieVo garantieVo){
            Garantie garantie = garantieConverter.toItem(garantieVo);
            return garantieService.delete(garantie);
            }

            @ApiOperation("Deletes a garantie by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return garantieService.deleteById(id);
            }




            }
