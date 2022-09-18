package com.example.booklevel.domain.message


import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Component


@Component
class I18NMessageHelper(val messageSource: MessageSource) {

    fun getMessage(code:String) = getMessage(code, null)

    private fun getMessage(code: String, args: Array<Any>?): String {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale()).ifEmpty { "메시지를 찾을 수 없습니다." }
    }
}