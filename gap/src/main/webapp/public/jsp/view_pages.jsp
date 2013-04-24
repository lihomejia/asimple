<style>
.img_bullet {
	text-decoration: none;
}
</style>
<div>
	<input type="hidden" name="pager.start" id="pager.start" value="${pager.start}"/>
	<input type="hidden" name="pager.count" id="pager.count" value="${pager.count}"/>
	<input type="hidden" name="pager.allhits" id="pager.allhits" value="${pager.allhits}"/>
	<input type="hidden" name="pager.hits" id="pager.hits" value="${pager.hits}"/>
	<input type="hidden" name="pager.page" id="pager.page" value="${pager.page}"/>
	<input type="hidden" name="pager.pages" id="pager.pages" value="${pager.pages}"/>
	<input type="hidden" name="searcherId" id="searcherId" value="${searcherId}"/>
</div> 
<div>
	<a href="javascript:first()" class="img_bullet"><img src="<%=basePath %>public/icons/resultset_first.png" /> </a>
	<a href="javascript:prev()" class="img_bullet"><img src="<%=basePath %>public/icons/resultset_previous.png" /> </a>
	<input size=5 id="page" value="${pager.page}" onkeyup="checkPageCode(this)" style="width: 35px; vertical-align: top" />
	<a href="javascript:goPage()" class="img_bullet"><img src="<%=basePath %>public/icons/shape_square_go.png" /> </a>
	<a href="javascript:next()" class="img_bullet"><img src="<%=basePath %>public/icons/resultset_next.png" /> </a>
	<a href="javascript:last()" class="img_bullet"><img src="<%=basePath %>public/icons/resultset_last.png" /> </a>
</div>
<script language="javascript">
	function doMethod(method) {
		var form = document.getElementById('form1');
		var url = form.action || window.location.href;
		form.action = url.replace(/(\/\w+\.html)/i, "/" + method + ".html");
		form.submit();
	}

	function next(){
		goPage(Math.min(document.getElementById("pager.page").value - 0 + 1, document.getElementById("pager.pages").value));
	}
	
	function first(){
		return goPage(1);
	}
	
	function prev(){
		goPage(Math.max(1, document.getElementById("pager.page").value - 1));
		// goPage(document.getElementById("pager.page).value || 1);
	}
	
	function last(){
		goPage(document.getElementById("pager.pages").value);
	}
	
	function goPage(p) {
		if (p === undefined) p = document.getElementById("page").value;
		document.getElementById("pager.start").value = parseInt(document.getElementById("pager.count").value) * (p - 1) + 1;
		doMethod("gopage");
		return false;
	}
	
	doQuery = doSearch = function(){
		document.getElementById("pager.start").value=1;
		doMethod("search");
	}
	
	function checkPageCode(inp){
		if (!new RegExp("^\\d+$").test(inp.value)) {
			document.getElementById('page').value = document.getElementById('pager.page').value;
		}
	}
</script>