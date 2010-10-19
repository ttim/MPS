package jetbrains.mps.make.unittest;

/*Generated by MPS */

import jetbrains.mps.make.facet.ITarget;
import jetbrains.mps.internal.make.runtime.script.TargetRange;
import jetbrains.mps.internal.make.runtime.script.Script;
import junit.framework.Assert;
import jetbrains.mps.make.script.IResult;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.make.resources.IResource;
import org.jmock.Expectations;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class Execute_Test extends MockTestCase {
  public void test_single() throws Exception {
    final ITarget make = Mockups.target(context, "make");
    Mockups.allowing(context, make);

    TargetRange tr = new TargetRange();
    tr.addTarget(make);

    Script sc = new Script(tr, new ITarget.Name("make"));
    sc.validate();
    Assert.assertTrue(sc.isValid());

    IResult res = sc.execute(Mockups.monitor(context, "mon"));
    Assert.assertNotNull(res);
    Assert.assertTrue(res.isSucessful());
    Assert.assertNotNull(res.output());
    Assert.assertTrue(Sequence.fromIterable(res.output()).isEmpty());
  }

  public void test_resources() throws Exception {
    final ITarget make = Mockups.target(context, "make");
    final ITarget res = Mockups.target(context, "res");
    final IResource resA = Mockups.resource(context, "resA");
    final IResource resB = Mockups.resource(context, "resB");
    final IResult result = Mockups.result(context, "result", true);
    context.checking(new Expectations() {
      {
        atLeast(1).of(res).before();
        will(returnValue(Sequence.fromArray(new ITarget.Name[]{new ITarget.Name("make")})));
        exactly(1).of(res).createJob();
        will(returnValue(Mockups.job(context, "resjob", new _FunctionTypes._return_P0_E0<IResult>() {
          public IResult invoke() {
            return result;
          }
        })));
        atLeast(1).of(result).output();
        will(returnValue(ListSequence.fromListAndArray(new ArrayList<IResource>(), resA, resB)));
      }
    });
    Mockups.allowing(context, res);
    Mockups.allowing(context, make);
    Mockups.allowing(context, result);

    TargetRange tr = new TargetRange();
    tr.addTarget(make);
    tr.addRelated(ListSequence.fromListAndArray(new ArrayList<ITarget>(), res));

    Script sc = new Script(tr, new ITarget.Name("make"));
    sc.validate();
    Assert.assertTrue(sc.isValid());

    IResult r = sc.execute(Mockups.monitor(context, "mon"));
    Assert.assertNotNull(r);
    Assert.assertTrue(r.isSucessful());
    Iterable<IResource> out = r.output();
    Assert.assertTrue(ListSequence.fromList(ListSequence.fromListAndArray(new ArrayList<IResource>(), resA, resB)).disjunction(Sequence.fromIterable(out)).isEmpty());
  }

  public void test_fail() throws Exception {
    final ITarget make = Mockups.target(context, "make");
    final ITarget gen = Mockups.target(context, "gen");
    final ITarget res = Mockups.target(context, "res");
    final IResource resA = Mockups.resource(context, "resA");
    final IResource resB = Mockups.resource(context, "resB");
    final IResult okresult = Mockups.result(context, "okresult", true);
    final IResult failresult = Mockups.result(context, "failresult", false);
    context.checking(new Expectations() {
      {
        atLeast(1).of(res).before();
        will(returnValue(Sequence.fromArray(new ITarget.Name[]{new ITarget.Name("make")})));
        exactly(1).of(res).createJob();
        will(returnValue(Mockups.job(context, "resjob", new _FunctionTypes._return_P0_E0<IResult>() {
          public IResult invoke() {
            return okresult;
          }
        })));
        atLeast(1).of(okresult).output();
        will(returnValue(ListSequence.fromListAndArray(new ArrayList<IResource>(), resA, resB)));

        atLeast(1).of(gen).before();
        will(returnValue(Sequence.fromArray(new ITarget.Name[]{new ITarget.Name("make")})));
        atLeast(1).of(gen).after();
        will(returnValue(Sequence.fromArray(new ITarget.Name[]{new ITarget.Name("res")})));
        exactly(1).of(gen).createJob();
        will(returnValue(Mockups.job(context, "genjob", new _FunctionTypes._return_P0_E0<IResult>() {
          public IResult invoke() {
            return failresult;
          }
        })));
      }
    });
    Mockups.allowing(context, res);
    Mockups.allowing(context, gen);
    Mockups.allowing(context, make);
    Mockups.allowing(context, okresult);
    Mockups.allowing(context, failresult);

    TargetRange tr = new TargetRange();
    tr.addTarget(make);
    tr.addRelated(ListSequence.fromListAndArray(new ArrayList<ITarget>(), gen, res));

    Script sc = new Script(tr, new ITarget.Name("make"));
    sc.validate();
    Assert.assertTrue(sc.isValid());

    IResult r = sc.execute(Mockups.monitor(context, "mon"));
    Assert.assertNotNull(r);
    Assert.assertFalse(r.isSucessful());

    Iterable<IResource> out = r.output();
    Assert.assertTrue(ListSequence.fromList(ListSequence.fromListAndArray(new ArrayList<IResource>(), resA, resB)).disjunction(Sequence.fromIterable(out)).isEmpty());
  }
}
