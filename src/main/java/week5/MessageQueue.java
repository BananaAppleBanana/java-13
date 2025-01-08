package week5;

/**
 *  1. diff queue model and pub sub model
 *  2. how sqs work and diff fifo and standard queue
 *  3. how does kafka work
 *  4. how does kafka balance the partitions with consumers
 *  5. two phase commit vs SAGA pattern
 *  6. CDC pattern and outbox pattern
 *  7. how to deduplicate message in message queue
 *  8. what is dead letter queue
 *  9. when use kafka vs activemq/ sqs
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *  Queue Model
 *
 *  producer(server1)           message queue cluster             Consumer(m2
 *  producer(server2)    ->     [][][][][m3][m2][m1]          ->  Consumer(m1
 *  producer(server3)                                             Consumer(m3
 *
 *  *  *  *  *  *  *  *  *  *  *  *
 *  Pub-Sub Model
 *
 *  producer(server1)           message queue cluster             Consumer(m1
 *  producer(server2)    ->     [][][][][m3][m2][m1]          ->  Consumer(m1
 *  producer(server3)                                             Consumer(m1
 *
 *  *  *  *  *  *  *  *  *  *  *  *
 *  SQS - queue model(FIFO / Standard)
 *
 *  producer(server1)           message queue cluster             Consumer(m2 timeout 5min
 *  producer(server2)    ->     [][][][][m3][m2][m1]          ->  Consumer(m1
 *  producer(server3)                                             Consumer(m3
 *
 *  Visibility Timeout
 *  *  *  *  *  *  *  *  *  *  *  *
 *  ActiveMQ / RabbitMQ
 *
 *  producer(server1)           message queue cluster             Consumer(m2
 *  producer(server2)    ->     [][][][][m3][m2][m1]          ->  Consumer(m1
 *  producer(server3)                                             Consumer(m3
 *  *  *  *  *  *  *  *  *  *  *  *
 *  Kafka
 *
 *  producer        ->    broker1(server)               ->      Consumer Group1
 *                        Topic1                                Consumer1(pull partition1)
 *                        partition1 [][][][m1]                 Consumer2(pull partition2)
 *                        partition2 [][][][m2]
 *
 *                        broker2(server)                       Consumer Group2
 *                                                              Consumer1(pull partition1, 2)
 *
 *  for same consumer group , same topic
 *      consumer 1 to many partition
 *
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *  Global Transaction
 *          service
 *          /    \
 *      DB1       DB2
 *
 *  1. Two Phase Commit
 *
 *          service
 *              |
 *         Coordinator
 *          /    \
 *      DB1       DB2
 *
 *      phase1: check DB1 / DB2, see if they can run this query
 *      phase2: send commit request to both of them
 *
 *  2. Saga Pattern
 *                  -  rollback queue / dead letter queue
 *      serviceA    -  message queue -  serviceB
 *        |                                |
 *       DB1                              DB2
 *
 *     1. serviceA commit tx in DB1  +20
 *     2. serviceB commit tx in DB2
 *        fail
 *        submit a rollback transaction(-20) to serviceA
 *  3. transaction cross database and message queue (CDC + outbox)
 *
 *     a. commit db
 *     //serviceA shutdown
 *     b. send message to message queue
 *
 *     a. send message to message queue
 *     //serviceA shutdown
 *     b. commit db
 *
 *
 *     Change Data Capture
 *     serviceA
 *       |
 *     DB1  -    CDC service -  message queue
 *
 *     a. serviceA
 *        begin tx
 *          insert data to DB1
 *          insert message to outbox table in DB1
 *        commit tx
 *
 *     b. CDC service
 *        keep checking the outbox table
 *        read new messages from outbox table
 *        send message to message queue
 *        remove message from outbox table
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *  Duplicate message messages
 *  1. SNS / some message queues have deduplicate setting
 *  2. deduplicate at consumer side
 *     message queue -  consumer
 *                          |
 *                       cache / db
 *  3. idempotent service
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *   Tomorrow:
 *      1. Daily work (Agile scrum, Sprint meetings)
 *      2. CI/CD
 *      3. git branch strategy
 *
 */