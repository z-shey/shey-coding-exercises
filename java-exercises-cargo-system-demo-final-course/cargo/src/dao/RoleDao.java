package dao;

import entity.Role;

import java.util.List;

public interface RoleDao {
    List<Role> selectAllRole();

    Role selectById(Integer RoleID);
}
