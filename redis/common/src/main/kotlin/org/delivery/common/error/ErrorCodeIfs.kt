package org.delivery.common.error

import java.util.function.IntFunction

interface ErrorCodeIfs {
    fun getHttpStatusCode() : Int
    fun getErrorCode(): Int
    fun getDescription(): String
}