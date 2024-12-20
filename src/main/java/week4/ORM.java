package week4;

/**
 * how to use hibernate
 * diff lazy loading and eager loading
 * what is lazy initialization exception
 * diff between jpa and hibernate
 * how does spring data jpa work
 * why orm / why hibernate / why spring data jpa
 *   *   *   *   *   *   *   *   *   *   *   *   *   *
 * How to use hibernate
 * 1. configure data source
 *       a. url
 *       b. username
 *       c. password
 * 2. hibernate loads data source -> create session factory
 * 3. create entity class
 *      @Entity
 *      @Table(..)
 *      public class StudentEntity {
 *          ..
 *          private String id;
 *          ..
 *          private String name;
 *
 *          @OneToMany(mappedBy="stu")
 *          private List<Teacher> teacherList;
 *      }
 *      ..
 *      class Teacher {
 *          @ManyToOne
 *          @JoinColumn("..")
 *          private Student stu;
 *      }
 *  4. create Repository interface + impl
 *          a. inject session
 *          b. session: hql / native query
 *          c. provide @Transactional annotation at service layer
 *     *     *     *     *     *     *     *     *     *
 * Lazy vs Eager
 * List<Student> stu = session....(select * from StudentEntity)
 * 1. Lazy loading (N + 1 issue)
 *      (hql)select s.* from StudentEntity s join s.teacherList=> (native query)select * from student
 *      for(Student s: stu) {
 *          List<Teacher> teacherList = s.getTeacher();
 *          teacherList.size() / iterator() / get()  => generate another native query get teacher info
 *      }
 *
 * 2. Eager loading
 *      (hql)select s.* from StudentEntity s join s.teacherList=> (native query)select * from student s join teacher t on ...
 *   *     *     *     *     *     *     *     *     *     *
 * Lazy Initialization Exception
 *   *     *     *     *     *     *     *     *     *     *
 * JPA                  vs          Hibernate
 * entity manager                   session
 * entity manager factory           session factory
 * persist()                        save()
 * merge()                          saveOrUpdate()
 * jpql                             hql
 * ..
 *   *     *     *     *     *     *     *     *     *     *
 *
 *   @Repository
 *   interface StudentRepo extends JpaRepository<StudentEntity, String>{
 *      @Query(...)
 *      ...... ()
 *
 *      .. findXXByXX();
 *   }
 *
 *   *     *     *     *     *     *     *     *     *     *
 *  why orm over jdbc
 *  1. object mapping
 *  2. connection pool
 *  3. centralized query / easy to migrate db
 *  4. cache (first level / 2nd level)
 *  5. lazy loading / eager loading
 *  ...
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *  Q1 move zero
 *  [1, 0, 1, 3, 12]
 *  int[] arr
 *  //slow = 2, fast = 3, arr = [1, 1, 0, 3, 12]
 *  for(int slow = 0, fast = 0; fast < arr.length; fast++) {
 *      //fast = 3, arr[fast] = 3
 *      if(arr[fast] != 0) {
 *          //slow = 2, arr = [1, 1, 3, 3, 12]
 *          arr[slow] = arr[fast];
 *          if(slow != fast) {
 *              //arr = [1, 1, 3, 0, 12]
 *              arr[fast] = 0;
 *          }
 *          //slow = 2
 *          slow++;
 *      }
 *  }
 *  [1, 1, 3, 12, 0]
 *  return arr
 *
 *  Q2 word dict
 *     List<String> words, String S
 *     ["apple", "pen"], "penapplepen" => return true
 *     ["apple", "pen"],  "applepennnn" => return false;
 *
 *
 *      boolean[] dp
 *      dp[0] = true;  substring(0, 1)
 *      dp[x] = true;  substring(0, x + 1)
 *
 *      int len = S.length() + 1;
 *      for(int i = 1; i < len; i++) {
 *          for(int j = 1; j <= i; j++) {
 *              if(dp[j - 1] == true) {
 *                  String str = S.substring(j - 1, i);
 *                  if(words.contains(str)) {
 *                      dp[i] = true;
 *                      break;
 *                  }
 *              }
 *          }
 *      }
 *
 *  Q3 (int[] arr, int B)
 *     example : arr = [1, 1, 3, 3] , B = 2
 *      1, 1 + B, 3 + B, 3 + B + B
 *      [1, 3, 5, 7]
 *      return 4
 *
 *  Q4 input: int[] arr
 *     constraint: 0 <= arr.length <= 10.   arr.length % 2 == 0
 *
 *     pick 2 numbers each time , calculate gcd(number1, number2) * round number
 *
 *     return max(1 * gcd(a, b) + 2 * gcd(e, f) + 3 * gcd(c, d)... )
 *
 *
 *    private int gcd(int a, int b) {
 *        ...
 *    }

 *    private int dfs(Integer[][] dp, int bitMask, int[] arr, int step, int n) {
 *         if(bitMask == (1 << n) - 1) {
 *             return 0;
 *         }
 *         if(dp[bitMask][step] != null) {
 *             return dp[bitMask][step];
 *         }
 *         int max = 0;
 *         for(int i = 0, d1 = 1; i < n; i++, d1 <<= 1) {
 *             if((bitMask & d1) != 0) {
 *                 continue;
 *             }
 *             for(int j = i + 1, d2 = d1 << 1; j < n; j++, d2 <<= 1) {
 *                  if((bitMask & d2) != 0) {
 *                      continue;
 *                  }
 *                  int res = step * gcd(arr[i], arr[j]) + dfs(bitMask | d1 | d2, arr, step + 1, n);
 *                  max = Math.max(max, res);
 *             }
 *         }
 *         return dp[bitMask][step] = max;
 *    }
 *
 *
 *   1. binary search
 *   2. tree BFS , DFS
 *   3. PriorityQueue sorting
 *   4. DP
 *   5. Union Found
 *   6. Binary index tree / Segment tree
 *   7. HashMap, TreeMap.....
 *
 *   Tomrorow
 *   Spring Security
 *
 *   examtopics
 *
 *   exem topics
 *
 *
 *
 */
