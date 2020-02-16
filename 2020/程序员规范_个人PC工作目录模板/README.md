## 程序员规范 | 个人PC工作目录模板

### 概述

分享一套个人PC上的工作目录结构，主要是因为看到很多小伙伴还有团队内部开发人员的个人工作目录略显混乱，经常找个软件或找个代码之类的，点点点就是找不到。看的人捉急。

![](http://tva1.sinaimg.cn/large/006dLZAxly1gavxh88habj30mz0ec7qk.jpg)

一套目录能解决问题吗 ？并不能，其实我想表达的是你应该需要一套自己的逻辑和习惯来降低记忆负担，提高效率，如果暂时没有，希望我分享的能给你一点帮助。

### 目录分类

```
├─dev             // 个人开发目录
├─enterprise      // 企业开发目录
├─enterprise_name // 某个企业开发目录
├─public          // 公共目录
```

整体分为个人开发、企业开发、具体企业开发、公共四个目录。

为什么分企业与个人开发目录，考虑部分开发者的工作电脑与个人电脑是一个。

为什么又分企业开发与某个企业开发目录，考虑你会跳槽换工作到不同的企业。

#### dev

个人开发目录

```
├─dev_install    // 各种软件开发工具安装目录（非服务类）
├─dev_package    // 各种软件开发工具安装包
├─dev_project    // 项目代码目录
├─dev_server	 // 各种服务类安装目录，如Tomcat、nginx、mysql等
└─dev_workspace  // 工作空间目录
└─dev_xxx        // 按需自由扩展
```

#### enterprise

企业开发目录

```
├─enterprise_install    // 各种软件开发工具安装目录（非服务类）
├─enterprise_package    // 各种软件开发工具安装包
├─enterprise_project    // 项目代码目录
├─enterprise_server	    // 各种服务类安装目录，如Tomcat、nginx、mysql等
└─enterprise_workspace  // 工作空间目录
└─enterprise_xxx        // 按需自由扩展
```

其实与上面 dev 是一样的，仅目录前半部分 dev 换成了 enterprise 。

为什么dev 或 enterprise 分类子目录上还要加 dev_xx 或者 enterprise_xxx 这个前缀，考虑如果你嫌目录深，可以去掉分类那一层，直接平铺开放。

#### enterprise_name

同 enterprise

#### public

公共目录

```
├─public_install    // 各种非开发类软件安装，如QQ、微信等
├─public_package    // 各种非开发类软件安装包
├─public_xxx        // 按需自由扩展
```



最后说一点，如果你盘不够大，可以分多个盘放，目录还是这个目录。

还有一点，公司如果有规范，那就遵循公司规范。



> 风象南出品

