package activity.whenDo;

import appiumControl.Button;
import appiumControl.Label;
import org.openqa.selenium.By;

public class MainScreen {
    public Button addButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));
    public Label noTaskLabel = new Label(By.id("com.vrproductiveapps.whendo:id/noNotesText"));

    public  MainScreen(){

    }
    public boolean isNoteDisplayed(String tittle){
        Label note = new Label(By.xpath("//android.widget.TextView[@text='"+tittle+"']"));
        return  note.isControlDisplayed();
    }

    public void labelClicked(String tittle){
        Label note = new Label(By.xpath("//android.widget.TextView[@text='"+tittle+"']"));
        note.click();
    }

}
