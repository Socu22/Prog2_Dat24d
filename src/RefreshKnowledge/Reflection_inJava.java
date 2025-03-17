package RefreshKnowledge;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection_inJava {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Cat cat = new Cat("JEns", 22); // the cats name is final and when that is created it is not changeable normally, but with reflections ii is possible
        Field[] fields = cat.getClass().getDeclaredFields(); // here is all the fields/attributes in the class
        for (Field field : fields){ // prints fields out in a loop
            System.out.println(field.getName());
        }
        System.out.println("---");
        for (Field field : fields){ // prints fields out in a loop
            if(field.getName().equals("name")){ // but if the fields name is changed (by some other developer) you have a problem as the proper refactoring is not also refactoring the string in this line of code. and then if this part of the code was part of the core functionality the software could break and/or become extremely buggy. and this only figures out these things in runtime, so it won't be able to be 'optimised' in compile. because of stuff like that code that does not use reflection is usually way faster than code that does not use it. do not use reflection if you can avoid using it, otherwise use it.
                field.setAccessible(true); //bypasses private final
                field.set(cat,"Jimmy Mc"); // sets it.

            }
        }
        System.out.println(cat.getName());

        Method[] declaredMethods = cat.getClass().getDeclaredMethods();
        System.out.println(Arrays.stream(declaredMethods).toList()); //unordered
        for (Method method: declaredMethods){
            if(method.getName().equals("sayMeow")){
                method.invoke(cat); // you can invoke methods through reflection. but public methods should be invoked normally through for example cat.meow();
            }
            if(method.getName().equals("setAge")){
                method.invoke(cat,1); // and methods parameters. still better to use cat.setAge(1); when public.
                System.out.println(cat.getAge());
            }
            if(method.getName().equals("sayAHiddenMeow")){
                method.setAccessible(true); // bypass private
                method.invoke(cat);
            }
            if (method.getName().equals("pus")){
                method.setAccessible(false); // for public static you don't need this one to be false. because it is public
                method.invoke(null); // but in the objects placeholder you set it to null, then you get the static output.
            }
            if (method.getName().equals("prs")){
                method.setAccessible(true); // for private static you need this one to be true so as to not cause a exception. because it is private.
                method.invoke(null); // but in the objects placeholder you set it to null, then you get the static output.
            }
        }

        }
}
