package com.tronos.co.tronos10.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Utils {

  @Autowired
  public Utils(MessageSource messageSource){
    this.messageSource = messageSource;
  }

  private static MessageSource messageSource;

  public static com.tronos.co.tronos10.util.ConflictException throwException(String exception) {
    throw new com.tronos.co.tronos10.util.ConflictException(
        messageSource
            .getMessage(exception, null,
                LocaleContextHolder.getLocale()));
  }

  public static com.tronos.co.tronos10.util.ConflictException throwExceptionParams(String exception, String append) {
    StringBuffer stringBuilder = new StringBuffer();
    stringBuilder
        .append(messageSource.getMessage(exception, null, LocaleContextHolder.getLocale()));
    stringBuilder.append(" ").append(append);
    throw new com.tronos.co.tronos10.util.ConflictException(stringBuilder.toString());
  }

  public static String getMessage(String message){
    return  messageSource
            .getMessage(message, null,
                    LocaleContextHolder.getLocale());
  }


}
