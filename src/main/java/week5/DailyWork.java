package week5;

/**
 *  Agile Scrum
 *      Jira
 *      Sprint 2 ~ 3 weeks
 *      Point System: 1 point = x hours / 1 point = difficulty level
 *      1. Sprint Planning meeting
 *              Production Backlog: TODO list
 *              Story :
 *              Ticket
 *      2. Daily Stand Up meeting
 *      3. Retrospective meeting / Sprint Review meeting
 *      4. Demo Review meeting
 *
 *   Team Size
 *      1. Manager
 *      2. Backend / Frontend / Full Stack developers
 *      3. Scrum Master (optional)
 *      4. QA (1 / 2 qa in your team ,  or separate qa team , or no qa)
 *      5. BA (optional)
 *   Other Teams
 *      1. DBA (shared cross diff team)
 *      2. Dev ops (deployment team)
 *      3. Data Scientist
 *     *     *     *     *     *     *     *     *     *     *     *     *     *     *
 *  What you do after you get stories
 *      1. clarify requirements
 *      2  checkout feature branch from dev branch
 *      3. TDD
 *          a. create class + interface with no implementations, put TODO
 *          b. create test cases and all corner cases
 *          c. impl TODO
 *          d. run test , fix bugs
 *      4. pull request code review
 *      5. merge feature branch to dev branch
 *      6. dev branch trigger CI/CD
 *     *     *     *     *     *     *     *     *     *     *     *     *     *     *
 *   CI/CD
 *      1. server
 *      2. pipeline (script)
 *      3. build  ->  test  ->   report   ->  package  ->  AWS ECR -> AWS ECS(task definition)
 *                                  |
 *                               Sonarqube(report server)
 *                               code coverage report
 *                               code sanity check report
 *     *     *     *     *     *     *     *     *     *     *     *     *     *     *
 * Git Branch Strategy
 *
 *  main branch -----v1.0                                         product env
 *                        \
 *  release branch  ------v1.0-------v1.1--------v2.0             release env
 *                                                  \
 *  development branch  ---------------------------------         dev env
 *                                  \                   /
 *  feature branch                   -------------------          your local env
 *                               ..
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *    Tomorrow , 10am cdt
 *    1. AWS
 *    2. Unit Test
 *
 *
 *
 *
 */