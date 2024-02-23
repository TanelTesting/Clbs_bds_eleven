import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

//@Listeners(AllureTestNg.class) <- I can not add any dependencies for Allure,
// otherwise my file in the editor becomes not runnable.
public class Classtestingclbsbdseleven {
    @Test
    public void testMethodTestingClbsbdseleven() {

        open("https://www.google.com/");

        //Search for imbd.com
        //assert that the search field is visible
        $(By.xpath("//*[@id=\"APjFqb\"]")).shouldBe(visible);
        //assert that cookie banner is visible.
        $(By.xpath("//*[@id=\"S3BnEe\"]")).shouldBe(visible);
        //click to accept googles cookies.
        $(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        //find search field, write "imbd", press enter
        $(By.xpath("//*[@id=\"APjFqb\"]")).setValue("imbd").pressEnter();

        //click on correct search result that redirects to imbd.com
        //Find the search result "IMDb: Ratings, Reviews, and Where To Watch The Best Movies", assert it to be visible, click on.
        $(By.cssSelector("#rso > div.hlcw0c > div > div > div > div > div > div > div > div.yuRUbf > div > span > a > h3")).shouldBe(visible).click();
        //Assert the cookies accept button to be visible.
        $(By.partialLinkText("accept-button"));
        //Find cookies accept button and click on it.
        $(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div/button[2]")).click();

        //click on Menu button
        //Assert Menu button text.
        $("#imdbHeader-navDrawerOpen > span").shouldHave(text("Menu"));
        //Find, assert to be visible, and click on Menu button.
        $(By.xpath("//*[@id=\"imdbHeader-navDrawerOpen\"]/span")).shouldBe(visible).click();

        //click on "Born Today"
        //Find "Born Today" button, assert it to be visible, click it.
        $(By.xpath("//*[@id=\"imdbHeader\"]/div[2]/aside[1]/div/div[2]/div/div[4]/span/div/div/ul/a[1]/span")).shouldBe(visible).click();

        //print out 5 first celebrities who are born today

        ElementsCollection borntodaycoll = $$(By.className("ipc-title__text"));

        int linesPrinted = 0;

        for(SelenideElement bd : borntodaycoll) {
            String textofbd = bd.getText();

            if (linesPrinted >= 6) {
                break;
            }
            System.out.println(textofbd);
            linesPrinted++;
        }

    }
}
