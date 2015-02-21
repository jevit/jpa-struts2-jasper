package struts2.action;

import org.springframework.beans.factory.annotation.Autowired;

import struts2.service.UtilisateurService;

import com.opensymphony.xwork2.ActionSupport;

public class UtilisateurAction extends ActionSupport {

	@Autowired
	UtilisateurService utilisateurService;

	public static final String MESSAGE = "hello";

	private String message;
	private String username;
	private String password;

	public String execute() throws Exception {

		return SUCCESS;
	}

	// simple validation
	public void validate() {
		if ("admin".equals(getUsername())) {
			addActionMessage("You are valid user!");
		} else {
			addActionError("Invalide login");
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
