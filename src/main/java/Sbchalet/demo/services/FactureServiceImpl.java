package Sbchalet.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sbchalet.demo.models.CommentPost;
import Sbchalet.demo.models.Facture;
import Sbchalet.demo.repository.FactureRepository;

@Service
public class FactureServiceImpl implements IFactureService{
	
	@Autowired
	private FactureRepository factureRepository ;

	@Override
	public List<Facture> list() {
		return (List<Facture>) this.factureRepository.findAll();
	}

	@Override
	public Facture save(Facture f) {
		return this.factureRepository.save(f);
	}

	@Override
	public void removeFacture(int id_facture) {
		this.factureRepository.deleteById(id_facture);
		
	}

	@Override
	public Facture updateFacture(int id_facture, Facture facture) {
		Facture updateFacture = null;
		Optional<Facture> factures = this.factureRepository.findById(id_facture);
		if (factures.isPresent()) {
			Facture upfacture = factures.get();
			upfacture = facture;
			updateFacture = this.factureRepository.save(upfacture);
		}
		return updateFacture;
	
	
	}

	@Override
	public Optional<Facture> getById(int id_facture) {
		return this.factureRepository.findById(id_facture);
		
	}

}
