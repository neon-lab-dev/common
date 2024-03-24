package com.neonlab.common.utilities;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

@UtilityClass
public class StringUtil {

    public static boolean isNullOrEmpty(String str){
        return (Objects.isNull(str) || StringUtils.isEmpty(str));
    }


}
