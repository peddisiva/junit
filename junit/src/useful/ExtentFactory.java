package useful;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String path = "C:\\Users\\Siva\\Desktop\\ExtentReports\\report_demo.html";
		extent = new ExtentReports(path, false);
		extent
		.addSystemInfo("Selenium Version", "3.0")
		.addSystemInfo("Platform", "windows");
		return extent;
	}

}
