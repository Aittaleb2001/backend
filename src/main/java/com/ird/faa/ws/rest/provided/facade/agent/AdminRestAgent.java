package  com.ird.faa.ws.rest.provided.facade.agent;

import com.ird.faa.service.agent.facade.AdminAgentService;

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
import com.ird.faa.bean.Admin;
import com.ird.faa.ws.rest.provided.converter.AdminConverter;
import com.ird.faa.ws.rest.provided.vo.AdminVo;

@Api("Manages admin services")
@RestController
@RequestMapping("api/agent/admin")
public class AdminRestAgent {

@Autowired
private AdminAgentService adminService;

@Autowired
private AdminConverter adminConverter;


            @ApiOperation("Updates the specified  admin")
            @PutMapping("/")
            public  AdminVo update(@RequestBody  AdminVo  adminVo){
            Admin admin = adminConverter.toItem(adminVo);
            admin = adminService.update(admin);
            return adminConverter.toVo(admin);
            }

    @ApiOperation("Finds a list of all admins")
    @GetMapping("/")
    public List<AdminVo> findAll(){
        return adminConverter.toVo(adminService.findAll());
    }

    @ApiOperation("Finds a admin with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public AdminVo findByIdWithAssociatedList(@PathVariable Long id){
    return adminConverter.toVo(adminService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search admin by a specific criteria")
    @PostMapping("/search")
    public List<AdminVo> findByCriteria(@RequestBody AdminVo adminVo){
        return adminConverter.toVo(adminService.findByCriteria(adminVo));
        }

            @ApiOperation("Finds a admin by id")
            @GetMapping("/id/{id}")
            public AdminVo findById(@PathVariable Long id){
            return adminConverter.toVo(adminService.findById(id));
            }

            @ApiOperation("Saves the specified  admin")
            @PostMapping("/")
            public AdminVo save(@RequestBody AdminVo adminVo){
            Admin admin = adminConverter.toItem(adminVo);
            admin = adminService.save(admin);
            return adminConverter.toVo(admin);
            }

            @ApiOperation("Delete the specified admin")
            @DeleteMapping("/")
            public int delete(@RequestBody AdminVo adminVo){
            Admin admin = adminConverter.toItem(adminVo);
            return adminService.delete(admin);
            }

            @ApiOperation("Deletes a admin by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return adminService.deleteById(id);
            }




            }
