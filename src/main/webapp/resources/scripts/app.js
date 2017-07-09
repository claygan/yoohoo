/**
 * Created by linzx on 2017/7/8.
 */
var active = "local";
var api_domain, daily_test, local_test;
//配置项对应的后端接口
if (active === "product") {
    api_domain = ""; //线上API端口，待配置
} else if (active === "daily_ued") {
    api_domain = "192.168.200.161:8080";
    daily_test = true; //日常服务器的标识s
} else if (active === "daily") {
    api_domain = "192.168.200.170:8080";
    daily_test = true; //日常服务器的标识
} else if (active === "local_test") {
    api_domain = "";
    local_test = true; //使用本地json测试的标识
} else if (active === "local") {
    api_domain = "127.0.0.1:8080";
} else {
    alert("配置错误，请指定正确的运行环境");
}
var url = {
    //试听
    submit : "http://" + api_domain + '/apply/submit',
    //登录
    login_in : "http://" + api_domain + '/user/login',
    //退出
    login_out : "http://" + api_domain + '/user/login',
    //试听申请列表页
    queryApply : "http://" + api_domain + '/apply/queryApply',
    //改变已联系的状态
    changeContact : "http://" + api_domain + '/apply/updateContactStatus',
};