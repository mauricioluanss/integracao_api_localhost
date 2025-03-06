package org.example.repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

public class Body {
    public String body(double value, String pm, String pt, String pmst) throws JsonProcessingException {
        Map<String, Object> json = new HashMap<>();
                json.put("command", "PAYMENT");
                json.put("value", value);
                json.put("idPayer", "MAURICIO");
                json.put("paymentMethod", pm);
                json.put("paymentType", pt);
                json.put("paymentMethodSubType", pmst);
                //json.put("installments", 0);
                //json.put("documentNumber", "string");
                //json.put("service", "string");
                //json.put("paymentDate", "yyyy-MM-dd");
                //json.put("email", "string");
                //json.put("password", "string");
                    //Map<String, Object> remoteOrder = new HashMap<>();
                    //json.put("PosId", "string");
                    //json.put("flow", "string");
                //json.put("remoteOrder", remoteOrder);
                //json.put("callbackUrl", callback);            **verificar depois
                //json.put("cnpjMultiEc", "string");
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(json);
    }
}
