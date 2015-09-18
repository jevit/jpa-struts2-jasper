package struts2.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import struts2.domain.Utilisateur;

public interface UtilisateurService {

	public Long saveOrUpdate(Utilisateur userDto) throws ParseException;

	public void delete(Long id);

	public Utilisateur get(Long id);

	public Collection<Utilisateur> list(String textSearched, Integer firstResult, Integer maxResults, String orderBy, String order);

	public Utilisateur findUserByName(String login);

	public String print() throws IOException;

	public List<Utilisateur> listAll();
}
