package com.easyhome.jrconsumer.api

/**
 * 存放一些与 API 有关的东西,如请求地址,请求码等
 */
object Api {

    const val LOGIN_REQUEST_CODE = 100
    const val LOGIN_RESULT_CODE = 101
    const val LOGIN_RESULT_CODE_NO = 102
    const val BASE = "api-user/"

    const val RequestSuccess = 0
    const val KEY_UUID = "KEY_UUID"
    const val USERAPI = "userapi"

    //内侧环境使用
    const val BASE_IP = "59.110.25.34"
    const val BASE_IP_2 = "59.110.25.34:8090"
    const val BASE_IP_H5 = "59.110.25.34"
    const val BASE_URL = "http://${BASE_IP}:8080"
    const val APP_H5_BASE_URL = "http://${BASE_IP_H5}:8080/app-h5-consumer"
    const val APP_H5_BASE_URL_2 = "http://${BASE_IP}:8080/app-h5-business"

    //居然测试环境 242
/*    const val BASE_IP = "47.98.119.242"
    const val BASE_IP_2 = "47.98.119.242:8030"
    const val BASE_IP_H5 = "apptest.jrlewu.com"
    const val BASE_URL = "http://${BASE_IP}:8080"
    const val APP_H5_BASE_URL = "http://${BASE_IP_H5}:8080/app-h5-consumer"
    const val APP_H5_BASE_URL_2 = "http://${BASE_IP}:8080/app-h5-business"*/
    //erp正式环境

/*
    const val BASE_IP = "39.106.73.106"
    const val BASE_IP_2 = "39.96.28.112:18090"
    const val BASE_IP_H5 = "39.106.73.106"
    const val BASE_URL = "http://${BASE_IP}:18080"
    const val APP_H5_BASE_URL = "http://${BASE_IP_H5}:18080/app-h5-consumer"
    const val APP_H5_BASE_URL_2 = "http://${BASE_IP}:18080/app-h5-business"
*/

    //实名认证-用户实名信息v1.0
    const val GET_USER_REAL_INFO = "${BASE_URL}/api/bestsign/userInfo"


}
