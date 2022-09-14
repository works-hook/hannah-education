package com.hannah.education.util

sealed class ApiResponse<T>(
    val data: T? = null,
    val message: String? = "OK"
) {
    class Success<T>(data: T) : ApiResponse<T>(data)
    class Error<T>(data: T?, errorMessage: String?) : ApiResponse<T>(data, errorMessage)
}