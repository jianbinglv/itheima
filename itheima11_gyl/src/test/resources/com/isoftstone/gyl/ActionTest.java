package com.isoftstone.gyl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.isoftstone.gyl.basedata.action.DepartmentAction;
import com.isoftstone.gyl.domain.privilege.Privilege;
import com.isoftstone.gyl.domain.privilege.Role;
import com.isoftstone.gyl.privilege.dao.PrivilegeDao;
import com.isoftstone.gyl.privilege.dao.RoleDao;
import com.isoftstone.gyl.privilege.service.RoleService;
import com.isoftstone.gyl.query.basedata.DepartmentQuery;

public class ActionTest {

	@Test
	public void testGetCount(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		DepartmentAction departmentAction= (DepartmentAction)context.getBean("departmentAction");
		DepartmentQuery departmentQuery = new DepartmentQuery();
		departmentAction.showPageResult();
		
	}
	@Test
	public void saveRole_privileges(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		RoleDao<Role> roleDao= (RoleDao<Role>)context.getBean("roleDao");
		PrivilegeDao privilegeDao=(PrivilegeDao) context.getBean("privilegeDao");
		Role role = roleDao.getEntryById(1L);
		Integer[] ids = new Integer[]{3,4,5,6};
		List<Privilege> privileges =  (List<Privilege>) privilegeDao.getPrivilegeByIds(ids);
		Set<Privilege> privilegesSet = new HashSet<Privilege>();
		privilegesSet.addAll(privileges);
		role.setPrivileges(privilegesSet);
		roleDao.saveEntry(role);
	}
	@Test
	public void testRoleService(){
		ApplicationContext context = new ClassPathXmlApplicationContext("com/isoftstone/gyl/spring/applicationContext.xml");
		RoleService roleService= (RoleService)context.getBean("roleService");
		Role role = roleService.getEntityById(30L);
		System.out.println(role.getName());
		
	}
}
