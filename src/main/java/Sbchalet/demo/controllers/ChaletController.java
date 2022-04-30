package Sbchalet.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.repository.ChaletRepository;
import Sbchalet.demo.services.ChaletServiceImpl;

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

	@GetMapping("")
	public List<Chalet> getAllPost() {
		return this.chaletservice.list();
	}

	@GetMapping("/{chalet-id}")
	@ResponseBody
	public Optional<Chalet> retrieveChalet(@PathVariable("chalet-id") int chalet_id) {
		return this.chaletservice.getById(chalet_id);
	}

	@PostMapping("")
	@ResponseBody
	public Chalet addChalet(@RequestBody Chalet ch) {
		Chalet chalet = chaletservice.save(ch);
		return chalet;
	}

	@DeleteMapping("/{id_chalet}")
	@ResponseBody
	public void removeChalet(@PathVariable("id_chalet") int id_chalet) {
		chaletservice.remove(id_chalet);
	}

	@PutMapping("/{id_chalet}")
	@ResponseBody
	public Chalet modifyChalet(@PathVariable int id_chalet, @RequestBody Chalet chalet) {
		return chaletservice.updateChalet(id_chalet, chalet);
	}
}
