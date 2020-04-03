$('#startDate').datepicker();
$('#endDate').datepicker();
$('#btn').click(function() {
  alert($('#endDate').datepicker('getDate'));
});