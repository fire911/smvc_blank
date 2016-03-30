# smvc_blank
spring mvc 空项目


#ajax请求如果参数有重名 以下方式可解决
var obj={
		 "username":"1321313",
		 "password":"456466",
		 "lists":[{"id":1,"username":"222"},{"id":2,"username":"231"}]
};
var param={
	 "username":"tttt",
	  obj:JSON.stringify(obj)
};
$.ajax({
	url:"${ctx}/admin/login",
	type:"post",
	dataType:"json",
	data:param1,
	success:function(data){
		alert(data.username);
	}
});
后台以T obj=JSON.parseObject(obj, T.class); 对字符串进行转译.