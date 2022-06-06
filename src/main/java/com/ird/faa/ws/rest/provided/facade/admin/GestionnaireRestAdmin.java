package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.GestionnaireAdminService;

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
import com.ird.faa.bean.Gestionnaire;
import com.ird.faa.ws.rest.provided.converter.GestionnaireConverter;
import com.ird.faa.ws.rest.provided.vo.GestionnaireVo;

@Api("Manages gestionnaire services")
@RestController
@RequestMapping("api/admin/gestionnaire")
public class GestionnaireRestAdmin {

@Autowired
private GestionnaireAdminService gestionnaireService;

@Autowired
private GestionnaireConverter gestionnaireConverter;


            @ApiOperation("Updates the specified  gestionnaire")
            @PutMapping("/")
            public  GestionnaireVo update(@RequestBody  GestionnaireVo  gestionnaireVo){
            Gestionnaire gestionnaire = gestionnaireConverter.toItem(gestionnaireVo);
            gestionnaire = gestionnaireService.update(gestionnaire);
            return gestionnaireConverter.toVo(gestionnaire);
            }

    @ApiOperation("Finds a list of all gestionnaires")
    @GetMapping("/")
    public List<GestionnaireVo> findAll(){
        return gestionnaireConverter.toVo(gestionnaireService.findAll());
    }

    @ApiOperation("Finds a gestionnaire with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public GestionnaireVo findByIdWithAssociatedList(@PathVariable Long id){
    return gestionnaireConverter.toVo(gestionnaireService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search gestionnaire by a specific criteria")
    @PostMapping("/search")
    public List<GestionnaireVo> findByCriteria(@RequestBody GestionnaireVo gestionnaireVo){
        return gestionnaireConverter.toVo(gestionnaireService.findByCriteria(gestionnaireVo));
        }

            @ApiOperation("Finds a gestionnaire by id")
            @GetMapping("/id/{id}")
            public GestionnaireVo findById(@PathVariable Long id){
            return gestionnaireConverter.toVo(gestionnaireService.findById(id));
            }

            @ApiOperation("Saves the specified  gestionnaire")
            @PostMapping("/")
            public GestionnaireVo save(@RequestBody GestionnaireVo gestionnaireVo){
            Gestionnaire gestionnaire = gestionnaireConverter.toItem(gestionnaireVo);
            gestionnaire = gestionnaireService.save(gestionnaire);
            return gestionnaireConverter.toVo(gestionnaire);
            }

            @ApiOperation("Delete the specified gestionnaire")
            @DeleteMapping("/")
            public int delete(@RequestBody GestionnaireVo gestionnaireVo){
            Gestionnaire gestionnaire = gestionnaireConverter.toItem(gestionnaireVo);
            return gestionnaireService.delete(gestionnaire);
            }

            @ApiOperation("Deletes a gestionnaire by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return gestionnaireService.deleteById(id);
            }




            }
