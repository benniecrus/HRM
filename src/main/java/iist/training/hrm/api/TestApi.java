package iist.training.hrm.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestApi {
	@Value("${app.version}")
	private String version;
	
	@GetMapping("/version")
	public String getVersion() {
		return version;
	}
}
