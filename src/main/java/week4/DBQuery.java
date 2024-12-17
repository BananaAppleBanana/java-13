/**
 * select *
 * from hr.employees
 *
 * -- select employee_id, first_name, last_name
 * -- from hr.employees
 *
 * -- select employee_id, first_name as fn, last_name as ln
 * -- from hr.employees
 *
 * -- SELECT eMployee_id, fiRst_name, last_Name
 * -- FROM hr.emPloyees
 *
 * -- select employee_id, first_name, last_name
 * -- from hr.employees
 * -- where employee_id > 200
 *
 *
 * -- select employee_id, first_name, last_name
 * -- from hr.employees
 * -- where employee_id > 200 and employee_id < 204
 * -- order by employee_id desc
 *
 *
 * select t.employee_id
 * from (select employee_id, first_name from hr.employees) t
 *
 * select max(salary)
 * from hr.employees
 *
 * select avg(salary)
 * from hr.employees
 *
 * select min(salary)
 * from hr.employees
 *
 * select count(COMMISSION_PCT	)
 * from hr.employees
 * select count(*)
 * from hr.employees
 *
 * -------------------------------
 * --get max salary in each department
 * select department_id, max(salary)
 * from hr.employees
 * where department_id != 90
 * group by department_id
 * having max(salary) > 10000
 * --------------------------------
 * select t.*
 * from  (select emp.*, dense_rank() over (order by salary desc) as rank
 * from hr.employees emp) t
 * where t.rank = 2
 *
 *
 * select department_id, salary, dense_rank() over (partition by department_id order by salary desc) as rank
 * from hr.employees
 *
 * ---------
 * question1: get department id which has 2nd highest employee number
 * 		  return dept_id, count_emp
 *
 *
 * SELECT department_id as dept_id, count_emp
 * FROM ( SELECT department_id, count(employee_id) as count_emp, DENSE_RANK() OVER (ORDER BY COUNT(employee_id) DESC) AS rank FROM hr.employees GROUP BY department_id )
 *     ranked_departments
 * WHERE rank = 2;
 *
 * ---------------------------------------------
 * result set A, B
 * union -> distinct(A + B)
 * union all -> A + B
 * intersect -> shared part(A, B)
 * minus -> A - B = A - shared part(A, B)
 *
 * select count(*)
 * from (
 *     select first_name, last_name from hr.employees
 * 	minus
 * 	select last_name, first_name from hr.employees
 * )
 *
 *
 * --cross join
 * select *
 * from tableA, tableB
 * where ...
 *
 * tableA	tableB
 *  1		 4
 *  2		 5
 *  3
 *
 * result set
 * col1,  col2
 * 1,		4
 * 1,		5
 * 2,		4
 * 2,		5
 * 3,		4
 * 3,		5
 *
 * --inner join
 * --departments: DEPARTMENT_ID(primary)	DEPARTMENT_NAME	MANAGER_ID	LOCATION_ID
 * --employees: EMPLOYEE_ID(primary)	FIRST_NAME	LAST_NAME SALARY MANAGER_ID	DEPARTMENT_ID(foreign key)
 * select * from hr.employees e join hr.departments d on e.department_id = d.department_id
 *
 * select * from hr.employees e, hr.departments d where e.department_id = d.department_id
 *
 *
 * --outer join : left join / right join / full join
 * select * from hr.employees e right join hr.departments d on e.department_id = d.department_id
 * where e.employee_id is null
 *
 *
 * --write a query to count employee number in each department
 * --return dept_id, dept_name, employee_number
 *
 * select d.department_id as dept_id, d.department_name as dept_name, count(e.employee_id) as employee_number
 * from hr.departments d left join hr.employees e on e.department_id=d.department_id
 * group by d.department_id, d.department_name
 *
 *
 * ---join 3 tables
 * select
 * from A join B on xx join C on xxx
 *
 *
 * Tomorrow:
 *     join = inner join
 * 	outer join
 *
 * 	transaction
 * 	index
 *
 * Group Homework
 * 	Transaction
 * 	1. what is transaction
 * 	2. what are isolation levels (mysql)
 * 	3. what are locks in database
 *
 * 	Index
 * 	1. what indexes we have in oracle
 * 	2. execution plan
 * 	3. what is hint
 *
 */