package com.nibnait.babasport.core.service.user;

import java.util.List;

import com.nibnait.common.page.Pagination;
import com.nibnait.babasport.core.bean.user.Employee;
import com.nibnait.babasport.core.query.user.EmployeeQuery;

/**
 * 
 * @author lixu
 * @Date [2014-3-28 下午01:50:28]
 */
public interface EmployeeService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addEmployee(Employee employee);

	/**
	 * 根据主键查询
	 */
	public Employee getEmployeeByKey(String id);

	/**
	 * 根据主键批量查询
	 */
	public List<Employee> getEmployeesByKeys(List<String> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(String id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<String> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateEmployeeByKey(Employee employee);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param employeeQuery
	 *            查询条件
	 * @return
	 */
	public Pagination getEmployeeListWithPage(EmployeeQuery employeeQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param employeeQuery
	 *            查询条件
	 * @return
	 */
	public List<Employee> getEmployeeList(EmployeeQuery employeeQuery);
}
