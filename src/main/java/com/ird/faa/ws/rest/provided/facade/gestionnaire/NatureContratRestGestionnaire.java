package  com.ird.faa.ws.rest.provided.facade.gestionnaire;

import com.ird.faa.service.gestionnaire.facade.NatureContratGestionnaireService;

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
import com.ird.faa.bean.NatureContrat;
import com.ird.faa.ws.rest.provided.converter.NatureContratConverter;
import com.ird.faa.ws.rest.provided.vo.NatureContratVo;

@Api("Manages natureContrat services")
@RestController
@RequestMapping("api/gestionnaire/natureContrat")
public class NatureContratRestGestionnaire {

@Autowired
private NatureContratGestionnaireService natureContratService;

@Autowired
private NatureContratConverter natureContratConverter;


            @ApiOperation("Updates the specified  natureContrat")
            @PutMapping("/")
            public  NatureContratVo update(@RequestBody  NatureContratVo  natureContratVo){
            NatureContrat natureContrat = natureContratConverter.toItem(natureContratVo);
            natureContrat = natureContratService.update(natureContrat);
            return natureContratConverter.toVo(natureContrat);
            }

    @ApiOperation("Finds a list of all natureContrats")
    @GetMapping("/")
    public List<NatureContratVo> findAll(){
        return natureContratConverter.toVo(natureContratService.findAll());
    }

    @ApiOperation("Finds a natureContrat with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public NatureContratVo findByIdWithAssociatedList(@PathVariable Long id){
    return natureContratConverter.toVo(natureContratService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search natureContrat by a specific criteria")
    @PostMapping("/search")
    public List<NatureContratVo> findByCriteria(@RequestBody NatureContratVo natureContratVo){
        return natureContratConverter.toVo(natureContratService.findByCriteria(natureContratVo));
        }

            @ApiOperation("Finds a natureContrat by id")
            @GetMapping("/id/{id}")
            public NatureContratVo findById(@PathVariable Long id){
            return natureContratConverter.toVo(natureContratService.findById(id));
            }

            @ApiOperation("Saves the specified  natureContrat")
            @PostMapping("/")
            public NatureContratVo save(@RequestBody NatureContratVo natureContratVo){
            NatureContrat natureContrat = natureContratConverter.toItem(natureContratVo);
            natureContrat = natureContratService.save(natureContrat);
            return natureContratConverter.toVo(natureContrat);
            }

            @ApiOperation("Delete the specified natureContrat")
            @DeleteMapping("/")
            public int delete(@RequestBody NatureContratVo natureContratVo){
            NatureContrat natureContrat = natureContratConverter.toItem(natureContratVo);
            return natureContratService.delete(natureContrat);
            }

            @ApiOperation("Deletes a natureContrat by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return natureContratService.deleteById(id);
            }




            }
