package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.DeviseAdminService;

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
import com.ird.faa.bean.Devise;
import com.ird.faa.ws.rest.provided.converter.DeviseConverter;
import com.ird.faa.ws.rest.provided.vo.DeviseVo;

@Api("Manages devise services")
@RestController
@RequestMapping("api/admin/devise")
public class DeviseRestAdmin {

@Autowired
private DeviseAdminService deviseService;

@Autowired
private DeviseConverter deviseConverter;


            @ApiOperation("Updates the specified  devise")
            @PutMapping("/")
            public  DeviseVo update(@RequestBody  DeviseVo  deviseVo){
            Devise devise = deviseConverter.toItem(deviseVo);
            devise = deviseService.update(devise);
            return deviseConverter.toVo(devise);
            }

    @ApiOperation("Finds a list of all devises")
    @GetMapping("/")
    public List<DeviseVo> findAll(){
        return deviseConverter.toVo(deviseService.findAll());
    }

    @ApiOperation("Finds a devise with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public DeviseVo findByIdWithAssociatedList(@PathVariable Long id){
    return deviseConverter.toVo(deviseService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search devise by a specific criteria")
    @PostMapping("/search")
    public List<DeviseVo> findByCriteria(@RequestBody DeviseVo deviseVo){
        return deviseConverter.toVo(deviseService.findByCriteria(deviseVo));
        }

            @ApiOperation("Finds a devise by id")
            @GetMapping("/id/{id}")
            public DeviseVo findById(@PathVariable Long id){
            return deviseConverter.toVo(deviseService.findById(id));
            }

            @ApiOperation("Saves the specified  devise")
            @PostMapping("/")
            public DeviseVo save(@RequestBody DeviseVo deviseVo){
            Devise devise = deviseConverter.toItem(deviseVo);
            devise = deviseService.save(devise);
            return deviseConverter.toVo(devise);
            }

            @ApiOperation("Delete the specified devise")
            @DeleteMapping("/")
            public int delete(@RequestBody DeviseVo deviseVo){
            Devise devise = deviseConverter.toItem(deviseVo);
            return deviseService.delete(devise);
            }

            @ApiOperation("Deletes a devise by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return deviseService.deleteById(id);
            }




            }
