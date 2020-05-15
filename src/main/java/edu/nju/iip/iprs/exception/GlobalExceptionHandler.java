package edu.nju.iip.iprs.exception;

import edu.nju.iip.iprs.message.ApiMessage;
import edu.nju.iip.iprs.product.list.constants.IProdListMessagesConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> exceptionHandler(HttpServletRequest request, Exception ex){

        logger.info(ex.getClass().getName());
        logger.error("error", ex);

        ApiMessage<String> apiMessage = new ApiMessage();

        apiMessage.setMsg(IProdListMessagesConstants.BAD_REQUEST_MESSAGE);

        return new ResponseEntity<>(apiMessage, new HttpHeaders(), HttpStatus.BAD_GATEWAY);
    }
}
