package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.CarburantChercheurService;

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
import com.ird.faa.bean.Carburant;
import com.ird.faa.ws.rest.provided.converter.CarburantConverter;
import com.ird.faa.ws.rest.provided.vo.CarburantVo;

@Api("Manages carburant services")
@RestController
@RequestMapping("api/chercheur/carburant")
public class CarburantRestChercheur {

@Autowired
private CarburantChercheurService carburantService;

@Autowired
private CarburantConverter carburantConverter;


            @ApiOperation("Updates the specified  carburant")
            @PutMapping("/")
            public  CarburantVo update(@RequestBody  CarburantVo  carburantVo){
            Carburant carburant = carburantConverter.toItem(carburantVo);
            carburant = carburantService.update(carburant);
            return carburantConverter.toVo(carburant);
            }

    @ApiOperation("Finds a list of all carburants")
    @GetMapping("/")
    public List<CarburantVo> findAll(){
        return carburantConverter.toVo(carburantService.findAll());
    }

    @ApiOperation("Finds a carburant with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CarburantVo findByIdWithAssociatedList(@PathVariable Long id){
    return carburantConverter.toVo(carburantService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search carburant by a specific criteria")
    @PostMapping("/search")
    public List<CarburantVo> findByCriteria(@RequestBody CarburantVo carburantVo){
        return carburantConverter.toVo(carburantService.findByCriteria(carburantVo));
        }

            @ApiOperation("Finds a carburant by id")
            @GetMapping("/id/{id}")
            public CarburantVo findById(@PathVariable Long id){
            return carburantConverter.toVo(carburantService.findById(id));
            }

            @ApiOperation("Saves the specified  carburant")
            @PostMapping("/")
            public CarburantVo save(@RequestBody CarburantVo carburantVo){
            Carburant carburant = carburantConverter.toItem(carburantVo);
            carburant = carburantService.save(carburant);
            return carburantConverter.toVo(carburant);
            }

            @ApiOperation("Delete the specified carburant")
            @DeleteMapping("/")
            public int delete(@RequestBody CarburantVo carburantVo){
            Carburant carburant = carburantConverter.toItem(carburantVo);
            return carburantService.delete(carburant);
            }

            @ApiOperation("Deletes a carburant by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return carburantService.deleteById(id);
            }




            }
