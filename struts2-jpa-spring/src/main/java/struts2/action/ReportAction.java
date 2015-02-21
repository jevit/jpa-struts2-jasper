package struts2.action;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import struts2.domain.Utilisateur;
import struts2.domain.UtilisateurVO;
import struts2.service.UtilisateurService;

import com.opensymphony.xwork2.ActionSupport;

public class ReportAction extends ActionSupport {

	@Autowired
	UtilisateurService utilisateurService;

	private List<UtilisateurVO> listUtilisateurVO;
	final Resource jrxml = new ClassPathResource("reports/test.jrxml");
	final Resource jasper = new ClassPathResource("reports/test.jasper");
	private String jasperFileDirectory;

	public String execute() throws Exception {
		List<Utilisateur> listUtilisateur = utilisateurService.listAll();
		listUtilisateurVO = toUtilisateurVO(listUtilisateur);
		jasperFileDirectory = jrxml.getFile().getAbsolutePath();
		// Normally we would provide a pre-compiled
		// .jrxml file
		// or check to make sure we don't compile on every request.
		try {
			String pathJrxml = jrxml.getFile().getAbsolutePath();
			String pathJasper = jasper.getFile().getAbsolutePath();
			JasperCompileManager.compileReportToFile(pathJrxml, pathJasper);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	private List<UtilisateurVO> toUtilisateurVO(List<Utilisateur> listUtilisateur) {
		List<UtilisateurVO> listUtilisateurVO = new ArrayList<UtilisateurVO>();
		for (int i = 0; i < listUtilisateur.size(); i++) {
			Utilisateur utilisateur = listUtilisateur.get(i);
			String firstname = utilisateur.getFirstname();
			String lastname = utilisateur.getLastname();
			UtilisateurVO utilisateurVO = new UtilisateurVO();
			utilisateurVO.setFirstname(firstname);
			utilisateurVO.setTest("test " + i);
			utilisateurVO.setLastname(lastname);
			listUtilisateurVO.add(utilisateurVO);
		}
		return listUtilisateurVO;

	}

	public List<UtilisateurVO> getListUtilisateurVO() {
		return listUtilisateurVO;
	}

	public void setListUtilisateurVO(List<UtilisateurVO> listUtilisateurVO) {
		this.listUtilisateurVO = listUtilisateurVO;
	}

	public String getJasperFileDirectory() {
		return jasperFileDirectory;
	}

	public void setJasperFileDirectory(String jasperFileDirectory) {
		this.jasperFileDirectory = jasperFileDirectory;
	}
}
