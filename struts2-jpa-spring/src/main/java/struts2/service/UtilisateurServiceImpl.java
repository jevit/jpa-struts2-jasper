package struts2.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import struts2.dao.UtilisateurDao;
import struts2.domain.Utilisateur;
import struts2.dto.UtilisateurDto;

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurServiceImpl.class);
	@Autowired
	private UtilisateurDao utilisateurDao;

	@Transactional
	public Long saveOrUpdate(Utilisateur userDto) {

		return utilisateurDao.saveOrUpdate(userDto);
	}

	@Transactional
	public void delete(Long id) {
		utilisateurDao.delete(id);
	}

	@Transactional(readOnly = true)
	public Utilisateur get(Long id) {
		Utilisateur userEntity = utilisateurDao.get(id);
		return userEntity;
	}

	@Transactional(readOnly = true)
	public List<Utilisateur> list(String textSearched, Integer firstResult, Integer maxResults, String orderBy, String order) {
		Collection<Utilisateur> list = null;
		Long count = null;
		if (StringUtils.isEmpty(textSearched)) {
			list = utilisateurDao.list(firstResult, maxResults, orderBy, order);
			count = utilisateurDao.count();
		} else {
			list = utilisateurDao.search(textSearched, firstResult, maxResults, orderBy, order);
			count = utilisateurDao.countSearch(textSearched);
		}

		return new ArrayList<Utilisateur>(list);
	}

	@Transactional(readOnly = true)
	public List<UtilisateurDto> listAll() {
		List<Utilisateur> listUtilisateur = (List<Utilisateur>) utilisateurDao.listAll();
		List<UtilisateurDto> listUtilisateurDto = UtilisateurDto.toUtilisateurDto(listUtilisateur);
		return listUtilisateurDto;
	}

	@Transactional
	public Utilisateur findUserByName(String login) {
		return utilisateurDao.findByLogin(login);
	}

}
