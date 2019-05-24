package com.scutj2ee.bookstore.web;

import com.scutj2ee.bookstore.entity.Address;
import com.scutj2ee.bookstore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/9 23:34
 * @description:
 * @Modified By：Liu Bin
 */
@RestController
@RequestMapping("")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * create by: Bin Liu
     * description: 查询该用户id所有地址
     * create time: 2019/5/23 9:24
     * @Param: null
     * @return 
     */
    @RequestMapping("/list")
    public ResponseEntity<List<Address>> list(){
        List<Address> addresses = this.addressService.findByUserId();
        if(addresses == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(addresses);
    }

    /**
     * 增加用户地址
     */
    @PostMapping
    public ResponseEntity<Void> addAddress(Address address)throws Exception{
        this.addressService.create(address);
        return ResponseEntity.ok().build();
    }

    /**
     * 用户修改地址信息
     *
     */
    @PutMapping
    public ResponseEntity<Void> changeAddress(Address address)throws Exception{
        this.addressService.update(address);
        return ResponseEntity.ok().build();
    }

    /**
     * create by: Bin Liu
     * description: 根据地址Id删除地址
     * create time: 2019/5/23 15:37
     * @Param: null
     * @return 
     */
    @DeleteMapping("{addressId}")
    public ResponseEntity<Void> deleteAddress(@PathVariable("addressId") Integer addressId){
        this.addressService.deleteById(addressId);
        return ResponseEntity.ok().build();
    }


}
