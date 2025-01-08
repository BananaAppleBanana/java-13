package week5;

/**
 * TTL
 *
 * 1. Cache Aside
 *    write:
 *          1. remove cache data
 *          2. insert / update / delete database
 *    read :
 *          1. read from cache -> find data -> return it
 *          2. if not -> get data from DB, save to cache -> return to user
 *
 *
 *    t1: user1 update id = 10, name = Tom -> Alex
 *        user1 remove cache data
 *    t2: user2 read id = 10
 *        get id = 10, name = Tom from database, save to cache
 *    t3: user1 update database
 * 2. Read Through
 *
 *    service -> cache -> database
 *
 * 3. Write Through
 *
 *    service -> cache -> database
 *
 *
 *
 */