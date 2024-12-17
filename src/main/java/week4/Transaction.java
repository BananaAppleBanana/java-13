package week4;

/**
 *      user1           user2
 *          \           /
 *          [file / data]
 *
 *  MVCC (multi version concurrency control)
 *  read_view
 *  update name -> alex
 *  id, name   row_id, tx_id, rollback_id
 *  1,  Tom              1
 *                                |
 *                                |
 *          1, Alex row_id_2, 2, --
 *
 *
 *
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 * ACID
 *
 * Read Uncommitted (dirty, non-repeatable read, phantom read, lost update)
 * tx1          select = 50rows                                   select = 150rows
 * timeline ----------------------------------------------------------------------------->
 * tx2                          begin tx      insert 100 rows                           commit
 *
 *
 * Read Committed
 * tx1          select = 50rows                                   select = 50rows
 * timeline ----------------------------------------------------------------------------->
 * tx2                          begin tx      insert 100 rows                           commit
 *
 * tx1          select = 50rows                         !=                            select
 * timeline ----------------------------------------------------------------------------->
 * tx2                       begin tx      insert/update/delete 100 rows  commit

 *
 * Repeatable Read
 * tx1          select = 50rows                         ==                            select
 * timeline ----------------------------------------------------------------------------->
 * tx2                       begin tx      insert/update/delete 100 rows  commit
 *
 * Serializable
 * apply share lock by default
 *
 *
 *   *   *   *   *   *   *   *   *
 *   id
 *   1
 *   5
 *   10
 *
 *   RU / RC isolation level
 *   select ... for update
 *   locks on id = 1, 5, 10
 *
 *   RR
 *   select ... for update
 *   ex locks on id = 1, 5, 10
 *   gap locks (min, 1), (1, 5),(10, max)
 *
 *
 *   Serializable
 *   select ...
 *
 *
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   optimistic lock
 *   count, version/timestamp
 *   1 ,
 *
 *      User1                       User2
 *    count = 1                     count = 1
 *      ++                          ++
 *              \       /
 *              count = 2
 *
 *  optimistic lock
 *      User1                       User2
 *    count = 1, v = 1          count = 1, v = 1
 *      ++                          ++
 *                              get lock
 *                              update count = 2, v = 2 where v = 1
 *                               db : count = 2,  v = 2
 *                              release lock
 *    get lock
 *  update count = 2, v = 2, where v = 1
 *   throw ex
 *   user re-read , count = 2, v = 2
 *    ++
 *   ....
 *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *
 */
