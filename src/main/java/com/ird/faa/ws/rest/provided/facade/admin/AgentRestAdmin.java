package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.AgentAdminService;

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
import com.ird.faa.bean.Agent;
import com.ird.faa.ws.rest.provided.converter.AgentConverter;
import com.ird.faa.ws.rest.provided.vo.AgentVo;

@Api("Manages agent services")
@RestController
@RequestMapping("api/admin/agent")
public class AgentRestAdmin {

@Autowired
private AgentAdminService agentService;

@Autowired
private AgentConverter agentConverter;


            @ApiOperation("Updates the specified  agent")
            @PutMapping("/")
            public  AgentVo update(@RequestBody  AgentVo  agentVo){
            Agent agent = agentConverter.toItem(agentVo);
            agent = agentService.update(agent);
            return agentConverter.toVo(agent);
            }

    @ApiOperation("Finds a list of all agents")
    @GetMapping("/")
    public List<AgentVo> findAll(){
        return agentConverter.toVo(agentService.findAll());
    }

    @ApiOperation("Finds a agent with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public AgentVo findByIdWithAssociatedList(@PathVariable Long id){
    return agentConverter.toVo(agentService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search agent by a specific criteria")
    @PostMapping("/search")
    public List<AgentVo> findByCriteria(@RequestBody AgentVo agentVo){
        return agentConverter.toVo(agentService.findByCriteria(agentVo));
        }

            @ApiOperation("Finds a agent by id")
            @GetMapping("/id/{id}")
            public AgentVo findById(@PathVariable Long id){
            return agentConverter.toVo(agentService.findById(id));
            }

            @ApiOperation("Saves the specified  agent")
            @PostMapping("/")
            public AgentVo save(@RequestBody AgentVo agentVo){
            Agent agent = agentConverter.toItem(agentVo);
            agent = agentService.save(agent);
            return agentConverter.toVo(agent);
            }

            @ApiOperation("Delete the specified agent")
            @DeleteMapping("/")
            public int delete(@RequestBody AgentVo agentVo){
            Agent agent = agentConverter.toItem(agentVo);
            return agentService.delete(agent);
            }

            @ApiOperation("Deletes a agent by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return agentService.deleteById(id);
            }




            }
