package struts2.action;

import java.io.IOException;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import struts2.dto.UtilisateurDto;
import struts2.service.ReportService;
import struts2.service.UtilisateurService;

import com.opensymphony.xwork2.ActionSupport;

public class ReportAction extends ActionSupport {

	@Autowired
	ReportService reportService;

	@Autowired
	UtilisateurService utilisateurService;

	private List<UtilisateurDto> listUtilisateurDto;
	private String jasperFileDirectory;

	public String execute() throws JRException, IOException {
		// todo s'assurer de la synchro
		listUtilisateurDto = utilisateurService.listAll();
		Resource jrxml = new ClassPathResource("reports/listeUtilisateurs.jrxml");
		Resource jasper = new ClassPathResource("reports/listeUtilisateurs.jasper");
		jasperFileDirectory = jasper.getFile().getAbsolutePath();
		reportService.editionListeUtilisateur(listUtilisateurDto, jasper);
		return SUCCESS;
	}

	public List<UtilisateurDto> getListUtilisateurDto() {
		return listUtilisateurDto;
	}

	public void setListUtilisateurDto(List<UtilisateurDto> listUtilisateurDto) {
		this.listUtilisateurDto = listUtilisateurDto;
	}

	public String getJasperFileDirectory() {
		return jasperFileDirectory;
	}

	public void setJasperFileDirectory(String jasperFileDirectory) {
		this.jasperFileDirectory = jasperFileDirectory;
	}
}
