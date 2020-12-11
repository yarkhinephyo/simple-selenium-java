package MyScraper;

import MyScraper.Pages.TrendingPage;

public class Main {

	public static void main(String[] args) {
		
		try {
			// Installs Chrome driver if none in system
			System.out.println("Setting up chromedriver...");
			MyChromeDriver.setup();
			
			// Navigates to trending page
			System.out.println("Navigating to the page...");
			TrendingPage trendingPage = new TrendingPage(MyChromeDriver.getDriver());
			
			// Scrape and save data
			System.out.println("Scraping and saving...");
			CsvRecorder.save(
				trendingPage.getTrendingRepos(),
				"./Trending Repositories.csv"
			);
			
			System.out.println("Done!");
		} catch (Exception error) {
			System.out.println("An error occured: " + error.getMessage());
		} finally {
			MyChromeDriver.quit();
			System.out.println("Chromedriver has quit.");
		}
		
	}

}
