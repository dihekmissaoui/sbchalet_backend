package Sbchalet.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Sbchalet.demo.models.CommentPost;
import Sbchalet.demo.repository.CommentPostRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class CommentPostServiceImplTest {

	@Autowired
	CommentPostRepository rep;

	@Test
	public void testlist() throws Exception {

		List<CommentPost> cmt = (List<CommentPost>) rep.findAll();
		Assertions.assertEquals(2, cmt.size());
	}

	
}
