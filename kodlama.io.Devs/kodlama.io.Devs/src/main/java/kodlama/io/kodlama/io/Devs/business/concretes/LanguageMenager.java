package kodlama.io.kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageMenager implements LanguageService {

	private LanguageRepository languageRepository;

	public LanguageMenager(LanguageRepository languageRepository) {

		this.languageRepository = languageRepository;
	}

	@Override
	public void add(Language language) throws Exception {
		if (this.isValid(language)) {
			if (this.isIdExist(language.getId())) {
				throw new Exception("ayni Id numarasiyla 2 programlamadili olamaz!");
			} else {
				this.languageRepository.add(language);
			}

		}
	}

	@Override
	public void delete(int id) throws Exception {
		if(!isIdExist(id)) {
			throw new Exception("Silmek için girmiş olduğunuz id sistemde mevcut değil.!!");
		}
		this.languageRepository.delete(id);
	}

	@Override
	public void update(Language language, int id) throws Exception {
		if(!isIdExist(id)) {
			throw new Exception("Güncellemek  için girmiş olduğunuz id sistemde mevcut değil.!!");
		}
		if(isValid(language )) {
			this.languageRepository.update(language,id);
		}
	}

	@Override
	public List<Language> getAll() {
		
		return this.languageRepository.getAll();
	}

	@Override
	public Language getById(int id) {

		return this.languageRepository.getById(id);
	}

	private boolean isNameEmpty(Language language) {
		if (language.getName().isEmpty()) {
			return true;
		} else {

			return false;
		}
	}

	private boolean isNameRepeat(Language language) {
		List<Language> languages = getAll();
		for (Language lang : languages) {
			if (lang.getName().equalsIgnoreCase(language.getName())) {
				return true;
			}

		}
		return false;
	}

	private boolean isValid(Language language) throws Exception {
		if (isNameEmpty(language)) {
			throw new Exception("Programlama dili ismi olmadan oluşturulamaz..");
		}
		if (isNameRepeat(language)) {
			throw new Exception("Girmiş olduğunuz programlama dili zaten mevcut!!");
		}
		return true;
	}

	private boolean isIdExist(int id) {
		for (Language lang : getAll()) {
			if (lang.getId() == id) {
				return true;
			}

		}
		return false;
	}
}
