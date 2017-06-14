var Script = function () {


    /* initialize the external events
     -----------------------------------------------------------------*/

    $('#external-events div.external-event').each(function() {

        // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
        // it doesn't need to have a start or end
        var eventObject = {
            title: $.trim($(this).text()) // use the element's text as the event title
        };

        // store the Event Object in the DOM element so we can get to it later
        $(this).data('eventObject', eventObject);

        // make the event draggable using jQuery UI
        $(this).draggable({
            zIndex: 999,
            revert: true,      // will cause the event to go back to its
            revertDuration: 0  //  original position after the drag
        });

    });


    /* initialize the calendar
     -----------------------------------------------------------------*/

    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();

    calendar = $('#calendar').fullCalendar({
    	dayClick: function() {
    		 $('#myModal2').modal();
        },
        /* editable: true,*/
        /*droppable: true, */// this allows things to be dropped onto the calendar !!!
        /*drop: function(date, allDay) { // this function is called when something is dropped

            // retrieve the dropped element's stored Event Object
            var originalEventObject = $(this).data('eventObject');

            // we need to copy it, so that multiple events don't have a reference to the same object
            var copiedEventObject = $.extend({}, originalEventObject);

            // assign it the date that was reported
            copiedEventObject.start = date;
            copiedEventObject.allDay = allDay;

            // render the event on the calendar
            // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
            $('#calendar').fullCalendar('renderEvent', copiedEventObject, true);

            // is the "remove after drop" checkbox checked?
            if ($('#drop-remove').is(':checked')) {
                // if so, remove the element from the "Draggable Events" list
                $(this).remove();
            }

        },*/
       
        /*events: [
            {
                title: 'My Event',
                start: '2017-06-12',
                url: 'http://google.com/'
            }
            // other events here
        ],
        eventClick: function(event) {
            if (event.url) {
                window.open(event.url);
                return false;
            }
        },*/
       /* eventClick: function(calEvent, jsEvent, view) {
           $("#myModal").dialog('open')*/
            /*alert('Event: ' + calEvent.title);
            alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
            alert('View: ' + view.name);

            // change the border color just for fun
            $(this).css('color', 'red');*/

       /* },*/
      header: {
         left: "prev,next today",
         center: "title",
         right: 'month,agendaWeek,agendaDay'
         },
         titleFormat: {
         month: "yyyy년 MMMM",
         week: "[yyyy] MMM d일{ [yyyy] MMM d일}",
         day: "yyyy년 MMM d일 dddd"
         },
         allDayDefault: true,
         defaultView: "month",
         editable: false,
         weekends : false,
         monthNames: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
         monthNamesShort: ["1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"],
         dayNames: ["일요일","월요일","화요일","수요일","목요일","금요일","토요일"],
         dayNamesShort: ["일","월","화","수","목","금","토"],
         buttonText: {
         today : "오늘",
         month : "월별",
         week : "주별",
         day : "일별"
         },
         selectable:true
         /*,
         select : function(event, jsEvent, view){
            $('#myModal2').modal();
         }*/
           


            
    });
   /*$('#myModal2').dialog({
        autoOpen:false,
           modal : true,
          draggable : true, //창 드래그 못하게
          resizable : false, //창 크기 고정
          height : 350,
          width : 550,  
         
     });*/
   /*
   $('#deletemodalclose').click(function(){
       $('#myModalDelete').dialog('close'); 
      
   });
   $('#insertmodalclose').click(function(){
       $('#myModal').dialog('close'); 
      
   });*/
   $('#start').datepicker({
       dateFormat: "yy-mm-dd"
    });
    $('#end').datepicker({
       dateFormat: "yy-mm-dd"
       
    });
   


}();