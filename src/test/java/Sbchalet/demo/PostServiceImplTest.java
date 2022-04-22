package Sbchalet.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import Sbchalet.demo.models.Post;
import Sbchalet.demo.repository.PostRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class PostServiceImplTest {
	@Autowired
	PostRepository rep;

	@Test
	public void testlist() {

		List<Post> l = rep.findAll();
		Assertions.assertEquals(1, l.size());

	}
	
	
}
