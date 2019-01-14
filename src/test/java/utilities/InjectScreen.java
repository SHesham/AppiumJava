package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import javax.inject.Inject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class InjectScreen {

    private InjectScreen() {
    }

    public static void injectFields(Object object, AppiumDriver<MobileElement> driver) {
        InjectScreen injectScreen = new InjectScreen();
        injectScreen.init(object, driver);
    }

    private void init(Object object, AppiumDriver<MobileElement> driver) {

        Class<?> aClass = object.getClass();

        for (Field field : aClass.getDeclaredFields()) {
            if (field.getAnnotation(Inject.class) != null) {

                boolean changeModifier = Modifier.isPrivate(field.getModifiers());

                if(changeModifier){
                    field.setAccessible(true);
                }

                try {
                    Class<?> fieldClass= field.getType();

                    Constructor<?> constructor = fieldClass.getConstructor(AppiumDriver.class);

                    Object page = constructor.newInstance(driver);

                    field.set(object, page);
                } catch (NoSuchMethodException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }

                if(changeModifier){
                    field.setAccessible(false);
                }
            }
        }
    }
}