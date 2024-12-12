package week3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *  What will happen when we click url in browser?
 *  www.xxx.com
 *  1. use mac address -> get private ip
 *  2. browser converts domain <-> public ip (from local cache, from DNS)
 *  3. private ip -> NAT device -> request -> server
 *       connection
 *      source ip, source port, destination ip, destination port
 *      private ip     8080       public ip      9090
 *
 *  4. server receives request -> TCP
 *  5. request -> tomcat server (default Spring Boot server)
 *                  a. build connection
 *                  b. assign connection to thread1 in threadpool(1000)
 *                  c. thread1 keeps reading data from that connection
 *                  d. thread1 returns response back to source location
 *             -> netty server (non blocking server, Spring WebFlux)
 *
 *
 * *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  How does browser / client send binary data to server?
 *
 *           [ip header][tcp header][http header][data]
 * *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  Why do we encode request / data.  Diff between encoding and encryption?
 *
 *      ASCII table 0 ~ 127
 *
 *
 *      00101010101010100010101001010101101010
 *      C++ , terminal operators
 *      request body json
 *
 *      BASE64 -> a - z, A - Z, 0 - 9,
 *
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  How does Spring handle your http / rest api request
 *
 *  request -> tomcat server (default Spring Boot server)
 *  *                  a. build connection
 *  *                  b. assign connection to thread1 in threadpool(1000)
 *  *                  c. thread1 keeps reading data from that connection
 *                            |
 *                            --> DispatcherServlet(front controller, /*) -> handler mapping -> Controller
 *                                         |
 *                                       view resolver(model and view)
 *
 *
 *                           --> DispatcherServlet(front controller, /*) -> handler mapping -> Controller(@ResponseBody, return json)
 *                                         |
 *                                       HttpMessageConverter
 *                                        |
 *                                      Jackson (convert object to json)
 *                                      Jax B (convert object to xml)
 *
 *
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *
 *  MVC
 *  model -> data layer + repository layer
 *  view -> frontend layer (jsp, react, angular, html)
 *  controller -> controller + service  ( business logic layer)
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  Spring : IOC + AOP
 *  Spring MVC: process http request (get, post , delete... with controller)
 *  Spring Data JPA: based on Hibernate, (CRUD with database)
 *  Spring Security: help you impl authentication / authorization
 *  Spring Actuator: health / monitor endpoints , provide metrics endpoint
 *  Spring Cloud(eureka, config,...): for microservice implementations
 *
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  why spring / what advantages of spring / features in spring
 *
 *  Spring IOC : factory pattern + reflection
 *      IOC container: Application Context
 *
 *      Dependency Injection
 *      1. @Component , @Controller, @Service, @Repository , @Bean
 *      2. @Autowired
 *              injection ways: field injection / constructor injection / setter injection
 *              injection type: by type injection / by name injection, @Qualifier
 *      3. bean scope : Singleton(default), Prototype, Request, Session, Global Session
 *
 *  Spring AOP : Dynamic Proxy
 *      Aspect : @Before, @After, @Around, @AfterReturn, @AfterThrow
 *      PointCut : locations
 *
 *      @After
 *      public void b1() {
 *
 *      }
 *
 *      @PointCutting("...location")
 *      @Before
 *      public void a() {
 *          System.out.println("before ..");
 *      }
 *
 *      @After
 *      public void b2() {
 *
 *      }
 *
 *      List<Method> methods = {after1, before, after2}
 *      before -> real logic -> after1 / 2
 *
 *      how AOP work
 *      1. load chain aspects list
 *      2. before: create beforeAdvice
 *                 execute before logic -> then execute all other logics
 *         after : create afterAdvice
 *                 execute all other logics -> execute after logic
 *      3. get List of Before/After advices
 *      for example {after1, before, after2}
 *      mi = ReflectiveMethodInvocation
 *      List<Advice> = {after1, before, after2}
 *      mi.proceed() {
 *          index of list = 0
 *          after1.invoke(this mi) {
 *              mi.proceed() {
 *                  index of list = 1
 *                  before.invoke(this mi) {
 *                      execute before logic
 *                      mi.proceed() {
 *                          index of list = 2
 *                          after2.invoke(this mi) {
 *                              mi.proceed() {
 *                                  index of list = 3 > list.size();
 *                                  execute real implementation
 *                              }
 *                              execute after 2 logic
 *                          }
 *                      }
 *                  }
 *              }
 *              execute after1 logic
 *          }
 *      }
 *      line 134 -> line 140 -> line 142 -> line 147
 *      before -> real logic -> after 2 -> after 1
 *
 *
 *
 *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *
 *  Tomorrow:  MAVEN + Spring Boot Rest api example
 *  What is Maven
 *  Why Spring Boot
 *  Rest API
 *  How to write rest api in spring boot
 *
 *  Assignment Deadline (Monday):
 *       1. write spring boot application
 *       2. send request to 3rd party api
 *       3. get response return the user
 *       4. can finish the project in 15 ~ 20 min without any helps
 *  Tomorrow 10:30 ~ 12:30 cdt
 *
 *
 */


@SpringBootApplication
class MySpringIOCExample {

    private static MyFirstComponent my1stBean;
    private static MyFirstComponent my2ndBean;

    @Autowired
    public MySpringIOCExample(@Qualifier("first") MyFirstComponent my1stBean, @Qualifier("second") MyFirstComponent my2ndBean) {
        MySpringIOCExample.my1stBean = my1stBean;
        MySpringIOCExample.my2ndBean = my2ndBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(MySpringIOCExample.class, args);
        System.out.println(my1stBean);
        System.out.println(my2ndBean);
        System.out.println(my1stBean == my2ndBean);


    }
}

@Component
interface MyFirstComponent {}

@Component("first")
@Scope("singleton")
class MyFirstComponentImpl1 implements MyFirstComponent {
    @Override
    public String toString() {
        return "MyFirstComponentImpl1{}";
    }
}

@Component("second")
@Scope("singleton")
class MyFirstComponentImpl2 implements MyFirstComponent {
    @Override
    public String toString() {
        return "MyFirstComponentImpl2{}";
    }
}