<div align="center">
 
 # 赣军密培训管理系统（后端服务）
 
 基于 Spring Boot 2.7 + MyBatis 的培训管理后端服务，提供微信授权登录、JWT 认证、培训报名、证书管理、发票管理等完整业务流程，支持 RESTful API 接口。
 
 ![Java](https://img.shields.io/badge/Java-8-orange.svg)
 ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.3-brightgreen.svg)
 ![MySQL](https://img.shields.io/badge/MySQL-8.0-orange.svg)
 
 App：[GanJunMi-App](https://github.com/XieYifan1201/GanJunMi-App)
 后台管理系统：[GanJunMi-Admin](https://github.com/XieYifan1201/GanJunMi-Admin)
 
</div>

---

## 📋 项目简介

赣军密培训管理系统后端服务是一个基于 Spring Boot 框架开发的企业级培训管理平台，主要面向军事保密培训场景，提供完整的培训业务流程支持。

### 核心功能

- 用户认证：微信授权登录 + JWT Token 认证 + 管理员账号密码登录
- 培训管理：培训班次管理、期次管理、报名信息管理
- 证书管理：证书生成、扫码查询、证书发放、特殊证书定制
- 发票管理：发票申请、审核、管理、公司信息自动填充
- 文章管理：微信公众号文章素材管理、草稿管理、发布管理
- 文件存储：本地文件存储 + 阿里云 OSS 文件上传
- 二维码生成：证书二维码自动生成与扫码验证
- 定时任务：微信 Access Token 自动刷新
- 数据统计：学员统计、报名统计、缴费状态管理

---

## 🛠️ 技术栈

### 后端框架
- **Spring Boot 2.7.3** - 核心框架
- **MyBatis** - 持久层框架
- **Spring MVC** - Web 框架
- **Spring Scheduling** - 定时任务

### 数据库与缓存
- **MySQL** - 关系型数据库
- **Druid** - 数据库连接池
- **Redis** - 缓存支持
- **PageHelper** - 分页插件

### 安全与认证
- **JWT (jjwt 0.9.1)** - Token 认证
- **微信 JS-SDK** - 微信公众号集成
- **MD5 加密** - 密码加密存储

### 工具库
- **Lombok** - 简化代码
- **Jackson** - JSON 序列化
- **FastJSON** - JSON 处理
- **Apache HttpClient** - HTTP 请求
- **阿里云 OSS SDK** - 文件存储
- **Knife4j** - API 文档
- **AspectJ** - AOP 编程
- **Hutool** - 二维码生成等工具

---

## 📦 项目结构

```
train/
├── train-common/              # 公共模块
│   └── src/main/java/com/train/
│       ├── cache/            # 缓存组件（微信Token缓存）
│       ├── constant/         # 常量定义（JWT常量、消息常量）
│       ├── context/          # 上下文工具（用户ID上下文）
│       ├── exception/        # 异常类（自定义异常）
│       ├── json/             # JSON 配置（Jackson自定义序列化）
│       ├── properties/       # 配置属性（JWT、微信配置）
│       ├── result/           # 统一返回结果
│       └── utils/            # 工具类（JWT、HTTP、OSS）
│
├── train-pojo/               # 实体类模块
│   └── src/main/java/com/train/
│       ├── dto/              # 数据传输对象（30+）
│       ├── entity/           # 数据库实体（7个核心实体）
│       └── vo/               # 视图对象（13个VO）
│
└── train-server/             # 服务模块
    └── src/main/java/com/train/
        ├── config/           # 配置类（WebMvc、跨域、拦截器）
        ├── controller/       # 控制器（8个Controller）
        ├── handler/          # 异常处理器
        ├── interceptor/      # JWT Token拦截器
        ├── mapper/           # MyBatis Mapper（8个Mapper）
        ├── service/          # 业务逻辑层（8个Service及实现）
        └── task/             # 定时任务（微信Token刷新）
```

---

## 🚀 快速开始

### 环境要求

- JDK 8+
- Maven 3.6+
- MySQL 8.0+
- Redis
- 微信公众号（用于授权登录）

### 安装步骤

1. **克隆项目**
```bash
git clone https://github.com/XieYifan1201/GanJunMi-Server.git
cd GanJunMi-Server
```

2. **配置数据库**

创建 MySQL 数据库，并导入数据库脚本（如有）

3. **修改配置文件**

编辑 `train-server/src/main/resources/application-dev.yml`：

```yaml
train:
  datasource:
    host: localhost
    port: 3306
    database: your_database
    username: your_username
    password: your_password
  redis:
    host: localhost
    port: 6379
    database: 0
  wechat:
    appid: your_wechat_appid
    secret: your_wechat_secret
```

4. **构建项目**
```bash
mvn clean install
```

5. **启动服务**
```bash
cd train-server
mvn spring-boot:run
```

6. **访问 API 文档**

启动后访问：`http://localhost:8080/doc.html`

---

## 📝 API 接口说明

### 用户模块 `/api/user`
- `POST /login` - 用户登录（支持微信授权和账号密码）
- `GET /getById` - 获取当前用户信息
- `PUT /update` - 修改用户信息
- `GET /addImage` - 用户证件照上传
- `POST /addAdmin` - 新增管理员账号（系统管理员）
- `GET /resetPwd` - 重置管理员密码（系统管理员）
- `GET /editPwd` - 修改自己的密码
- `GET /delete` - 删除管理员账号（系统管理员）
- `POST /page1` - 分页查询用户列表
- `PUT /editAuthority` - 修改用户权限（系统管理员）

### 学员模块 `/api/student`
- `POST /sign` - 学员报名
- `POST /SAUpdateSign` - 管理员添加/修改学员报名信息
- `POST /add` - 添加学员信息
- `POST /signInfo` - 学员获取自己的报名信息
- `GET /getById` - 根据ID获取学员信息
- `POST /update` - 修改学员信息
- `GET /delete` - 删除学员信息
- `POST /getByBatch` - 分页查询学员信息
- `POST /getByBatch1` - 分页查询学员信息（包含发票信息）
- `POST /getByBatch2` - 分页查询学员信息（包含班次信息）
- `POST /issueCertificate` - 给学员颁发证书
- `POST /getCertificate` - 获取学员证书信息
- `GET /cancelSign` - 撤销报名
- `GET /getCount` - 获取学员的报名次数
- `POST /updatePayStatus` - 修改学员缴费状态
- `POST /addCertificateContent` - 添加/修改特殊证书内容
- `GET /getAllApplyInfo` - 获取当前账号的所有报名信息

### 证书模块 `/api/certificate`
- `GET /getByNumber` - 通过证书编号查询证书信息（公开接口）

### 培训班次模块 `/api/classes`
- `POST /add` - 添加培训期次信息
- `POST /addClasses` - 给期次添加班次信息
- `GET /delete` - 删除培训期次信息
- `GET /deleteByTrainsClassId` - 删除班次信息
- `POST /update` - 修改培训期次信息
- `POST /updateClasses` - 修改班次信息
- `POST /getInfo` - 分页查询期次信息
- `GET /getByTrainsId` - 根据期次ID获取班次信息
- `GET /setStart` - 开启/关闭报名
- `POST /setCertificate` - 添加/修改证书信息
- `GET /getCertificate` - 获取证书信息
- `POST /getStudents` - 获取报名班次的学员信息
- `GET /getClassCount` - 获取报名班级总人数
- `GET /cancelSign` - 管理员取消学员报名
- `POST /getClassInfos` - 分页获取班次信息

### 发票模块 `/api/invoice`
- `POST /saveInvoice` - 保存开票信息
- `GET /deleteInvoice` - 删除开票信息
- `POST /updateInvoice` - 修改开票信息
- `GET /getInvoiceById` - 根据ID获取开票信息
- `POST /addOrUpdateInvoice` - 添加或修改开票信息
- `GET /getInvoiceByStudentId` - 根据学员ID获取开票信息
- `GET /getInvoiceByIdCard` - 根据身份证获取开票信息
- `GET /getCompanyInfo` - 根据发票抬头查询公司发票信息

### 文章模块 `/api/article`
- `POST /uploadimg` - 上传图文消息内的图片获取URL
- `POST /add` - 新建草稿
- `POST /get` - 获取草稿
- `POST /delete` - 删除草稿
- `POST /update` - 修改草稿
- `POST /batchget` - 获取草稿列表
- `POST /submit` - 发布文章
- `POST /getState` - 发布状态轮询
- `POST /delArticle` - 删除发布
- `POST /getarticle` - 通过article_id获取已发布文章
- `POST /getArticleBatch` - 获取成功发布列表

### 授权模块
- `POST /getWxConfig` - 获取jsapi_ticket签名
- `GET /refresh/jsapi_ticket` - 重新获取access_token和jsapi_ticket

### 通用模块
- `POST /api/upload` - 文件上传（图片）
- `GET /files/{filename}` - 获取图片文件
- `POST /api/uploadReceipt` - 上传回执单
- `GET /files/receipt/{filename}` - 获取回执单文件
- `POST /api/uploadEmpty` - 上传回执单空表
- `GET /getEmptyPath` - 获取空表路径
- `GET /getList` - 获取公众号成功发布列表

---

## 🔧 核心配置

### JWT 认证配置

```yaml
train:
  jwt:
    secretKey: anjunmi              # JWT 签名密钥
    ttl: 2592000000                 # Token 有效期（30天）
    tokenName: token                # Token 在请求头中的名称
```

### 微信公众号配置

```yaml
train:
  wechat:
    appid: ${WECHAT_APPID}          # 微信公众号 AppID
    secret: ${WECHAT_SECRET}        # 微信公众号 AppSecret
```

### 文件存储配置

```yaml
web:
  upload-path: D:/image/            # 图片保存路径
  qrcode-path: D:/image/qrcode/     # 二维码保存路径
  receipt-path: D:/image/receipt/   # 回执单保存路径
```

### 拦截器配置

系统使用 JWT Token 拦截器，对 `/api/**` 路径进行拦截认证，但排除以下公开接口：
- `/api/user/login` - 用户登录
- `/api/certificate/getByNumber` - 证书查询

---

## 📊 数据库设计

### 核心表结构

- `user` - 用户表（学员、管理员、系统管理员）
- `student` - 学员信息表
- `trains_class` - 培训班次表
- `trains_info` - 培训期次信息表
- `certificate` - 证书模板表
- `student_certificate` - 学员报名记录表
- `invoice_info` - 发票信息表

---

## 🔒 安全说明

- JWT Token 采用 HS256 算法签名，有效期30天
- 管理员密码采用 MD5 加密存储
- 接口访问权限控制（JWT拦截器）
- SQL 注入防护（MyBatis 参数化查询）
- 跨域配置（CORS 全局配置）
- 文件上传大小限制（图片5MB，回执单10MB）
- 文件类型校验（仅允许图片和PDF）
