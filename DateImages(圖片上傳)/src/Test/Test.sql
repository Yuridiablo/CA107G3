drop table EMP_PHOTO;

create table emp_photo (
empno          char(6)       not null ,
photo_format   varchar(10)   not null ,
picture        blob    );

select * from EMP_PHOTO;


 
註:
1: 使用SQL Server 2008時, 第6行的欄位型態可用【image】或【varbinary(max)】
2: 使用其它資料庫時, 第6行的欄位型態是使用【blob】