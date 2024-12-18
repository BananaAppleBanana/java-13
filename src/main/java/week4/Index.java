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
 * * ******************************
 -- EXPLAIN PLAN FOR
 -- select * from hr.employees;
 -- select plan_table_output from table(dbms_xplan.display('plan_table',null,null));

 -- EXPLAIN PLAN FOR
 -- select * from hr.employees e join hr.departments d on e.department_id = d.department_id;
 -- select plan_table_output from table(dbms_xplan.display('plan_table',null,null));
 -- table scan path:
 --     index access path:
 --     	index unique scan
 --     	index range scan
 --     	index full scan
 --     	index fast full scan
 -- 	full table scan

 --index unique scan
 -- EXPLAIN PLAN FOR
 -- select * from hr.employees where employee_id = 100;
 -- select plan_table_output from table(dbms_xplan.display('plan_table',null,null));


 -- index range scan
 -- EXPLAIN PLAN FOR
// -- select /*+ index(e) */
//  * from hr.employees e where employee_id > 100;
//        -- select plan_table_output from table(dbms_xplan.display('plan_table',null,null));
//
//        -- EXPLAIN PLAN FOR
//        -- select /*+ full(e) */ * from hr.employees e where employee_id >= 100 and employee_id <= 101;
//        -- select plan_table_output from table(dbms_xplan.display('plan_table',null,null));
//
//
//        -- EXPLAIN PLAN FOR
//        -- select * from hr.employees e join hr.departments d on e.department_id = d.department_id;
//        -- select plan_table_output from table(dbms_xplan.display('plan_table',null,null));
//
//        -- EXPLAIN PLAN FOR
//        -- select * from hr.employees e, hr.departments d where e.department_id = d.department_id;
//        -- select plan_table_output from table(dbms_xplan.display('plan_table',null,null));
//
//        -- EXPLAIN PLAN FOR
//        -- select * from hr.employees;
//        -- select plan_table_output from table(dbms_xplan.display('plan_table',null,null));
//
//        -- EXPLAIN PLAN FOR
//        -- select * from (select * from hr.employees);
//        -- select plan_table_output from table(dbms_xplan.display('plan_table',null,null));
//
//        -- hash join, merge join, nested loop join
//
//        -- merge join :
//
//        -- public int[] merge(int[] a1, int[] a2) {
//        --     //a1 == null / a2 == null , throw exception
//        --     int p1 = 0, p2 = 0;
//        --     int[] res = new int[a1.length + a2.length];
//        -- 	int idx = 0;
//        --     while(p1 < a1.length && p2 < a2.length) {
//        --         if(a1[p1] <= a2[p2]) {
//        --         	res[idx++] = a1[p1++];
//        --         } else {
//        --         	res[idx++] = a2[p2++];
//        --         }
//        --     }
//        --     for(; p1 < a1.length; p1++) {
//        --         res[idx] = a1[p1];
//        --     }
//        --     for(; p2 < a2.length; p2++) {
//        --         res[idx] = a2[p2];
//        --     }
//        --     return res;
//        -- }
//
//
//        -- nested loop join:
//        -- for(int i = 0; i < len; i++) {
//        --     for(int j = 0; j < len; j++) {
//
//        --     }
//        -- }
//
//        -- hash join : similar to hashmap
//
//
//        EXPLAIN PLAN FOR
//        select /*+ use_merge(e d) leading(d) full(e) full(d) */ * from hr.employees e join hr.departments d on e.department_id = d.department_id;
//        select plan_table_output from table(dbms_xplan.display('plan_table',null,null));
//
//
//        -- material view
//
//
//
//        EXPLAIN PLAN FOR
//        select * from myQ union select * from myQ;
//        select plan_table_output from table(dbms_xplan.display('plan_table',null,null));
//
//
//
//
//
//        */
