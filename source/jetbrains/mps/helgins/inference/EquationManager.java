package jetbrains.mps.helgins.inference;

import jetbrains.mps.helgins.structure.RuntimeErrorType;
import jetbrains.mps.helgins.structure.RuntimeTypeVariable;
import jetbrains.mps.smodel.*;
import jetbrains.mps.util.*;
import jetbrains.mps.logging.Logger;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: User
 * Date: 03.02.2006
 * Time: 22:27:59
 * To change this template use File | Settings | File Templates.
 */
public class EquationManager {

  private static Logger LOG = Logger.getLogger(EquationManager.class);

  private TypeChecker myTypeChecker;
  private INodeTypesComponent myNodeTypesComponent;

  private Map<IWrapper, Map<IWrapper, ErrorInfo>> mySubtypesToSupertypesMap = new HashMap<IWrapper, Map<IWrapper, ErrorInfo>>();
  private Map<IWrapper, Map<IWrapper, ErrorInfo>> mySupertypesToSubtypesMap = new HashMap<IWrapper, Map<IWrapper, ErrorInfo>>();
  private Map<IWrapper, Map<IWrapper, ErrorInfo>> mySubtypesToSupertypesMapStrong = new HashMap<IWrapper, Map<IWrapper, ErrorInfo>>();
  private Map<IWrapper, Map<IWrapper, ErrorInfo>> mySupertypesToSubtypesMapStrong = new HashMap<IWrapper, Map<IWrapper, ErrorInfo>>();

  private Map<IWrapper, Map<IWrapper, ErrorInfo>> myComparableTypesMap = new HashMap<IWrapper, Map<IWrapper, ErrorInfo>>();
  private Map<IWrapper, Map<IWrapper, ErrorInfo>> myComparableTypesMapStrong = new HashMap<IWrapper, Map<IWrapper, ErrorInfo>>();

  private Map<IWrapper, IWrapper> myEquations = new HashMap<IWrapper, IWrapper>();

  public EquationManager(TypeChecker typeChecker, INodeTypesComponent nodeTypesComponent) {
    myTypeChecker = typeChecker;
    myNodeTypesComponent = nodeTypesComponent;
  }

  public TypeChecker getTypeChecker() {
    return myTypeChecker;
  }

  public void putAllEquations(EquationManager slave) {
    for (IWrapper key : slave.mySubtypesToSupertypesMap.keySet()) {
      Map<IWrapper, ErrorInfo> map = mySubtypesToSupertypesMap.get(key);
      if (map == null) {
        map = new HashMap<IWrapper, ErrorInfo>();
        mySubtypesToSupertypesMap.put(key, map);
      }
      map.putAll(slave.mySubtypesToSupertypesMap.get(key));
    }

    for (IWrapper key : slave.mySupertypesToSubtypesMap.keySet()) {
      Map<IWrapper, ErrorInfo> map = mySupertypesToSubtypesMap.get(key);
      if (map == null) {
        map = new HashMap<IWrapper, ErrorInfo>();
        mySupertypesToSubtypesMap.put(key, map);
      }
      map.putAll(slave.mySupertypesToSubtypesMap.get(key));
    }

    for (IWrapper key : slave.mySubtypesToSupertypesMapStrong.keySet()) {
      Map<IWrapper, ErrorInfo> map = mySubtypesToSupertypesMapStrong.get(key);
      if (map == null) {
        map = new HashMap<IWrapper, ErrorInfo>();
        mySubtypesToSupertypesMapStrong.put(key, map);
      }
      map.putAll(slave.mySubtypesToSupertypesMapStrong.get(key));
    }

    for (IWrapper key : slave.mySupertypesToSubtypesMapStrong.keySet()) {
      Map<IWrapper, ErrorInfo> map = mySupertypesToSubtypesMapStrong.get(key);
      if (map == null) {
        map = new HashMap<IWrapper, ErrorInfo>();
        mySupertypesToSubtypesMapStrong.put(key, map);
      }
      map.putAll(slave.mySupertypesToSubtypesMapStrong.get(key));
    }

    for (IWrapper key : slave.myComparableTypesMap.keySet()) {
      Map<IWrapper, ErrorInfo> map = myComparableTypesMap.get(key);
      if (map == null) {
        map = new HashMap<IWrapper, ErrorInfo>();
        myComparableTypesMap.put(key, map);
      }
      map.putAll(slave.myComparableTypesMap.get(key));
    }

    for (IWrapper key : slave.myComparableTypesMapStrong.keySet()) {
      Map<IWrapper, ErrorInfo> map = myComparableTypesMapStrong.get(key);
      if (map == null) {
        map = new HashMap<IWrapper, ErrorInfo>();
        myComparableTypesMapStrong.put(key, map);
      }
      map.putAll(slave.myComparableTypesMapStrong.get(key));
    }

    for (IWrapper type : slave.myEquations.keySet()) {

      IWrapper parentType = slave.myEquations.get(type);
      if (parentType != null) {
        processEquation(type, parentType, null);
      }
    }
  }

  public IWrapper getParent(IWrapper type) {
    IWrapper parent = myEquations.get(type);
    if (parent == null) {
      EquationManager equationManager = getMaster();
      if (equationManager != null) {
        parent = equationManager.getParent(type);
      }
    }
    return parent;
  }

  public void setParent(IWrapper type, IWrapper parent) {
    myEquations.put(type, parent);
  }

  public IWrapper getRepresentatorWrapper(IWrapper type_) {
    List<IWrapper> path = new LinkedList<IWrapper>();
    int pathLength = 0;
    IWrapper type= type_;
    while (getParent(type) != null) {
      path.add(type);
      pathLength++;
      type = getParent(type);
    }
    // shortening the paths
    if (pathLength > 1) {
      for (IWrapper typeOnPath : path) {
        setParent(typeOnPath, type);
      }
    }
    return type;
  }

  public SNode getRepresentator(SNode type_) {
    if (type_ == null) return null;
    return fromWrapper(getRepresentatorWrapper(fromNode(type_)));
  }


  public void addInequation(SNode subType, SNode supertype, SNode nodeToCheck) {
    addInequation(fromNode(subType), fromNode(supertype), nodeToCheck, true);
  }

  public void addInequation(SNode subType, SNode supertype, ErrorInfo errorInfo) {
    addInequation(fromNode(subType), fromNode(supertype), errorInfo, true);
  }

  public void addInequation(SNode subType, SNode supertype, SNode nodeToCheck, boolean isWeak) {
    addInequation(fromNode(subType), fromNode(supertype), new ErrorInfo(nodeToCheck, null), isWeak);
  }

  public void addInequation(SNode subType, SNode supertype, ErrorInfo errorInfo, boolean isWeak) {
    addInequation(fromNode(subType), fromNode(supertype), errorInfo, isWeak);
  }

  private IWrapper fromNode(SNode node) {
    if (node == null) return null;
    return new NodeWrapper(node);
  }
  //--------------------


  public void addInequation(IWrapper subType, IWrapper supertype, SNode nodeToCheck) {
    addInequation(subType, supertype, nodeToCheck, true);
  }

  public void addInequation(IWrapper subType, IWrapper supertype, ErrorInfo errorInfo) {
    addInequation(subType, supertype, errorInfo, true);
  }

  public void addInequation(IWrapper subType, IWrapper supertype, SNode nodeToCheck, boolean isWeak) {
    addInequation(subType, supertype, new ErrorInfo(nodeToCheck, null), isWeak);
  }

  public void addInequation(IWrapper subType, IWrapper supertype, ErrorInfo errorInfo, boolean isWeak) {
    IWrapper subtypeRepresentator = getRepresentatorWrapper(subType);
    IWrapper supertypeRepresentator = getRepresentatorWrapper(supertype);

    // no equation needed
    if (fromWrapper(subtypeRepresentator) == fromWrapper(supertypeRepresentator)) return;

    // if one of them is a var
    RuntimeTypeVariable varSubtype = subtypeRepresentator.getVariable();
    RuntimeTypeVariable varSupertype = supertypeRepresentator.getVariable();
    if (varSubtype != null || varSupertype != null) {
      if (isWeak) {
        addSubtyping(subtypeRepresentator, supertypeRepresentator, errorInfo);
      } else {
        addStrongSubtyping(subtypeRepresentator, supertypeRepresentator, errorInfo);
      }
      return;
    }

    // if strict subtyping
    if (myTypeChecker.getSubtypingManager().isSubtype(fromWrapper(subtypeRepresentator), fromWrapper(supertypeRepresentator), true, isWeak)) {
      return;
    }

    if (errorInfo.getErrorString() != null) {
      myTypeChecker.reportTypeError(errorInfo.getNodeWithError(), errorInfo.getErrorString());
      return;
    }
    String strongString = isWeak ? "" : " strong";
    IErrorReporter errorReporter =
            new EquationErrorReporter(this, "type ", subtypeRepresentator, " is not" + strongString + " subtype of ", supertypeRepresentator, "");
    myTypeChecker.reportTypeError(errorInfo.getNodeWithError(), errorReporter);
  }

  public void addInequationComparable(SNode type1, SNode type2, SNode nodeToCheck) {
    addInequationComparable(fromNode(type1), fromNode(type2), nodeToCheck, true);
  }

  public void addInequationComparable(SNode type1, SNode type2, ErrorInfo errorInfo) {
    addInequationComparable(fromNode(type1), fromNode(type2), errorInfo, true);
  }

  public void addInequationComparable(SNode type1, SNode type2, SNode nodeToCheck, boolean isWeak) {
    addInequationComparable(fromNode(type1), fromNode(type2), new ErrorInfo(nodeToCheck, null), isWeak);
  }

  public void addInequationComparable(SNode type1, SNode type2, ErrorInfo errorInfo, boolean isWeak) {
    addInequationComparable(fromNode(type1), fromNode(type2), errorInfo, isWeak);
  }

  //---------------------

  public void addInequationComparable(IWrapper type1, IWrapper type2, SNode nodeToCheck) {
    addInequationComparable(type1, type2, nodeToCheck, true);
  }

  public void addInequationComparable(IWrapper type1, IWrapper type2, ErrorInfo errorInfo) {
    addInequationComparable(type1, type2, errorInfo, true);
  }

  public void addInequationComparable(IWrapper type1, IWrapper type2, SNode nodeToCheck, boolean isWeak) {
    addInequationComparable(type1, type2, new ErrorInfo(nodeToCheck, null), isWeak);
  }

  public void addInequationComparable(IWrapper type1, IWrapper type2, ErrorInfo errorInfo, boolean isWeak) {
    IWrapper representator1 = getRepresentatorWrapper(type1);
    IWrapper representator2 = getRepresentatorWrapper(type2);

    // no equation needed
    if (fromWrapper(representator1) == fromWrapper(representator2)) return;

    // if one of them is a var
    RuntimeTypeVariable varSubtype = representator1.getVariable();
    RuntimeTypeVariable varSupertype = representator2.getVariable();
    if (varSubtype != null || varSupertype != null) {
      if (isWeak) {
        addComparable(representator1, representator2, errorInfo);
      } else {
        addStrongComparable(representator1, representator2, errorInfo);
      }
      return;
    }

    // if subtype or supertype
    if (myTypeChecker.getSubtypingManager().isComparableWRTRules(fromWrapper(representator1), fromWrapper(representator2))) {
      return;
    }
    if (myTypeChecker.getSubtypingManager().isSubtype(fromWrapper(representator1), fromWrapper(representator2), isWeak)) {
      return;
    }
    if (myTypeChecker.getSubtypingManager().isSubtype(fromWrapper(representator2), fromWrapper(representator1), isWeak)) {
      return;
    }

    if (errorInfo.getErrorString() != null) {
      myTypeChecker.reportTypeError(errorInfo.getNodeWithError(), errorInfo.getErrorString());
      return;
    }
    String strongString = isWeak ? "" : " strongly";
    IErrorReporter errorReporter =
            new EquationErrorReporter(this, "type ", representator1," is not" + strongString + " comparable with ", representator2, "");
    myTypeChecker.reportTypeError(errorInfo.getNodeWithError(), errorReporter);
  }

  public void addEquation(SNode lhs, SNode rhs, SNode nodeToCheck) {
    addEquation(fromNode(lhs), fromNode(rhs), nodeToCheck, null);
  }

  public void addEquation(IWrapper lhs, IWrapper rhs, SNode nodeToCheck) {
    addEquation(lhs, rhs, nodeToCheck, null);
  }

  public void addEquation(SNode lhs, SNode rhs, SNode nodeToCheck, String errorString) {
    addEquation(fromNode(lhs), fromNode(rhs), nodeToCheck, errorString);
  }

  public void addEquation(IWrapper lhs, IWrapper rhs, SNode nodeToCheck, String errorString) {
    IWrapper rhsRepresentator = getRepresentatorWrapper(lhs);
    IWrapper lhsRepresentator = getRepresentatorWrapper(rhs);

    // no equation needed
    if (rhsRepresentator == lhsRepresentator) return;

    // add var to type's multieq
    RuntimeTypeVariable varRhs = rhsRepresentator.getVariable();
    RuntimeTypeVariable varLhs = lhsRepresentator.getVariable();
    if (varRhs != null) {
      processEquation(rhsRepresentator, lhsRepresentator, nodeToCheck);
      return;
    } else {
      if (varLhs != null) {
        processEquation(lhsRepresentator, rhsRepresentator, nodeToCheck);
        return;
      }
    }

    // solve equation
    if (!compareWrappers(rhsRepresentator, lhsRepresentator)) {
      IErrorReporter errorReporter;
      if (errorString != null) {
        errorReporter = new SimpleErrorReporter(errorString);
      } else {
        errorReporter =
                new EquationErrorReporter(this, "incompatible types: ", rhsRepresentator, " and ", lhsRepresentator, "");
      }
      processErrorEquation(lhsRepresentator, rhsRepresentator, errorReporter, nodeToCheck);
      return;
    }
    Set<Pair<SNode, SNode>> childEQs = createChildEquations(rhsRepresentator, lhsRepresentator);
    for (Pair<SNode, SNode> eq : childEQs) {
      addEquation(fromNode(eq.o2), fromNode(eq.o1), nodeToCheck, errorString);
    }
  }

  private SNode fromWrapper(IWrapper lhs) {
    if (lhs == null) return null;
    return lhs.getNode();
  }

  private void processEquation(IWrapper var, IWrapper type, SNode nodeToCheck) {
    setParent(var, type);
    keepInequation(var, type);
    RuntimeTypeVariable typeVar = var.getVariable();
    if (typeVar instanceof RuntimeErrorType) {
      TypeChecker.getInstance().reportTypeError(nodeToCheck,((RuntimeErrorType)typeVar).getErrorText());
    }
  }

  private void keepInequation(IWrapper var, IWrapper type) {
    if (mySubtypesToSupertypesMap.get(var) != null) {
      Map<IWrapper,ErrorInfo> supertypes = mySubtypesToSupertypesMap.get(var);
      mySubtypesToSupertypesMap.remove(var);
      for (IWrapper supertype : supertypes.keySet()) {
        Map<IWrapper, ErrorInfo> map = mySupertypesToSubtypesMap.get(supertype);
        if (map != null) {
          map.remove(var);
        }
      }
      for (IWrapper supertype : supertypes.keySet()) {
        addInequation(type, supertype, supertypes.get(supertype));
      }
    }
    if (mySupertypesToSubtypesMap.get(var) != null) {
      Map<IWrapper,ErrorInfo> subtypes = mySupertypesToSubtypesMap.get(var);
      mySupertypesToSubtypesMap.remove(var);
      for (IWrapper subtype : subtypes.keySet()) {
        Map<IWrapper, ErrorInfo> map = mySubtypesToSupertypesMap.get(subtype);
        if (map != null) {
          map.remove(var);
        }
      }
      for (IWrapper subtype : subtypes.keySet()) {
        addInequation(subtype, type, subtypes.get(subtype));
      }
    }
    if (mySubtypesToSupertypesMapStrong.get(var) != null) {
      Map<IWrapper,ErrorInfo> supertypes = mySubtypesToSupertypesMapStrong.get(var);
      mySubtypesToSupertypesMapStrong.remove(var);
      for (IWrapper supertype : supertypes.keySet()) {
        Map<IWrapper, ErrorInfo> map = mySupertypesToSubtypesMapStrong.get(supertype);
        if (map != null) {
          map.remove(var);
        }
      }
      for (IWrapper supertype : supertypes.keySet()) {
        addInequation(type, supertype, supertypes.get(supertype), false);
      }
    }
    if (mySupertypesToSubtypesMapStrong.get(var) != null) {
      Map<IWrapper,ErrorInfo> subtypes = mySupertypesToSubtypesMapStrong.get(var);
      mySupertypesToSubtypesMapStrong.remove(var);
      for (IWrapper subtype : subtypes.keySet()) {
        Map<IWrapper, ErrorInfo> map = mySubtypesToSupertypesMapStrong.get(subtype);
        if (map != null) {
          map.remove(var);
        }
      }
      for (IWrapper subtype : subtypes.keySet()) {
        addInequation(subtype, type, subtypes.get(subtype), false);
      }
    }

    if (myComparableTypesMap.get(var) != null) {
      Map<IWrapper,ErrorInfo> comparables = myComparableTypesMap.get(var);
      myComparableTypesMap.remove(var);
      for (IWrapper comparable : comparables.keySet()) {
        Map<IWrapper, ErrorInfo> map = myComparableTypesMap.get(comparable);
        if (map != null) {
          map.remove(var);
        }
      }
      for (IWrapper subtype : comparables.keySet()) {
        addInequationComparable(subtype, type, comparables.get(subtype));
      }
    }

    if (myComparableTypesMapStrong.get(var) != null) {
      Map<IWrapper,ErrorInfo> comparables = myComparableTypesMapStrong.get(var);
      myComparableTypesMapStrong.remove(var);
      for (IWrapper comparable : comparables.keySet()) {
        Map<IWrapper, ErrorInfo> map = myComparableTypesMapStrong.get(comparable);
        if (map != null) {
          map.remove(var);
        }
      }
      for (IWrapper subtype : comparables.keySet()) {
        addInequationComparable(subtype, type, comparables.get(subtype), false);
      }
    }
  }

  private void processErrorEquation(IWrapper type, IWrapper error, IErrorReporter errorReporter, SNode nodeToCheck) {
    setParent(error, type); //type
    myTypeChecker.reportTypeError(nodeToCheck, errorReporter);
  }

  public void clear() {
    mySubtypesToSupertypesMap.clear();
    mySupertypesToSubtypesMap.clear();
    mySubtypesToSupertypesMapStrong.clear();
    mySupertypesToSubtypesMapStrong.clear();
    myComparableTypesMap.clear();
    myEquations.clear();
  }

  private static boolean compareWrappers(IWrapper wrapper1, IWrapper wrapper2) {
    if (wrapper1 == wrapper2) return true;
    if (wrapper1 == null) {
      return false;
    }
    if (wrapper2 == null) {
      return false;
    }
    return wrapper1.matchesWith(wrapper2);
  }

  public static Set<Pair<SNode, SNode>> createChildEquations(IWrapper wrapper1, IWrapper wrapper2) {
    if (wrapper1.isCondition() || wrapper2.isCondition()) {
      return new HashSet<Pair<SNode, SNode>>();
    }
    final SNode node1 = wrapper1.getNode();
    final SNode node2 = wrapper2.getNode();
    final Set<Pair<SNode, SNode>> result = new HashSet<Pair<SNode, SNode>>();

    Set<String> allChildRoles = node1.getChildRoles();
    node2.addChildRoles(allChildRoles);

    for (String childRole : allChildRoles) {
      List<SNode> childrenInNode1 = node1.getChildren(childRole);
      List<SNode> childrenInNode2 = node2.getChildren(childRole);
      Iterator<SNode> childrenIterator2 = childrenInNode2.iterator();
      for (SNode child1 : childrenInNode1) {
        SNode child2 = childrenIterator2.hasNext() ? childrenIterator2.next() : null;
        result.add(new Pair<SNode, SNode>(child1, child2));
      }
      for (;childrenIterator2.hasNext();) {
        SNode child2 = childrenIterator2.next();
        result.add(new Pair<SNode, SNode>(null, child2));
      }
    }
    return result;
  }

  private void addSubtyping(IWrapper subtype, IWrapper supertype, ErrorInfo errorInfo) {
    Map<IWrapper,ErrorInfo> supertypes = mySubtypesToSupertypesMap.get(subtype);
    if (supertypes == null) {
      supertypes = new HashMap<IWrapper, ErrorInfo>();
      mySubtypesToSupertypesMap.put(subtype, supertypes);
    }
    supertypes.put(supertype, errorInfo);

    Map<IWrapper,ErrorInfo> subtypes = mySupertypesToSubtypesMap.get(supertype);
    if (subtypes == null) {
      subtypes = new HashMap<IWrapper, ErrorInfo>();
      mySupertypesToSubtypesMap.put(supertype, subtypes);
    }
    subtypes.put(subtype, errorInfo);
  }

  private void addStrongSubtyping(IWrapper subtype, IWrapper supertype, ErrorInfo errorInfo) {
    Map<IWrapper,ErrorInfo> supertypes = mySubtypesToSupertypesMapStrong.get(subtype);
    if (supertypes == null) {
      supertypes = new HashMap<IWrapper, ErrorInfo>();
      mySubtypesToSupertypesMapStrong.put(subtype, supertypes);
    }
    supertypes.put(supertype, errorInfo);

    Map<IWrapper,ErrorInfo> subtypes = mySupertypesToSubtypesMapStrong.get(supertype);
    if (subtypes == null) {
      subtypes = new HashMap<IWrapper, ErrorInfo>();
      mySupertypesToSubtypesMapStrong.put(supertype, subtypes);
    }
    subtypes.put(subtype, errorInfo);
    addSubtyping(subtype, supertype, errorInfo);
  }

  private void addComparable(IWrapper type1, IWrapper type2, ErrorInfo errorInfo) {
    Map<IWrapper,ErrorInfo> comparables1 = myComparableTypesMap.get(type1);
    if (comparables1 == null) {
      comparables1 = new HashMap<IWrapper, ErrorInfo>();
      myComparableTypesMap.put(type1, comparables1);
    }
    comparables1.put(type2, errorInfo);

    Map<IWrapper,ErrorInfo> comparables2 = myComparableTypesMap.get(type2);
    if (comparables2 == null) {
      comparables2 = new HashMap<IWrapper, ErrorInfo>();
      myComparableTypesMap.put(type2, comparables2);
    }
    comparables2.put(type1, errorInfo);
  }

  private void addStrongComparable(IWrapper type1, IWrapper type2, ErrorInfo errorInfo) {
    Map<IWrapper,ErrorInfo> comparables1 = myComparableTypesMapStrong.get(type1);
    if (comparables1 == null) {
      comparables1 = new HashMap<IWrapper, ErrorInfo>();
      myComparableTypesMapStrong.put(type1, comparables1);
    }
    comparables1.put(type2, errorInfo);

    Map<IWrapper,ErrorInfo> comparables2 = myComparableTypesMapStrong.get(type2);
    if (comparables2 == null) {
      comparables2 = new HashMap<IWrapper, ErrorInfo>();
      myComparableTypesMapStrong.put(type2, comparables2);
    }
    comparables2.put(type1, errorInfo);
  }

  private Set<IWrapper> subtypingGraphVertices() {
    Set<IWrapper> nodes = new HashSet<IWrapper>(mySubtypesToSupertypesMap.keySet());
    Set<IWrapper> result = new HashSet<IWrapper>();
    for (IWrapper node : nodes) {
      Map<IWrapper, ErrorInfo> map = mySubtypesToSupertypesMap.get(node);
      if (map == null || map.isEmpty()) {
        mySubtypesToSupertypesMap.remove(node);
      } else {
        result.add(node);
      }
    }
    nodes = new HashSet<IWrapper>(mySupertypesToSubtypesMap.keySet());
    for (IWrapper node : nodes) {
      Map<IWrapper, ErrorInfo> map = mySupertypesToSubtypesMap.get(node);
      if (map == null || map.isEmpty()) {
        mySupertypesToSubtypesMap.remove(node);
      } else {
        result.add(node);
      }
    }
    nodes = new HashSet<IWrapper>(mySubtypesToSupertypesMapStrong.keySet());
    for (IWrapper node : nodes) {
      Map<IWrapper, ErrorInfo> map = mySubtypesToSupertypesMapStrong.get(node);
      if (map == null || map.isEmpty()) {
        mySubtypesToSupertypesMapStrong.remove(node);
      } else {
        result.add(node);
      }
    }
    nodes = new HashSet<IWrapper>(mySupertypesToSubtypesMapStrong.keySet());
    for (IWrapper node : nodes) {
      Map<IWrapper, ErrorInfo> map = mySupertypesToSubtypesMapStrong.get(node);
      if (map == null || map.isEmpty()) {
        mySupertypesToSubtypesMapStrong.remove(node);
      } else {
        result.add(node);
      }
    }

    return result;
  }

  public void solveInequations() {
    Set<IWrapper> types = subtypingGraphVertices();
    boolean hasConcreteTypes = true;

    // we assume that there are no equations such as T1 :< T2 where T1 and T2 are both concrete
    while (hasConcreteTypes) {
      hasConcreteTypes = false;
      for (IWrapper type : types) {
        if (BaseAdapter.isInstance(fromWrapper(type), RuntimeTypeVariable.class)) {
          varLessThanType(type, true);
          typeLessThanVar(type, true);
          varLessThanType(type, false);
          varLessThanType(type, false);
        } else {
          hasConcreteTypes = true;
        }
      }
      types = subtypingGraphVertices();
    }


    for (IWrapper type : types) {
      assert type.isVariable();

      Map<IWrapper, ErrorInfo> supertypes = mySubtypesToSupertypesMap.get(type);
      if (supertypes != null) {
        mySubtypesToSupertypesMap.remove(type);
        for (IWrapper supertype : supertypes.keySet()) {
          mySupertypesToSubtypesMap.get(supertype).remove(type);
          addEquation(type, supertype, supertypes.get(supertype).getNodeWithError());
        }
      }
      Map<IWrapper, ErrorInfo> subtypes = mySupertypesToSubtypesMap.get(type);
      if (subtypes != null) {
        mySupertypesToSubtypesMap.remove(type);
        for (IWrapper subtype : subtypes.keySet()) {
          mySubtypesToSupertypesMap.get(subtype).remove(type);
          addEquation(type,  subtype, subtypes.get(subtype).getNodeWithError());
        }
      }
      Map<IWrapper, ErrorInfo> supertypesStrong = mySubtypesToSupertypesMapStrong.get(type);
      if (supertypesStrong != null) {
        mySubtypesToSupertypesMapStrong.remove(type);
        for (IWrapper supertype : supertypesStrong.keySet()) {
          mySupertypesToSubtypesMapStrong.get(supertype).remove(type);
          addEquation(type, supertype, supertypesStrong.get(supertype).getNodeWithError());
        }
      }
      Map<IWrapper, ErrorInfo> subtypesStrong = mySupertypesToSubtypesMapStrong.get(type);
      if (subtypesStrong != null) {
        mySupertypesToSubtypesMapStrong.remove(type);
        for (IWrapper subtype : subtypesStrong.keySet()) {
          mySubtypesToSupertypesMapStrong.get(subtype).remove(type);
          addEquation(type,  subtype, subtypesStrong.get(subtype).getNodeWithError());
        }
      }
    }
  }

  private void typeLessThanVar(IWrapper type, boolean isWeak) {
    final Map<IWrapper, Map<IWrapper, ErrorInfo>> supertypesToSubtypesMap;
    final Map<IWrapper, Map<IWrapper, ErrorInfo>> subtypesToSupertypesMap;
    if (isWeak) {
      supertypesToSubtypesMap = mySupertypesToSubtypesMap;
      subtypesToSupertypesMap = mySubtypesToSupertypesMap;
    } else {
      supertypesToSubtypesMap = mySupertypesToSubtypesMapStrong;
      subtypesToSupertypesMap = mySubtypesToSupertypesMapStrong;
    }


    Map<IWrapper, ErrorInfo> subtypes = supertypesToSubtypesMap.get(type);
    if (subtypes == null) {
      return;
    }
    if (subtypes.isEmpty()) {
      supertypesToSubtypesMap.remove(type);
      return;
    }
    Set<IWrapper> concreteSubtypes = new HashSet<IWrapper>();
    for (IWrapper subtypeNode : subtypes.keySet()) {
      if (!subtypeNode.isVariable()) {
        concreteSubtypes.add(subtypeNode);
      }
    }
    if (concreteSubtypes.isEmpty()) return;

    SNode nodeToCheck = subtypesToSupertypesMap.get(concreteSubtypes.iterator().next()).get(type).getNodeWithError();

    for (IWrapper subtypeNode : concreteSubtypes) {
      supertypesToSubtypesMap.get(type).remove(subtypeNode);
      subtypesToSupertypesMap.get(subtypeNode).remove(type);
    }
    //  T,S <: c => c = lcs(T,S)
    addEquation(type, fromNode(myTypeChecker.getSubtypingManager().leastCommonSupertype(toNodes(concreteSubtypes))), nodeToCheck);
  }

  private Set<SNode> toNodes(Set<IWrapper> wrappers) {
    return CollectionUtil.map(wrappers, new Mapper<IWrapper, SNode>() {
      public SNode map(IWrapper nodeWrapper) {
        return fromWrapper(nodeWrapper);
      }
    });
  }

  private void varLessThanType(IWrapper type, boolean isWeak) {
    final Map<IWrapper, Map<IWrapper, ErrorInfo>> supertypesToSubtypesMap;
    final Map<IWrapper, Map<IWrapper, ErrorInfo>> subtypesToSupertypesMap;
    if (isWeak) {
      supertypesToSubtypesMap = mySupertypesToSubtypesMap;
      subtypesToSupertypesMap = mySubtypesToSupertypesMap;
    } else {
      supertypesToSubtypesMap = mySupertypesToSubtypesMapStrong;
      subtypesToSupertypesMap = mySubtypesToSupertypesMapStrong;
    }

    Map<IWrapper, ErrorInfo> supertypes = subtypesToSupertypesMap.get(type);
    if (supertypes == null) {
      return;
    }
    if (supertypes.isEmpty()) {
      subtypesToSupertypesMap.remove(type);
      return;
    }
    Set<IWrapper> concreteSupertypes = new HashSet<IWrapper>();
    for (IWrapper supertypeNode : supertypes.keySet()) {
      if (!supertypeNode.isVariable()) {
        concreteSupertypes.add(supertypeNode);
      }
    }
    if (concreteSupertypes.isEmpty()) return;

    IWrapper supertype = concreteSupertypes.iterator().next();
    SNode nodeToCheck = supertypes.get(supertype).getNodeWithError();

    for (IWrapper supertypeNode : concreteSupertypes) {
      subtypesToSupertypesMap.get(type).remove(supertypeNode);
      supertypesToSubtypesMap.get(supertypeNode).remove(type);
    }
    // c :< T => c = T
    addEquation(type, supertype, nodeToCheck);
  }

  public EquationManager getMaster() {
    if (myNodeTypesComponent == null) return null;
    return myNodeTypesComponent.getMaster(this);
  }

  public static class ErrorInfo {
    private String myErrorString;
    private SNode myNodeWithError;

    private String myRuleModel;
    private String myRuleId;

    public ErrorInfo(SNode nodeWithError, String errorString) {
      myErrorString = errorString;
      myNodeWithError = nodeWithError;
    }

    public ErrorInfo(SNode nodeWithError, String errorString, String ruleModel, String ruleId) {
      myErrorString = errorString;
      myNodeWithError = nodeWithError;
      myRuleModel = ruleModel;
      myRuleId = ruleId;
    }

    public String getErrorString() {
      return myErrorString;
    }

    public SNode getNodeWithError() {
      return myNodeWithError;
    }

    public SNode findRuleNode() {
      SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(SModelUID.fromString(myRuleModel));
      if (modelDescriptor == null) return null;
      return modelDescriptor.getSModel().getNodeById(myRuleId);
    }
  }


}
