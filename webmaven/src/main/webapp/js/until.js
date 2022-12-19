// 获取指定名称的cookie
function  getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');//拆分cookie字符串
    for(var i=0; i<ca.length; i++)
    {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) return c.substring(name.length,c.length);
    }
    return "";
}

// 打印所有cookie
function print() {
    var strcookie = document.cookie;//获取cookie字符串
    var arrcookie = strcookie.split(";");//分割
    var cookies="";
    //遍历匹配
    for (var i = 0; i < arrcookie.length; i++) {
        var arr = arrcookie[i].split("=");
        cookies+=arr[0] + ":" + arr[1];
    }
    alert(cookies)
}