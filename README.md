# Money Exchange - MicroService
Technical test on foreign exchange calculation.

Use the below endpoints to test the application.

http://localhost:8080/currency-exchange/buySGD/HKD/value/1000

http://localhost:8080/currency-exchange/sellSGD/USD/value/100


        ~To Run in Docker containder~ 
    docker build . -t kotlin-spring-demo
    docker images
    docker run -p 9090:8080 kotlin-spring-demo 
    docker stop kotlin-spring-demo
    
    