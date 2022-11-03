package kodlama.io.kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.Devs.entities.concretes.Language;

public interface LanguageRepository {
	void add (Language language );
	void delete(int id);
	void update(Language id);
	List<Language>getAll();
	
	Language getById(int id);
	void update(Language language, int id);

}
