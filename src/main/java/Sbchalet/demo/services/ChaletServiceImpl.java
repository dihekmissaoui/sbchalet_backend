package Sbchalet.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.repository.ChaletRepository;


@Service
public class ChaletServiceImpl implements IChaletService{
	@Autowired
	private ChaletRepository chaletrepository ;

	@Override
	public List<Chalet> list() {
		return (List<Chalet>) this.chaletrepository.findAll();
	}

	@Override
	public Chalet save(Chalet ch) {
		return this.chaletrepository.save(ch);
	}

	@Override
	public void remove(int id_chalet) {
		this.chaletrepository.deleteById(id_chalet);
		
	}

	@Override
	public Chalet updateChalet(int id_chalet, Chalet chalet) {
		Chalet updatedChalet = null;
		Optional<Chalet> searchChalet = this.chaletrepository.findById(id_chalet);
		if (searchChalet.isPresent()) {
			Chalet finded = searchChalet.get();
			finded = chalet;
			updatedChalet = this.chaletrepository.save(finded);
		}
		return updatedChalet;
	}

	@Override
	public Optional<Chalet> getById(int id_chalet) {
		return this.chaletrepository.findById(id_chalet);
	}


}
