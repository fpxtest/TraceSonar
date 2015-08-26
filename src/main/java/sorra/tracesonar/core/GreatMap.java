package sorra.tracesonar.core;

import java.util.Map;
import java.util.Optional;

public class GreatMap {
  public static final GreatMap INSTANCE = new GreatMap();

  public Map<String, CallerCollector> callerCollectors = Factory.infoMap();
  public Map<String, MethodInsnCollector> methodInsnCollectors = Factory.infoMap();

  public CallerCollector getCallerCollector(String owner) {
    return callerCollectors.computeIfAbsent(owner, CallerCollector::new);
  }

  public Optional<MethodInsnCollector> getMethodInsnCollector(String className) {
    return Optional.ofNullable(methodInsnCollectors.get(className));
  }

  public void addMethodInsnCollector(MethodInsnCollector methodInsnCollector) {
    methodInsnCollectors.put(methodInsnCollector.getClassName(), methodInsnCollector);
  }
}
