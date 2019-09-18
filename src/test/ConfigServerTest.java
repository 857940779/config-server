import com.alibaba.fastjson.JSON;
import com.springmvc.common.Environment;
import com.springmvc.dao.ConfigServiceDOMapper;
import com.springmvc.model.ConfigServiceDTO;
import com.springmvc.service.ConfigServerService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @Author: luohanwen
 * @Date: 2019/9/17 17:34
 */
public class ConfigServerTest {

    public static ApplicationContext ctx;
    public static ConfigServiceDOMapper configServiceDOMapper;
    public static ConfigServerService configServerService;

    @BeforeClass
    public static void init(){
        ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        configServiceDOMapper=ctx.getBean(ConfigServiceDOMapper.class);
        configServerService=ctx.getBean(ConfigServerService.class);
        System.out.println("-----------------");
    }

    @Test
    public void test(){
        System.out.println(JSON.toJSONString(configServiceDOMapper.selectByPrimaryKey(1)));
    }

    @Test
    public void testAddServer(){
        ConfigServiceDTO configServiceDTO=new ConfigServiceDTO();

        configServiceDTO.setName("测试服务器");
        configServiceDTO.setIp("127.0.0.1");
        configServiceDTO.setPort("8080");
        configServiceDTO.setEnvironment(Environment.DEV.code);
        configServiceDTO.setServiceName("测试服务器");
        configServiceDTO.setCreator("test");
        configServiceDTO.setCreateTime(new Date());
        configServerService.addOrUpdateServer(configServiceDTO);
    }

}
