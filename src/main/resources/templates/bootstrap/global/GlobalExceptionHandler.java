package {package}.{project.name}.bootstrap.global;

import com.cic.irc.utils.result.ResultModel;
import com.cic.irc.utils.result.ResultUtil;
import com.cic.irc.utils.result.errorcode.DefaultErrorCode;
import com.cic.irc.utils.result.exception.DomainException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Priority;

@ControllerAdvice
@Priority(1)
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DomainException.class)
    @ResponseBody
    public ResultModel<?> detail(DomainException e) {
        // 记录错误日志
        LOGGER.error(e.getErrCode(), e.getMessage(), e);
        // 转换成返回给前台的信息
        return ResultUtil.fail(e.getErrCode(), e.getMessage(), null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultModel<?> detail(Exception e) {
        LOGGER.error(DefaultErrorCode.SYS_ERROR.code(), e);
        return ResultUtil.fail(DefaultErrorCode.SYS_ERROR, null);
    }

}