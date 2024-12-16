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