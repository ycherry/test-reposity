
function warn(view,str){
		document.getElementById(view).innerHTML=str;
}

    function checkName(){
     	var ob = document.forms["register"].elements["customerName"];
    //	var ob1 = document.forms["register"].elements["customerId"];
		var customerName=ob.value;
		var customerNamelength=customerName.length;
		 var ob2 = document.forms["register"].elements["customerPass"];
		if (customerNamelength<3) {
			
			warn("name","用户名长度小于3");
			ob.focus();		
		}		
		else {
			warn("name","ok");
		    ob2.focus();
		}
	}
	
	function checkPass(){
		var ob1 = document.forms["register"].elements["customerId"];
		var customerName=ob1.value;
		var customerNamelength=customerName.length;
	    var ob2 = document.forms["register"].elements["customerPass"];
		var customerPassword=ob2.value;
		var customerPasswordlength=customerPassword.length;
		var ob3 = document.forms["register"].elements["customerPass2"];
		if (customerPasswordlength<6&&customerNamelength>=6){
		
		ob2.focus();
		warn("pass","密码长度小于6");
		}
		else if (customerPasswordlength<6){
			warn("pass","!");
		}
		else{
			warn("pass","ok");
			ob3.focus();
		}
	}
	
	function checkPass2(){
    	var ob2 = document.forms["register"].elements["customerPass"];
		var customerPassword=ob2.value;
		var customerPasswordlength=customerPassword.length;
    	var ob3 = document.forms["register"].elements["customerPass2"];
		var checkPassword=ob3.value;
		var checkPasswordlength=checkPassword.length;
		
		if (checkPassword!=customerPassword){
			
		ob3.focus();
			warn("pass2","两次密码不一致！");
			}else{
			 warn("pass2","ok");
			}
	}

	function checkName2(){
	    	var ob7 = document.forms["register"].elements["customerName"];
		var customerName2=ob7.value;
		var customerName2length=customerPassword.length;
		if (customerName2length==0){
			warn("name2","昵称不能为空");
			ob7.focus();
		}else{
			warn("name2","ok");
		}
	}
	function checkAge(){
		var type=/^\d+$/;
		var ob4 = document.forms["register"].elements["customerAge"];
		var age=ob4.value;
		var agelength=age.length;
		if ((agelength !=0)&&(age>150||age<=0||!type.test(age))){
			warn("age","年龄值不正确");;
		ob4.focus();	
			return false;
		}
		else if(agelength ==0)		age=0;
		else warn("age","ok");
	}

function checkEmail(){
	var mail = document.getElementById("customerEmail");
	if( 0 == mail.length ){
		warn("email","邮箱不能为空");
		mail.focus();
		return false;
	}
	var in1 = mail.value.indexOf("@");
	var in2 = mail.value.indexOf(".");
	var in3 = mail.value.indexOf(" ");
	if(in1 < 1 || in2 - in1 < 2 || in2 + 1 == mail.value.length || -1 != in3){
		warn("email","邮箱格式不正确");
		mail.focus();
		return false;
	}else{
		warn("email","ok");

	}
}

	function checkPost(){
		var type=/^\d+$/;
		var ob5 = document.forms["register"].elements["customerPost"];
		var post=ob5.value;
		var postlength=post.length;
		if ((postlength !=6)||(!type.test(post))){
			warn("post","邮编为6位数");;
			ob5.focus();
			return false;
		}
		else warn("post","ok");
	}

	function checkPhone(){
		var type=/^\d+$/;
		var ob6 = document.forms["register"].elements["customerPhone"];
		var phone=ob6.value;
		var phonelength=phone.length;
		if (!type.test(phone)&&phone.length!=0){
			warn("phone","联系方式有误");;
			ob6.focus();
			return false;
		}
		else warn("phone","ok");
	}



	function check(){
		var ob1 = document.forms["register"].elements["customerName"];
		var customerName=ob1.value;
		var customerNamelength=customerName.length;
		var ob2 = document.forms["register"].elements["customerPassword"];
		var customerPassword=ob2.value;
		var customerPasswordlength=customerPassword.length;
		var ob3 = document.forms["register"].elements["checkPassword"];
		var checkPassword=ob3.value;
		var checkPasswordlength=checkPassword.length;	
		var type=/^\d+$/;
		var ob4 = document.forms["register"].elements["age"];
		var age=ob4.value;
		var agelength=age.length;
		if ((customerPasswordlength==0||customerNamelength==0 ) ||((agelength !=0)&&(age>150||age<0||!type.test(age)))){
			alert("请将未填写的填写完整");

		}
	}



   var xmlHttp;
     
      function ajaxFunction()
 		{
 			var idField = document.getElementById("userId");
      
 		 xmlHttp = GetXmlHttpObject();
 		 if (xmlHttp==null)
		    {
		    alert ("浏览器不兼容！+1");
		    return;
		    }
  
		 xmlHttp.onreadystatechange= processFunction;
		 url="./CheckIdCtrl?customerId="+ escape(idField.value);
		 url = encodeURI(url);   
		url = encodeURI(url);

		
		 xmlHttp.open("GET",url,true);
		 xmlHttp.send(null);

     }
     
   
      function ajaxGeneralFunction(functionName,url)
 		{
 			
        
 		 xmlHttp = GetXmlHttpObject();
 		 if (xmlHttp==null)
		    {
		    alert ("浏览器不兼容！+2");
		    return;
		    }
        
		 xmlHttp.onreadystatechange= functionName;
		
		 xmlHttp.open("GET",url,true);
		 xmlHttp.send(null);

     }
     
 
     function  processFunction(){
     	if(xmlHttp.readyState==4){
		       if(xmlHttp.status==200)		      
		        {
		         document.getElementById("name").innerHTML = xmlHttp.responseText;
		        }
		      }
     }
     
	
		function GetXmlHttpObject()
		{
		  var xmlHttp=null;
		  try
		    {
		    xmlHttp=new XMLHttpRequest();
		    }
		  catch (e)
		    {
		    try
		      {
		      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		      }
		    catch (e)
		      {
		      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }
		    }
		return xmlHttp;
	  }
		
