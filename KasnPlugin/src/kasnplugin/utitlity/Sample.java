package kasnplugin.utitlity;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

public class Sample {
	
	public static void main(String[] args) {
		
		Job job = new Job("My first Job"){
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				System.out.println("Hello World from a background job");
				return Status.OK_STATUS;
			}
		};
		job.setPriority(Job.SHORT);
		job.schedule();
		
	}
	
}
