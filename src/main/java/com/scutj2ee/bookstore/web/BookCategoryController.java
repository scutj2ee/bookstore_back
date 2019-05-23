package com.scutj2ee.bookstore.web;

import com.scutj2ee.bookstore.entity.BookCategory;
import com.scutj2ee.bookstore.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/23 15:42
 * @ Description：书本种类控制类
 * @ Modified By：
 */

@RestController
@RequestMapping("category")
public class BookCategoryController {
    @Autowired
    private BookCategoryService bookCategoryService;

    /**
     * 根据父节点查询商品类目
     * @param pid
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<BookCategory>> queryCategoryByPid(@RequestParam("pid") Long pid){

        //如果pid的值为-1那么需要获取数据库中最后一条数据
        if (pid == -1){
            List<BookCategory> last = this.bookCategoryService.queryLast();
            return ResponseEntity.ok(last);
        }
        else {
            List<BookCategory> list = this.bookCategoryService.queryCategoryByPid(pid);
            if (list == null) {
                //没有找到返回404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            //找到返回200
            return ResponseEntity.ok(list);
        }
    }

    /**
     * 保存
     * @return
     */
    @PostMapping
    public ResponseEntity<Void> saveCategory(BookCategory bookCategory){
        this.bookCategoryService.create(bookCategory);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 更新
     * @return
     */
    @PutMapping
    public ResponseEntity<Void> updateCategory(BookCategory bookCategory){
        this.bookCategoryService.update(bookCategory);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /**
     * 删除
     * @return
     */
    @DeleteMapping("cid/{cid}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("cid") Integer id){
        this.bookCategoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 根据分类id集合查询分类名称
     * @param ids
     * @return
     */
    @GetMapping("names")
    public ResponseEntity<List<String>> queryNameByIds(@RequestParam("ids")List<Integer> ids){
        List<String> list = bookCategoryService.queryNameByIds(ids);
        if (list == null || list.size() < 1){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(list);
        }
    }

    /**
     * 根据分类id集合查询分类名称
     * @param ids
     * @return
     */
    @GetMapping("all")
    public ResponseEntity<List<BookCategory>> queryCategoryByIds(@RequestParam("ids")List<Integer> ids){
        List<BookCategory> list = bookCategoryService.queryCategoryByIds(ids);
        if (list == null || list.size() < 1){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(list);
        }
    }

    /**
     * 根据分类id集合查询分类名称
     * @param id
     * @return
     */
    @GetMapping("all/level/{cid3}")
    public ResponseEntity<List<BookCategory>> queryAllCategoryLevelByCid3(@PathVariable("cid3")Long id){
        List<BookCategory> list = bookCategoryService.queryAllCategoryLevelByCid3(id);
        if (list == null || list.size() < 1){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(list);
        }
    }
}
