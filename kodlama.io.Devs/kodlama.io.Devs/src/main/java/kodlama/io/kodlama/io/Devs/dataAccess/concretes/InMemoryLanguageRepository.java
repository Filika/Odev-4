package kodlama.io.kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository{

	private List<Language> languages;
	public InMemoryLanguageRepository () {
		languages  = new ArrayList<>();
		languages.add(new Language(1,"C#"));
		languages.add(new Language(2,"Java"));
		languages.add(new Language(3,"PHP"));
		
		
		
	}
	@Override
	public void add(Language language) {
		this.languages.add(language);
		
	}

	@Override
	public void delete(int id) {
	Language lang =  this.getById(id);
	languages.remove(lang);
		
	}

	@Override
	public void update(Language language, int id ) {
		Language lang = this.getById(id);
		lang.setName(language.getName());
		
	}

	@Override
	public List<Language> getAll() {
		
		return this.languages;
	}

	@Override
	public Language getById(int id) {
		for(Language lang : getAll() ) {
			if(lang.getId() == id) {
				return lang;
			}
		}
		return null;
	}
	@Override
	public void update(Language id) {
		
		
	}
	

}
