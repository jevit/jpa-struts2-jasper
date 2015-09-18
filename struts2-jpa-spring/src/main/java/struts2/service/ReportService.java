package struts2.service;

import java.io.IOException;

import org.springframework.web.servlet.ModelAndView;

public interface ReportService {

	public void launchRapport() throws IOException;

	public ModelAndView doSalesReportPDF(ModelAndView modelAndView);
}
