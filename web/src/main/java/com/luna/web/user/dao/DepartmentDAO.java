package com.luna.web.user.dao;

import com.luna.web.user.entity.DepartmentDO;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author Luna@win10
 * @date 2020/3/22 10:09
 */
@Repository
public class DepartmentDAO {

	private static Map<Integer, DepartmentDO> departments = null;

	static {
		departments = new HashMap<Integer, DepartmentDO>();

		departments.put(101, new DepartmentDO(101, "D-AA"));
		departments.put(102, new DepartmentDO(102, "D-BB"));
		departments.put(103, new DepartmentDO(103, "D-CC"));
		departments.put(104, new DepartmentDO(104, "D-DD"));
		departments.put(105, new DepartmentDO(105, "D-EE"));
	}

	public List<DepartmentDO> getDepartmentDOs() {
		List<DepartmentDO> list = new ArrayList<>();
		list.addAll(departments.values());
		return list;
	}

	public DepartmentDO getDepartmentDO(Integer id) {
		return departments.get(id);
	}

}
