package io.github.julianjupiter.springbootcrud.service;

import java.util.Optional;

import io.github.julianjupiter.springbootcrud.domain.Artikel;

public interface ArtikelService {
	 Iterable<Artikel> getAllArtikel();
	   Artikel getArtikelById(Integer id);
	    Artikel saveArtikel(Artikel artikel);
	    void deleteArtikel(Integer id);
}
