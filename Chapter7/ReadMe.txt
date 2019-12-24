java -jar moco-runner-1.0.0-standalone.jar http -p 8888 -c SetUp.json   // 开启端口 并注册接口json文件


// 问题: 添加信息头管理器之后 如过post传值用json 传值 如果里边含有中文 结果返回400  如果换成英文则可以成功
// 没有添加信息头管理器之前可以穿中文