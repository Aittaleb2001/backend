package  com.ird.faa.ws.rest.provided.facade.gestionnaire;

import com.ird.faa.service.gestionnaire.facade.SinistreGestionnaireService;

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
import com.ird.faa.bean.Sinistre;
import com.ird.faa.ws.rest.provided.converter.SinistreConverter;
import com.ird.faa.ws.rest.provided.vo.SinistreVo;

@Api("Manages sinistre services")
@RestController
@RequestMapping("api/gestionnaire/sinistre")
public class SinistreRestGestionnaire {

@Autowired
private SinistreGestionnaireService sinistreService;

@Autowired
private SinistreConverter sinistreConverter;


            @ApiOperation("Updates the specified  sinistre")
            @PutMapping("/")
            public  SinistreVo update(@RequestBody  SinistreVo  sinistreVo){
            Sinistre sinistre = sinistreConverter.toItem(sinistreVo);
            sinistre = sinistreService.update(sinistre);
            return sinistreConverter.toVo(sinistre);
            }

    @ApiOperation("Finds a list of all sinistres")
    @GetMapping("/")
    public List<SinistreVo> findAll(){
        return sinistreConverter.toVo(sinistreService.findAll());
    }

    @ApiOperation("Finds a sinistre with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public SinistreVo findByIdWithAssociatedList(@PathVariable Long id){
    return sinistreConverter.toVo(sinistreService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search sinistre by a specific criteria")
    @PostMapping("/search")
    public List<SinistreVo> findByCriteria(@RequestBody SinistreVo sinistreVo){
        return sinistreConverter.toVo(sinistreService.findByCriteria(sinistreVo));
        }

            @ApiOperation("Finds a sinistre by id")
            @GetMapping("/id/{id}")
            public SinistreVo findById(@PathVariable Long id){
            return sinistreConverter.toVo(sinistreService.findById(id));
            }

            @ApiOperation("Saves the specified  sinistre")
            @PostMapping("/")
            public SinistreVo save(@RequestBody SinistreVo sinistreVo){
            Sinistre sinistre = sinistreConverter.toItem(sinistreVo);
            sinistre = sinistreService.save(sinistre);
            return sinistreConverter.toVo(sinistre);
            }

            @ApiOperation("Delete the specified sinistre")
            @DeleteMapping("/")
            public int delete(@RequestBody SinistreVo sinistreVo){
            Sinistre sinistre = sinistreConverter.toItem(sinistreVo);
            return sinistreService.delete(sinistre);
            }

            @ApiOperation("Deletes a sinistre by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return sinistreService.deleteById(id);
            }
        @ApiOperation("find by typeSinistre id")
        @GetMapping("/typeSinistre/id/{id}")
        public List<Sinistre> findByTypeSinistreId(@PathVariable Long id){
        return sinistreService.findByTypeSinistreId(id);
        }

        @ApiOperation("delete by typeSinistre id")
        @DeleteMapping("/typeSinistre/id/{id}")
        public int deleteByTypeSinistreId(@PathVariable Long id){
        return sinistreService.deleteByTypeSinistreId(id);
        }

        @ApiOperation("find by client reference")
        @GetMapping("/client/reference/{reference}")
        public List<Sinistre> findByClientReference(@PathVariable String reference){
        return sinistreService.findByClientReference(reference);
        }

        @ApiOperation("delete by client reference")
        @DeleteMapping("/client/reference/{reference}")
        public int deleteByClientReference(@PathVariable String reference){
        return sinistreService.deleteByClientReference(reference);
        }

        @ApiOperation("find by client id")
        @GetMapping("/client/id/{id}")
        public List<Sinistre> findByClientId(@PathVariable Long id){
        return sinistreService.findByClientId(id);
        }

        @ApiOperation("delete by client id")
        @DeleteMapping("/client/id/{id}")
        public int deleteByClientId(@PathVariable Long id){
        return sinistreService.deleteByClientId(id);
        }





            }
