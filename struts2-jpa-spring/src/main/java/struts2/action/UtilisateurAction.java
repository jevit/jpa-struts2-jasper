package struts2.action;

import org.springframework.beans.factory.annotation.Autowired;

import struts2.service.IUtilisateurService;

public class UtilisateurAction {

	@Autowired
	IUtilisateurService utilisateurService;

	public String execute() throws Exception {
		utilisateurService.print();
		return utilisateurService.print();
	}
}
