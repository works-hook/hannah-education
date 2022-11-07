package com.hannah.education.userservice.util

sealed class ApiResponse<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T, message: String) : ApiResponse<T>(data, message)
    class Error<T>(data: T, errorMessage: String?) : ApiResponse<T>(data, message = errorMessage)
    class Ok<T>(data: T) : ApiResponse<T>(data, "OK")
}