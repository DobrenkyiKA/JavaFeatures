package stable.JEP_511_ModuleImportDeclarations;
//import java.util.Map;                   // or import java.util.*;
//import java.util.function.Function;     // or import java.util.function.*;
//import java.util.stream.Collectors;     // or import java.util.stream.*;
//import java.util.stream.Stream;         // (can be removed)

import module java.base;

public class ModuleImportDeclarationVsOnDemandImport {
    void main() {
        String[] fruits = new String[]{"apple", "berry", "citrus"};
        Map<String, String> m =
                Stream.of(fruits)
                        .collect(Collectors.toMap(s -> s.toUpperCase().substring(0, 1),
                                Function.identity()));
        IO.println(m);
    }
}
