package cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n02.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n02.domain.Fruita;
import cat.itacademy.barcelonactiva.samayoa.sonia.s04.t02.n02.services.FruitaService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/fruita")
public class FruitaController {
	
	@Autowired
	FruitaService fruitaService;
	
	@PostMapping("/add")
	  public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita) {
	    try {
	      Fruita dataFruita = fruitaService.addFruita(new Fruita(fruita.getNom(), fruita.getQuilos()));
	      return new ResponseEntity<>(dataFruita, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	 @PutMapping("/update")
	  public String updateFruita(@RequestBody Fruita fruitaUpdate) {
	    
	      return fruitaService.updateFruita(fruitaUpdate);

	  }
	 
	 @DeleteMapping("/delete/{id}")
	  public String deleteFruita(@PathVariable int id) {
	    
	      return fruitaService.deleteFruita(id);

	  }
	
		
	@PostMapping("/getOne/{id}")
	public Optional<Fruita> getOneFruita(@PathVariable int id){
		return fruitaService.getOneFruita(id);
	}

	@GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruita(){

        List<Fruita> fruites = fruitaService.getAllFruita();
        return new ResponseEntity<List<Fruita>>(fruites, HttpStatus.OK);
    }


}
