package  com.ird.faa.ws.rest.provided.facade.gestionnaire;

import com.ird.faa.service.gestionnaire.facade.ClientGestionnaireService;

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
import com.ird.faa.bean.Client;
import com.ird.faa.ws.rest.provided.converter.ClientConverter;
import com.ird.faa.ws.rest.provided.vo.ClientVo;

@Api("Manages client services")
@RestController
@RequestMapping("api/gestionnaire/client")
public class ClientRestGestionnaire {

@Autowired
private ClientGestionnaireService clientService;

@Autowired
private ClientConverter clientConverter;


            @ApiOperation("Updates the specified  client")
            @PutMapping("/")
            public  ClientVo update(@RequestBody  ClientVo  clientVo){
            Client client = clientConverter.toItem(clientVo);
            client = clientService.update(client);
            return clientConverter.toVo(client);
            }

    @ApiOperation("Finds a list of all clients")
    @GetMapping("/")
    public List<ClientVo> findAll(){
        clientConverter.initList(false);
    List<ClientVo> result= clientConverter.toVo(clientService.findAll());
    clientConverter.initList(true);
        return result;
    }

    @ApiOperation("Finds a client with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ClientVo findByIdWithAssociatedList(@PathVariable Long id){
    return clientConverter.toVo(clientService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search client by a specific criteria")
    @PostMapping("/search")
    public List<ClientVo> findByCriteria(@RequestBody ClientVo clientVo){
        return clientConverter.toVo(clientService.findByCriteria(clientVo));
        }

            @ApiOperation("Finds a client by id")
            @GetMapping("/id/{id}")
            public ClientVo findById(@PathVariable Long id){
            return clientConverter.toVo(clientService.findById(id));
            }

            @ApiOperation("Saves the specified  client")
            @PostMapping("/")
            public ClientVo save(@RequestBody ClientVo clientVo){
            Client client = clientConverter.toItem(clientVo);
            client = clientService.save(client);
            return clientConverter.toVo(client);
            }

            @ApiOperation("Delete the specified client")
            @DeleteMapping("/")
            public int delete(@RequestBody ClientVo clientVo){
            Client client = clientConverter.toItem(clientVo);
            return clientService.delete(client);
            }

            @ApiOperation("Deletes a client by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return clientService.deleteById(id);
            }
        @ApiOperation("find by typeClient id")
        @GetMapping("/typeClient/id/{id}")
        public List<Client> findByTypeClientId(@PathVariable Long id){
        return clientService.findByTypeClientId(id);
        }

        @ApiOperation("delete by typeClient id")
        @DeleteMapping("/typeClient/id/{id}")
        public int deleteByTypeClientId(@PathVariable Long id){
        return clientService.deleteByTypeClientId(id);
        }





            }
