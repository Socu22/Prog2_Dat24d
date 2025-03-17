package RefreshKnowledge;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Annotations_PrebuildOrCustom {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        @SuppressWarnings("unused") // can suppress warning like, unused instances of classes. allways put it right before the thing you want to annotate
        Object object = new Object();

        //some logic, that uses reflection.
        Cat cat = new Cat("B2",2);
        if (cat.getClass().isAnnotationPresent(VeryInportant.class)) { // here is an example of annotation use case, when you want to find an annotation in a class. if a class has an aannotation you can get it simple like this and refer to it.
            System.out.println("this is a important");
        }else {
            System.out.println("is not important");
        }
        //methods
        for(Method method:cat.getClass().getDeclaredMethods()){
            if (method.isAnnotationPresent(RunNow.class)) {
                RunNow annotation = method.getAnnotation(RunNow.class); // used to get parameterized values from annotation beans.
                for (int i = 0; i < annotation.times(); i++) { // to get the value inside like here.
                    method.invoke(cat);

                }
            }
        }
        for (Field field: cat.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if(field.isAnnotationPresent(ImportantString.class)){
                Object oValue = field.get(cat); //get can be something other than a string.
                System.out.println((String) oValue);
                if (oValue instanceof String sValue){ // cast automatically
                    System.out.println(sValue.toLowerCase());
                }
            }
        }
    }



}
//custom annotations
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //for annotations for classes
@interface VeryInportant{
    // before it can be used you have to add some annotations.


}
@Target({ElementType.TYPE, ElementType.METHOD}) //for annotations for classes and methods
@Retention(RetentionPolicy.RUNTIME) // for when the annotation is processed compile time or runtime. class that only matters in compile time as when the compile time is over so is the annotation. in runtime you can access these annotations through reflection code. source will delete the annotation before compile time one of these is for example the supresswarings.
@interface VeryInportant2{
    // before it can be used you have to add some annotations.


}
@VeryInportant
class catTest {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RunNow{
    int times() default 1; //only primitives work here+array+String+class type. default is good to have so that it is optional to insert and parameter
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface ImportantString{

}