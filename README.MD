# Repository purpose:
Create a convenient way to track JDK changes across versions.

# Content:
- Each module contains a single JDK version with its own features.
- JEPs features are separated by their status (see below). 
- USEFUL_LINKS.md contains links to JEPs descriptions on official https://openjdk.org/ and on other resources.

# JEPs status (package name):
- experimental
- incubator
- preview
- stable - new features that are ready to be used in production.

To enable features that are in preview or incubator stage:
[JEP_514_AheadOfTimeCommandLineErgonomics](JDK25/src/main/java/stable/JEP_514_AheadOfTimeCommandLineErgonomics)
–enable-preview: required for all preview features, otherwise compile errors will appear
–add-modules <name>: required for incubating modules, such as the jdk.incubator.vector
–release 25: recommended during compilation to target the Java 25 platform

Be aware that preview and incubator APIs may change or be removed in future versions. We should avoid using them in production or stay up to date with the official JDK documentation and release notes to look out for bug fixes or problems. 
Having this in mind, to compile and run code with such features, we need:

> At compile time do
javac --enable-preview --release 25 --add-modules jdk.incubator.vector MyClass.java

> At runtime do
java --enable-preview --add-modules jdk.incubator.vector MyApp

This way we hint the Java Virtual Machine (JVM) to allow the use of such features at compile and runtime.