package com.lintmar.client.fallback;

import com.lintmar.client.BookClient;
import com.lintmar.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author LintMar
 * @date 2022/7/26
 **/
@Slf4j
@Component
public class BookFallbackClient implements BookClient {
    @Override
    public Book getBookByBid(Integer bid) {
        log.warn("Book Service Error");
        Book book = new Book();
        book.setBid(bid);
        book.setTitle("服务器异常");
        book.setDesc("请联系服务器管理员");
        return book;
    }
}
