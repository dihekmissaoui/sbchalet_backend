package Sbchalet.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import Sbchalet.demo.models.DatabaseFile;
import Sbchalet.demo.payload.response.Response;
import Sbchalet.demo.services.DatabaseFileService;

@RestController
public class FileUploadController {
	@Autowired
	DatabaseFileService fileStorageService;

//@PostMapping("/uploadFile/{chaletId}")
    @RequestMapping(path = "/uploadFile/{chaletId}", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public Response uploadFile(@RequestParam("file") MultipartFile file, @RequestParam  int chaletId) {
		DatabaseFile filename = fileStorageService.storeFile(file, chaletId);
		String filedownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("downloadFile/")
				.path(filename.getFileName()).toString();
		return new Response(filename.getFileName(), filedownloadUri, file.getContentType(), file.getSize());

	}

	@PostMapping("/uploadMultiFiles")
	public List<Response> uploadMultiFiles(@RequestParam("files") MultipartFile[] files, @RequestParam int chaletId) {
		return Arrays.asList(files).stream().map(file -> uploadFile(file, chaletId)).collect(Collectors.toList());
	}

}
