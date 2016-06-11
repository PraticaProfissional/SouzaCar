package br.com.souzacar.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.souzacar.SouzaCarApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SouzaCarApplication.class)
@WebAppConfiguration
public class ContatosInternosApplicationTests {

	@Test
	public void contextLoads() {
	}

}
