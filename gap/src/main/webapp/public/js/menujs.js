// JavaScript Document

function changeBgColor(id,obj){
    var len=document.getElementById(id).childNodes.length;
	 for(var i=0;i<len;i++){
	      document.getElementById(id).childNodes[i].className="none";
	 }
     obj.className="liang";
}

function zhedie(x,y)
{
     
	 var ulArrLen = document.getElementsByTagName('ul').length;

	 var len123=document.getElementById(x).childNodes.length;
	    for(var i=0;i<len123;i++){	
			    document.getElementById(x).childNodes[i].className="none";
	    }


	if(document.getElementById(x))
	{

	  if(document.getElementById(x).style.display!="block")
	  {
		  document.getElementById(x).style.display="block";
		  y.className="shiyunlei2a";
	  
	  }
	  else
	  {
		  document.getElementById(x).style.display="none";
		  y.className="shiyunlei2";
	  }
	  
	  for(i=1;i<=ulArrLen;i++)
	  {
		  
		  if(document.getElementById("shiyunul"+i))
		  {
		  if(document.getElementById("shiyunul"+i).style.display!="none"&&"shiyunul"+i!=x)
	  {
		  document.getElementById("shiyunul"+i).style.display="none";
		  document.getElementById("menudiv"+i).className="shiyunlei2";
	  }
		  }
		  else
		  {
			 document.getElementById("menudiv"+i).className="shiyunlei2b"; 
		  }
		  
	  }
	}
	else
	{
		for(i=1;i<=ulArrLen;i++)
	  {
		  if(document.getElementById("shiyunul"+i))
		  {
		  if(document.getElementById("shiyunul"+i).style.display!="none"&&"shiyunul"+i!=x)
	  {
		  document.getElementById("shiyunul"+i).style.display="none";
		  document.getElementById("menudiv"+i).className="shiyunlei2";
	  }
		  }
		  else
		  {
			 document.getElementById("menudiv"+i).className="shiyunlei2b"; 
		  }
	  }
	  
	  y.className="shiyunlei2b0";
		
	}
}

function zhedie2()
{
	
	if(document.getElementById("zuoce").style.display=="none"||document.getElementById("zuoce").style.display=="")
	{
		document.getElementById("zuoce").style.display="block";
		document.getElementById("youce").style.width="800px";
		
		document.getElementById("menunr_1").style.width="190px";
		document.getElementById("zuoce0").style.width="190px";
		document.getElementById("jiantoutu").src="../../images/icon_slide.gif";
		
		
	}
	else
	{
		document.getElementById("zuoce").style.display="none";
		document.getElementById("youce").style.width="985px";

		
		
		document.getElementById("zuoce0").style.width="6px";
		document.getElementById("menunr_1").style.width="0";
		
		

		document.getElementById("jiantoutu").src="../../images/icon_slide_a.gif";
		
	}
	
}