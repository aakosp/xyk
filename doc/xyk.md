
####1.后台登录  

>Method: POST  
>Path: /login  
>参数:   id:登录id，pwd:密码MD5  
>**返回数据描述: sessionId**

```json
{
    "code": "0",
    "msg": "登录成功",
    "data": {
  		"sessionId" : "123213123"
	}
}
```

| 参数名       | 类型     | 描述        |
| --------- | ------ | --------- |
| sessionId | string | sessionId |



####2.后台用户查询  

>Method: GET  
>Path: /admin/user/page/{pagenum}  
>**返回数据描述: 用户信息** 

```json
{
    "code": "0",
    "msg": "获取成功",
    "data": {
        "page" : 1,
        "total" : 5,
        "user" : [{
            "id": 1,
            "name": "张三",
            "idCard": "410181198801015052",
            "company": "XXX责任有限公司",
            "expiry": "2018-06-10"
         },{
            "id": 1,
            "name": "张三",
            "idCard": "410181198801015052",
            "company": "XXX责任有限公司",
            "expiry": "2018-06-10"
         }]
    }
}
```

| 参数名     | 类型     | 描述   |
| ------- | ------ | ---- |
| id      | number | 用户id |
| name    | string | 用户姓名 |
| idCard  | string | 身份证号 |
| company | string | 公司名称 |
| expiry  | string | 失效时间 |



####2.1后台用户搜索  

>Method: GET  
>Path: /admin/user/search/{key}  
>**返回数据描述: 用户信息** 

```json
{
    "code": "0",
    "msg": "获取成功",
    "data": {
        "page" : 1,
        "total" : 5,
        "user" : [{
            "id": 1,
            "name": "张三",
            "idCard": "410181198801015052",
            "company": "XXX责任有限公司",
            "expiry": "2018-06-10"
         },{
            "id": 1,
            "name": "张三",
            "idCard": "410181198801015052",
            "company": "XXX责任有限公司",
            "expiry": "2018-06-10"
         }]
    }
}
```

| 参数名     | 类型     | 描述   |
| ------- | ------ | ---- |
| id      | number | 用户id |
| name    | string | 用户姓名 |
| idCard  | string | 身份证号 |
| company | string | 公司名称 |
| expiry  | string | 失效时间 |



####3.后台查询用户资料详情  

>Method: GET  
>Path: /admin/user/info/{id}  
>**返回数据描述: 用户信息详情** 
>
>PS: 
>
>​    应缴总额=个人应缴+单位应缴
>
>​    实缴总额=个人实缴+单位实缴
>
>​    个人欠款=个人应缴-个人实缴
>
>​    单位欠款=单位应缴+单位实缴

```json
{
    "code": "0",
    "msg": "获取成功",
    "data": {
        "id": 1,
        "name": "张三",
        "idCard": "410181198801015052",
        "sex": 0,
        "birthday": "1988-01-01",
        "insuranceTime": "2015-01-01",
        "company": "XXX责任有限公司",
        "companyId": "123456789012",
        "payMonthDue": 12,
        "payMonth": 12,
        "paymentSelfDue": 11223.56,
        "paymentCompanyDue": 33445.66,
        "paymentSelf": 11111.12,
        "paymentCompany": 33335.11,
        "expiry": "2018-06-10"
        "pension": [{
            "id": 1,
            "uid": 1,
            "beginDate": "2018-01",
            "month": 4,
            "paymentSelf": 333.3,
            "paymentCompany": 666.6,
            "paymentBase": 4500
           },{
            "id": 2,
            "uid": 1,
            "beginDate": "2017-05",
            "month": 7,
            "paymentSelf": 222.2,
            "paymentCompany": 444.4,
            "paymentBase": 300
           }]
    }
}
```

| 参数名               | 类型     | 描述           |
| ----------------- | ------ | ------------ |
| id                | number | 用户id         |
| name              | string | 用户姓名         |
| idCard            | string | 身份证号         |
| sex               | number | 性别:  0:女 1:男 |
| birthday          | string | 生日           |
| insuranceTime     | string | 参保时间         |
| company           | string | 公司名称         |
| companyId         | string | 公司编码         |
| payMonthDue       | number | 应缴月份         |
| payMonth          | number | 实缴月份         |
| paymentSelfDue    | number | 个人应缴         |
| paymentCompanyDue | number | 公司应缴         |
| paymentSelf       | number | 个人实缴         |
| paymentCompany    | number | 公司实缴         |
| expiry            | string | 失效时间         |
| pension           | object | 参照5.查询养老条目详情 |



####3.1.前台查询用户资料详情  

>Method: GET  
>Path: /user/info/{id}  
>**返回数据描述: 用户信息详情** 
>
>PS: 
>
>​    应缴总额=个人应缴+单位应缴
>
>​    实缴总额=个人实缴+单位实缴
>
>​    个人欠款=个人应缴-个人实缴
>
>​    单位欠款=单位应缴+单位实缴

```json
{
    "code": "0",
    "msg": "获取成功",
    "data": {
        "id": 1,
        "name": "张三",
        "idCard": "410181198801015052",
        "sex": 0,
        "birthday": "1988-01-01",
        "insuranceTime": "2015-01-01",
        "company": "XXX责任有限公司",
        "companyId": "123456789012",
        "payMonthDue": 12,
        "payMonth": 12,
        "paymentSelfDue": 11223.56,
        "paymentCompanyDue": 33445.66,
        "paymentSelf": 11111.12,
        "paymentCompany": 33335.11,
        "pension": [
           {
            "id": 1,
            "uid": 1,
            "beginDate": "2018-01",
            "month": 4,
            "paymentSelf": 333.3,
            "paymentCompany": 666.6,
            "paymentBase": 4500
           },{
            "id": 2,
            "uid": 1,
            "beginDate": "2017-05",
            "month": 7,
            "paymentSelf": 222.2,
            "paymentCompany": 444.4,
            "paymentBase": 300
           }
        ]
    }
}
```

| 参数名               | 类型     | 描述           |
| ----------------- | ------ | ------------ |
| id                | number | 用户id         |
| name              | string | 用户姓名         |
| idCard            | string | 身份证号         |
| sex               | number | 性别:  0:女 1:男 |
| birthday          | string | 生日           |
| insuranceTime     | string | 参保时间         |
| company           | string | 公司名称         |
| companyId         | string | 公司编码         |
| payMonthDue       | number | 应缴月份         |
| payMonth          | number | 实缴月份         |
| paymentSelfDue    | number | 个人应缴         |
| paymentCompanyDue | number | 公司应缴         |
| paymentSelf       | number | 个人实缴         |
| paymentCompany    | number | 公司实缴         |
| expiry            | string | 失效时间         |
| pension           | object | 参照5.查询养老条目详情 |



####4.新建/修改后台用户资料详情  

>Method: POST  
>Path: /admin/user/update  
>**返回数据描述:修改结果 ** 
>
>PS: 新建不传id

```json
{
    "code": "0",
    "msg": "获取成功",
    "data": null
}
```

| 传参名               | 类型     | 描述           |
| ----------------- | ------ | ------------ |
| id                | number | 用户id         |
| name              | string | 用户姓名         |
| idCard            | string | 身份证号         |
| sex               | number | 性别:  0:女 1:男 |
| birthday          | string | 生日           |
| insuranceTime     | string | 参保时间         |
| company           | string | 公司名称         |
| companyId         | string | 公司编码         |
| payMonthDue       | number | 应缴月份         |
| payMonth          | number | 实缴月份         |
| paymentSelfDue    | number | 个人应缴         |
| paymentCompanyDue | number | 公司应缴         |
| arrearsSelf       | number | 个人欠款         |
| arrearsCompany    | number | 公司欠款         |
| paymentSelf       | number | 个人实缴         |
| paymentCompany    | number | 公司实缴         |
| expiry            | string | 失效时间         |



####5.删除用户  

>Method: GET  
>Path: /admin/user/delete/{id}  
>**返回数据描述:修改结果 ** 

```json
{
    "code": "0",
    "msg": "获取成功",
    "data": null
}
```



####6.查询养老条目详情  

>Method: GET  
>Path: /admin/user/pension/{id}  
>**返回数据描述:养老条目 ** 
>
>PS: 缴费合计=个人缴费+单位缴费

```json
{
    "code": "0",
    "msg": "获取成功",
    "data": [
          {
            "id": 1,
            "uid": 1,
            "beginDate": "2018-01",
            "month": 4,
            "paymentSelf": 333.3,
            "paymentCompany": 666.6,
            "paymentBase": 4500
        },{
            "id": 2,
            "uid": 1,
            "beginDate": "2017-05",
            "month": 7,
            "paymentSelf": 222.2,
            "paymentCompany": 444.4,
            "paymentBase": 300
        }
   ]
}
```

| 参数名            | 类型     | 描述                 |
| -------------- | ------ | ------------------ |
| id             | number | 条目id               |
| uid            | number | 用户id               |
| beginDate      | string | 条目起始时间             |
| month          | number | 几个月，根据次数循环生成相应条数条目 |
| paymentSelf    | number | 个人缴费               |
| paymentCompany | number | 单位缴费               |
| paymentBase    | number | 缴费基数               |



####7.创建/修改养老条目详情  

>Method: GET  
>Path: /admin/user/pension/{id}  
>**返回数据描述:养老条目 ** 
>
>PS: 缴费合计=个人缴费+单位缴费  
>新建不传id  
>一条数据生成的具体条目数=month条，起始时间为beginDate  
>也可以考虑用beginDate，endDate的形式，你考虑下怎么处理合适

```json
{
    "code": "0",
    "msg": "获取成功",
    "data": null
}
```

| 参数名            | 类型     | 描述                 |
| -------------- | ------ | ------------------ |
| id             | number | 条目id               |
| uid            | number | 用户id               |
| beginDate      | string | 条目起始时间             |
| month          | number | 几个月，根据次数循环生成相应条数条目 |
| paymentSelf    | number | 个人缴费               |
| paymentCompany | number | 单位缴费               |
| paymentBase    | number | 缴费基数               |



###code值说明  

| code值 | 描述        |
| ----- | --------- |
| 0     | 成功        |
| 1     | 失败        |
| 2     | 数据无效      |
| 999   | session失效 |
| 9999  | 未知异常      |