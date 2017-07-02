 $.ajax({
    	url:"clist.htm",
    	type:"get",
    	dataType : "json",
    	success : function(data){
    		title = [];
    		content = [];
    		start = [];
    		end = [];
    		
    		$.each(data, function(index, obj){
    			title = obj.title;
    			content = obj.content;
    			start = obj.start;
    			end = obj.end;
    			
    		});
    		console.log(title);
    		console.log(content);
    		cal();
    	}
    
    
    });
    
    function cal(){
    	console.log("안녕:" +title);
		console.log("너도 안녕:" + content);
    	
	   	 $('#calendar').fullCalendar({
	     	
    		 header: {
    		      left: 'prev,next today',
    		      center: 'title',
    		      right: 'month,agendaWeek,agendaDay'
    		    },
          
            editable: true, //크기를 줄이거나 움직이는
            selectable:true,
            select: function() { 
       		 $('#myModal2').modal();
               },
            
        events: 
            {
                url : 'clist.htm'
            },
 		});
    	
    	
    }
   
    $('#specifictask_start').datepicker({
       dateFormat: "yy-mm-dd"
    });
    $('#specifictask_end').datepicker({
       dateFormat: "yy-mm-dd"
       
    });
  