package com.example.scavengerhunt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NestedObject {
    public SingleKeyValue nestedKeyValue;
}
