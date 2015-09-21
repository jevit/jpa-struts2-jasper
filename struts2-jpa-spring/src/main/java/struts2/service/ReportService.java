package struts2.service;

import java.io.IOException;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

import org.springframework.core.io.Resource;

import struts2.dto.UtilisateurDto;

public interface ReportService {

	/**
	 * Lancement du rapport
	 * 
	 * @param listUtilisateurDto
	 *            list a transmettre au rapport
	 * @param jasperFileDirectory
	 *            repertoire du rapport
	 * @throws IOException
	 * @throws JRException
	 */
	public void editionListeUtilisateur(List<UtilisateurDto> listUtilisateurDto, Resource jasper) throws IOException, JRException;

}
