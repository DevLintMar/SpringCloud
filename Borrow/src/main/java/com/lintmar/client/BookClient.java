package com.lintmar.client;

import com.lintmar.client.fallback.BookFallbackClient;
import com.lintmar.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LintMar
 * @date 2022/7/25
 **/
@FeignClient(value = "bookservice", fallback = BookFallbackClient.class)
public interface BookClient {
    @RequestMapping("/book/{bid}")
    Book getBookByBid(@PathVariable("bid") Integer bid);
}
