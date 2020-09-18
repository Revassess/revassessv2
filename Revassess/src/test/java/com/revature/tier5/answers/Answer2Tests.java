package com.revature.tier5.answers;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.ranieri.assesors.RevAssess;
import dev.ranieri.assesors.RevaTest;

/**
 * prompt: 
 * Successfully consume the data 
 * at the provided endpoint (rendering
 * data to screen not required)
 */
@ExtendWith(RevAssess.class)
public class Answer2Tests {

    private WebDriver wd;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "src/assets/geckodriver.exe");
        wd = new FirefoxDriver();
        File html = Paths.get("src/main/webapp/html/index.html").toFile();
        wd.navigate().to("file://" + html.getAbsolutePath());
        
    }
    @RevaTest(tier = 5, points = 20)
    public void testAjax() {
    	try {
        String s = (String) (new WebDriverWait(wd, 10)).until(ExpectedConditions.jsReturnsValue("return JSON.stringify(getResp())"));
        wd.navigate().to("http://ec2-3-19-123-54.us-east-2.compute.amazonaws.com:9999/flashcard");
        String json = wd.findElement(By.tagName("body")).getText();
        assertEquals(json.toString(), s);
    	} catch(Exception e) {
    		fail();
    	} finally {
    		wd.close();
    	}
    } 
}