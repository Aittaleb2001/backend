package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.TypeSinistreAdminService;

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
import com.ird.faa.bean.TypeSinistre;
import com.ird.faa.ws.rest.provided.converter.TypeSinistreConverter;
import com.ird.faa.ws.rest.provided.vo.TypeSinistreVo;

@Api("Manages typeSinistre services")
@RestController
@RequestMapping("api/admin/typeSinistre")
public class TypeSinistreRestAdmin {

@Autowired
private TypeSinistreAdminService typeSinistreService;

@Autowired
private TypeSinistreConverter typeSinistreConverter;


            @ApiOperation("Updates the specified  typeSinistre")
            @PutMapping("/")
            public  TypeSinistreVo update(@RequestBody  TypeSinistreVo  typeSinistreVo){
            TypeSinistre typeSinistre = typeSinistreConverter.toItem(typeSinistreVo);
            typeSinistre = typeSinistreService.update(typeSinistre);
            return typeSinistreConverter.toVo(typeSinistre);
            }

    @ApiOperation("Finds a list of all typeSinistres")
    @GetMapping("/")
    public List<TypeSinistreVo> findAll(){
        return typeSinistreConverter.toVo(typeSinistreService.findAll());
    }

    @ApiOperation("Finds a typeSinistre with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeSinistreVo findByIdWithAssociatedList(@PathVariable Long id){
    return typeSinistreConverter.toVo(typeSinistreService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeSinistre by a specific criteria")
    @PostMapping("/search")
    public List<TypeSinistreVo> findByCriteria(@RequestBody TypeSinistreVo typeSinistreVo){
        return typeSinistreConverter.toVo(typeSinistreService.findByCriteria(typeSinistreVo));
        }

            @ApiOperation("Finds a typeSinistre by id")
            @GetMapping("/id/{id}")
            public TypeSinistreVo findById(@PathVariable Long id){
            return typeSinistreConverter.toVo(typeSinistreService.findById(id));
            }

            @ApiOperation("Saves the specified  typeSinistre")
            @PostMapping("/")
            public TypeSinistreVo save(@RequestBody TypeSinistreVo typeSinistreVo){
            TypeSinistre typeSinistre = typeSinistreConverter.toItem(typeSinistreVo);
            typeSinistre = typeSinistreService.save(typeSinistre);
            return typeSinistreConverter.toVo(typeSinistre);
            }

            @ApiOperation("Delete the specified typeSinistre")
            @DeleteMapping("/")
            public int delete(@RequestBody TypeSinistreVo typeSinistreVo){
            TypeSinistre typeSinistre = typeSinistreConverter.toItem(typeSinistreVo);
            return typeSinistreService.delete(typeSinistre);
            }

            @ApiOperation("Deletes a typeSinistre by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typeSinistreService.deleteById(id);
            }




            }
