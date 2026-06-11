$(document).ready(function() {
$('[data-toggle="toggle"]').change(function() {
$(this).parents().next('.hidden-row').toggle();
var label = $(this).parent('td').find('label');
var text = label.text();
if (text == '+') { text = '-' }
else { text = '+' }
label.text(text);
});
});
