package pe.com.backend;

//import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@RunWith(SpringRunner.class)
@SpringBootTest
class MicrsoerviceBackendApplicationTests {

	@Test
	public void contextLoads() throws Exception {
		Map<String, String> cuponMap = new HashMap<String, String>();
		cuponMap.put("cod_cupon", "C85056CV000000007");
		assertThat(cuponMap.get("cod_cupon")).isNotNull();
	}
}
