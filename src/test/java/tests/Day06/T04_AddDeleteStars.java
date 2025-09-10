package tests.Day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class T04_AddDeleteStars extends TestBase {

    /*
    Go to https://claruswaysda.github.io/addDeleteStar.html
Create a method to add given number of stars
Create a method to delete given numbers of stars
Create a method to verify the given number of stars deleted
     */

    String url = "https://claruswaysda.github.io/addDeleteStar.html";
    @Test
    void Test04() throws InterruptedException {
        driver.get(url);
       int numberOfStarsToAdd = 7;
       int numberOfStarsToDelete = 3;
        addStars(numberOfStarsToAdd);
        deleteStars(numberOfStarsToDelete);
        verifyStarsDeleted(numberOfStarsToAdd - numberOfStarsToDelete);
    }

    private void addStars(int numberOfStarsToAdd) {
        By addStarButton = By.id("push-button");
        for (int i = 0; i < numberOfStarsToAdd; i++){
            driver.findElement(addStarButton).click();
        }
    }

    private void deleteStars(int numberOfStarsToDelete) throws InterruptedException {
        By deleteStarButton = By.id("delete-button");
        for (int i = 0; i < numberOfStarsToDelete; i++){
            driver.findElement(deleteStarButton).click();
        }

    }

    private void verifyStarsDeleted(int expectedNumberOfStars) throws InterruptedException {
        Assertions.assertEquals(expectedNumberOfStars, driver.findElements(By.className("star")).size());
        Thread.sleep(2500);

    }
}

