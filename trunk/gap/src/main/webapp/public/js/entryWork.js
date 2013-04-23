function subform(flag) {
	if (!beforeSubmit()) return false;
	document.forms[0].action=window.actionPath + flag + '.html';
	return _subform(document.forms[0], true);
}

function _subform(form, validation){
	if (validation)
		if (typeof(form._onsubmit) == "function" && !form._onsubmit() || 
			typeof(form.onsubmit) == "function" && !form.onsubmit()
		)
		return false;	
	form.onsubmit = function(){return true};
	form.submit();
}

function beforeSubmit(){return true;}

function goBack() {
	location.replace(document.referrer);
}