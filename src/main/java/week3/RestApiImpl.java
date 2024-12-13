package week3;

/**
 *  *  What is Maven
 *  *  Why Spring Boot
 *  *  Rest API
 *  *  How to write rest api in spring boot
 *    *    *    *    *    *    *    *    *    *    *    *    *
 *    Why Spring Boot
 *    1. Main method to start application (main starter)
 *    2. embedded tomcat
 *    3. auto configuration
 *    4. application.properties / .yml
 *    5. actuator
 *    ...
 *    *    *    *    *    *    *    *    *    *    *    *    *
 *    Rest API
 *    1. noun endpoint :  /Student
 *    2. http method: get / post / delete / put / head / patch / option ..
 *          get : get resource
 *          post : create resource  -> response return relocation id / id
 *          delete : remove resource
 *          put : update resource
 *          patch : update partial resource
 *          head : get request -> no response body
 *          option : CORS / preflight
 *
 *
 *          idempotent service / endpoint
 *       http status: 2xx / 3xx / 4xx / 5xx
 *    3. content type : json / xml
 *    4. stateless
 *          /website.com/student?pageNum=1&pageCount=50&token=xxx
 *
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *       stateful = session
 *          /website.com/student?page=
 *
 *
 *       request -> server / tomcat
 *                  look up your session_id
 *               <- generate a new session_id
 *
 *               ->  tomcat
 *                   look up your session_id -> find it -> get data from session / map / cache
 *
 *
 *              load balancer (sticky session)
 *             /        \        \
 *          node1       node2   node3
 *              \       |       /
 *                  cache / db
 *
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *    CRUD for Student
 *    1. get all students
 *          endpoint:
 *          status code:
 *          http method:
 *          request body:
 *          response body:
 *    2. get student by id
 *    3. create student
 *    4. update student
 *
 *
 *
 * all students
 *     endpoint: /students
 *     status code: 200, 400, 500
 *     http method: get
 *     request body:
 *     response body: students: {data: [{id:1, name'abc'}]}
 * 2. student by id
 *     endpoint: /students/{id}
 *     status code: 200
 *     http method: get
 *     request body:
 *     response body: students: {id:1, name'abc'}
 * 3. create:
 * endpoint: /students
 * status code: 201
 *     http method: post
 *     request body:student: { name:'cbc'}
 *     response body: students: {id:1, name'cbc'}
 * 4. update:
 * endpoint: /students/{id}
 * status code: 204
 *     http method: post
 *     request body:student: {id:1, name:'cbc'}
 *
 *
 *
 *
 *     endpoint: GET /api/v1/students
 *
 * status code: 200 OK
 *
 * http method: GET
 *
 * response body:{
 *     "student":[
 *         {
 *           "id":1,
 *            .....
 *         }
 *     ],
 *     "total":1
 *     "pageNum":1
 *     "pageCount":1
 * }
 *
 * endpoint: /all_students
 * HTTP Method: GET
 * Status Code: 200 OK
 * Request Body: no body need
 * Response Body:
 * [
 *     {
 *         "id": 1,
 *         "name": “A”,
 *         "age": 20,
 *         "email": “…”
 *     },
 *     {
 *         "id": 2,
 *         "name": "B",
 *         "age": 22,
 *         "email": “…”
 *     }
 * …
 * ]
 *
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *
 */

