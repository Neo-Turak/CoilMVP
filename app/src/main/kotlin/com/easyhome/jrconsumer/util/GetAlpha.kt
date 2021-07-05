package com.easyhome.jrconsumer.util

class GetAlpha {

    fun toAlpha(first: String): String {
        when (first) {
            "北" -> return "B"
            "上" -> return "S"
            "天" -> return "T"
            "重" -> return "C"
            "黑" -> return "H"
            "辽" -> return "L"
            "吉", "江" -> return "J"
            "河", "湖" -> return "H"
            "山", "陕" -> return "S"
            "安", "澳" -> return "A"
            "浙" -> return "Z"
            "福" -> return "F"
            "广" -> return "G"
            "海" -> return "H"
            "四" -> return "S"
            "云" -> return "Y"
            "贵" -> return "G"
            "青" -> return "Q"
            "甘" -> return "G"
            "台" -> return "T"
            "内" -> return "N"
            "宁" -> return "N"
            "新", "香" -> return "X"
            "西" -> return "X"
        }
        return " "
    }
}