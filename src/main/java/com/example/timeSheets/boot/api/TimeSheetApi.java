package com.example.timeSheets.boot.api;

import com.example.timeSheets.boot.model.TimeSheet;
import com.example.timeSheets.boot.service.TimeSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("timesheet")
public class TimeSheetApi {

    @Autowired
    private TimeSheetService service;

    @PostMapping
    public String save(@RequestBody TimeSheet timeSheet) {
        service.save(timeSheet);
        return "TimeSheet saved with success";
    }
    @GetMapping("/v2")
    public Page<TimeSheet> getTimeSheets( @RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                          @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize ){
        return service.getTimeSheets(pageNumber, pageSize);
    }
    @DeleteMapping("/{timeSheetId}")
    public String deletetimeSheet(@PathVariable Long timeSheetId) {
        service.deleteById(timeSheetId);
        return "Time sheet " + timeSheetId + " Was deleted";
    }
}
