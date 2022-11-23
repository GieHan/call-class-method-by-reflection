package de.gie;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {

    public App() {

    }

    /*
    Calling a class & method by string
    Class and method don't have any parameter
     */
    public void callClassAndMethodByStringNoParam(String cName, String mName){
        try {
            //----- Define the class
            Class focusClass = Class.forName("de.gie.collection." + cName);

            //----- Define method
            Method focusMethod = focusClass.getMethod(mName);

            //----- Instance
            Object focusObjectOfTheClass = focusClass.getDeclaredConstructor().newInstance();

            //----- Call Result
            String result = ((String) focusMethod.invoke(focusObjectOfTheClass));

            System.out.println("[callClassAndMethodByString] " + result);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }


    /*
    Calling a class & method by string
    Class and method have parameter
     */
    public void callClassAndMethodByStringWithParam(String cName, Class[] cParamDefArr, Object[] cParamArr, String mName, Class[] mParamDeffArr, Object[] mParamArr){
        try {
            //----- Define the class & constructor
            Class focusClass                    = Class.forName("de.gie.collection." + cName);
            Constructor focusClassConstructor   = focusClass.getConstructor(cParamDefArr);

            //----- Define method
            Method focusMethod = focusClass.getMethod(mName, mParamDeffArr);

            //----- Instance
            Object focusObjectOfTheClass = focusClassConstructor.newInstance(cParamArr);

            //----- Call Result
            String result = ((String) focusMethod.invoke(focusObjectOfTheClass, mParamArr));

            System.out.println("[callClassAndMethodByStringWithParam] " + result);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) {
        System.out.println("\n----------------------------------------------------------\n");
        App app = new App();


        app.callClassAndMethodByStringNoParam("Cat", "doSound");


        // ----- We need to build data for param
        String cName            = "Kangaroo";
        Class[] cParamDefArr    = new Class[]{boolean.class};
        Object[] cParamArr      = new Object[]{true};

        String mName            = "doSing";
        Class[] mParamDefArr   = new Class[]{String.class, int.class, Boolean.class};
        Object[] mParamArr      = new Object[]{"Hi There", 1234, true};
        app.callClassAndMethodByStringWithParam(cName, cParamDefArr, cParamArr, mName, mParamDefArr, mParamArr);




        System.out.println("\n----------------------------------------------------------\n");
    }
}