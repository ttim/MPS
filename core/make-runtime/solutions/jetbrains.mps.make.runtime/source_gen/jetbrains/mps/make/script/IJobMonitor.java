package jetbrains.mps.make.script;

/*Generated by MPS */


public interface IJobMonitor {
  public boolean stopRequested();
  public IProgress currentProgress();
  public void reportFeedback(IFeedback fdbk);
  public static class Stub implements IJobMonitor {
    private IProgress pstub;

    public Stub(IProgress pstub) {
      this.pstub = pstub;
    }

    public Stub() {
      this.pstub = new IProgress.Stub();
    }

    public IProgress currentProgress() {
      return pstub;
    }

    public void reportFeedback(IFeedback fdbk) {
    }

    public boolean stopRequested() {
      return false;
    }
  }

}
