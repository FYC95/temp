package fyc.epss.controller;

import fyc.epss.domain.Business;
import fyc.epss.domain.Ordermap;
import fyc.epss.utils.DataFlexPacking;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/ordermaps")
public class OrdermapFinalController implements Common<Ordermap>{
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
    public DataFlexPacking addOne(@RequestParam(value = "obj",required = true) Ordermap obj) {
        return Common.super.addOne(obj);
    }

    @Override
    @PutMapping
    public DataFlexPacking updateOne(Ordermap obj) {
        return Common.super.updateOne(obj);
    }
}
