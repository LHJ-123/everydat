##常用xml配置文件
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">


</beans>
```
##自动装配的xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">
    <context:annotation-config/>
    <!--注解支持-->


</beans>
```
##注解说明
- @Autowired :自动装配通过类型,类型找不到通过名字找
如果Autowired不能唯一自动装配上属性，则需要通过@Qualifier(value="x")
- @Nullable:字段标记了这个注解，说明这个字段可以为null;
- @Resource:自动装配通过名字找，名字找不到通过类型找
- @Component :组件，放在类上，相当于这个类被spring管理了，就是bean
 @Value：可以为类中的相关属性输入值
- 衍生的注解:
@Component有几个衍生注解，我们在web开发中，会按照mvc三层架构分层!
controller--@Controller
dao--@Repository
service--@Service
这四个注解功能都是一样的，都是代表将某个类注册到Spring中，装配Bean
- @Scope :作用域注解，设置为单例，原型等等。

- @Configuration:代表这是一个配置类，和之前beans.xml作用是一样的
- @Bean：相当于beans.xml中的bean对象相关配置,它下面方法的名字就相当于原来的
id，方法返回值就是class属性
- @Import：将两个配置类弄为一个整体

##代理模式
是springAOP底层

模式分类：
- 静态代理
角色分析：
1.抽象角色：一般会使用接口或者抽象类来解决
2.真实角色：被代理的角色
3.代理角色：代理真实的角色，代理后，我们一般会做一些附属操作
4.客户：访问代理对象的人

代理模式好处：
1.可以使真实角色操作更加纯粹，不用去关注一些公共业务
2.公共业务交给了代理角色，实现了业务分工
3.公共业务发生扩展的时候，方便集中管理

缺点：
一个真实角色产生一个代理角色，代码量翻倍，效率变低

- 动态代理
