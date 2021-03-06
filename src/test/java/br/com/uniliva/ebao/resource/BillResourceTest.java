package br.com.uniliva.ebao.resource;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BillResourceTest {


	    
	    @LocalServerPort
	    private int port;

	    @Autowired
	    private TestRestTemplate restTemplate;

	    @Test
	    public void ShouldReturnTitle() throws Exception {
	        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/boletos",
	                String.class)).contains("Uniliva");
	    }
	    
	    @Test
	    public void ShouldReturnTitleV2()  throws Exception {
	        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/boletos-v2",
	                String.class)).contains("Uniliva");
	    }


}
