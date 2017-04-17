package com.graniumhub.web;

import com.graniumhub.data.dto.dish.DishInput;
import com.graniumhub.data.dto.dish.DishResponse;
import com.graniumhub.data.filter.OnSaleDishFilter;
import com.graniumhub.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sasha on 3/28/17.
 */
@RestController
@CrossOrigin
public class DishController {

    private final DishService service;

    @Autowired
    public DishController(DishService service) {
        this.service = service;
    }


    @GetMapping(value = "/sales")
    public ResponseEntity<List<DishResponse>> sales(){
        List<DishResponse> sales = service.findSales();
        return ResponseEntity.ok(sales);
    }

    @PostMapping(value = "/dishes")
    public ResponseEntity<DishResponse> create(DishInput input) {
        DishResponse response = service.create(input);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/dishes/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        boolean result = service.delete(id);
        return result ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping(value = "/dishes/{id}")
    public ResponseEntity<DishResponse> setDiscount(@PathVariable int id,
                                                    @RequestParam int discount){
        DishResponse response = service.setDiscount(id, discount);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/categories/{id}/dishes")
    public ResponseEntity<List<DishResponse>> findByCategory(
            @PathVariable int id,
            OnSaleDishFilter dishFilter) {

        List<DishResponse> dishes = service.findByCategoryId(id);
        dishes = dishes.stream()
                .filter(dishFilter)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dishes);
    }

}
