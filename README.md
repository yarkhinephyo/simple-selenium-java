#### How it works
1. The application installs chromedriver for appriopriate Chrome and OS [WebDriverManager](https://github.com/bonigarcia/webdrivermanager#motivation)
2. Headless Chrome scrapes Github Trending page
3. Saves to CSV in the same directory

#### Build instruction
1. Double click on `gradlew.bat`
2. `
cd ./MyScraper
`
3. `
./gradlew build
`

#### Use instruction
1. Ensure Java runtime is minimally 1.8
2. `
java -jar MyScraper.jar
`