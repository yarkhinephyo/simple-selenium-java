package MyScraper.Pages;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MyScraper.MyChromeDriver;

public class TrendingPage {
	
	@FindBy(xpath = "//article[contains(@class, 'Box-row')]")
    private List<WebElement> trendingRepos;
	
	@FindBy(xpath = "//a[contains(@class, 'js-selected-navigation-item selected subnav-item')]")
	private WebElement repoIcon;
	
	private static final String pageURL = "https://github.com/trending";
	
	public TrendingPage(ChromeDriver driver) {
		driver.get(pageURL);
		PageFactory.initElements(driver, this);
	}	
	
	public LinkedList<String[]> getTrendingRepos() {
		
		LinkedList<String[]> repoRecords = new LinkedList<>();
		repoRecords.add(new String[] {"Name", "Stars", "Language"});
		
		MyChromeDriver.waitElement(repoIcon);
		
		for(WebElement trendingRepo: trendingRepos) {
			String language, stars, repoName;
			
			// Programming language
			try {
				language = trendingRepo
						.findElement(By.xpath(".//span[contains(@itemprop, 'programmingLanguage')]"))
						.getText();
			} catch (NoSuchElementException error) {
				language = "";
			}
			
			// Star count
			try {
				stars = trendingRepo
						.findElement(By.xpath(".//*[name()='svg' and contains(@aria-label, 'star')]"))
						.findElement(By.xpath("./.."))
						.getText();
			} catch (NoSuchElementException error) {
				stars = "";
			}
			
			// Repository Name
			try {
				repoName = trendingRepo
						.findElement(By.xpath(".//h1/a"))
						.getText();
			} catch (NoSuchElementException error) {
				repoName = "";
			}
			
			repoRecords.add(new String[] {repoName, stars, language});
		}
		
		return repoRecords;
	}
}
