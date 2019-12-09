package com.xt.winter;

import com.xt.service.winter.WorkAttendanceServiceI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Winter
 * @Date 2019/12/9 13:55
 */
@SpringBootTest
public class WinterTest {
    @Autowired
    private WorkAttendanceServiceI workAttendanceService;
    @Test
    void testWorkAttendance() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = format.parse("8:30:00");
        Date date2 = format.parse("14:20:20");
        Time startTime = new Time(date1.getTime());
        Time endTime = new Time(date2.getTime());
        workAttendanceService.updateWorkAttendanceDate(startTime,endTime,null,1);
    }
}
