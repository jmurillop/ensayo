package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

//Clase donde se definen los elementos y métodos de una pantalla de la página web a automatizar.
public class PageExample {

    //Se define un drive para la definición del constructor.
    WebDriver driver;

    //<editor-fold desc="Elements">

    //Definición de WebElements y otros elementos
    @FindBy(xpath = "//*[@id='basicBootstrapForm']/div/div/input")
    WebElement TEXTBOX_FIRSTNAME;

    @FindBy(id = "checkbox1")
    WebElement CHECKBOX_CRICKET;

    @FindBy(id = "Skills")
    WebElement LIST_SKILLS;

    Select SELECT_SKILLS;

    String v = "value";

    //</editor-fold>

    //<editor-fold desc="Constructor">
    public PageExample(WebDriver driver) {
        this.driver=driver;
        //Este método crea todoso los webElements
        PageFactory.initElements(driver, this);

        //Creación de objetos necesarios
        SELECT_SKILLS= new Select(LIST_SKILLS);
    }
    //</editor-fold>

    //<editor-fold desc="Seters">
    public void setTEXTBOX_FIRSTNAME(String FIRSTNAME){
        TEXTBOX_FIRSTNAME.sendKeys(FIRSTNAME);
    }

    public void setCHECKBOX_CRICKET(){
        CHECKBOX_CRICKET.click();
    }

    public void setLIST_SKILLS(){
        List<WebElement> LIST_ALL_SKILLS = SELECT_SKILLS.getOptions();
        for (int i = 0; i < LIST_ALL_SKILLS.size(); i++) {
            LIST_ALL_SKILLS.get(i).click();
        }
    }
    //</editor-fold>

    //<editor-fold desc="Validators">
    public void validateTEXTBOX_FIRSTNAME(String expected){
        Assert.assertEquals(expected,TEXTBOX_FIRSTNAME.getAttribute(v));
    }

    public void validateCHECKBOX_CRICKET(){
        Assert.assertTrue("The Cricket is not checked",CHECKBOX_CRICKET.isSelected());
    }

    public void validateLIST_SKILLS(){
        List<WebElement> LIST_ALL_SKILLS = SELECT_SKILLS.getOptions();
        Assert.assertEquals(LIST_ALL_SKILLS.get(LIST_ALL_SKILLS.size()-1).getText(),LIST_SKILLS.getAttribute(v));
    }
    //</editor-fold>

}


//CTL+ALT+L para refactorizar
//CTRL+ALT+T para hacer bloques