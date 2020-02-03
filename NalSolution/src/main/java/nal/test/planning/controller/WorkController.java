package nal.test.planning.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nal.test.planning.common.Common;
import nal.test.planning.constant.Constant.CodeResponse;
import nal.test.planning.constant.Constant.FormatDate;
import nal.test.planning.constant.Constant.MessageCommon;
import nal.test.planning.dto.JsonResponseDto;
import nal.test.planning.dto.JsonResponsePagingDto;
import nal.test.planning.dto.MetaPaging;
import nal.test.planning.enity.Work;
import nal.test.planning.service.WorkService;

/**
 * Controller of work
 * @author TuanNH
 */
@RestController
@RequestMapping("/work")
public class WorkController {

    /**
     * Injects workService
     */
    @Autowired
    WorkService workService;

    /**
     * Get list work and paging
     * @param pageNum page number current
     * @param limit limit page
     * @return ResponseEntity result list
     */
    @RequestMapping(value = "/get-list", method = RequestMethod.GET)
    public ResponseEntity<Object> getListWork(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "limit", defaultValue = "20") int limit){
        JsonResponsePagingDto jsonResponseDto = new JsonResponsePagingDto();

        // get list work from service
        List<Work> listWork= workService.getListWork(pageNum, limit);

        // return result
        jsonResponseDto.setCode(CodeResponse.OK);
        jsonResponseDto.setMessage(MessageCommon.SUCCESS);
        jsonResponseDto.setData(listWork);

        // set info of paging
        MetaPaging metaPaging = new MetaPaging();
        metaPaging.setPageNum(pageNum);
        metaPaging.setLimit(limit);
        metaPaging.setTotalShow(listWork.size());
        metaPaging.setTotalRecords(workService.countAllWork());

        jsonResponseDto.setMetaPaging(metaPaging);

        return new ResponseEntity<Object>(jsonResponseDto, HttpStatus.OK);
    }

    /**
     * Insert a new work
     * @param workJson object of work
     * @return ResponseEntity result after execute add
     */
    @RequestMapping(value = "/add-work", method = RequestMethod.POST)
    public ResponseEntity<Object> addWork(@RequestBody Work  workJson){
        JsonResponseDto jsonResponseDto = new JsonResponseDto();

        // get work from to check exists
        Work work = workService.getWork(workJson.getId());
        if(work != null) {
            jsonResponseDto.setCode(CodeResponse.BAD_REQUEST);
            jsonResponseDto.setMessage(MessageCommon.WORK_EXIST);
            return new ResponseEntity<Object>(jsonResponseDto, HttpStatus.BAD_REQUEST);
        }

        // check valid information of work
        if(!isValidInfoWork(jsonResponseDto, workJson)) {
            jsonResponseDto.setCode(CodeResponse.BAD_REQUEST);
            return new ResponseEntity<Object>(jsonResponseDto, HttpStatus.BAD_REQUEST);
        }

        // execute add work
        workService.addWork(workJson);

        // return result
        jsonResponseDto.setCode(CodeResponse.OK);
        jsonResponseDto.setMessage(MessageCommon.ADD_SUCCESS);
        return new ResponseEntity<Object>(jsonResponseDto, HttpStatus.OK);
    }

    /**
     * Update a work
     * @param workJson object of work
     * @return ResponseEntity result after execute update
     */
    @RequestMapping(value = "/update-work", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateWork(@RequestBody Work  workJson){
        JsonResponseDto jsonResponseDto = new JsonResponseDto();

        // get work from to check exists
        Work work = workService.getWork(workJson.getId());
        if(work == null) {
            jsonResponseDto.setCode(CodeResponse.BAD_REQUEST);
            jsonResponseDto.setMessage(MessageCommon.WORK_NOT_EXIST);
            return new ResponseEntity<Object>(jsonResponseDto, HttpStatus.BAD_REQUEST);
        }

        // check valid information of work
        if(!isValidInfoWork(jsonResponseDto, workJson)) {
            jsonResponseDto.setCode(CodeResponse.BAD_REQUEST);
            return new ResponseEntity<Object>(jsonResponseDto, HttpStatus.BAD_REQUEST);
        }

        // execute update work
        workService.updateWork(workJson);

        // return result
        jsonResponseDto.setCode(CodeResponse.OK);
        jsonResponseDto.setMessage(MessageCommon.UPDATE_SUCCESS);
        return new ResponseEntity<Object>(jsonResponseDto, HttpStatus.OK);
    }

    /**
     * Delete a work
     * @param id id of work
     * @return ResponseEntity result after execute delete
     */
    @RequestMapping(value = "/delete-work/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteWork(@PathVariable(value = "id") int id){
        JsonResponseDto jsonResponseDto = new JsonResponseDto();

        // get work from to check exists
        Work work = workService.getWork(id);
        if(work == null) {
            jsonResponseDto.setCode(CodeResponse.BAD_REQUEST);
            jsonResponseDto.setMessage(MessageCommon.WORK_NOT_EXIST);
            return new ResponseEntity<Object>(jsonResponseDto, HttpStatus.BAD_REQUEST);
        }

        // execute delete
        workService.deleteWork(id);

        // return result
        jsonResponseDto.setCode(CodeResponse.OK);
        jsonResponseDto.setMessage(MessageCommon.DEL_SUCCESS);
        return new ResponseEntity<Object>(jsonResponseDto, HttpStatus.OK);
    }

    /**
     * Check valid information of work object
     * @param jsonResponseDto
     * @param workJson
     * @return boolean true if valid
     */
    private boolean isValidInfoWork(JsonResponseDto jsonResponseDto, Work workJson) {

        // check null or empty
        if(StringUtils.isEmpty(workJson.getWorkName().trim())) {
            jsonResponseDto.setMessage(MessageCommon.NOT_EMPTY_WORK_NAME);
            return false;
        }
        if(StringUtils.isEmpty(workJson.getStartingDate().trim())) {
            jsonResponseDto.setMessage(MessageCommon.NOT_EMPTY_STARTING_DATE);
            return false;
        }
        if(StringUtils.isEmpty(workJson.getEndingDate().trim())) {
            jsonResponseDto.setMessage(MessageCommon.NOT_EMPTY_ENDING_DATE);
            return false;
        }
        if(StringUtils.isEmpty(workJson.getStatus().trim())) {
            jsonResponseDto.setMessage(MessageCommon.NOT_EMPTY_STATUS);
            return false;
        }

        // check format date
        if(!Common.isDateValid(workJson.getStartingDate(), FormatDate.ddMMyyyy_1)) {
            jsonResponseDto.setMessage(MessageCommon.FORMAT_STARTING_DATE);
            return false;
        }

        if(!Common.isDateValid(workJson.getEndingDate(), FormatDate.ddMMyyyy_1)) {
            jsonResponseDto.setMessage(MessageCommon.FORMAT_ENDING_DATE);
            return false;
        }

        // check starting date > ending date
        Date startDate = Common.convDate(workJson.getStartingDate(), FormatDate.ddMMyyyy_1);
        Date endDate =  Common.convDate(workJson.getEndingDate(), FormatDate.ddMMyyyy_1);
        if(endDate.before(startDate)) {
            jsonResponseDto.setMessage(MessageCommon.STARTING_AFTER_ENDING_DATE);
            return false;
        }

        // check status 
        if(!checkValidStatus(workJson.getStatus().trim())) {
            jsonResponseDto.setMessage(MessageCommon.CHOSSE_STATUS);
            return false;
        }
        return true;
    }
    /**
     * Check is valid status
     * @param status
     * @return
     */
    private boolean checkValidStatus(String status) {
        if(status.equals("Planning") || status.equals("Doing") || status.equals("Complete")) {
            return true;
        }
        return false;
    }
}
