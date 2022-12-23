package fyc.epss.controller;

import fyc.epss.domain.Admin;
import fyc.epss.domain.Food;
import fyc.epss.utils.DataFlexPacking;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/foods")
public class FoodFinalController implements Common<Food>{
    @Override
    @GetMapping
    public DataFlexPacking selectMultiple() {
        return DataFlexPacking.success().add("key","value");
    }

    @Override
    @GetMapping("/{pk}")
    public DataFlexPacking selectOne(@RequestParam(value = "pk")Integer id) {
        return Common.super.selectOne(id);
    }

    @Override
    @DeleteMapping("/{pk}")
    public DataFlexPacking deleteOne(@RequestParam(value = "pk")Integer id) {
        return Common.super.deleteOne(id);
    }

    @Override
    @PostMapping
    public DataFlexPacking addOne(@RequestParam(value = "obj",required = true) Food obj) {
        return Common.super.addOne(obj);
    }

    @Override
    @PutMapping
    public DataFlexPacking updateOne(Food obj) {
        return Common.super.updateOne(obj);
    }
}
