package Sbchalet.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.repository.ChaletRepository;

@Service
public class ChaletServiceImpl implements IChaletService {
	@Autowired
	private ChaletRepository chaletrepository;

	private static final Logger logger = Logger.getLogger(ChaletServiceImpl.class);

	@Override
	public List<Chalet> list() {
		try {
			logger.info(" Je suis dans Listchalet ");
			logger.debug("Je vais retourner Listchalet");
			logger.info("Je vien de finir l'operation ");
			return (List<Chalet>) this.chaletrepository.findAll();
		} catch (Exception e) {
			logger.error("Error in ListChalet() :", e);

		}
		return new ArrayList<Chalet>();

	}

	@Override
	public Chalet save(Chalet ch) {

		try {
			logger.trace("accès à la méthode");
			logger.info("je vais enregister Chalet");
			return this.chaletrepository.save(ch);
		} catch (Exception e) {
			logger.error("Error dans save() :", e);
		}
		return new Chalet();

	}

	@Override
	public void remove(int id_chalet) {
		try {
			logger.info("supprimer chalet= " + id_chalet);
			this.chaletrepository.deleteById(id_chalet);
		} catch (Exception e) {
			logger.error("Error dans remove() :", e);
		}
		logger.info("chalet n'existe pas");

	}

	@Override
	public Chalet updateChalet(int id_chalet, Chalet chalet) {
		try {
			logger.info("je suis dans updateChalet()");
			Chalet updatedChalet = null;
			Optional<Chalet> searchChalet = this.chaletrepository.findById(id_chalet);
			if (searchChalet.isPresent()) {
				Chalet finded = searchChalet.get();
				finded = chalet;
				logger.debug("je vais lancer updatedChalet ,");
				updatedChalet = this.chaletrepository.save(finded);
			}
			logger.info("j'ai terminé mon instruction ");
			return updatedChalet;

		} catch (Exception e) {
			logger.error("Error dans updateChalet :", e);
		}

		return new Chalet();
	}

	@Override
	public Optional<Chalet> getById(int id_chalet) {

		try {
			logger.info("je vais afficher le Chalet par id =" + id_chalet);
			return this.chaletrepository.findById(id_chalet);
		} catch (Exception e) {
			logger.error("Error dans getById() :", e);
		}
		return null;
	}

	@Override
	public Chalet getChaletById(int id_chalet) {

		try {
			logger.info("je vais afficher le Chalet par id =" + id_chalet);
			Optional<Chalet> optional = this.chaletrepository.findById(id_chalet);
			Chalet chalet = null;
			if (optional.isPresent()) {
				chalet = optional.get();
				return chalet;
			} else {
				throw new NotFound("Chalet with id:" + id_chalet + " is not found", null, null);
			}

		} catch (Exception e) {
			logger.error("Error dans getById() :", e);
		}
		return null;
	}

}
