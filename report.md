# Java课程期末作业报告——教务系统设计
## 项目背景介绍
我们主要针对学生这一特定人群，设计一个信息管理系统，即我们常用的教务系统。教务系统对学生来说，就是日常生活中离不开的物品，选课、查阅信息等，对我们的学习生活发挥了很大的作用。既然教务系统对我们如此重要，我们小组就利用Java技术实现一个简单的教务系统。

## 系统功能介绍
通过教务系统我们可以方便地管理我们的信息，并可以查询相应的课程信息、成绩等。通过Java的GUI设计，我们的系统具有相对人性的系统界面。
### 登录界面
我们通过应用一开始的登录界面，可以进行注册用户还有登录用户两项功能。
当然，如果登录时，出现密码错误或者用户不存在的情况，我们也会作出相应的提示。
<!-- ![Client](/screenshot/client.jpg) -->
<img style="width: 403.2px;height: 302.4px;" src="/screenshot/client.jpg"/>

### 个人信息修改
当然，完成注册以后，我们还可以根据需要重新修改我们的个人信息。
![modifyInfo](/screenshot/modifyInfo.jpg)

而且通过表格的方式呈现我们的选课信息，我们可以很方便地查询、排序、筛选过滤我们所需的信息。
![CourseTable](/screenshot/courseTable.jpg)

### 查询课程
与上面的登录密码校验不同，我们设计的教务系统实现的查询主要创新点在于，我们设计其支持模糊查询的功能，我们只需输入两三个字符，我们的课程信息表单就可以显示出对应的符合要求的课程信息。
![Filter](/screenshot/filter.jpg)

由上面的图片可知，我们所设计的模糊查询，只要课程中有相应的关键字，即可查询到对应的信息。

## 系统类图
![UML]()

## 关键模块说明
我们的分成源码、数据、以及外部资源和程序截图等。
data文件夹用于持久化存储数据，使用了文件存储技术。
![structure](/screenshot/structure.jpg)

我们的项目设计主要使用了三层架构的设计模式。即，界面层（User Interface layer）、业务逻辑层（Business Logic Layer）、数据访问层（Data access layer）。这样的设计方式旨在降低程序之间的耦合度，方便我们的修改。
![3-tierArchitecture](/screenshot/3-tierArchitecture.jpg)

### 数据层类
数据层的类有四个```Course```、```CourseDB```、```User```、```UserDB```。
通过上面的系统类图可以很清晰地看出他们之间的关系。
```User```中可以访问该用户已经选择的课程，```Course```中也可以查看选择该课程的用户。
而数据库（包含```UserDB```和```CourseDB```）存储整个系统中含有的所有用户和所有的课程。两个数据库都提供了相当多的接口，用于和逻辑层直接交互。
<!-- <img style="width: 403.2px;height: 302.4px;" src="/screenshot/CourseDB.jpg"/>
<img style="width: 403.2px;height: 302.4px;" src="/screenshot/UserDB.jpg"/> -->
![CourseDB](/screenshot/CourseDB.jpg)
![UserDB](/screenshot/UserDB.jpg)

### 界面层类
界面层类里主要有```GUI```一个主类，```UIConst```主要记下```GUI```界面所用到的相关设置。```gui```内有一个名为```panel```的包，存储我们所需要跳转的相关页面；还有一个```component```的包，存储为实现一些特定功能的而特别设计的组件。
![gui](/screenshot/gui.jpg)

### 业务逻辑层类
业务逻辑层主要实现了网络编程的相关功能。```logic```包内只有一个文件```Configuration```，它提供地址服务器的地址和端口，用于客户端和服务器之间进行沟通。
![logic](/screenshot/logic.jpg)
#### 客户端
客户端只有相应的```Client```类，主要作用为创建```socket```并进行相应的接收、处理、发送信息，与服务器进行交互，并根据服务器发来的信息调用```GUI```的方法，对```GUI```进行调整。
![UMLClient]()
#### 服务器端
```server```包下有三个类：
1. ```Server```类：用于运行服务器。新建客户端时，```Server```都新建一个线程```NotifyHandler```，用于监听客户端的信息。
2. ```Message```类：主要用于信息传递。
![Message](/screenshot/Message.jpg)
比较特别是，```Message```类为了实现能够传递不同类型的信息。我们将其设计为泛型设计，并通过```Vector```实现能够传递任意数量的变量。例如，要进行注册的操作，我们只需将```T```设为```String```，将用户名和密码压入```Vector```中即可传给服务器进行处理。
3. ```NotifyHandler```类：用于识别、响应处理客户端发来的请求。进行```UserDB```和```CourseDB```之间的交互。
![NotifyHandler](/screenshot/NotifyHandler.jpg)

## 知识点应用说明
1. 面向对象编程知识点（必须涉及到）：
    * 类和对象
    * 超类与继承
    * 接口及其实现
    * 异常处理
    * 多线程
    * 文件存储
    * 网络编程
2. 扩展知识点（鼓励挑战）：
    * Java 图形界面
    * Java JDBC
    * Java 设计模式
    * 其它