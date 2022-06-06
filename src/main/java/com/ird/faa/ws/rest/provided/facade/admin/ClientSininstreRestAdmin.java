package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.ClientSininstreAdminService;

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
import com.ird.faa.bean.ClientSininstre;
import com.ird.faa.ws.rest.provided.converter.ClientSininstreConverter;
import com.ird.faa.ws.rest.provided.vo.ClientSininstreVo;

@Api("Manages clientSininstre services")
@RestController
@RequestMapping("api/admin/clientSininstre")
public class ClientSininstreRestAdmin {

@Autowired
private ClientSininstreAdminService clientSininstreService;

@Autowired
private ClientSininstreConverter clientSininstreConverter;


            @ApiOperation("Updates the specified  clientSininstre")
            @PutMapping("/")
            public  ClientSininstreVo update(@RequestBody  ClientSininstreVo  clientSininstreVo){
            ClientSininstre clientSininstre = clientSininstreConverter.toItem(clientSininstreVo);
            clientSininstre = clientSininstreService.update(clientSininstre);
            return clientSininstreConverter.toVo(clientSininstre);
            }

    @ApiOperation("Finds a list of all clientSininstres")
    @GetMapping("/")
    public List<ClientSininstreVo> findAll(){
        return clientSininstreConverter.toVo(clientSininstreService.findAll());
    }

    @ApiOperation("Finds a clientSininstre with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ClientSininstreVo findByIdWithAssociatedList(@PathVariable Long id){
    return clientSininstreConverter.toVo(clientSininstreService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search clientSininstre by a specific criteria")
    @PostMapping("/search")
    public List<ClientSininstreVo> findByCriteria(@RequestBody ClientSininstreVo clientSininstreVo){
        return clientSininstreConverter.toVo(clientSininstreService.findByCriteria(clientSininstreVo));
        }

            @ApiOperation("Finds a clientSininstre by id")
            @GetMapping("/id/{id}")
            public ClientSininstreVo findById(@PathVariable Long id){
            return clientSininstreConverter.toVo(clientSininstreService.findById(id));
            }

            @ApiOperation("Saves the specified  clientSininstre")
            @PostMapping("/")
            public ClientSininstreVo save(@RequestBody ClientSininstreVo clientSininstreVo){
            ClientSininstre clientSininstre = clientSininstreConverter.toItem(clientSininstreVo);
            clientSininstre = clientSininstreService.save(clientSininstre);
            return clientSininstreConverter.toVo(clientSininstre);
            }

            @ApiOperation("Delete the specified clientSininstre")
            @DeleteMapping("/")
            public int delete(@RequestBody ClientSininstreVo clientSininstreVo){
            ClientSininstre clientSininstre = clientSininstreConverter.toItem(clientSininstreVo);
            return clientSininstreService.delete(clientSininstre);
            }

            @ApiOperation("Deletes a clientSininstre by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return clientSininstreService.deleteById(id);
            }
        @ApiOperation("find by client reference")
        @GetMapping("/client/reference/{reference}")
        public List<ClientSininstre> findByClientReference(@PathVariable String reference){
        return clientSininstreService.findByClientReference(reference);
        }

        @ApiOperation("delete by client reference")
        @DeleteMapping("/client/reference/{reference}")
        public int deleteByClientReference(@PathVariable String reference){
        return clientSininstreService.deleteByClientReference(reference);
        }

        @ApiOperation("find by client id")
        @GetMapping("/client/id/{id}")
        public List<ClientSininstre> findByClientId(@PathVariable Long id){
        return clientSininstreService.findByClientId(id);
        }

        @ApiOperation("delete by client id")
        @DeleteMapping("/client/id/{id}")
        public int deleteByClientId(@PathVariable Long id){
        return clientSininstreService.deleteByClientId(id);
        }

        @ApiOperation("find by sinistre reference")
        @GetMapping("/sinistre/reference/{reference}")
        public List<ClientSininstre> findBySinistreReference(@PathVariable String reference){
        return clientSininstreService.findBySinistreReference(reference);
        }

        @ApiOperation("delete by sinistre reference")
        @DeleteMapping("/sinistre/reference/{reference}")
        public int deleteBySinistreReference(@PathVariable String reference){
        return clientSininstreService.deleteBySinistreReference(reference);
        }

        @ApiOperation("find by sinistre id")
        @GetMapping("/sinistre/id/{id}")
        public List<ClientSininstre> findBySinistreId(@PathVariable Long id){
        return clientSininstreService.findBySinistreId(id);
        }

        @ApiOperation("delete by sinistre id")
        @DeleteMapping("/sinistre/id/{id}")
        public int deleteBySinistreId(@PathVariable Long id){
        return clientSininstreService.deleteBySinistreId(id);
        }

        @ApiOperation("find by quittanceIndemniser reference")
        @GetMapping("/quittanceIndemniser/reference/{reference}")
        public List<ClientSininstre> findByQuittanceIndemniserReference(@PathVariable String reference){
        return clientSininstreService.findByQuittanceIndemniserReference(reference);
        }

        @ApiOperation("delete by quittanceIndemniser reference")
        @DeleteMapping("/quittanceIndemniser/reference/{reference}")
        public int deleteByQuittanceIndemniserReference(@PathVariable String reference){
        return clientSininstreService.deleteByQuittanceIndemniserReference(reference);
        }

        @ApiOperation("find by quittanceIndemniser id")
        @GetMapping("/quittanceIndemniser/id/{id}")
        public List<ClientSininstre> findByQuittanceIndemniserId(@PathVariable Long id){
        return clientSininstreService.findByQuittanceIndemniserId(id);
        }

        @ApiOperation("delete by quittanceIndemniser id")
        @DeleteMapping("/quittanceIndemniser/id/{id}")
        public int deleteByQuittanceIndemniserId(@PathVariable Long id){
        return clientSininstreService.deleteByQuittanceIndemniserId(id);
        }





            }
