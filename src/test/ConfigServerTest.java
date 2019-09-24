import com.alibaba.fastjson.JSON;
import com.springmvc.common.Environment;
import com.springmvc.dao.ConfigServiceDOMapper;
import com.springmvc.model.ConfigPropertyDTO;
import com.springmvc.model.ConfigServiceDTO;
import com.springmvc.model.PropertyDTO;
import com.springmvc.service.ConfigPropertyService;
import com.springmvc.service.ConfigServerService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: luohanwen
 * @Date: 2019/9/17 17:34
 */
public class ConfigServerTest {

    public static ApplicationContext ctx;
    public static ConfigServiceDOMapper configServiceDOMapper;
    public static ConfigServerService configServerService;
    public static ConfigPropertyService configPropertyService;

    @BeforeClass
    public static void init(){
        ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        configServiceDOMapper=ctx.getBean(ConfigServiceDOMapper.class);
        configServerService=ctx.getBean(ConfigServerService.class);
        configPropertyService=ctx.getBean(ConfigPropertyService.class);
        System.out.println("--------init success---------");
    }

    @Test
    public void test(){
        System.out.println(JSON.toJSONString(configServiceDOMapper.selectByPrimaryKey(1)));
    }

    @Test
    public void testAddServer(){
        ConfigServiceDTO configServiceDTO=new ConfigServiceDTO();

        configServiceDTO.setName("DataService");
        configServiceDTO.setIp("127.0.0.1");
        configServiceDTO.setPort("8080");
        configServiceDTO.setEnvironment(Environment.DEV.code);
        configServiceDTO.setServiceName("DataService");
        configServiceDTO.setCreator("test");
        configServiceDTO.setCreateTime(new Date());
        configServerService.addOrUpdateServer(configServiceDTO);
    }

    @Test
    public void testAddProperty(){
        ConfigPropertyDTO configPropertyDTO=new ConfigPropertyDTO();
        configPropertyDTO.setServiceId(2);  //服务id

        List<PropertyDTO> list=new ArrayList<>();
        PropertyDTO propertyDTO=new PropertyDTO();
        propertyDTO.setKey("database.url");
        propertyDTO.setValue("jdbc:mysql://127.0.0.1:3306/config_center?characterEncoding=UTF8&allowMultiQueries\\=true");
        list.add(propertyDTO);

        PropertyDTO propertyDTO2=new PropertyDTO();
        propertyDTO2.setKey("mq.url");
        propertyDTO2.setValue("tcp://127.0.0.1:61616");
        list.add(propertyDTO2);

        PropertyDTO propertyDTO3=new PropertyDTO();
        propertyDTO3.setKey("mq.user");
        propertyDTO3.setValue("admin");
        list.add(propertyDTO3);

        PropertyDTO propertyDTO4=new PropertyDTO();
        propertyDTO4.setKey("mq.password");
        propertyDTO4.setValue("admin");
        list.add(propertyDTO4);

        PropertyDTO propertyDTO5=new PropertyDTO();
        propertyDTO5.setKey("redis.server.url");
        propertyDTO5.setValue("127.0.0.1:6389");
        list.add(propertyDTO5);

        PropertyDTO propertyDTO6=new PropertyDTO();
        propertyDTO6.setKey("jdbc.username");
        propertyDTO6.setValue("root");
        list.add(propertyDTO6);

        PropertyDTO propertyDTO7=new PropertyDTO();
        propertyDTO7.setKey("jdbc.password");
        propertyDTO7.setValue("root");
        list.add(propertyDTO7);
        configPropertyDTO.setList(list);         //配置信息

        configPropertyService.addOrUpdateProperty(configPropertyDTO);
    }

    @Test
    public void testGetAppProperty(){
        ConfigServiceDTO configServiceDTO=new ConfigServiceDTO();
        configServiceDTO.setIp("127.0.0.1");
        configServiceDTO.setEnvironment(Environment.DEV.code);
        configServiceDTO.setServiceName("测试服务器");
        configPropertyService.getPropertyByService(configServiceDTO);
    }

}
