

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

    	 $('#calendar').fullCalendar({
    		
    		/*events: function(start, end, callback) {
    			$.ajax({
    			    url: 'calendar.htm',
    			    type:  "post",
    			    dataType: 'json',
    			    success: function(data) {
    			    	specifictask_cont =[];
    			    	specifictask_start = [];
    			    	specifictask_end = [];
    			    	$.each(data, function(index,obj){
    			    		specifictask_cont = obj.specifictask_cont
    			    		specifictask_start = obj.specifictask_start
    			    		specifictask_end = obj.specifictask_end
    			    	});
    			    	console.log(specifictask_cont);
    			    	console.log(specifictask_start);
    			    	console.log(specifictask_end);
    			    	
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
            
           /* select : function(event, jsEvent, view){
               $('#myModal2').modal();
            },*/
            dayClick: function() { //날짜를 클릭하면 모달창이
    		 $('#myModal2').modal();
            },
            editable: true, //크기를 줄이거나 움직이는
            selectable:true
            , //달력을 누르면 파란표시되는
            
        events: 
            {
                url : 'clist.htm'
            }  
        
        
       /* eventClick: function(calEvent, jsEvent, view) {
            
            alert('Event: ' + calEvent.title);
            alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
            alert('View: ' + view.name);

            $(this).css('color', 'red');
        }*/
 		});
   
    $('#specifictask_start').datepicker({
       dateFormat: "yy-mm-dd"
    });
    $('#specifictask_end').datepicker({
       dateFormat: "yy-mm-dd"
       
    });
    
/*  $.ajax({
    		url :  "clist.htm",
    		type:  "POST",
    		dataType: "json",
    		success: function(data) {
    			console.log(data);
    			alert("success");
    			var  title = ""; 
    			var start = ""; 
    			var end = ""; 
    			$.each(data, function(index, obj) {
                    title = obj.member_id;
                    start = obj.specifictask_start;
                    end = obj.specifictask_edn;
                   
                  });
    			 console.log(title);
                 console.log(start);
                 console.log(end);
		    	
		    }
    });*/