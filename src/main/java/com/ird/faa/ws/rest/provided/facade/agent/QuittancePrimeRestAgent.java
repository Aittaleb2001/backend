package  com.ird.faa.ws.rest.provided.facade.agent;

import com.ird.faa.service.agent.facade.QuittancePrimeAgentService;

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
import com.ird.faa.bean.QuittancePrime;
import com.ird.faa.ws.rest.provided.converter.QuittancePrimeConverter;
import com.ird.faa.ws.rest.provided.vo.QuittancePrimeVo;

@Api("Manages quittancePrime services")
@RestController
@RequestMapping("api/agent/quittancePrime")
public class QuittancePrimeRestAgent {

@Autowired
private QuittancePrimeAgentService quittancePrimeService;

@Autowired
private QuittancePrimeConverter quittancePrimeConverter;


            @ApiOperation("Updates the specified  quittancePrime")
            @PutMapping("/")
            public  QuittancePrimeVo update(@RequestBody  QuittancePrimeVo  quittancePrimeVo){
            QuittancePrime quittancePrime = quittancePrimeConverter.toItem(quittancePrimeVo);
            quittancePrime = quittancePrimeService.update(quittancePrime);
            return quittancePrimeConverter.toVo(quittancePrime);
            }

    @ApiOperation("Finds a list of all quittancePrimes")
    @GetMapping("/")
    public List<QuittancePrimeVo> findAll(){
        return quittancePrimeConverter.toVo(quittancePrimeService.findAll());
    }

    @ApiOperation("Finds a quittancePrime with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public QuittancePrimeVo findByIdWithAssociatedList(@PathVariable Long id){
    return quittancePrimeConverter.toVo(quittancePrimeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search quittancePrime by a specific criteria")
    @PostMapping("/search")
    public List<QuittancePrimeVo> findByCriteria(@RequestBody QuittancePrimeVo quittancePrimeVo){
        return quittancePrimeConverter.toVo(quittancePrimeService.findByCriteria(quittancePrimeVo));
        }

            @ApiOperation("Finds a quittancePrime by id")
            @GetMapping("/id/{id}")
            public QuittancePrimeVo findById(@PathVariable Long id){
            return quittancePrimeConverter.toVo(quittancePrimeService.findById(id));
            }

            @ApiOperation("Saves the specified  quittancePrime")
            @PostMapping("/")
            public QuittancePrimeVo save(@RequestBody QuittancePrimeVo quittancePrimeVo){
            QuittancePrime quittancePrime = quittancePrimeConverter.toItem(quittancePrimeVo);
            quittancePrime = quittancePrimeService.save(quittancePrime);
            return quittancePrimeConverter.toVo(quittancePrime);
            }

            @ApiOperation("Delete the specified quittancePrime")
            @DeleteMapping("/")
            public int delete(@RequestBody QuittancePrimeVo quittancePrimeVo){
            QuittancePrime quittancePrime = quittancePrimeConverter.toItem(quittancePrimeVo);
            return quittancePrimeService.delete(quittancePrime);
            }

            @ApiOperation("Deletes a quittancePrime by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return quittancePrimeService.deleteById(id);
            }
        @ApiOperation("find by contrat numAttestation")
        @GetMapping("/contrat/numAttestation/{numAttestation}")
        public List<QuittancePrime> findByContratNumAttestation(@PathVariable String numAttestation){
        return quittancePrimeService.findByContratNumAttestation(numAttestation);
        }

        @ApiOperation("delete by contrat numAttestation")
        @DeleteMapping("/contrat/numAttestation/{numAttestation}")
        public int deleteByContratNumAttestation(@PathVariable String numAttestation){
        return quittancePrimeService.deleteByContratNumAttestation(numAttestation);
        }

        @ApiOperation("find by contrat id")
        @GetMapping("/contrat/id/{id}")
        public List<QuittancePrime> findByContratId(@PathVariable Long id){
        return quittancePrimeService.findByContratId(id);
        }

        @ApiOperation("delete by contrat id")
        @DeleteMapping("/contrat/id/{id}")
        public int deleteByContratId(@PathVariable Long id){
        return quittancePrimeService.deleteByContratId(id);
        }





            }
