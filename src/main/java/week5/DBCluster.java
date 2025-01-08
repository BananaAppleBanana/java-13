package week5;

/**
 *  Random IO : B + tree (read faster)
 *  Sequential IO : log append (write faster)
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *
 *     write
 *      |
 *  Write DB    ->     Read DB1 , 2 , 3
 *     |
 * StandBy DB
 *
 *
 *  1. write
 *          setting1: write to write DB and all read DB
 *          setting1: write to write DB and wait for 0 ~ N read DB
 *  2. read
 *          setting1: read from one of the read DB
 *          setting2: read from write db
 *     *     *     *     *     *     *     *     *     *     *     *     *
 *  CAP
 *      Consistency
 *      Availability
 *      Partition Tolerance
 *  BASE
 *      Basic Availability
 *      Soft Stage
 *      Eventually Consistency
 *
 *     *     *     *     *     *     *     *     *     *     *     *     *     *
 *    RDBMS Cluster example without config service
 *
 *    DB1   id(1, 4, 7
 *    DB2   id(2, 5, 8
 *    DB3   id(3, 6, 9
 *    DB4
 *
 *    query -> id % 4 -> find db
 *
 *     *     *     *     *     *     *     *     *     *     *     *     *
 *   MongoDB
 *
 *
 *                          mongos  -       config service
 *                      /       |           \
 *              sharding1       2           3
 *              primary node
 *              secondary node
 *              secondary node
 *
 *
 *     *     *     *     *     *     *     *     *     *     *     *     *
 *   Consistent hashing
 *   0 ~ Integer_max
 *
 *   DB1(0 ~ 10k)
 *   DB2(10k ~ 20k)
 *   DB3(20k ~ 30k)
 *   DB4(30k ~ max)
 *
 *   query -> hash(id) -> index
 *     *     *     *     *     *     *     *     *     *     *     *     *     *
 *  Cassandra Node(LSM tree)
 *
 *Write     ->  MemTable (cache) -> when hit threshold ,  dump data into SSTable(sorted string table immutable)
 *         |
 *        commit log
 *
 *
 *                          [SST1        SST2        SST3        SST4        SST5] => compact into 1 SST
 *
 *
 *
 * Read    -> MemTable (cache)  -> blooming filter ->
 *
 *
 *               SST1   [][][][][][][true]  hash algo1
 *                      [true][][][][][][]  hash algo4
 *
 *
 *               SST2   [][true][][][][][]  hash algo2
 *               SST3   [][][][][][][][][]  hash algo3
 *
 *     *     *     *     *     *     *     *     *     *     *     *     *     *
 *  Cassandra Cluster (leaderless system)
 *
 *                Node1(0)
 *
 *     Node4(30k)            Node2(10k)
 *
 *               Node3(20k)
 *
 *
 *      Replica Factor : 3
 *      Write Consistency Level: 1 ~ 3
 *                           -> Node1
 *      Write -> Node 4 -    -> Node2
 *                           -> Node3
 *
 *      Read Consistency Level: 1 ~ 3
 *
 *      Read ->  Node 4 -  -> Node1
 *                         -> Node2
 *
 *
 *      maintain consistency: WC + RC > RF
 *
 *
 *   *    *     *     *     *     *     *     *     *     *     *    *
 *   Global Secondary Index
 *      "Tom" : sharding 1, 3
 *      "Alex" : sharding 1, 4
 *
 *     *     *     *     *     *     *     *     *     *     *     *     *
 *  Redis
 *  20k hash slots
 *
 *             leader(0~10k)                     leader(10k ~ 20k)
 *           /          \                       /       \
 *     follower     follower                follower follower
 *
 *   *   *    *     *     *     *     *     *     *     *     *     *    *
 *      Election algorithm Raft
 *
 *      zookeeper
 *
 *      Leader     Candidate      Follower
 *
 *
 *
 */