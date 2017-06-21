package kr.co.nextdoor.schedule.dao;

import kr.co.nextdoor.specifictask.dto.SpecificTaskDTO;
import kr.co.nextdoor.specifictask.dto.SpecificTaskModiDTO;

public interface FullcalendarDAO {
        /*
        * @method Name : insertFullcalendarTask
        * @date : 2017. 06.18
        * @author : 최성용
        * @description : 캘린더 업무생성
        * @return : int
        */
        public int insertFullcalendarSpecificTask(SpecificTaskDTO specifictaskdto)throws Exception;
        
            /*
            * @method Name : insertFullcalendarTask
            * @date : 2017. 06.18
            * @author : 최성용
            * @description : 캘린더 세부업무생성
            * @return : int
            */
        public int insertFullcalendarSpecificModiTask(SpecificTaskModiDTO specificmoditaskdto );
        /*
         * @method Name : fullcalendarProjectList
         * @date : 2017. 06.18
         * @author : 최성용
         * @description : 캘린더 업무 리스트
         * @return : ArrayList
         */
        
      
}
