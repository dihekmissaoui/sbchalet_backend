package Sbchalet.demo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.models.Post;
import Sbchalet.demo.repository.ChaletRepository;
import Sbchalet.demo.services.ChaletServiceImpl;
import Sbchalet.demo.services.IPostService;

@RestController
@CrossOrigin
@RequestMapping("/api/chalet")

public class ChaletController {
	
	@Autowired
	private ChaletServiceImpl chaletservice ;
	
	@Autowired ChaletRepository chaletRepository;
	
	//Paging&Sorting
	@GetMapping("/page-and-sort")
	  public Page<Chalet> getAllTutorialsPage(
			  Pageable pageable) {

		return chaletRepository.findAll(pageable);
	}

	// getPost => afficher les posts
	@GetMapping("")
	public List<Chalet> getAllPost() {
		return this.chaletservice.list();
	}

	// getPostbyid => selon id

	@GetMapping("/{chalet-id}")
	@ResponseBody
	public Optional<Chalet> retrieveChalet(@PathVariable("chalet-id") int chalet_id) {
		return this.chaletservice.getById(chalet_id);
	}

	// ajouter post
	@PostMapping("")
	@ResponseBody
	public Chalet addChalet(@RequestBody Chalet ch) {
		Chalet chalet = chaletservice.save(ch);
		return chalet;
	}

	// supprimer post
	@DeleteMapping("/{id_chalet}")
	@ResponseBody
	public void removeChalet(@PathVariable("id_chalet") int id_chalet) {
		chaletservice.remove(id_chalet);
	}

	// mis a jour post
	@PutMapping("/{id_chalet}")
	@ResponseBody
	public Chalet modifyChalet(@PathVariable int id_chalet, @RequestBody Chalet chalet) {
		return chaletservice.updateChalet(id_chalet, chalet);
	}
}
