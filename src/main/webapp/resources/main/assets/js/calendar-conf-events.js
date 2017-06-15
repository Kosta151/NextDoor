var Script = function () {


    /* initialize the external events
     -----------------------------------------------------------------*/

  /*  $('#external-events div.external-event').each(function() {

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

    });*/


    /* initialize the calendar
     -----------------------------------------------------------------*/

    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();

    	calendar = $('#calendar').fullCalendar({
    	
    		/*events: function(start, end, callback) {
    			$.ajax({
    			    url: '/myfeed.json',
    			    dataType: 'json',
    			    success: function(data, text, request) {
    			    	var events = eval(data.jsonTxt);
    			        callback(events);
    			    }
    			});
    		},*/
    	
    	//캘린더 한글 적용
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
            day : "일별"},
            
            select : function(event, jsEvent, view){
               $('#myModal2').modal();
            },
            /*dayClick: function() { //날짜를 클릭하면 모달창이
    		 $('#myModal2').modal();
            },*/
            editable: true, //크기를 줄이거나 움직이는
            selectable:true, //달력을 누르면 파란표시되는
        /* droppable: true,*/ 
        /// this allows things to be dropped onto the calendar !!!
        
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
       
        events: [
            {
                title: '프로젝트명',
                start: '2017-06-12',
                end: '2017-06-22',
                url: 'http:projectList.htm'
            }
            // other events here
        ],
        
       /* eventClick: function(calEvent, jsEvent, view) {
            
            alert('Event: ' + calEvent.title);
            alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
            alert('View: ' + view.name);

            $(this).css('color', 'red');
        }*/
 		});
   
   /*
   $('#deletemodalclose').click(function(){
       $('#myModalDelete').dialog('close'); 
      
   });
   $('#insertmodalclose').click(function(){
       $('#myModal').dialog('close'); 
      
   });*/
   
        
   /* 
    $('#start').datepicker({
       dateFormat: "yy-mm-dd"
    });
    $('#end').datepicker({
       dateFormat: "yy-mm-dd"
       
    });
    */
   


}();