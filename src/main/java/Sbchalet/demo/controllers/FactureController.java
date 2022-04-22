package Sbchalet.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Sbchalet.demo.models.Facture;
import Sbchalet.demo.services.FactureServiceImpl;
import Sbchalet.demo.services.IFactureService;

@RestController
@RequestMapping("/api/facture")
public class FactureController {
	@Autowired
	private IFactureService factureservice ;

	// getPost => afficher les posts
	@GetMapping("/")
	public List<Facture> getAllFacture() {
		return this.factureservice.list();
	}
	
	// getPostbyid => selon id

		@GetMapping("/{id_facture}")
		@ResponseBody
		public Optional<Facture> retrieveFacture(@PathVariable("id_facture")int id_facture) {
			return this.factureservice.getById(id_facture);
		}
		

		// ajouter post
		@PostMapping("/")
		@ResponseBody
		public Facture addFacture(@RequestBody Facture Facture) {
			Facture fact = factureservice.save(Facture);
			return fact;
		}
		
		// supprimer post
		@DeleteMapping("/{id}")
		@ResponseBody
		public void removefacture(@PathVariable("id") int id_facture){
			factureservice.removeFacture(id_facture);
		}

		// mis a jour post
		@PutMapping("/{id_facture}")
		@ResponseBody
		public Facture modifyFacture (@PathVariable int id_facture, @RequestBody Facture Facture) {
			return factureservice.updateFacture(id_facture, Facture);
		}

}
