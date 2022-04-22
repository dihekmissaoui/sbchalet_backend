package Sbchalet.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sbchalet.demo.models.CommentPost;
import Sbchalet.demo.repository.CommentPostRepository;

@Service
public class CommentPostServiceImpl implements ICommentPost {

	@Autowired
	CommentPostRepository commentpostrepository;

	@Override
	public List<CommentPost> list() {
		return (List<CommentPost>) this.commentpostrepository.findAll();
	}

	@Override
	public CommentPost save(CommentPost c) {

		return this.commentpostrepository.save(c);
	}

	@Override
	public void remove(int idpostcomment) {
		this.commentpostrepository.deleteById(idpostcomment);

	}

	@Override
	public Optional<CommentPost> getById(int idpostcomment) {

		return this.commentpostrepository.findById(idpostcomment);
	}

	@Override
	public CommentPost updatecommnentPost(int idpostcomment, CommentPost comment) {

		CommentPost updatecommnentPost = null;
		Optional<CommentPost> commantaire = this.commentpostrepository.findById(idpostcomment);
		if (commantaire.isPresent()) {
			CommentPost upcommant = commantaire.get();
			upcommant = comment;
			updatecommnentPost = this.commentpostrepository.save(upcommant);
		}
		return updatecommnentPost;
	}
	
	
	@Override
	public void likeCommentPost (int id){
		commentpostrepository.likeCommentPost(id);
	}
	
	
	@Override
	public void dislikeCommentPost(int id){
		commentpostrepository.dislikeCommentPost(id);
	}
	

}
