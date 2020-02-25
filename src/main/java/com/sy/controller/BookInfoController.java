package com.sy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sy.mapper.BookInfoMapper;
import com.sy.pojo.BookForm;
import com.sy.pojo.BookInfo;
import com.sy.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
public class BookInfoController {
    @Autowired
    BookInfoMapper bookInfoMapper;
    @Autowired
    BookService bookService;


    @GetMapping("/getAllBook")
    public String getAllBook(@RequestParam("limit") Integer limit,
                             @RequestParam("page") Integer page,
                             @RequestParam("bookName") String bookName) {
        List<BookInfo> list = bookInfoMapper.getBookByPage((page - 1) * limit, limit, "%" + bookName + "%");
        Map<Integer, String> bookCategoryMap = bookService.getBookCategoryMap();
        for (BookInfo book : list) { //给categoryName赋值
            book.setCategoryName(bookCategoryMap.get(book.getCategoryType()));
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        //count主要用于计算总页数， 要区别对待 搜索这一特殊情况  担心每次都like会影响效率，所以设置两个方法来做
        jsonObject.put("count", bookName.isEmpty() ? bookInfoMapper.getAllCount() : bookInfoMapper.getCountByName("%" + bookName + "%"));
        jsonObject.put("data", list);
        return jsonObject.toJSONString();

    }

    @PostMapping("/addBook")
    public Integer addBook(BookForm bookForm) throws IOException {  //RequestBody 必须是json  RequestParam 必须是key-value形式
        //获得图片后缀
        String extUserImg = bookForm.getBookImg().getOriginalFilename().substring(bookForm.getBookImg().getOriginalFilename().lastIndexOf("."));
        //生成唯一名称
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + extUserImg;
        //资源images 文件夹目录
        String filePath = System.getProperty("user.dir").toString() + "\\src\\main\\resources\\static\\images\\bookImg\\";
        FileCopyUtils.copy(bookForm.getBookImg().getInputStream(), new FileOutputStream(new File(filePath + fileName)));
        String bookId = UUID.randomUUID().toString().replaceAll("-", "");
        String bookImg = "/images/bookImg/" + fileName;
        String bookName = bookForm.getBookName();
        BigDecimal bookPrice = bookForm.getBookPrice();
        Integer bookStock = bookForm.getBookStock();
        String bookAuthor = bookForm.getBookAuthor();
        String bookPress = bookForm.getBookPress();
        String bookIntroduce = bookForm.getBookIntroduce();
        Integer bookStatus = bookForm.getBookStatus() == null ? 0 : 1;
        Integer categoryType = bookForm.getCategoryType();
        Integer i = bookInfoMapper.addBook(bookId, bookImg, bookName, bookPrice, bookStock, bookAuthor, bookPress, bookIntroduce, bookStatus, categoryType);
        return i;
    }

    @PostMapping("/changeBookStatus")
    public Integer changeBookStatus(@RequestParam("bookId") String bookId,
                                    @RequestParam("bookStatus") Integer bookStatus) {
        Integer i = bookInfoMapper.changeBookStatus(bookId, bookStatus);
        return i;
    }

    @PostMapping("/updateBook")
    public Integer updateBook(BookForm bookForm,
                              @RequestParam("img") String img) throws IOException {  //RequestBody 必须是json  RequestParam 必须是key-value形式
        String bookImg = img;
        int status = 0;
        if (!bookForm.getBookImg().isEmpty()) {
            //获得图片后缀
            String extUserImg = bookForm.getBookImg().getOriginalFilename().substring(bookForm.getBookImg().getOriginalFilename().lastIndexOf("."));
            //生成唯一名称
            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + extUserImg;
            //资源images 文件夹目录
            String filePath = System.getProperty("user.dir").toString() + "\\src\\main\\resources\\static\\images\\bookImg\\";
            FileCopyUtils.copy(bookForm.getBookImg().getInputStream(), new FileOutputStream(new File(filePath + fileName)));
            bookImg = "/images/bookImg/" + fileName;
            status = 1;
        }
        String bookId = bookForm.getBookId();
        String bookName = bookForm.getBookName();
        BigDecimal bookPrice = bookForm.getBookPrice();
        Integer bookStock = bookForm.getBookStock();
        String bookAuthor = bookForm.getBookAuthor();
        String bookPress = bookForm.getBookPress();
        String bookIntroduce = bookForm.getBookIntroduce();
        Integer bookStatus = 1;
        if (bookForm.getBookStatus() == null) {
            bookStatus = 0;
        }
        Integer categoryType = bookForm.getCategoryType();
        if (status == 1) {
            return bookInfoMapper.updateBook(bookId, bookImg, bookName, bookPrice, bookStock, bookAuthor, bookPress, bookIntroduce, bookStatus, categoryType);
        } else {
            return bookInfoMapper.updateBookNoImg(bookId, bookName, bookPrice, bookStock, bookAuthor, bookPress, bookIntroduce, bookStatus, categoryType);
        }
    }


    @PostMapping("/multipleDelete")
    public Integer multipleDelete(@RequestParam("bookIdList") String bookIdList) {
        List<String> list = JSON.parseArray(bookIdList, String.class);
        Integer i = bookInfoMapper.multipleDelete(list);
        //返回的是 行改变数量，只要大于零 就是操作成功了
        return i > 0 ? 1 : 0;
    }

    @PostMapping("/deleteBookById")
    public Integer deleteBookById(@RequestParam("bookId") String bookId) {
        Integer i = bookInfoMapper.deleteBookById(bookId);
        return i;
    }


}
