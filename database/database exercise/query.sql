-- Insert into public.employee values (Default,'Nikunj','1998-11-25',
-- '2019-01-01','vp',4578545457,true,'sector 25','o-','M',false)

-- insert into public.salary values (6,25000,'2019-07-01','2019-07-31',5)

-- insert into department_empl values (6,9,'2020-01-01','2020-08-01') 

-- 1)rename table
-- ALTER TABLE employee
-- RENAME TO employees;

-- 2)count of employee
-- select count(*) from employee 
-- select count(*) from employee where employee_isActive=true 

-- 3) employee with name
-- select * from employee where employee_name like '%ha%'

-- 4)total salary to employess 

-- select sum(salary_amount) from salary

-- SELECT employee_id, SUM(salary_amount)
-- FROM salary 
-- GROUP BY employee_id;

-- 5)more than 100000 


-- SELECT distinct(employee.employee_name)
-- FROM employee inner Join salary 
-- where salary.salary_amount > 100000


-- SELECT employee.employee_name
-- FROM employee inner Join salary 
-- ON employee.employee_id=salary.employee_id where salary.salary_amount >100000


-- 6) more than 50000 within time periode




-- select employee.employee_name
--   FROM employee inner Join salary 
-- ON employee.employee_id=salary.employee_id 
--     where salary.from_date between '2019-07-01' and '2019-08-30'
-- 	GROUP BY
--   employee.employee_id having SUM (salary.salary_amount) > 40000




-- *************************************************************************************************************************************


-- 1)Find total number of employees in each employee type

select emp_type,count(*) from employee group by emp_type

-- 2)Write a query to find below listed result

select e.emp_type,sum(case when a.att_status='P' THEN 1 else 0 end) ,sum(case when a.att_status='A' THEN 1 else 0 end) 
from employee e inner join attendance a On e.emp_id=a.emp_id group by e.emp_type

-- 3)Find number of absent days within last 15 days. If absent_days_count is more than 8 then
-- return “red” in display_status otherwise “green”

select e.emp_name, sum(case when a.att_status='A' THEN 1 else 0 end),
	(case 
		when sum(case when a.att_status='A' THEN 1 else 0 end)>=8 
		then 'red' else 'green' end)	
	from employee e NATURAL join  attendance a 
	where att_date > current_date - interval '10' day
	GROUP By e.emp_name;



-- 4) Find total paid salary, yearly_deduction(sal_net_amount - sal_paid_amount) by
-- organization within last year for each employee

select e.emp_name, sum(s.sal_paid_amount),
	sum(s.sal_net_amount-s.sal_paid_amount )
	,e.emp_type	
	from employee e Left outer join  salary s ON e.emp_id = s.emp_id 
	 where s.sal_date > current_date - interval '1 year'
	 GROUP By e.emp_name,s.sal_paid_amount,s.sal_net_amount,e.emp_id;

-- 5)Find second highest total salary paid by organization within last year

	SELECT t.emp_name,t.p 
FROM (
      SELECT e.emp_name,sum(s.sal_paid_amount) as p,
          DENSE_RANK() OVER (ORDER BY sum( s.sal_paid_amount) DESC) AS Rank 
      FROM employee e left outer join salary s On e.emp_id = s.emp_id
		where s.sal_date > current_date - interval '1 year' GROUP by emp_name,sal_paid_amount
      ) as t  
WHERE t.Rank = 2 




-- or 

select emp_name emp_name ,sal_paid_amount salary FROM employee NATURAL JOIN salary  where
sal_paid_amount = (SELECT t.amount sec_max FROM
(SELECT sal_paid_amount amount FROM employee  NATURAL JOIN  salary 
 GROUP BY sal_paid_amount ORDER BY sal_paid_amount DESC LIMIT 2)T  OFFSET 1 LIMIT 1);


-- 6)Organization wants to declare employee of the month based on below criteria
-- 1. Not a single leave taken by employee in last month
-- 2. Employee having highest review in last month


select * From ( select e.emp_name,
(case 
		when sum(case when a.att_status='A' THEN 1 else 0 end)>1 
		then 0 else 1 end) isallow ,
		(Max(r.review_rating)) rate	
from employee e INNER join attendance a ON e.emp_id = a.emp_id 
	INNER join review r ON a.emp_id = r.emp_id 
	WHERE a.att_date > current_date - interval '1 MONTH' 
					 GROUP BY e.emp_name) emp
					 where emp.isallow=1  
					 order by emp.rate desc offset 1 rows fetch next 1 rows only 



-- or

 select DISTINCT(emp_name) from employee 
  NATURAL JOIN 
 ( select emp_id from attendance group by emp_id having sum(case when att_status='A' and att_date > current_date - interval '1 MONTH'
				 then 1 else 0 end)=0) attend 
  NATURAL JOIN 
  ( select emp_id from review where review_rating=(SELECT Max(review_rating) FROM review)
  )  ratting

-- or 

select emp_id, emp_name from employee NATURAL join review
    where review.review_rating = (
        select max(review_rating) review_rating from review
            where emp_id in (
                select emp_id from attendance
                    GROUP by (emp_id)
                    having sum(case when att_status = 'A' then 1 else 0 end) = 0
            )    
    ) and emp_id in (
        select emp_id from attendance
            GROUP by (emp_id)
            having sum(case when att_status = 'A' then 1 else 0 end) = 0
    ) group by (emp_id, emp_name)

-- or

select emp_name employee_of_month from employee where emp_id in  (
	select emp_id from review where  review_rating 
	in (select max(review_rating) from review where  emp_id in
	(select emp_id from attendance group by emp_id 
	having sum(case when att_status = 'A' then 1 else 0 end ) = 0)) 
	and emp_id in (select emp_id from attendance group by emp_id 
	having sum(case when att_status = 'A' then 1 else 0 end ) = 0)
)

-- 7)Find a list of employee having last month salary belongs to below criteria using single query
-- 1. Less than 10000
-- 2. Between 30000 to 40000
-- 3. More than 75000

select emp_name, sal_paid_amount 
	from employee natural join (select * from salary where sal_date > current_date - interval '1 MONTH') salary 
	where not(sal_paid_amount between 10000 and 30000) and not(sal_paid_amount between 40000 and 75000);

-- 8)Find a list of employee having different amount of salary in last two months.

select emp_name, abs(salary1-salary2) salary_diff_in_last_two_month from 
	employee natural join 
	(select emp_id, sal_net_amount as salary1 from salary where sal_date > current_date - interval '2 MONTH'
	 and sal_date < current_date - interval '1 MONTH' )s1 
	natural join (select emp_id, sal_net_amount as salary2 from salary where sal_date > current_date - interval '1 MONTH') s2
	 where abs(salary1-salary2)>0
GROUP By emp_name, abs(salary1-salary2) ;



-- 9)Query to count how many “Male” employees are there in a department or
-- in a company.
select count(*) from employee where emp_gender=1

10)Create procedure which will take Date/Month-Year as argument and will
generate Attendance Report for each employee for entered month.

CREATE OR REPLACE FUNCTION attendance_report (month character, year character)
returns table(emp_name character, total_present_days bigint, total_absent_days bigint) as $$
	select emp_name, sum(CASE WHEN att_status = 'P' THEN 1 ELSE 0 END) 
	total_present_days, sum(CASE WHEN att_status = 'A' THEN 1 ELSE 0 END)
	total_absent_days from employee natural join (select * from 
		attendance where to_char(att_date, 'yyyy')=year and to_char(att_date, 'mm')=right(concat('0',month),2))
		attendance group by emp_id
$$
language 'sql';

select * from attendance_report('07','2019');


12)Retrieve the names of employees who work on every project.

select emp_name from employee 
NATURAL join workson group by emp_id having sum(project_id)=(select count(*) total from project)

13)Retrieve the names of employees who do not work on any project.

select emp_name from employee 
NATURAL join workson group by emp_id having sum(project_id)=0

Q14: Find details of those employees whose salary is > the average salary for all employees
in his/her department. Output salary in ascending order.

select emp_name,salary.sal_paid_amount from employee natural join salary group by emp_id,sal_paid_amount 
having 
sum(case when sal_date > current_date - interval '13 day' then sal_paid_amount else 0 end) >

	(select avg(sal_paid_amount) from salary where sal_date > current_date - interval '13 day' ) 
	ORDER by sal_paid_amount desc
#######################################################################################################################

CREATE OR REPLACE FUNCTION function_copy() RETURNS TRIGGER AS
$BODY$
BEGIN
    INSERT INTO
        attendance(emp_id,att_date,att_status)
        VALUES(new.emp_id,current_date,'P');

           RETURN new;
END;
$BODY$
language plpgsql;

CREATE TRIGGER trig_copy
     AFTER INSERT ON employee
     FOR EACH ROW
     EXECUTE PROCEDURE function_copy();
	 
	 INSERT into employee values(default,'Nihar',1,current_date,1,1,50000)


$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4


CREATE OR REPLACE FUNCTION checkPercentage(id integer,dateObj date) 
RETURNS table(name_emp character, attended bigint ,
 total_days bigint, percentage numeric) 
    AS $$
    Begin return query 
    select res.emp_name, res.att as attended,res.tot,round(att::decimal/tot * 100 ,2) percentage from
	(select e.emp_name, sum(case when a.att_status = 'P' then  1 else 0 end) att , count(*) tot from employee e
left join attendance a on e.emp_id = a.emp_id 
and EXTRACT(month FROM dateObj) = EXTRACT(month FROM att_date)
and EXTRACT(year FROM dateObj) = EXTRACT(year FROM att_date)
/*and MONTH(att_date) = MONTH(dateObj)
and Year(att_date) = Year(dateObj)
and  to_char(dateObj ,  'YYYY') = to_char(att_date , 'YYYY')  
and  to_char(dateObj , 'MM')  = to_char(att_date , 'MM') 
*/
where e.emp_id = id
group by e.emp_id) as res;
End ; $$

LANGUAGE 'plpgsql';

