package com.etboot.modules.base.controller.common;

import com.etboot.common.generate.XbootVueGenerator;
import com.etboot.common.generate.bean.OrmField;
import com.etboot.common.utils.ResultUtil;
import com.etboot.common.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@Api(description = "Vue代码生成")
@RequestMapping(value = "/xboot/generate")
public class GenerateController {

    @RequestMapping(value = "/table/{vueName}/{rowNum}", method = RequestMethod.POST)
    @ApiOperation(value = "增删改表格生成")
    public Result<Object> generateTable(@PathVariable String vueName,
                                        @PathVariable Integer rowNum,
                                        @RequestBody List<OrmField> fields) throws IOException {
//        String result = XbootVueGenerator.generate("table.btl", vueName, rowNum, fields);
//        return new ResultUtil<Object>().setData(result);
        String component = XbootVueGenerator.generate("tableIndex.btl", false, vueName, rowNum, fields);
        String componentApi = XbootVueGenerator.generate("tableIndex.btl", true, vueName, rowNum, fields);
        String add = XbootVueGenerator.generate("add.btl", false, vueName, rowNum, fields);
        String addApi = XbootVueGenerator.generate("add.btl", true, vueName, rowNum, fields);
        String edit = XbootVueGenerator.generate("edit.btl", false, vueName, rowNum, fields);
        String editApi = XbootVueGenerator.generate("edit.btl", true, vueName, rowNum, fields);
        String single = XbootVueGenerator.generate("table.btl", false, vueName, rowNum, fields);
        String singleApi = XbootVueGenerator.generate("table.btl", true, vueName, rowNum, fields);
        String api = XbootVueGenerator.generate("api.btl", true, vueName, rowNum, fields);

        Map<String, String> map = new HashMap<>();
        map.put("component", component);
        map.put("componentApi", componentApi);
        map.put("add", add);
        map.put("addApi", addApi);
        map.put("edit", edit);
        map.put("editApi", editApi);
        map.put("single", single);
        map.put("singleApi", singleApi);
        map.put("api", api);

        return ResultUtil.data(map);
    }

    @RequestMapping(value = "/tree/{vueName}/{rowNum}", method = RequestMethod.POST)
    @ApiOperation(value = "树形结构生成")
    public Result<Object> generateTree(@PathVariable String vueName,
                                       @PathVariable Integer rowNum,
                                       @RequestBody List<OrmField> fields) throws IOException {
        //String result = XbootVueGenerator.generate("tree.btl", vueName, rowNum, fields);
        String result = XbootVueGenerator.generate("tree.btl", false, vueName, rowNum, fields);
        String resultApi = XbootVueGenerator.generate("tree.btl", true, vueName, rowNum, fields);
        String api = XbootVueGenerator.generate("treeApi.btl", true, vueName, rowNum, fields);
        Map<String, String> map = new HashMap<>();
        map.put("result", result);
        map.put("resultApi", resultApi);
        map.put("api", api);
        return ResultUtil.data(map);
    }

    @RequestMapping(value = "/getEntityData/{path}", method = RequestMethod.GET)
    @ApiOperation(value = "通过实体类生成Vue代码Json数据")
    public Result<Object> getEntityData(@PathVariable String path) {
        String result = "";
        try {
            result = XbootVueGenerator.gengerateEntityData(path);
        } catch (Exception e) {
            return new ResultUtil<Object>().setErrorMsg("实体类文件不存在");
        }
        return new ResultUtil<Object>().setData(result);
    }
}
