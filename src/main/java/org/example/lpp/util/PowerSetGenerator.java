package org.example.lpp.util;

import java.util.List;
import java.util.Set;

public interface PowerSetGenerator<T> {
	Set<List<T>> generate(List<T> list);
}