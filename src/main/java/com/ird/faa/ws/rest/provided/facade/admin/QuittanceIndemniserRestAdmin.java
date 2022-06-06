package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.QuittanceIndemniserAdminService;

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
import com.ird.faa.bean.QuittanceIndemniser;
import com.ird.faa.ws.rest.provided.converter.QuittanceIndemniserConverter;
import com.ird.faa.ws.rest.provided.vo.QuittanceIndemniserVo;

@Api("Manages quittanceIndemniser services")
@RestController
@RequestMapping("api/admin/quittanceIndemniser")
public class QuittanceIndemniserRestAdmin {

@Autowired
private QuittanceIndemniserAdminService quittanceIndemniserService;

@Autowired
private QuittanceIndemniserConverter quittanceIndemniserConverter;


            @ApiOperation("Updates the specified  quittanceIndemniser")
            @PutMapping("/")
            public  QuittanceIndemniserVo update(@RequestBody  QuittanceIndemniserVo  quittanceIndemniserVo){
            QuittanceIndemniser quittanceIndemniser = quittanceIndemniserConverter.toItem(quittanceIndemniserVo);
            quittanceIndemniser = quittanceIndemniserService.update(quittanceIndemniser);
            return quittanceIndemniserConverter.toVo(quittanceIndemniser);
            }

    @ApiOperation("Finds a list of all quittanceIndemnisers")
    @GetMapping("/")
    public List<QuittanceIndemniserVo> findAll(){
        return quittanceIndemniserConverter.toVo(quittanceIndemniserService.findAll());
    }

    @ApiOperation("Finds a quittanceIndemniser with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public QuittanceIndemniserVo findByIdWithAssociatedList(@PathVariable Long id){
    return quittanceIndemniserConverter.toVo(quittanceIndemniserService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search quittanceIndemniser by a specific criteria")
    @PostMapping("/search")
    public List<QuittanceIndemniserVo> findByCriteria(@RequestBody QuittanceIndemniserVo quittanceIndemniserVo){
        return quittanceIndemniserConverter.toVo(quittanceIndemniserService.findByCriteria(quittanceIndemniserVo));
        }

            @ApiOperation("Finds a quittanceIndemniser by id")
            @GetMapping("/id/{id}")
            public QuittanceIndemniserVo findById(@PathVariable Long id){
            return quittanceIndemniserConverter.toVo(quittanceIndemniserService.findById(id));
            }

            @ApiOperation("Saves the specified  quittanceIndemniser")
            @PostMapping("/")
            public QuittanceIndemniserVo save(@RequestBody QuittanceIndemniserVo quittanceIndemniserVo){
            QuittanceIndemniser quittanceIndemniser = quittanceIndemniserConverter.toItem(quittanceIndemniserVo);
            quittanceIndemniser = quittanceIndemniserService.save(quittanceIndemniser);
            return quittanceIndemniserConverter.toVo(quittanceIndemniser);
            }

            @ApiOperation("Delete the specified quittanceIndemniser")
            @DeleteMapping("/")
            public int delete(@RequestBody QuittanceIndemniserVo quittanceIndemniserVo){
            QuittanceIndemniser quittanceIndemniser = quittanceIndemniserConverter.toItem(quittanceIndemniserVo);
            return quittanceIndemniserService.delete(quittanceIndemniser);
            }

            @ApiOperation("Deletes a quittanceIndemniser by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return quittanceIndemniserService.deleteById(id);
            }
        @ApiOperation("find by devise reference")
        @GetMapping("/devise/reference/{reference}")
        public List<QuittanceIndemniser> findByDeviseReference(@PathVariable String reference){
        return quittanceIndemniserService.findByDeviseReference(reference);
        }

        @ApiOperation("delete by devise reference")
        @DeleteMapping("/devise/reference/{reference}")
        public int deleteByDeviseReference(@PathVariable String reference){
        return quittanceIndemniserService.deleteByDeviseReference(reference);
        }

        @ApiOperation("find by devise id")
        @GetMapping("/devise/id/{id}")
        public List<QuittanceIndemniser> findByDeviseId(@PathVariable Long id){
        return quittanceIndemniserService.findByDeviseId(id);
        }

        @ApiOperation("delete by devise id")
        @DeleteMapping("/devise/id/{id}")
        public int deleteByDeviseId(@PathVariable Long id){
        return quittanceIndemniserService.deleteByDeviseId(id);
        }





            }
