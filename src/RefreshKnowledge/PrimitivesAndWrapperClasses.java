package RefreshKnowledge;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class PrimitivesAndWrapperClasses {
    public static void main(String[] args) {
// byte: 8-bit integer
        byte byteValue = 100;
        System.out.println("byte value: " + byteValue);

// short: 16-bit integer
        short shortValue = 32000;
        System.out.println("short value: " + shortValue);

// int: 32-bit integer (default integer type)
        int intValue = 2147483647;
        System.out.println("int value: " + intValue);

// long: 64-bit integer
        long longValue = 9223372036854775807L; // Note the 'L' suffix
        System.out.println("long value: " + longValue);

// float: 32-bit floating point
        float floatValue = 3.14f; // Note the 'f' suffix
        System.out.println("float value: " + floatValue);

// double: 64-bit floating point (default floating-point type)
        double doubleValue = 3.141592653589793;
        System.out.println("double value: " + doubleValue);

//String: Array of char
        String stringValue= "This is a test";
        String[] stringValueArray =stringValue.split(" ");
        StringBuffer sb = new StringBuffer("Hello this is a test, change it to something real!");
        sb.replace(0,5,"Gay");
        sb.delete(4,9);
        sb.insert(8," not ");
        sb.replace(7,9,"");
        sb.reverse();
        sb.reverse();
        sb.trimToSize();
        sb.replace(7,31,"");
        System.out.println("StringBufferValue: "+sb);
        StringBuilder sb2 = new StringBuilder("tset a si siht");
        sb2.reverse();
        sb2.replace(0,1,"T");
        System.out.println("StringBuilderValue: "+sb2);



// char: 16-bit Unicode character
        char charValue = 'A';
        System.out.println("char value: " + charValue);
        //Checks if char is in stringValue


// boolean: true or false
        boolean booleanValue = true;
        System.out.println("boolean value: " + booleanValue);
    }
}
