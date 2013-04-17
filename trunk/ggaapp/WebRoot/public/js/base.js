JGAP = {
	on : function(obj, ev, fn, bol) {
		if (obj.attachEvent) {
			obj.attachEvent("on" + ev, fn);
		} else {
			obj.addEventListener(ev, fn, bol || false);
		}
	}
}
JGAP.userDf = 'Y-m-d';



$A = Array.from = function(iterable) {
	if (!iterable) {
		return [];
	}
	if (iterable.toArray) {
		return iterable.toArray();
	} else {
		var results = [];
		for (var i = 0; i < iterable.length; i++) {
			results.push(iterable[i]);
		}
		return results;
	}
};
if (!window.$) window.$ = function() {
	var elements = new Array();
	for (var i = 0; i < arguments.length; i++) {
		var element = arguments[i];
		if (typeof element == "string") {
			element = document.getElementById(element);
		}
		if (arguments.length == 1) {
			return element;
		}
		elements.push(element);
	}
	return elements;
}