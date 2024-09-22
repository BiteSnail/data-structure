package org.example

import java.util.*

class Browser {
    private val prevStack = Stack<String>()
    private val nextStack = Stack<String>()
    private var currentPage: String? = null

    /* 브라우저가 page 에 방문합니다.
    1. 만약 현재 페이지가 null이 아니라면 prevStack 에 추가합니다.
    2. 현재 페이지를 갱신합니다.
    3. nextStack을 초기화합니다.
     */
    fun visit(page: String) {
        TODO("Require Implementation")
    }

    /* 이전 페이지로 이동합니다.
    1. prevStack 이 비어 있다면 null 을 반환합니다.
    2. nextStack에 현재 페이지를 추가합니다.
    3. prevStack 에서 페이지를 불러와 현재 페이지를 갱신합니다.
    4. 현재 페이지를 반환합니다.
     */
    fun goBack(): String? {
        TODO("Require Implementation")
    }

    /* 다음 페이지로 이동합니다.
    1. nextStack 이 비어 있다면 null 을 반환합니다.
    2. prevStack에 현재 페이지를 추가합니다.
    3. nextStack에서 페이지를 불러와 현재 페이지를 갱신합니다.
    4. 현제 페이지를 반환합니다.
     */
    fun goForward(): String? {
        TODO("Require Implementation")
    }

    fun getCurrentPage(): String? {
        return currentPage
    }
}