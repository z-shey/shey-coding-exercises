package io.shey.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.shey.auth.domain.Permission;
import io.shey.auth.service.PermissionService;
import io.shey.auth.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author shey
* @description 针对表【permission(权限表)】的数据库操作Service实现
* @createDate 2024-06-07 07:20:38
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

}




