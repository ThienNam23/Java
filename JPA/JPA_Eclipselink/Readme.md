* Basic:
 - POJO: 
  + Employee.java
 - Services:
  + CreateEmployee.java
  + DeleteEmployee.java
  + FindEmployee.java
  + UpdateEmployee.java
  
* NamedQueries:
 - Named Queries define: 
  + Employee.java - line 12
 - Run:
  + NamedQueries.java

* Advanced Mappings: SINGLE_TABLE, JOINED_TABLE, TABLE_PER_CLASS
 - Entities:
  + Staff.java (super class)
  + NonTeachingStaff.java
  + TeachingStaff.java
 - Services:
  + SaveClient.java
  
* JPQL:
 - JPQLExample.java

* Entity Relationships:
 - put these corresponding anotations above FK properties line:
  + @ManyToOne
  + @OneToMany
  + @OneToOne
  + @manyTomany
  
* Criteria API:
 - CriteriaAPI.java
