package com.lintmar.controller;

import com.lintmar.bean.UserBorrowDetail;
import com.lintmar.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LintMar
 * @date 2022/7/25
 **/
@RestController
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @RequestMapping("/borrow/{uid}")
    // @HystrixCommand(fallbackMethod = "fallback")
    public UserBorrowDetail borrow(@PathVariable("uid") Integer uid) {
        return borrowService.getUserBorrowDetailByUid(uid);
    }
}
