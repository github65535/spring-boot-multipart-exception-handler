/*
 * Copyright 2016 Pigumer Group Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.pigumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MultipartExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultipartExceptionHandler.class);

    @ExceptionHandler(MultipartException.class)
    public String handleException(HttpServletRequest request, Exception e) {
        LOGGER.warn(request.getRequestURI(), e);
        return "filesizeerror";
    }
}
