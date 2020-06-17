insert into course (course_id, course_name,creation_date,last_updated_date) values(1001, 'React Training',sysdate(),sysdate());
insert into course (course_id, course_name,creation_date,last_updated_date) values(1002, 'Swift Training',sysdate(),sysdate());
insert into course (course_id, course_name,creation_date,last_updated_date) values(1003, 'Angular Training',sysdate(),sysdate());


insert into passport (id,number) values (3001,'EFG23232');
insert into passport (id,number) values (3002,'ABC23232');
insert into passport (id,number) values (3003,'IJK23232');


insert into student (id,name,passport_id) values(2001,'Anantha',3001);
insert into student (id,name,passport_id) values(2002,'Anjitha',3002);
insert into student (id,name,passport_id) values(2003,'Jaya',3003);



insert into review (id,rating,description,course_course_id) values(4001,'5','Awesome Tutorials',1001);
insert into review (id,rating,description,course_course_id) values(4002,'4','Good tutorials',1001);
insert into review (id,rating,description,course_course_id) values(4003,'5','Superb tutorials',1003);

insert into course_student (student_id,course_id) values(2001,1001);
insert into course_student (student_id,course_id) values(2002,1001);
insert into course_student (student_id,course_id) values(2001,1002);
insert into course_student (student_id,course_id) values(2003,1001);

