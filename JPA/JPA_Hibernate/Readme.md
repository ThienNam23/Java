1. Phải thêm:
		<!-- https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api -->
		<dependency>
			<groupId>javax.xml.bind</groupId>
			<artifactId>jaxb-api</artifactId>
			<version>2.3.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.sun.xml.bind/jaxb-core -->
		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-core</artifactId>
			<version>2.3.0.1</version>
		</dependency>
		<dependency>
			<groupId>com.sun.xml.bind</groupId>
			<artifactId>jaxb-impl</artifactId>
			<version>2.3.1</version>
		</dependency>
bởi có 1 hàm tồn tại ở java 8 nhưng bị xóa bỏ ở java 11, nghi vấn là hàm buildSessionFactory() dòng 29 - App.java

2. phải đặt hibernate.cfg.xml trong src/main/java

3. Trong hibernate.cfg.xml sửa thành <property name="hibernate.dialect">org.hibernate.dialect.MariaDBDialect</property>

4. Mặc định trong Hibernate cache level là 1, để lên cache level 2 cần thêm các dependencies sau:
		<!-- https://mvnrepository.com/artifact/net.sf.ehcache/ehcache -->
		<dependency>
			<groupId>net.sf.ehcache</groupId>
			<artifactId>ehcache</artifactId>
			<version>2.10.6</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.hibernate/hibernate-ehcache -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-ehcache</artifactId>
			<version>5.2.12.Final</version>
		</dependency>

5. Trong IDE có cài thêm plugin JBoss để tạo file hibernate.cfg.xml từ Eclipse Marketplace

6. Caching level 2 cho phép truy cập cache liên session

7. từ Hibernate.Ehcache 4.0 trở lên thì trong *.cfg.xml, dùng: <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory.class</property>

8. từ Hibernate 5.2, setResultTransformer không dùng nữa (deprecated) và đang được thảo luận thay thế ở bản 6.0, trong khi chưa có bản thay thế thì vẫn dùng mặc dù deprecated (HqlExample.java - line 77)

9. Có 4 trạng thái đối với 1 object: persistent, transient, detached, removed

10. sử dụng session.load thay vì session.get, load sẽ trả về proxy object, chỉ khi tác động đến đối tượng load mới gửi query đi
