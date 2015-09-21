package struts2.service;

import java.io.IOException;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import struts2.dao.UtilisateurDao;
import struts2.dto.UtilisateurDto;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportServiceImpl.class);

	@Autowired
	UtilisateurDao utilisateurDao;

	public void editionListeUtilisateur(List<UtilisateurDto> listUtilisateurDto, Resource jasper) throws IOException, JRException {
		String pathJasper = jasper.getFile().getAbsolutePath();
		JasperPrint print = JasperFillManager.fillReport(pathJasper, null, new JRBeanCollectionDataSource(listUtilisateurDto));
		JasperExportManager.exportReportToPdf(print);
	}

}
