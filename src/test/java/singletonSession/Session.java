package singletonSession;

import factoryDevices.FactoryDevices;
import io.appium.java_client.AppiumDriver;

public class Session {
    // Atributo del mismo tipo
    private static Session session  = null;
    private AppiumDriver driver;
    // constructor privado
    private Session(){
//        driver = FactoryDevices.make("android").create();
        driver = FactoryDevices.make("cloud").create();
    }

    // Metodo estatico publico para acceder a la instacia unica
    public static Session getInstnce(){
        if (session == null)
            session = new Session();
        return session;
    }

    public void closeApp(){
        driver.quit();
        session =  null;
    }

    public AppiumDriver getDriver(){
        return  driver;
    }

}
