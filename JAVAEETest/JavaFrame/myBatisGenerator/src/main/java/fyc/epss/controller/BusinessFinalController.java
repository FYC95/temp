package fyc.epss.controller;

import fyc.epss.domain.Business;
import fyc.epss.domain.Info;
import fyc.epss.utils.DataFlexPacking;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/businesss")
public class BusinessFinalController implements Common<Business>{
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
    public DataFlexPacking addOne(@RequestParam(value = "obj",required = true) Business obj) {
        return Common.super.addOne(obj);
    }

    @Override
    @PutMapping
    public DataFlexPacking updateOne(Business obj) {
        return Common.super.updateOne(obj);
    }
}
