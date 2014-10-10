package struts2.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import struts2.dao.UtilisateurDao;
import struts2.domain.Utilisateur;

@Service
public class UtilisateurService implements IUtilisateurService {

	@Autowired
	private UtilisateurDao dao;

	@Transactional
	public Long saveOrUpdate(Utilisateur userDto) {

		return dao.saveOrUpdate(userDto);
	}

	@Transactional
	public void delete(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	public Utilisateur get(Long id) {
		Utilisateur userEntity = dao.get(id);

		return userEntity;
	}

	@Transactional(readOnly = true)
	public List<Utilisateur> list(String textSearched, Integer firstResult,
			Integer maxResults, String orderBy, String order) {

		Collection<Utilisateur> list = null;
		Long count = null;

		if (StringUtils.isEmpty(textSearched)) {
			list = dao.list(firstResult, maxResults, orderBy, order);
			count = dao.count();
		} else {
			list = dao.search(textSearched, firstResult, maxResults, orderBy,
					order);
			count = dao.countSearch(textSearched);
		}

		return new ArrayList<Utilisateur>(list);
	}

	@Transactional
	public Utilisateur findUserByName(String login) {
		return dao.findByLogin(login);
	}

	@Transactional
	public String print() {
		System.out.println("hellotests");
		return "hellotest";
	}
}
