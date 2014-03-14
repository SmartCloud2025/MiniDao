package examples.dao;

import java.util.List;
import java.util.Map;

import org.jeecgframework.minidao.annotation.Arguments;
import org.jeecgframework.minidao.annotation.MiniDao;
import org.jeecgframework.minidao.annotation.Sql;

import examples.entity.Employee;


@MiniDao
public interface EmployeeDao{

	@Arguments("employee")
	public List<Map> getAllEmployees(Employee employee);
	
	@Arguments("empno")
    Employee getEmployee(String empno);
    
    @Arguments({"empno","name"})
    Map getMap(String empno,String name);

    @Sql("SELECT count(*) FROM employee")
    Integer getCount();

    @Arguments("employee")
    int update(Employee employee);

    @Arguments("employee")
    void insert(Employee employee);
}
