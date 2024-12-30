package week5;

/**
 * Microservice Introduction
 *
 *
 * Microservice vs Monolithic
 *
 * * * * * * * * * * * * * * * *
 * Monolithic App
 *          user
 *          |
 *         Load Balancer
 *      /       \       \          \
 *   Node1     Node2     Node3      Node4
 *
 *Why not monolithic
 *  1. scalability
 *  2. deployment
 *  3. languages / implementations of diff services
 *  4. ....
 *
 ** * * * * * * * * * * * * * * *
 * Vertical Scaling vs Horizontal Scaling
 * Vertical Scaling : hardware
 * Horizontal Scaling: add more servers / nodes
 *
 *  ** * * * * * * * * * * * * * * *
 *  public ip : your phone number
 *  private ip : internal extension number (internal phone call extension)
 *
 *  private ip -(transfer)> public ip  -> Api gateway(service) -> stu service(private ip)
 *
 ** * * * * * * * * * * * * * * *
 * How do we create microservices / Why Microservices
 *          Api Gateway (public ip)
 *          /       \
 *  stu service    class info service(private ip)
 *     |
 *  serviceB
 *
 *
 * 1. discovery service / service registration / registration center
 *    serviceA -> serviceB
 *      |
 *    service discovery:  [serviceB: ip1, 2, 3] [serviceA: ipxxx..]
 * 2. api gateway
 *      a. rate limiter
 *          token bucket
 *          \    /
 *           \__/   ->
 *          queue + sliding window
 *      b. co-relation id(global unique id)
 *          UUID
 *          snowflake id (64 bit)
 *                  [..     bit][..     bit][..    bit][..  bit][ serial id]
 *                  timestamp    machine id  process id ...
 *          database primary key (sequence id)
 *                  db1(1, 4, 7 .... +3)
 *                  db2(2, 5, 8 .... +3)
 *                  db3(3, 6, 9 .... +3)
 *      c. log
 * 3. centralized configuration service
 * 4. message queue
 *        user
 *         |
 *        producer  - message queue(server) - consumer -> notification service
 *                          |
 *                        disk
 * 5. security service
 * 6. circuit breaker
 *       serviceA -> circuit breaker -> serviceB
 *       a. open :
 *              keep tracking failed request amount in current interval
 *              eg.  3 requests failed out of 5 requests
 *                   change status from open -> close
 *      b. close :
 *              serviceA always gets a default data / preset data / response from service B
 *              circuit breaker use background thread -> check service B status
 *              if service B becomes healthy -> change status from close -> open
 *
 * 7. database cluster / sharding
 * 8. cache cluster
 *      a. read through
 *      b. write through
 *      c. cache aside pattern
 *      ..
 * 9. git branch strategy
 * 10. deployment, CI/CD
 * 11. monitors
 *      a. log monitor
 *      b. api performance monitor
 *      c. metrics
 *
 * evaluation: Thursday / Friday
 */