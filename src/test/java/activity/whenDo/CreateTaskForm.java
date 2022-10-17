package activity.whenDo;

import appiumControl.Button;
import appiumControl.Label;
import appiumControl.TextBox;
import org.openqa.selenium.By;

public class CreateTaskForm {
    public TextBox tittleTxtBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public TextBox noteTxtBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public Button saveButtonBox = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));
    public Button deleteButtonBox = new Button(By.id("com.vrproductiveapps.whendo:id/deleteItem"));
    public Label alertLabel = new Label(By.id("com.vrproductiveapps.whendo:id/alertTitle"));
    public Button deleteAlertButtonBox = new Button(By.id("android:id/button1"));
}
