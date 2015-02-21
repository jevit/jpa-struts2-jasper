package struts2.service;

import org.springframework.web.servlet.ModelAndView;

public interface ReportService {

	public void launchRapport();

	public ModelAndView doSalesReportPDF(ModelAndView modelAndView);
}
