package struts2.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportServiceImpl.class);

	public void launchRapport() throws IOException {
		// Resource yourfile = new ClassPathResource("reports/test.jasper");
		// JasperPrint print;
		// try {
		// print = JasperFillManager.fillReport(yourfile.getInputStream(), null,
		// new JRBeanCollectionDataSource(new ArrayList()));
		// LOGGER.debug("Fichier trouvé : " +
		// yourfile.getFile().getAbsolutePath());
		// // Visualisation, exportation ou impression
		// // JasperViewer.viewReport(print);
		// // JasperExportManager.exportReportToPdfFile(print,
		// // "reportATester.pdf");
		//
		// // JasperExportManager.exportReportToHtmlFile(print, "test.html");
		// // JasperPrintManager.printReport(print, true);
		// } catch (JRException e) {
		// LOGGER.debug(e.getMessage());
		// } catch (IOException e) {
		// LOGGER.debug(e.getMessage());
		// } finally {
		// yourfile.getInputStream().close();
		// }

	}

	public ModelAndView doSalesReportPDF(ModelAndView modelAndView) {
		LOGGER.debug("Received request to download PDF report");

		// Retrieve our data from a custom data provider
		// Our data comes from a DAO layer
		// SalesDAO dataprovider = new SalesDAO();

		// Assign the datasource to an instance of JRDataSource
		// JRDataSource is the datasource that Jasper understands
		// This is basically a wrapper to Java's collection classes
		JRDataSource datasource = new JRBeanCollectionDataSource(new ArrayList());

		// In order to use Spring's built-in Jasper support,
		// We are required to pass our datasource as a map parameter
		// parameterMap is the Model of our application
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("datasource", datasource);

		// pdfReport is the View of our application
		// This is declared inside the /WEB-INF/jasper-views.xml
		modelAndView = new ModelAndView("pdfReport", parameterMap);

		// Return the View and the Model combined
		return modelAndView;
	}
}
