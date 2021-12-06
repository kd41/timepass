 //Visit date picker
$( "#visit_datepicker" ).datepicker({
dateFormat: 'dd.mm.yy',
minDate:0,
maxDate:60
});

  //Visit time picker
 $('#visit_timepicker').timepicker(
 {timeFormat : 'HH:mm',
  minTime: '8:00am',
  maxTime: '7:00pm'}
 );

//Visits search bar by keyword
 $(document).ready(function(){
   $("#visit-search-input").on("keyup", function() {
     var value = $(this).val().toLowerCase();
     $("#visits-table-body tr").filter(function() {
       $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
     });
   });
 });
