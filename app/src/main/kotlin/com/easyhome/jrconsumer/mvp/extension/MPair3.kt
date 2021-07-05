package com.easyhome.jrconsumer.mvp.extension

import java.io.Serializable

/**
 * Time 2018/10/12  5:24 PM
 *
 * Pair
 **/
data class MPair3<A, B,C>(
    var first: A,
    var second: B,
    var three: C
) : Serializable{
    override fun toString(): String {
        return "MPair(first=$first, second=$second)"
    }
}