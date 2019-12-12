# Kuchen Brau



#### Directory Structure
    |-- kuchen-brau  
    |   |-- README.md  
    |   |-- brew-tasks
    |   |   |-- <Front End Task Applicationn in Angular>
    |   |   |-- ...  
    |   |-- camunda-engine
    |   |   |-- <Camunda Process Application>
    |   |   |-- ...
    |   |-- simulator
    |   |   |-- Simulates running a bunch of instances of the process
    |   |   |-- ...

   
#### Build and Run the Process Application
    cd camunda-engine
    mvn clean install
    java -jar camunda-engine.jar

#### Build and Run the Task List Application
    cd brew-tasks
    /usr/local/lib/node_modules/npm/bin/npm-cli.js run start --scripts-prepend-node-path=auto
Open a browser to http://localhost:4200/
