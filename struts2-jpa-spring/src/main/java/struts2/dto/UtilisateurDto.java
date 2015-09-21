package struts2.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import struts2.domain.Utilisateur;

public class UtilisateurDto {

	private String lastname;

	private String firstname;

	private String test;

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public static List<UtilisateurDto> toUtilisateurDto(Collection<Utilisateur> listUtilisateur) {
		List<UtilisateurDto> listUtilisateurVO = new ArrayList<UtilisateurDto>();
		for (Utilisateur utilisateur : listUtilisateur) {
			String firstname = utilisateur.getFirstname();
			String lastname = utilisateur.getLastname();
			UtilisateurDto utilisateurVO = new UtilisateurDto();
			utilisateurVO.setFirstname(firstname);
			utilisateurVO.setTest("_");
			utilisateurVO.setLastname(lastname);
			listUtilisateurVO.add(utilisateurVO);
		}
		return listUtilisateurVO;

	}
}
