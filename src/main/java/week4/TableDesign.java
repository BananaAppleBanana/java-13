package week4;

/**
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *  Basic table design
 *  1 - 1
 *  1 - m
 *  Teacher 1 - m Student
 *  Teacher: id(pk), name..
 *  Student: id(pk), teacher_id(fk)
 *
 *  m - m
 *  Teacher m - m Student
 *  teacher: id(pk), name
 *  teacher_student: id(pk), s_id(fk), t_id(fk)
 *  student: id(pk), name
 *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   Entity attribute value
 *   Survey table
 *   id, column_name, column_type, column_value, survey_id
 *   1 , 'name'     , 'string'   , 'Tom'       , 1
 *   2 , 'skills'   , 'string'   ,  'java'     , 1
 *   3,  'name'     , 'string'   , 'Alex'      , 2
 *   4,  'gender'   , 'string'   ,  'male'     , 2
 *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *              parent table(shared data)
 *
 *            /          \           \
 *        sub_table1    sub_table2     sub_table3
 *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *  id, name,  values
 *  1,  'Tom',  {json format}
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   id, name, col1, col2, col3,......col20..
 *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *  Normalization Rules
 *  1st,  one column contains one value
 *      example:
 *      name
 *     firstname, lastname
 *  2nd,  1st + all non-prime attributes fully depend on prime attributes
 *     example:
 *      (s_id, t_id), s_name, t_name
 *  3rd,  2nd + no transitive relationships
 *      example:
 *      s_id, s_name, address_id, address_details
 *
 *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *  PL/SQL
 *  Declare
 *      ..define variable
 *  Begin
 *      .....
 *  End
 *
 *  Stored Procedure
 *  Function
 *  Trigger
 *      do something before / after insert / update / delete data into student table
 *  Package
 *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *  DB types
 *  RDBMS: Oracle , MySQL, PostgreSQL, SQL Server, SQLite..
 *  RDBMS in cache: H2, Derby
 *  NoSQL: MongoDB, Cassandra
 *  Cache: Redis, Memcache
 *  Object storage: S3, S3 Glacier
 *  File : EFS
 *  Document DB: Elastic Search, OpenSearch(Serverless Elastic Search)
 *  ...
 *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *
 */