package week4;

/**
 *   clustered index
 *   B+ index
 *                      [110]
 *                  /               \
 *          [50,    80]             [110,   200]
 *         /      |       \           \         \
 *   [10, 20]<-> [50, 70]<->[80, 100] <->[110, 120]<->[200, 300]
 *   name
 *   id
 *   salary
 *   ...
 *
 *     *     *     *     *     *     *     *     *     *     *
 *   non clustered index
 *      1. B+ tree index
 *      2. bitmap index
 *    *      *      *      *      *      *      *      *      *
 *    B tree
 *   []
 *
 *   insert 10, 20, 50
 *   [10, 20, 50]
 *
 *   insert 100
 *   [10, 20, 50, 100]
 *          [50]
 *         /    \
 *   [10, 20]   [50, 100]
 *
 *   insert 70, 80
 *          [50, 80]
 *         /    \       \
 *   [10, 20]   [50, 70] [80, 100]
 *
 *   insert 110, 120
 *          [50, 80,  110]
 *         /    \       \           \
 *   [10, 20]   [50, 70] [80, 100]  [110, 120]
 *
 *   insert 200, 300
 *                      [110]
 *                  /               \
 *          [50,    80]             [110,   200]
 *         /      |       \           \         \
 *   [10, 20]   [50, 70] [80, 100]  [110, 120]  [200, 300]
 *    *    *    *    *    *    *    *    *    *    *    *    *
 *
 *  B+ index
 *                      [110]
 *                  /               \
 *          [50,    80]             [110,   200]
 *         /      |       \           \         \
 *   [10, 20]<-> [50, 70]<->[80, 100] <->[110, 120]<->[200, 300]
 *   rowid rowid        rowid
 *     |
 *     |
 *     |                    table
 *     -------------------> .....
 *
 *
 *   select ... where id = 10
 *   1. loop up B+ index
 *   2. get row id
 *   3. use row id to find the row
 *
 *   select ... where id >= 10 and id <= 20
 *    *    *    *    *    *    *    *    *    *    *    *    *
 * Bitmap
 * id,  state           NJ,   NY,   VA
 * 1,    NJ             1     0     0
 * 2,    NJ             1     0     0
 * 3     NY             0     1     0
 * 4     VA             0     0     1
 *
 * NJ: 1100
 * NY: 0010
 * VA: 0001
 *
 * NJ || NY = 1100 || 0010 = 1110
 *
 *
 * example: appointment
 * 1h = 2 * 30min
 * 12h : 24 empty slots
 *
 * bitmap: 32 int number
 *
 *    date1: 000000000..00
 *    date2: 000000..01
 *
 *     *     *     *     *     *     *     *     *     *     *
 *     Tomorrow
 *     execution plan
 *     hint
 *     table design
 */