package io.shey.auth.mapper;

import io.shey.auth.domain.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author shey
 * @description 针对表【permission(权限表)】的数据库操作Mapper
 * @createDate 2024-06-07 07:20:38
 * @Entity io.shey.auth.domain.Permission
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    List<String> selectPermissionByAccountID(Long accountId);
}




