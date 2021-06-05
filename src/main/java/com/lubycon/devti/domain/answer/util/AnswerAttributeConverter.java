package com.lubycon.devti.domain.answer.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lubycon.devti.domain.answer.entity.AnswerAttribute;
import java.util.List;
import javax.persistence.AttributeConverter;

public class AnswerAttributeConverter implements AttributeConverter<List<AnswerAttribute>, String> {

  private static final ObjectMapper objectMapper = new ObjectMapper().configure(
      DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  @Override
  public String convertToDatabaseColumn(List<AnswerAttribute> answerAttributeList) {
    try {
      return objectMapper.writeValueAsString(answerAttributeList);
    } catch (JsonProcessingException e) {
      throw new IllegalArgumentException(String.valueOf(answerAttributeList));
    }
  }

  @Override
  public List<AnswerAttribute> convertToEntityAttribute(String dbData) {
    try {
      return objectMapper.readValue(dbData,
          objectMapper.getTypeFactory().constructCollectionType(List.class, AnswerAttribute.class));
    } catch (JsonProcessingException e) {
      throw new IllegalArgumentException(String.valueOf(dbData));
    }
  }
}
