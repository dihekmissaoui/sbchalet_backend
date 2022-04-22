package Sbchalet.demo.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Sbchalet.demo.models.Post;
import Sbchalet.demo.services.IPostService;

@RestController
@RequestMapping("/api/post")
public class PostController {
	// injection du service
		// le service est un bean
		// le bean contient les fonctions à éxecuter
		private IPostService postservice;

		@Autowired
		public void setPostservice(IPostService postservice) {
			this.postservice = postservice;
		}

		// getPost => afficher les posts
		@GetMapping("/")
		public List<Post> getAllPost() {
			return this.postservice.list();
		}

		// getPostbyid => selon id

		@GetMapping("/{post-id}")
		@ResponseBody
		public Optional<Post> retrievePost(@PathVariable("post-id") int postId) {
			return this.postservice.getById(postId);
		}

		// ajouter post
		@PostMapping("/")
		@ResponseBody
		public Post addPost(@RequestBody Post p) {
			Post post = postservice.save(p);
			return post;
		}

		// supprimer post
		@DeleteMapping("/{id}")
		@ResponseBody
		public void removePost(@PathVariable("id") int id) {
			postservice.remove(id);
		}

		// mis a jour post
		@PutMapping("/{id}")
		@ResponseBody
		public Post modifyPost(@PathVariable int id, @RequestBody Post post) {
			return postservice.updatePost(id, post);
		}

//		-----------------------------------------------------------------------------------
		@PutMapping("/like/{id}")
		@ResponseBody
		public void like(@PathVariable int id) {
			System.out.println("je suis ici dans like");
			postservice.likePost(id);

		}

		@PutMapping("/dislike/{id}")
		public void dislike(@PathVariable int id) {
			System.out.println("je suis ici dans dislike");
			postservice.dislikePost(id);

		}

		@GetMapping("/getPostByHighLike")
		@ResponseBody
		public List<Post> getPostByHighLike() {
			return postservice.getPostByHighLike();
		}

		@GetMapping("/getPostByTitle/{title}")
		@ResponseBody
		public List<Post> getPostByTitle(@PathVariable String title) {
			return postservice.getPostByTitle(title);
		}
		
		@GetMapping("/trendingPosts")
		@ResponseBody
		public List<Post> trendingPosts(){
			return postservice.getPostWithMaxComments();
		}
		
}
