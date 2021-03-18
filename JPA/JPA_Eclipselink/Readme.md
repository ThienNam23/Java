**A. Basic:**
 *1. POJO:* 
  + Employee.java
 *2. Services:*
  + CreateEmployee.java
  + DeleteEmployee.java
  + FindEmployee.java
  + UpdateEmployee.java
  
**B. NamedQueries:**
 - Named Queries define: 
  + Employee.java - line 12
 - Run:
  + NamedQueries.java

**C. Advanced Mappings: SINGLE_TABLE, JOINED_TABLE, TABLE_PER_CLASS**
 - Entities:
  + Staff.java (super class)
  + NonTeachingStaff.java
  + TeachingStaff.java
 - Services:
  + SaveClient.java
  
**D. JPQL:**
 - JPQLExample.java

**E. Entity Relationships:**
 - put these corresponding anotations above FK properties line:
  + @ManyToOne
  + @OneToMany
  + @OneToOne
  + @manyTomany
  
**F. Criteria API:**
 - CriteriaAPI.java
