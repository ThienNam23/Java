**A. Basic:**
  * _POJO:_
    * Employee.java
  * _Services:_
    * CreateEmployee.java
    * DeleteEmployee.java
    * FindEmployee.java
    * UpdateEmployee.java
  
**B. NamedQueries:**
 * _Named Queries define:_
    * Employee.java - line 12
 * _Run:_
    * NamedQueries.java

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
* Item 1
* Item 2
  * Item 2a
    * Item 2b
