package jetbrains.mps.bootstrap.helgins.runtime;

import jetbrains.mps.helgins.inference.util.IDependency_Runtime;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Cyril.Konopko
 * Date: 01.04.2007
 * Time: 17:23:11
 * To change this template use File | Settings | File Templates.
 */
public interface IHelginsDescriptor {
  public Set<InferenceRule_Runtime> getInferenceRules();
  public Set<NonTypesystemRule_Runtime> getNonTypesystemRules();
  public Set<SubtypingRule_Runtime> getSubtypingRules();
  public Set<SupertypingRule_Runtime> getSupertypingRules();
  public Set<ComparisonRule_Runtime> getComparisonRules();
  public Set<InequationReplacementRule_Runtime> getEliminationRules();
  public Set<IDependency_Runtime> getDependencies();
}
