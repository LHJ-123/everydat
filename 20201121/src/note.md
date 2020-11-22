##HTTP请求
1.首行
- 方法
- URL
- 版本号

2.协议头
每一行是一个键值对 键和值之间任然使用“冒号空格”分割

3.空行
header结束标记

4.正文


##HTTP响应
1.首行
- 版本号
- 状态码
- 状态码描述信息

2.协议头
每一行是一个键值对 键和值之间任然使用“冒号空格”分割

3.空行

4.正文

##都知道哪些HTTP方法
- GET
- POST
- PUT
- HEAD
- DELETE

##GET和POST的区别
GET一般把数据放到URL中，POST一般把数据放到body中。

##状态码
- 1XX 信息性状态码（请求正在处理）
- 2XX 成功状态码（请求处理完毕）
- 3XX 重定向状态码（需要附加操作）
- 4XX 客户端错误状态码（服务器无法处理请求）
- 5XX 服务器错误状态码（服务器处理请求出错）

##Cookie
保存在浏览器中的一个字符串，这个字符串是通过服务器返回的响应中的Set-Cookie字段中来得，后续再访问该服务器，请求中就会自动带上Cookie字段

##工厂模式
当创建一个实例的时候，如果创建过程比较复杂，此时就可以吧这个new操作封装到一个专门的静态方法中，用这个静态方法辅助进行实例化和初始化操作。
是为了填构造方法重载的坑

##Session
在服务器登录成功时，把用户信息保存到一个哈希表中（value），同时生成一个key（这个key是保证唯一性的字符串）sessionID，最终只要把sessionID写回到cookie中
就好了，后续用户访问页面时，cookie中带有的内容就是sessionID，他是个没啥规律的字符串，不涉及敏感信息，但是服务器可以通过这个sessionID找到用户相应信息。