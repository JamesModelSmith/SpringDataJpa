package com.example.demo.repository;

import com.example.demo.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;
//当加上下面的注解的时候就可以不用继承后面的接口了
@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
public interface EmployeeRepository extends Repository<Employee,Integer> {
    /**
     * 根据名字查询内容
     * @param name
     * @return
     */
    public Employee findByName(String name);

    /**
     * 组合条件查询 名字以什么开头和年龄小于多少的组合条件
     * @param name
     * @param age
     * @return
     */
    public List<Employee> findByNameStartingWithAndAgeLessThan(String name,Integer age);

    /**
     * 以什么字母结尾和年龄小于多少的组合查询
     * @param name
     * @param age
     * @return
     */

    public List<Employee> findByNameEndingWithAndAgeLessThan(String name,Integer age);
    //where name in (?,?,....) or age <?

    /**
     *
     * @param names
     * @param age
     * @return
     */
    public List<Employee> findByNameInOrAgeLessThan(List<String> names,Integer age);

    /**
     * 根据注解设置查询条件然后简化名称
     * @return
     */
    @Query("select o from Employee  o where id=(select max(id) from Employee t1)")
    public Employee getEmployeeByMaxId();

    /**
     *
     * @param name
     * @param age
     * @return
     */
    @Query("select o from Employee o where o.name=?1 and o.age=?2")
    public List<Employee> queryParams1(String name,Integer age);

    /**
     * 方法2
     * @param name
     * @param age
     * @return
     */
    @Query("select o from Employee o where o.name=:name and o.age=:age")
    public List<Employee> queryParams2(@Param("name")String name,@Param("age")Integer age);

    /**
     *
     * @param name
     * @return
     */
    @Query("select o from Employee o where o.name like %?1%")
    public List<Employee> queryLike1(String name);

    /**
     *
     * @param name
     * @return
     */
    @Query("select o from Employee  o where  o.name like %:name%")
    public List<Employee> queryLike2(@Param("name") String name);

    /**
     * 原生的方法
     * @return
     */
    @Query(nativeQuery = true,value = "select count(1) from employee")
    public long gerCount();

    /**
     * 更新操作
     * @param id
     * @param age
     */
    //这个注解是允许修改的意思，需要事务
    @Modifying
    @Query("update Employee o set o.age=:age where o.id=:id")
    public void update(@Param("id")Integer id,@Param("age") Integer age);

}
