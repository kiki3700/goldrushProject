import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ipcheck{
	@Autowired
	Environment env;
	void init() {
		System.out.println(env.getProperty("ip"));
	}
}