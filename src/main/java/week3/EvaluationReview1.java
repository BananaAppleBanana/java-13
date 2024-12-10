package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * How to create immutable class
 *  1. final
 *  2. no setter, only getter
 *  3. deep copy
 */
final class MyImmutableClass {
    private final String data;
    private final List<Integer> a = new ArrayList<>();

    public MyImmutableClass(String data, List<Integer> b) {
        this.data = data;
        /**
         * deep copy b to this.a
         */
    }

    public String getData() {
        return data;
    }

    public List<Integer> getMyList() {
        /**
         * deep copy a -> new List
         * return new List
         */
        return null;
    }
}

/**
 * fail fast exception
 * 1. Concurrent Modification Exception
 */

class FailFastException {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        for(int a: arr) {
            arr.add(4);
        }
    }
}


/**
 * How does ConcurrentHashMap work
 *  1. synchronized + CAS -> put
 *  2. no lock / synchornized -> get
 *
 *
 *  Volatile
 *  is this thread safe?
 *  class MyClass {
 *      private volatile int a = 0;
 *
 *      public void increment() {
 *          sycnrhonized(this) {
 *              a++;
 *          }
 *
 *          b++;
 *      }
 *  }
 *  t1 -> increment()
 *  t2 -> increment()
 *  ..
 *
 *
 *  Cpu
 *  L1
 *  L2
 *  L3
 *
 *  main memory
 *
 *  1. CPU read a = 0
 *  2. CPU change a + 1 = 1
 *  3. write it back to main memory
 */

/**
 *  ThreadPool Structure
 *
 *  producer    ->  [][][][][][][]  -> worker threads
 *                  blocking queue
 *
 *  How many types of ThreadPool in Java ?
 *  1. ForkJoinPool
 *  2. ThreadPoolExecutor
 *      fixed ThreadPool : core pool size == max pool size
 *      Single ThreadPool : core pool size == max pool size == 1
 *      Cache ThreadPool  : special blocking queue (size = 1)
 *      Scheduled ThreadPool : special blocking queue (sorted)
 *
 *  ReentrantLock
 *      1. condition
 *      2. fair lock
 *      3. lock multiple times in different method
 *      4. tryLock
 *  ReentrantReadWriteLock
 *      1. Read lock blocks Write lock
 *         Read lock allows Read lock
 *      2. Write lock blocks everything
 *  Semaphore
 *      1. allows multiple lock owner
 *  CountDownLatch
 *  CyclicBarrier
 *
 *
 *  Blocking Queue
 *  CompletableFuture vs Future
 */

class CompletableFutureExample {
    public static void main(String[] args) {
        List<CompletableFuture<Integer>> completableFutureList = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            final int j = i;
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return j;
            });
            completableFutureList.add(future);
        }
        //solution1
//        for(CompletableFuture<Integer> cf: completableFutureList) {
//            System.out.println(cf.join());
//        }

        //solution2
        CompletableFuture<Void> completableFutureAllOf = CompletableFuture
                .allOf(completableFutureList.toArray(new CompletableFuture[0]));
        completableFutureAllOf.thenAccept(Void -> completableFutureList.stream().map(CompletableFuture::join).forEach(System.out::println)).join();
    }
}


/**
 * Out of memory error?
 *  1. generate heap dump (file)
 *  2. memory leak  -> Jprofiler, jmc, memory analyzer ...
 *          static
 *          connections
 *  3. change reference types
 * Stack over flow error
 *
 *
 * Reference types in java
 *  1. Strong Reference
 *  2. Soft Reference
 *  3. Weak Reference
 *  4. Phantom Reference + Reference Queue
 *
 */

/**
 * Stream API
 * Java Reflection + Dynamic Proxy + Customized Annotations
 * Design patterns
 * network -> server
 * Http + Rest api -> Maven + Spring Boot
 *
 *
 * Tomorrow : 1:30pm CDT
 *
 */