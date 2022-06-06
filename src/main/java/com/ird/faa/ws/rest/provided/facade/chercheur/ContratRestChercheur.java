package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.ContratChercheurService;

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
import com.ird.faa.bean.Contrat;
import com.ird.faa.ws.rest.provided.converter.ContratConverter;
import com.ird.faa.ws.rest.provided.vo.ContratVo;

@Api("Manages contrat services")
@RestController
@RequestMapping("api/chercheur/contrat")
public class ContratRestChercheur {

@Autowired
private ContratChercheurService contratService;

@Autowired
private ContratConverter contratConverter;


            @ApiOperation("Updates the specified  contrat")
            @PutMapping("/")
            public  ContratVo update(@RequestBody  ContratVo  contratVo){
            Contrat contrat = contratConverter.toItem(contratVo);
            contrat = contratService.update(contrat);
            return contratConverter.toVo(contrat);
            }

    @ApiOperation("Finds a list of all contrats")
    @GetMapping("/")
    public List<ContratVo> findAll(){
        contratConverter.initList(false);
    List<ContratVo> result= contratConverter.toVo(contratService.findAll());
    contratConverter.initList(true);
        return result;
    }

    @ApiOperation("Finds a contrat with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ContratVo findByIdWithAssociatedList(@PathVariable Long id){
    return contratConverter.toVo(contratService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search contrat by a specific criteria")
    @PostMapping("/search")
    public List<ContratVo> findByCriteria(@RequestBody ContratVo contratVo){
        return contratConverter.toVo(contratService.findByCriteria(contratVo));
        }

            @ApiOperation("Finds a contrat by id")
            @GetMapping("/id/{id}")
            public ContratVo findById(@PathVariable Long id){
            return contratConverter.toVo(contratService.findById(id));
            }

            @ApiOperation("Saves the specified  contrat")
            @PostMapping("/")
            public ContratVo save(@RequestBody ContratVo contratVo){
            Contrat contrat = contratConverter.toItem(contratVo);
            contrat = contratService.save(contrat);
            return contratConverter.toVo(contrat);
            }

            @ApiOperation("Delete the specified contrat")
            @DeleteMapping("/")
            public int delete(@RequestBody ContratVo contratVo){
            Contrat contrat = contratConverter.toItem(contratVo);
            return contratService.delete(contrat);
            }

            @ApiOperation("Deletes a contrat by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return contratService.deleteById(id);
            }
        @ApiOperation("find by quittancePrime id")
        @GetMapping("/quittancePrime/id/{id}")
        public List<Contrat> findByQuittancePrimeId(@PathVariable Long id){
        return contratService.findByQuittancePrimeId(id);
        }

        @ApiOperation("delete by quittancePrime id")
        @DeleteMapping("/quittancePrime/id/{id}")
        public int deleteByQuittancePrimeId(@PathVariable Long id){
        return contratService.deleteByQuittancePrimeId(id);
        }

        @ApiOperation("find by natureContrat id")
        @GetMapping("/natureContrat/id/{id}")
        public List<Contrat> findByNatureContratId(@PathVariable Long id){
        return contratService.findByNatureContratId(id);
        }

        @ApiOperation("delete by natureContrat id")
        @DeleteMapping("/natureContrat/id/{id}")
        public int deleteByNatureContratId(@PathVariable Long id){
        return contratService.deleteByNatureContratId(id);
        }

        @ApiOperation("find by vehicule reference")
        @GetMapping("/vehicule/reference/{reference}")
        public List<Contrat> findByVehiculeReference(@PathVariable String reference){
        return contratService.findByVehiculeReference(reference);
        }

        @ApiOperation("delete by vehicule reference")
        @DeleteMapping("/vehicule/reference/{reference}")
        public int deleteByVehiculeReference(@PathVariable String reference){
        return contratService.deleteByVehiculeReference(reference);
        }

        @ApiOperation("find by vehicule id")
        @GetMapping("/vehicule/id/{id}")
        public List<Contrat> findByVehiculeId(@PathVariable Long id){
        return contratService.findByVehiculeId(id);
        }

        @ApiOperation("delete by vehicule id")
        @DeleteMapping("/vehicule/id/{id}")
        public int deleteByVehiculeId(@PathVariable Long id){
        return contratService.deleteByVehiculeId(id);
        }

        @ApiOperation("find by client reference")
        @GetMapping("/client/reference/{reference}")
        public List<Contrat> findByClientReference(@PathVariable String reference){
        return contratService.findByClientReference(reference);
        }

        @ApiOperation("delete by client reference")
        @DeleteMapping("/client/reference/{reference}")
        public int deleteByClientReference(@PathVariable String reference){
        return contratService.deleteByClientReference(reference);
        }

        @ApiOperation("find by client id")
        @GetMapping("/client/id/{id}")
        public List<Contrat> findByClientId(@PathVariable Long id){
        return contratService.findByClientId(id);
        }

        @ApiOperation("delete by client id")
        @DeleteMapping("/client/id/{id}")
        public int deleteByClientId(@PathVariable Long id){
        return contratService.deleteByClientId(id);
        }





            }
