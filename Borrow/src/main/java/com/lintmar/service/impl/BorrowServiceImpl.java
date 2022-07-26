package com.lintmar.service.impl;


import com.lintmar.bean.UserBorrowDetail;
import com.lintmar.client.BookClient;
import com.lintmar.client.UserClient;
import com.lintmar.entity.Book;
import com.lintmar.entity.Borrow;
import com.lintmar.entity.User;
import com.lintmar.repository.BorrowRepository;
import com.lintmar.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author LintMar
 * @date 2022/7/25
 **/
@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    @Resource
    private UserClient userClient;

    @Resource
    private BookClient bookClient;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(Integer uid) {
        List<Borrow> borrowList = borrowRepository.findBorrowByUid(uid);
        User user = userClient.getUserByUid(uid);
        List<Book> bookList = borrowList.stream().map((borrow) -> bookClient.getBookByBid(borrow.getBid()))
                .collect(Collectors.toList());
        UserBorrowDetail detail = new UserBorrowDetail();
        detail.setUser(user);
        detail.setBookList(bookList);
        return detail;
    }
}
