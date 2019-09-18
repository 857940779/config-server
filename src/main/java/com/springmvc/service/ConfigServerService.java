package com.springmvc.service;

import com.springmvc.model.ConfigPropertyDTO;
import com.springmvc.model.ConfigServiceDTO;

/**
 * @Author: luohanwen
 * @Date: 2019/9/17 17:02
 * 配置服务接口
 */
public interface ConfigServerService {

    /**
     * 添加或修改服务，成功返回1，失败返回-1
     * @param configServiceDTO
     * @return
     */
    int addOrUpdateServer(ConfigServiceDTO configServiceDTO);

    /**
     * 删除服务
     * @param serviceId
     * @return
     */
    int deleteServer(Integer serviceId);

}
