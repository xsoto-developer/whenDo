package cleanTest;

import activity.whenDo.CreateTaskForm;
import activity.whenDo.MainScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

import java.util.concurrent.TimeUnit;

public class CreateTaskWhenDoTest {
    MainScreen mainScreen = new MainScreen();
    CreateTaskForm createNoteForm  = new CreateTaskForm();

    @Test
    public void verifyCreateNewForm(){

        // Definicion de variables
        String tittle = "Mobile Exercise";
        String note = "This is the execution of the mobile exercise by xsoto;)";
        String update = " UPDATE";
        String messageErrorMainScreen = "Error: the note was not create";
        String messageErrorTaskScreen = "Error: the task was not create";
        String messageErrorDeleteTask = "Error: La tarea no fue eliminada";
        String alertTitle = "Confirm Delete";
        String messageTaskAdd = "No tasks added";
        String messageErrorListTask = "Error al listar las tareas";

        Session.getInstnce().getDriver().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        //Registro de la tarea
        mainScreen.addButton.click();
        createNoteForm.tittleTxtBox.setText(tittle);
        createNoteForm.noteTxtBox.setText(note);
        createNoteForm.saveButtonBox.click();

        //Verificacion de la existencia de la tarea
        Assertions.assertTrue(mainScreen.isNoteDisplayed(tittle), messageErrorMainScreen);
        Session.getInstnce().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Actualizacion de la tarea
        mainScreen.labelClicked(tittle);
        Session.getInstnce().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        createNoteForm.tittleTxtBox.setText(tittle + update);
        createNoteForm.saveButtonBox.click();
        Assertions.assertTrue(mainScreen.isNoteDisplayed(tittle + update),messageErrorTaskScreen);
        Session.getInstnce().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Seleccion de la tarea a ser eliminada
        mainScreen.labelClicked(tittle + update);
        Session.getInstnce().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        createNoteForm.deleteButtonBox.click();
        Session.getInstnce().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Verificacion del mensaje de confirmacion de la tarea a ser eliminada
        Assertions.assertEquals(alertTitle,createNoteForm.alertLabel.getText(),messageErrorDeleteTask);
        Session.getInstnce().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Eliminacion de la tarea
        createNoteForm.deleteAlertButtonBox.click();
        Session.getInstnce().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Verificacion de la tarea eliminada
        Assertions.assertEquals(messageTaskAdd,mainScreen.noTaskLabel.getText(),messageErrorListTask);

    }

    @AfterEach
    public void closeApp(){
        Session.getInstnce().closeApp();
    }
}

