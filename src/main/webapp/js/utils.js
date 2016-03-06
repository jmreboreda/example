$(document).ready(function(){
	console.log("Ready!");
	init();
});

function init() {
	$("#personsPattern").on("keyup change", function(){
		$("#searchPersonsForm").submit();
	});
};