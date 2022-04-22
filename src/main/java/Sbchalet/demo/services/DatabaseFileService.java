package Sbchalet.demo.services;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import Sbchalet.demo.exception.FileNotFoundException;
import Sbchalet.demo.exception.FileStorageException;
import Sbchalet.demo.exception.PostNotFoundException;
import Sbchalet.demo.exception.FileNotFoundException;
import Sbchalet.demo.models.DatabaseFile;
import Sbchalet.demo.models.Post;
import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.repository.DatabaseFileRepository;

@Service
public class DatabaseFileService {
	@Autowired
	DatabaseFileRepository dbFileRepository;
	@Autowired
	IChaletService chaletService;

	public DatabaseFile storeFile(MultipartFile file, int id) {
		// Normalize file name
		String fileName = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new Sbchalet.demo.exception.FileStorageException(
						"Sorry! Filename contains invalid path sequence " + fileName);
			}
			Optional<Chalet> optionalChalet = chaletService.getById(id);
			DatabaseFile dbFile = null;
			if (optionalChalet.isPresent()) {
				Chalet chalet = optionalChalet.get();
				dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes(), chalet);
				return dbFileRepository.save(dbFile);
			} else
				throw new PostNotFoundException("pas de post dans la saisie de l'image");
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}

	}

	public DatabaseFile getFile(String fileId) {
		return dbFileRepository.findById(fileId)
				.orElseThrow(() -> new FileNotFoundException("file not found with id " + fileId));

	}
	
	public List<DatabaseFile> getAll() {
		return dbFileRepository.findAll();
	}

}
