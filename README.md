# JavaMaven
  * Maven HomeWork Project
  
# Maven Packaging Steps
  * To create mvn task package, run the folowing commands:
    1. mvn clean  package -P task -Dservice=task
    
  * To create mvn developer package, run the folowing commands:
    1. mvn clean  package -P dev -Dservice=dev
    
  * To run the program:
    1. java -jar .\service\taskService\target\taskService-1.0.jar

# Versions Available
    1. Version3 (the default branch):
    This version contains HomeWork1 assingment with collections.

    2. Version4 (branch):
    This version contains HomeWork1 assingment with generics.

* To select other version, checkout the desired branch