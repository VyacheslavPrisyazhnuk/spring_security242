package web.dao;


import web.model.Role;


public interface RoleDao {
    void addRole(Role role);
    Role show(Long id);
    Role findByName(String name);
//    Set<Role> findByUser(User user);
}
