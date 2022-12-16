package com.helmes.cities.adapter.out.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "city")
public class CityEntity implements Serializable  {
  @Id
  private String Id;

  @NonNull
  @Indexed(unique = true)
  @Field("city_name")
  private String name;

  @NonNull
  @Field("photo_url")
  private String photo;
}
