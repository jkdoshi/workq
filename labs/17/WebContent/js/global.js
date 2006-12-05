// put your global javascript functions here!
function hilite(elem) {
	elem.oldClassName = elem.className;
	elem.className = 'hilite';
}

function unhilite(elem) {
	elem.className = elem.oldClassName;
}
