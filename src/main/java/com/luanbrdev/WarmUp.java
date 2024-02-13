package com.luanbrdev;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WarmUp {
    public List<String> somethingImportant = Collections.synchronizedList(new ArrayList<>());
    public List<String> somethingUnnecessary = Collections.synchronizedList(new ArrayList<>());
}
