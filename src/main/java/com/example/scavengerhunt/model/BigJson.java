package com.example.scavengerhunt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BigJson {
    public List<String> arrayOfStrings;
    public List<SingleKeyValue> arrayOfObject;
    public NumberObject objectOfNumbers;
    public NestedObject nestedObject;
    public List<NestedObject> nestedObjectArray;
    public String description;
}
