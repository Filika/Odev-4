package kodlama.io.kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService  {
	void add (Language language)throws Exception;
	void delete (int id)throws Exception;
	void update (Language language ,int id)throws Exception;
	List<Language>getAll();
	Language getById(int id);
	
	
}
