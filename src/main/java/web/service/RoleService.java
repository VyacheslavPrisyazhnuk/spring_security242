package web.service;


import web.model.Role;

public interface RoleService {
    void addRole(Role role);
    Role show(Long id);
    Role findByName(String name);
}
