package com.vimean.employees.employee.external;

import com.vimean.employees.employee.dto.request.ExternalReq;
import com.vimean.employees.employee.dto.response.ExternalRes;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.UUID;

@Service
public class Provider extends ExternalConfig{

    private final RestTemplate restTemplate;

    public Provider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private HttpHeaders getHeader(String correlationId){
        HttpHeaders headers = new HttpHeaders();
        headers.set("App_code", "Bakong");
        headers.set("CORRELATION_ID", correlationId);
        return headers;
    }

    private <T> T sendRequestNoToken(String url, HttpMethod method, @Nullable HttpEntity<?> req, String desc,
                                     String traceId, Map<String, String> additionalHeaders,
                                     ParameterizedTypeReference<T> typeReference) {
        if (null == traceId) {
            traceId = UUID.randomUUID().toString();
        }
        HttpEntity<?> entity = new HttpEntity<>(req != null ? req.getBody() : null, getHeader(traceId));
        try {
            T res = this.restTemplate.exchange(url, method, entity, typeReference).getBody();
            return res;
        } catch (Exception e) {
            return null;
        }
    }

    private <T> T sendPostMethod(String url, @Nullable HttpEntity<?> req, String desc,
                                 ParameterizedTypeReference<T> typeReference) {
        return sendRequestNoToken(url, HttpMethod.POST, req, desc, null, null, typeReference);
    }

    /*---Calling external ---*/
    /*public WSO2Response<BkgAccountInfoRes> bkgOpenAccInfo(InitLinkAccountReq req) throws AppException{
        String url = this.wso2BaseUrl + WSO2Constant.BAKONG_OPEN_ACCOUNT_INFO;
        return sendPostMethod(url, new HttpEntity<>(req), url, new ParameterizedTypeReference<>(){});
    }*/

    public ExternalRes exService (ExternalReq req){
        String url = "https://reqres.in/api/register";
        return sendPostMethod(url, new HttpEntity<>(req), url, new ParameterizedTypeReference<>(){});
    }

}
