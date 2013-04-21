function subform(flag) {
	beforeSubmit();

	if(flag === "save") {
		document.forms[0].action=window.savepath;
		return _subform(document.forms[0], true);
	} else if(flag === "update") {
		document.forms[0].action=window.updatepath;
		return _subform(document.forms[0], true);
	} else if(flag === "delete") {
		document.forms[0].action=window.deletepath;
		return _subform(document.forms[0], true);
	}
	return true;
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

function beforeSubmit(){}