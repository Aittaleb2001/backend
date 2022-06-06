package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.VehiculeAdminService;

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
import com.ird.faa.bean.Vehicule;
import com.ird.faa.ws.rest.provided.converter.VehiculeConverter;
import com.ird.faa.ws.rest.provided.vo.VehiculeVo;

@Api("Manages vehicule services")
@RestController
@RequestMapping("api/admin/vehicule")
public class VehiculeRestAdmin {

@Autowired
private VehiculeAdminService vehiculeService;

@Autowired
private VehiculeConverter vehiculeConverter;


            @ApiOperation("Updates the specified  vehicule")
            @PutMapping("/")
            public  VehiculeVo update(@RequestBody  VehiculeVo  vehiculeVo){
            Vehicule vehicule = vehiculeConverter.toItem(vehiculeVo);
            vehicule = vehiculeService.update(vehicule);
            return vehiculeConverter.toVo(vehicule);
            }

    @ApiOperation("Finds a list of all vehicules")
    @GetMapping("/")
    public List<VehiculeVo> findAll(){
        return vehiculeConverter.toVo(vehiculeService.findAll());
    }

    @ApiOperation("Finds a vehicule with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public VehiculeVo findByIdWithAssociatedList(@PathVariable Long id){
    return vehiculeConverter.toVo(vehiculeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search vehicule by a specific criteria")
    @PostMapping("/search")
    public List<VehiculeVo> findByCriteria(@RequestBody VehiculeVo vehiculeVo){
        return vehiculeConverter.toVo(vehiculeService.findByCriteria(vehiculeVo));
        }

            @ApiOperation("Finds a vehicule by id")
            @GetMapping("/id/{id}")
            public VehiculeVo findById(@PathVariable Long id){
            return vehiculeConverter.toVo(vehiculeService.findById(id));
            }

            @ApiOperation("Saves the specified  vehicule")
            @PostMapping("/")
            public VehiculeVo save(@RequestBody VehiculeVo vehiculeVo){
            Vehicule vehicule = vehiculeConverter.toItem(vehiculeVo);
            vehicule = vehiculeService.save(vehicule);
            return vehiculeConverter.toVo(vehicule);
            }

            @ApiOperation("Delete the specified vehicule")
            @DeleteMapping("/")
            public int delete(@RequestBody VehiculeVo vehiculeVo){
            Vehicule vehicule = vehiculeConverter.toItem(vehiculeVo);
            return vehiculeService.delete(vehicule);
            }

            @ApiOperation("Deletes a vehicule by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return vehiculeService.deleteById(id);
            }
        @ApiOperation("find by carburant id")
        @GetMapping("/carburant/id/{id}")
        public List<Vehicule> findByCarburantId(@PathVariable Long id){
        return vehiculeService.findByCarburantId(id);
        }

        @ApiOperation("delete by carburant id")
        @DeleteMapping("/carburant/id/{id}")
        public int deleteByCarburantId(@PathVariable Long id){
        return vehiculeService.deleteByCarburantId(id);
        }

        @ApiOperation("find by typeVehicule id")
        @GetMapping("/typeVehicule/id/{id}")
        public List<Vehicule> findByTypeVehiculeId(@PathVariable Long id){
        return vehiculeService.findByTypeVehiculeId(id);
        }

        @ApiOperation("delete by typeVehicule id")
        @DeleteMapping("/typeVehicule/id/{id}")
        public int deleteByTypeVehiculeId(@PathVariable Long id){
        return vehiculeService.deleteByTypeVehiculeId(id);
        }

        @ApiOperation("find by client reference")
        @GetMapping("/client/reference/{reference}")
        public List<Vehicule> findByClientReference(@PathVariable String reference){
        return vehiculeService.findByClientReference(reference);
        }

        @ApiOperation("delete by client reference")
        @DeleteMapping("/client/reference/{reference}")
        public int deleteByClientReference(@PathVariable String reference){
        return vehiculeService.deleteByClientReference(reference);
        }

        @ApiOperation("find by client id")
        @GetMapping("/client/id/{id}")
        public List<Vehicule> findByClientId(@PathVariable Long id){
        return vehiculeService.findByClientId(id);
        }

        @ApiOperation("delete by client id")
        @DeleteMapping("/client/id/{id}")
        public int deleteByClientId(@PathVariable Long id){
        return vehiculeService.deleteByClientId(id);
        }

        @ApiOperation("find by contrat numAttestation")
        @GetMapping("/contrat/numAttestation/{numAttestation}")
        public List<Vehicule> findByContratNumAttestation(@PathVariable String numAttestation){
        return vehiculeService.findByContratNumAttestation(numAttestation);
        }

        @ApiOperation("delete by contrat numAttestation")
        @DeleteMapping("/contrat/numAttestation/{numAttestation}")
        public int deleteByContratNumAttestation(@PathVariable String numAttestation){
        return vehiculeService.deleteByContratNumAttestation(numAttestation);
        }

        @ApiOperation("find by contrat id")
        @GetMapping("/contrat/id/{id}")
        public List<Vehicule> findByContratId(@PathVariable Long id){
        return vehiculeService.findByContratId(id);
        }

        @ApiOperation("delete by contrat id")
        @DeleteMapping("/contrat/id/{id}")
        public int deleteByContratId(@PathVariable Long id){
        return vehiculeService.deleteByContratId(id);
        }

        @ApiOperation("find by marque id")
        @GetMapping("/marque/id/{id}")
        public List<Vehicule> findByMarqueId(@PathVariable Long id){
        return vehiculeService.findByMarqueId(id);
        }

        @ApiOperation("delete by marque id")
        @DeleteMapping("/marque/id/{id}")
        public int deleteByMarqueId(@PathVariable Long id){
        return vehiculeService.deleteByMarqueId(id);
        }





            }
