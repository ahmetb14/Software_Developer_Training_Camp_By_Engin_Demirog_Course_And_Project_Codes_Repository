package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilites.converters.DtoConverterService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.Result;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageDto;

@Service
public class LanguageManager implements LanguageService {

	private LanguageDao languageDao;
	private DtoConverterService dtoConverterService;

	public LanguageManager(LanguageDao languageDao, DtoConverterService dtoConverterService) {

		super();
		this.languageDao = languageDao;
		this.dtoConverterService = dtoConverterService;

	}

	@Override
	public DataResult<List<Language>> getAll() {

		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(),
				" -> İş Arayanların Dil Bilgisi Sistemden Başarıyla Geldi!");

	}

	@Override
	public Result add(LanguageDto lang) {

		this.languageDao.save((Language) this.dtoConverterService.dtoClassConverter(lang, Language.class));

		return new SuccessResult(" -> İşlem Başarılı!");

	}

}
