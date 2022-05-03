package Sbchalet.demo.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import Sbchalet.demo.models.DatabaseFile;
import Sbchalet.demo.payload.response.Response;
import Sbchalet.demo.services.DatabaseFileService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FileUploadController {
	@Autowired
	DatabaseFileService fileStorageService;

	@RequestMapping(path = "/uploadFile", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public Response uploadFile(@RequestParam("file") MultipartFile file, @RequestParam int elementId,
			@RequestParam String partOf) {

		DatabaseFile filename = fileStorageService.storeFile(file, elementId, partOf);

		String filedownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("downloadFile/")
				.path(filename.getFileName()).toString();

		return new Response(filename.getData().toString(), filedownloadUri, file.getContentType(), file.getSize());

	}

	@PostMapping("/uploadMultiFiles")
	public List<Response> uploadMultiFiles(@RequestParam("files") MultipartFile[] files, @RequestParam int elementId,
			@RequestParam String partOf) {
		return Arrays.asList(files).stream().map(file -> uploadFile(file, elementId, partOf))
				.collect(Collectors.toList());
	}

}
