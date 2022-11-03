package kodlama.io.kodlama.io.Devs.wepApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/laguages")
public class LanguageController {
	private LanguageService languageService;

	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	@GetMapping("/getall")
	public List<Language>getAll(){
		return languageService.getAll();
	}
	@GetMapping("/getById/{id}")
	public Language getById(@PathVariable int id)throws Exception{
		return languageService.getById(id);
	}
	@PostMapping("/add")
	public void add(@RequestBody Language language)throws Exception {
		this.languageService.add(language);
	}
	@PutMapping("/update/{id}")
	public void update(@RequestBody Language language,@PathVariable  int id)throws Exception{
		this.languageService.update(language,id);
	}
@DeleteMapping("/delete/{id}")
public void delete (@PathVariable int id ) throws Exception{
	this.languageService.delete(id);
	
}
}
