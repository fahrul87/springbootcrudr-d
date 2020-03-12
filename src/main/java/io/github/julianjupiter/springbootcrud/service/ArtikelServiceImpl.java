package io.github.julianjupiter.springbootcrud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.julianjupiter.springbootcrud.domain.Artikel;
import io.github.julianjupiter.springbootcrud.repository.ArtikelRepository;

@Service
public class ArtikelServiceImpl implements ArtikelService {
	
	private ArtikelRepository artikelRepository;
	
	@Autowired
	public void setArtikelRepository(ArtikelRepository artikelRepository) {
		this.artikelRepository = artikelRepository;
	}

	@Override
	public Iterable<Artikel> getAllArtikel() {
	
		return this.artikelRepository.findAll();
	}

	@Override
	public Artikel getArtikelById(Integer id) {
	
		return this.artikelRepository.findOne(id);
	}

	@Override
	public Artikel saveArtikel(Artikel artikel) {
		
		return this.artikelRepository.save(artikel);
	}

	@Override
	public void deleteArtikel(Integer id) {
		
		this.artikelRepository.delete(id);
	}

}
