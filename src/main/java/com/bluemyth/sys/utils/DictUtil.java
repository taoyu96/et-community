package com.bluemyth.sys.utils;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.bluemyth.framework.utils.SpringContextUtils;
import com.bluemyth.sys.entity.Dict;
import com.bluemyth.sys.service.DictService;
import com.bluemyth.sys.service.impl.DictServiceImpl;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by xiaot on 2018/6/17
 */
public class DictUtil {

    private static DictService dictService = (DictService) SpringContextUtils.getBean(DictServiceImpl.class);

    private static Map<String,List<Dict>> dictMap = new HashMap<>();


    public static String getCodeName(String dictType,String code){
        List<Dict> list = dictMap.get(dictType);
        if(list == null) {
            Dict dict = new Dict();
            list = dictService.selectList(new EntityWrapper<Dict>(dict));
        }

        for(Dict dict :list){
           if(StringUtils.equalsIgnoreCase(StringUtils.trimToNull(code),
                   StringUtils.trimToNull(dict.getCode()))){
              return StringUtils.trimToEmpty(dict.getValue()) ;
           }
        }

        return "";
    }

}
