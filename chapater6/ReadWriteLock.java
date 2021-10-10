package chapater6;

public class ReadWriteLock {
    private int readingReaders = 0;
    private int waitingWriters=0;
    private int writingWriters=0;
    private boolean preferWriter=true;//是否写入优先

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters>0 ||(waitingWriters>0 && preferWriter)) {
            wait();
        }
        readingReaders++;
    }
    public synchronized void ReadUnlock(){
        readingReaders--;
        preferWriter=true;
        notifyAll();
    }


}
