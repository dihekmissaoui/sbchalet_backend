package Sbchalet.demo.services;

import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Sbchalet.demo.models.Post;
import Sbchalet.demo.repository.PostRepository;
@Service
public class PostServiceImpl  implements IPostService  {
	@Autowired
	PostRepository postrepository;



	@Override
	public List<Post> list() {
		return (List<Post>) this.postrepository.findAll();
	}

	@Override
	public Post save(Post p) {
		return this.postrepository.save(p);
	}

	@Override
	public void remove(int id) {
		this.postrepository.deleteById(id);

	}

	@Override
	public Post updatePost(int id, Post p) {
		Post updatedpost = null;
		Optional<Post> searchPost = this.postrepository.findById(id);
		if (searchPost.isPresent()) {
			Post finded = searchPost.get();
			finded = p;
			updatedpost = this.postrepository.save(finded);
		}
		return updatedpost;
	}

	@Override
	public Optional<Post> getById(int id) {
		return this.postrepository.findById(id);
	}
    
	@Override
	public void likePost(int id){
		postrepository.likePost(id);
	}
	
	@Override
	public void dislikePost(int id){
		postrepository.dislikePost(id);
	}

	@Override
	public List<Post> getPostByHighLike() {
		return this.postrepository.getPostByHighLike();
	}

	@Override
	public List<Post> getPostByTitle(String title) {
		return this.postrepository.getPostByTitle(title);
	}

	@Override
	public List<Post> getPostWithMaxComments() {
		
		return this.postrepository.getPostWithMaxComments();
	}
}
