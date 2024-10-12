package com.quartz;


import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

@Slf4j
public abstract class AbstractJob implements InterruptableJob {

    protected boolean interrupt = false;

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        this.interrupt = true;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            runJob(context);
        } catch(Throwable e) {
            log.error("Error when running runJob for job " + this.getClass().getSimpleName(), e);
            JobExecutionException jobExecutionException = new JobExecutionException(e);
            context.put("error", e.toString());
            try {
                onException(context);
            } catch(Exception eInner) {
                log.error("Exception caught when running onException for job " + this.getClass().getSimpleName(), eInner);
            } finally {
                throw jobExecutionException;
            }
        }
    }

    public abstract void onException(JobExecutionContext context);

    public abstract void runJob(JobExecutionContext context) throws Exception;

    protected void checkInterrupt() throws InterruptedException {
        if (interrupt)
            throw new InterruptedException("Job " + this.getClass().getSimpleName() + " was interrupted");
    }
}