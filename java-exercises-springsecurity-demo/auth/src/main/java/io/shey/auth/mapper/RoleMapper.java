package io.shey.auth.mapper;

import io.shey.auth.domain.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author shey
 * @description 针对表【role(角色表)】的数据库操作Mapper
 * @createDate 2024-06-07 07:20:33
 * @Entity io.shey.auth.domain.Role
 */
public interface RoleMapper extends BaseMapper<Role> {
    String selectRoleByAccountID(Long accountId);
}




