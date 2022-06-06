package  com.ird.faa.ws.rest.provided.facade.gestionnaire;

import com.ird.faa.service.gestionnaire.facade.ContratGarantieGestionnaireService;

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
import com.ird.faa.bean.ContratGarantie;
import com.ird.faa.ws.rest.provided.converter.ContratGarantieConverter;
import com.ird.faa.ws.rest.provided.vo.ContratGarantieVo;

@Api("Manages contratGarantie services")
@RestController
@RequestMapping("api/gestionnaire/contratGarantie")
public class ContratGarantieRestGestionnaire {

@Autowired
private ContratGarantieGestionnaireService contratGarantieService;

@Autowired
private ContratGarantieConverter contratGarantieConverter;


            @ApiOperation("Updates the specified  contratGarantie")
            @PutMapping("/")
            public  ContratGarantieVo update(@RequestBody  ContratGarantieVo  contratGarantieVo){
            ContratGarantie contratGarantie = contratGarantieConverter.toItem(contratGarantieVo);
            contratGarantie = contratGarantieService.update(contratGarantie);
            return contratGarantieConverter.toVo(contratGarantie);
            }

    @ApiOperation("Finds a list of all contratGaranties")
    @GetMapping("/")
    public List<ContratGarantieVo> findAll(){
        return contratGarantieConverter.toVo(contratGarantieService.findAll());
    }

    @ApiOperation("Finds a contratGarantie with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ContratGarantieVo findByIdWithAssociatedList(@PathVariable Long id){
    return contratGarantieConverter.toVo(contratGarantieService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search contratGarantie by a specific criteria")
    @PostMapping("/search")
    public List<ContratGarantieVo> findByCriteria(@RequestBody ContratGarantieVo contratGarantieVo){
        return contratGarantieConverter.toVo(contratGarantieService.findByCriteria(contratGarantieVo));
        }

            @ApiOperation("Finds a contratGarantie by id")
            @GetMapping("/id/{id}")
            public ContratGarantieVo findById(@PathVariable Long id){
            return contratGarantieConverter.toVo(contratGarantieService.findById(id));
            }

            @ApiOperation("Saves the specified  contratGarantie")
            @PostMapping("/")
            public ContratGarantieVo save(@RequestBody ContratGarantieVo contratGarantieVo){
            ContratGarantie contratGarantie = contratGarantieConverter.toItem(contratGarantieVo);
            contratGarantie = contratGarantieService.save(contratGarantie);
            return contratGarantieConverter.toVo(contratGarantie);
            }

            @ApiOperation("Delete the specified contratGarantie")
            @DeleteMapping("/")
            public int delete(@RequestBody ContratGarantieVo contratGarantieVo){
            ContratGarantie contratGarantie = contratGarantieConverter.toItem(contratGarantieVo);
            return contratGarantieService.delete(contratGarantie);
            }

            @ApiOperation("Deletes a contratGarantie by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return contratGarantieService.deleteById(id);
            }
        @ApiOperation("find by contrat numAttestation")
        @GetMapping("/contrat/numAttestation/{numAttestation}")
        public List<ContratGarantie> findByContratNumAttestation(@PathVariable String numAttestation){
        return contratGarantieService.findByContratNumAttestation(numAttestation);
        }

        @ApiOperation("delete by contrat numAttestation")
        @DeleteMapping("/contrat/numAttestation/{numAttestation}")
        public int deleteByContratNumAttestation(@PathVariable String numAttestation){
        return contratGarantieService.deleteByContratNumAttestation(numAttestation);
        }

        @ApiOperation("find by contrat id")
        @GetMapping("/contrat/id/{id}")
        public List<ContratGarantie> findByContratId(@PathVariable Long id){
        return contratGarantieService.findByContratId(id);
        }

        @ApiOperation("delete by contrat id")
        @DeleteMapping("/contrat/id/{id}")
        public int deleteByContratId(@PathVariable Long id){
        return contratGarantieService.deleteByContratId(id);
        }

        @ApiOperation("find by garantie id")
        @GetMapping("/garantie/id/{id}")
        public List<ContratGarantie> findByGarantieId(@PathVariable Long id){
        return contratGarantieService.findByGarantieId(id);
        }

        @ApiOperation("delete by garantie id")
        @DeleteMapping("/garantie/id/{id}")
        public int deleteByGarantieId(@PathVariable Long id){
        return contratGarantieService.deleteByGarantieId(id);
        }





            }
