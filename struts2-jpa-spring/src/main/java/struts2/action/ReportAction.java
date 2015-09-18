package struts2.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import struts2.domain.Utilisateur;
import struts2.dto.UtilisateurDto;
import struts2.service.UtilisateurService;

import com.opensymphony.xwork2.ActionSupport;

public class ReportAction extends ActionSupport {

	@Autowired
	UtilisateurService utilisateurService;

	private List<UtilisateurDto> listUtilisateurDto;
	final Resource jrxml = new ClassPathResource("reports/test.jrxml");
	final Resource jasper = new ClassPathResource("reports/test.jasper");
	private String jasperFileDirectory;

	public String execute() throws JRException, IOException {
		List<Utilisateur> listUtilisateur = utilisateurService.listAll();
		listUtilisateurDto = toUtilisateurDto(listUtilisateur);
		jasperFileDirectory = jasper.getFile().getAbsolutePath();
		String pathJrxml = jrxml.getFile().getAbsolutePath();
		String pathJasper = jasper.getFile().getAbsolutePath();
		JasperPrint print = JasperFillManager.fillReport(pathJasper, null, new JRBeanCollectionDataSource(listUtilisateurDto));
		JasperExportManager.exportReportToPdf(print);
		// JasperCompileManager.compileReportToFile(pathJrxml, pathJasper);
		// JasperPrint print = JasperFillManager.fillReport(pathJasper,
		// null,new JRBeanCollectionDataSource(listUtilisateurVO));
		// JasperViewer.viewReport(print);
		return SUCCESS;
	}

	private List<UtilisateurDto> toUtilisateurDto(List<Utilisateur> listUtilisateur) {
		List<UtilisateurDto> listUtilisateurVO = new ArrayList<UtilisateurDto>();
		for (int i = 0; i < listUtilisateur.size(); i++) {
			Utilisateur utilisateur = listUtilisateur.get(i);
			String firstname = utilisateur.getFirstname();
			String lastname = utilisateur.getLastname();
			UtilisateurDto utilisateurVO = new UtilisateurDto();
			utilisateurVO.setFirstname(firstname);
			utilisateurVO.setTest("Test " + i);
			utilisateurVO.setLastname(lastname);
			listUtilisateurVO.add(utilisateurVO);
		}
		return listUtilisateurVO;

	}

	public String getJasperFileDirectory() {
		return jasperFileDirectory;
	}

	public void setJasperFileDirectory(String jasperFileDirectory) {
		this.jasperFileDirectory = jasperFileDirectory;
	}
}
