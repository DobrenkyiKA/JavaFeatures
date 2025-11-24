package preview.JEP_502_StableValues_Prevew;

import java.lang.StableValue;

public class StableValuesExample {
    static void main() {
        // Create a new unset StableValue
        var greeting = StableValue.<String>of();

        String message = greeting.orElseSet(() -> "Hello from StableValue!");
        System.out.println(message);
    }
}
