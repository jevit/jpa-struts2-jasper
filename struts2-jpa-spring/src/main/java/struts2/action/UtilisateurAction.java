package struts2.action;

import org.springframework.beans.factory.annotation.Autowired;

import struts2.service.UtilisateurService;

import com.opensymphony.xwork2.ActionSupport;

public class UtilisateurAction extends ActionSupport {

	@Autowired
	UtilisateurService utilisateurService;

	public static final String MESSAGE = "hello";

	private String message;

	public String execute() throws Exception {

		return SUCCESS;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
