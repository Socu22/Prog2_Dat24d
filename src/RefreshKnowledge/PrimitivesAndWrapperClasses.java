package RefreshKnowledge;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.random.RandomGenerator;

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

// Math and Random
        somethingRandom();
    }
    static void somethingRandom(){
        RandomGenerator randomGenerator = new Random();
        System.out.println(randomGenerator.nextBoolean());
        System.out.println(randomGenerator.nextInt(5)); // from 0-n
       /* Random random = new Random(); // there is no reason to use this pther than in older software from java 17 and below else use SplittedRandom or SecureRandom depending on your use case.
        System.out.println(random.nextBoolean());
        System.out.println(random.nextInt(5));

        */
        randomGenerator = new SplittableRandom(); // for when you need fast acting randomness
        randomGenerator= new SecureRandom(); // it is slower than the older Random but it is more secure.

    }
    static void math(){
        double x =Math.pow(2,2); // x^y
        x= Math.abs(-11); // returns absolute value
        x= Math.divideExact(5,7); //x divided by the divisor
        x= Math.exp(25); //expotential e^x

       BigDecimal bigDecimal= new BigDecimal(5); //idc

    }
}
